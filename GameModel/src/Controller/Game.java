package Controller;

import Model.*;
import View.GameView;

import javax.management.DynamicMBean;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.StrictMath.abs;

public class Game {

    private DataBase con = new DataBase();

    private int width;
    private int height;

    private GameView view;
    private JFrame window;
    private List<Wall> walls;
    private Player player;
    private List<Enemy> enemies;
    private List<Bullet> bullets;
    private List<DynamicObject> deadThings;

    private int score = 0;
    private int enemyScore = 10;
    private int loopCounter;
    public int getScore() {
        return score;
    }

    Game(JFrame window) {
      //init stuff
       this.window = window;
       walls = new ArrayList<>();
       enemies = new ArrayList<>();
       bullets = new ArrayList<>();
       deadThings = new ArrayList<>();

       width = 700;
       height = 400;

       initWalls();
       walls.add(new Wall(200, 200, 30, 0));

       player = new Player(50, 50, 25, 0, 3, 1, 0);
      //test walls for collision
      /*walls.add(new Wall(30, 30, 30, 0));
      //walls.add(new Wall(60,30,30,0));
      walls.add(new Wall(30, 60, 30,0));
      walls.add(new Wall(30, 90,30,0));*/

       enemies.add(new Enemy(500,300, 30, 0,1,100));

      //create view
       view = new GameView(window, this, height, width, getAllObjects());
       view.createBufferStrategy(4);

      //set up game loop
      class GameLoopTask extends TimerTask {
        public void run()
        {
          GameLoop();
        }
      }
      Timer t = new Timer();
      t.schedule(new GameLoopTask(), 0, 1000/60);

    }



    private void initWalls()
    {
      int scale = 30; //if you change this, change number of walls created
      int ycount = 11;
      int xcount = 22;
      for(int x = 0; x <= xcount; x++) {
        walls.add(new Wall(x*scale, 0, scale, 0));
        walls.add(new Wall(x*scale, scale*ycount, scale, 0));
      }
      for(int y = 1; y < ycount; y++){
        walls.add(new Wall(0, y*scale, scale, 0));
        walls.add(new Wall(xcount*scale, y*scale, scale, 0));
      }
    }

    public List<GameObject> getAllObjects()
    {
      List<GameObject> allObjects = new ArrayList<>();
      allObjects.addAll(walls);
      if(player != null) allObjects.add(player);
      allObjects.addAll(enemies);
      allObjects.addAll(bullets);
      return allObjects;
    }

    public class CollisionData
    {
      public GameObject object;
      public int horOverlap;
      public int vertOverlap;
      public CollisionData(GameObject ob, int x, int y){
        this.object = ob;
        this.horOverlap = x;
        this.vertOverlap = y;
      }
    }

    private List<CollisionData> checkCollisions(DynamicObject object)
    {
      List<CollisionData> collisionList = new ArrayList<>();
      List<GameObject> allObjects = getAllObjects();
      allObjects.remove(object);

      int xpos = (int)object.getXpos();
      int ypos = (int)object.getYpos();
      int scaleHalf = (int)object.getScale() / 2;

      int lb1 = (xpos - scaleHalf);
      int rb1 = (xpos + scaleHalf);
      int bb1 = (ypos - scaleHalf);
      int tb1 = (ypos + scaleHalf);

      for(GameObject ob : allObjects) {
        int OBxpos = (int) ob.getXpos();
        int OBypos = (int) ob.getYpos();
        int OBscaleHalf = (int) ob.getScale() / 2;

        int lb2 = (OBxpos - OBscaleHalf);
        int rb2 = (OBxpos + OBscaleHalf);
        int bb2 = (OBypos - OBscaleHalf);
        int tb2 = (OBypos + OBscaleHalf);

        boolean left = rb1 > lb2 && lb1 < lb2;
        boolean right = lb1 < rb2 && rb1 >= rb2;
        boolean insideHor = lb1 > lb2 && rb1 < rb2;
        boolean top = bb1 < tb2 && tb1 >= tb2;
        boolean bottom = tb1 > bb2 && bb1 < bb2;
        boolean insideVert = tb1 < tb2 && bb1 > bb2;

        boolean horizontalOverlap = left || right || insideHor;
        boolean verticalOverlap = top || bottom || insideVert;

        if (horizontalOverlap && verticalOverlap) {
          int hori = 0, vert = 0;
          if (left) {
            hori = rb1 - lb2;
          } else if (right) {
            hori = lb1 - rb2;
          }

          if (top) {
            vert = bb1 - tb2;
          } else if (bottom) {
            vert = tb1 - bb2;
          }

          collisionList.add(new CollisionData(ob, hori, vert));
        }
      }
      return collisionList;
    }

    public void GameLoop(){

      for(Enemy e : enemies){
        if(!e.getIsDead()) {
          e.SetTargetPosition(player.getXpos(), player.getYpos());
          e.moveTowardTarget();
        }
      }

      //move all bullets
      for (Bullet b : bullets){
        if(!b.getIsDead())
          b.MoveInDirection();
      }

      //things that only happen while player is alive
      if(!player.getIsDead()) {
        //check for player collisions
        List<CollisionData> playerCollisions = checkCollisions(player);
        for (CollisionData cd : playerCollisions) {
          //if collision with wall, push player back
          if (cd.object instanceof Wall) {
            if (cd.horOverlap != 0 && abs(cd.horOverlap) < abs(cd.vertOverlap)) {
              player.setXpos(player.getXpos() - cd.horOverlap);
            } else {
              player.setYpos(player.getYpos() - cd.vertOverlap);
            }
          }
          //if collision with enemy, die
          else if (cd.object instanceof Enemy) {
            player.setIsDead(true);
            deadThings.add(player);
          }
        }
        //shoot
        if (player.getShootSpeed() != 0) {
          //if the speed is 0, the player is not shooting
          if (loopCounter % player.getShootSpeed() == 0) {
            //spawn a Bullet
            bullets.add(new Bullet(player.getXpos(), player.getYpos(), player.getScale() / 4, player.getRotation(), player.getSpeed(), 1));
          }
        }
      }


      //check for enemy collisions
      for(Enemy e : enemies)
      {
        if(!e.getIsDead()) {
          List<CollisionData> eCollisions = checkCollisions(e);
          for (CollisionData cd : eCollisions) {
            //if collision with wall, push enemy back
            if (cd.object instanceof Wall) {
              if (cd.horOverlap != 0 && abs(cd.horOverlap) < abs(cd.vertOverlap)) {
                e.setXpos(e.getXpos() - cd.horOverlap);
              } else {
                e.setYpos(e.getYpos() - cd.vertOverlap);
              }
            }
          }
        }
      }

      //check for enemy collisions
      for(Bullet b : bullets)
      {
        //System.out.println("checking bullet");
        if(!b.getIsDead()) {
          List<CollisionData> bCollisions = checkCollisions(b);
          for (CollisionData cd : bCollisions) {
            //if collision with enemy, die and kill enemy
            if (cd.object instanceof Enemy) {
              Enemy e = (Enemy)cd.object;
              if(!e.getIsDead()) {
                b.setIsDead(true);
                deadThings.add(b);
                e.setIsDead(true);
                deadThings.add(e);
                score += enemyScore;
              }
            }
            //if collision with wall, die
            else if(cd.object instanceof Wall)
            {
              b.setIsDead(true);
              deadThings.add(b);
            }
          }
        }
      }

      //despawn dead things after time
      List<DynamicObject> stillDeadThings = new ArrayList<>();
      for(DynamicObject dyno: deadThings)
      {
        if(!dyno.checkDeathTime())
          stillDeadThings.add(dyno);
        else
        {
          if(dyno instanceof Player) {
            //game oveR
              // GOTO MAIN MENU
          }
          else if(dyno instanceof Enemy){
            enemies.remove(dyno);
          }
          else if(dyno instanceof Bullet){
            bullets.remove(dyno);
          }
        }
      }
      deadThings = stillDeadThings;
      //System.out.println(deadThings);

      loopCounter++;
      view.paint(view.getBufferStrategy().getDrawGraphics());
      view.repaint();
    }

    public void HandleInput(boolean W, boolean A, boolean S, boolean D, boolean SPACE, boolean LEFT, boolean RIGHT, boolean UP, boolean DOWN)
    {
        if(player.getIsDead())
          return;

        int speed = 1;

        //moving
        float dx = 0;
        float dy = 0;
        if (W){ dy -= speed;}
        if (A){ dx -= speed;}
        if (S){ dy += speed;}
        if (D){ dx += speed;}

        if(player != null)
            player.MoveInDirection(dx, dy);

        //aiming
        if      (LEFT) {player.setRotation((float)Math.PI);}
        else if (RIGHT) {player.setRotation(0);}
        else if (DOWN) {player.setRotation((float)(Math.PI/2));}
        else if (UP) {player.setRotation((float)(Math.PI * 3/2));}


        //shooting
        if (SPACE){
            player.setShootSpeed(10); // every 10 frames
        }
        else {
            player.setShootSpeed(0);
        }

    }


}
