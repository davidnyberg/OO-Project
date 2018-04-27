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
    private int score = 0;

    public int getScore() {
        return score;
    }

    Game(JFrame window) {
      //init stuff
       this.window = window;
       walls = new ArrayList<>();
       enemies = new ArrayList<>();
       bullets = new ArrayList<>();

       width = 700;
       height = 400;

       initWalls();

       player = new Player(50, 50, 25, 0, 3, 1, 2);
       //enemies.add(new Enemy(20,20, 30, 0,3,1));

      //create view
       view = new GameView(window, this, height, width, getAllObjects());

      //set up game loop
      class GameLoopTask extends TimerTask {
        public void run()
        {
          GameLoop();
        }
      }
      Timer t = new Timer();
      t.schedule(new GameLoopTask(), 0, 1000/1);

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

      //collisionData a = new collisionData();

      int xpos = (int)object.getXpos();
      int ypos = (int)object.getYpos();
      int scaleHalf = (int)object.getScale() / 2;

      int lb1 = (xpos - scaleHalf);
      int rb1 = (xpos + scaleHalf);
      int bb1 = (ypos - scaleHalf);
      int tb1 = (ypos + scaleHalf);

      for(GameObject ob : allObjects)
      {
        int OBxpos = (int)ob.getXpos();
        int OBypos = (int)ob.getYpos();
        int OBscaleHalf = (int)ob.getScale() / 2;

        int lb2 = (OBxpos - OBscaleHalf);
        int rb2 = (OBxpos + OBscaleHalf);
        int bb2 = (OBypos - OBscaleHalf);
        int tb2 = (OBypos + OBscaleHalf);

        boolean left = rb1 > lb2 && lb1 < lb2;
        boolean right = lb1 < rb2 && rb1 > rb2;
        boolean top = bb1 < tb2 && tb1 > tb2;
        boolean bottom = tb1 > bb2 && bb1 < bb2;
        boolean innerVert = tb1 < tb2 && bb1 > bb2;
        boolean innerHor = lb1 > lb2 && rb1 < rb2;

        boolean horizontalOverlap = left || right || innerHor;
        boolean verticalOverlap = top || bottom || innerVert;




        if(horizontalOverlap && verticalOverlap) {

          int hori, vert;

            if(left){
                hori = rb1 - lb2;
          } else if (right) {
                hori = rb2 - lb1;
            } else {
                hori = 0;
            }

            if (top){
                vert = tb2 - bb1;
            } else if (bottom){
                vert = bb2 - tb1;
            } else {
                vert = 0;
            }


            collisionList.add(new CollisionData(ob, hori, vert));
        }
      }

      return collisionList;
    }

    public void GameLoop(){

      //move player
      player.MoveInDirection(0, -1);

      for(Enemy e : enemies){
          e.SetTargetPosition(player.getXpos(), player.getYpos());
          e.moveTowardTarget();
      }

      //check for collisions
      List<CollisionData> playerCollisions = checkCollisions(player);
      System.out.println(checkCollisions(player));

      for (CollisionData cd : playerCollisions){
          if (cd.object instanceof Wall){
              if(abs(cd.horOverlap) < abs(cd.vertOverlap)){
                  player.setXpos(player.getXpos()-cd.horOverlap);
              } else {
                  player.setYpos(player.getYpos()+cd.vertOverlap);
              }
          }
      }

      view.repaint();


          //score++;
          //con.setScore(1, "test", score);
          //--Move objects--
          //move player
          //HandleInput();
          //move enemies (toward player)
          //move bullets (forward)


          //--Check for collisions--
          //check walls against all objects
          //if player or enemie, move outside of wall
          //if bullet, kill bullet

          //check bullets with enemies
          //if bullet in enemy, kill enemy and bullet

          //check player with enemies
          //if player in enemy, kill player

          //--Spawn more enemies--
          //while(need to spawn more enemies)
            //gen approriate spawn area (not in wall, not too close to player
            //enemies.add(new enemy)
    }

    public void HandleInput(boolean W, boolean A, boolean S, boolean D, boolean SPACE, boolean LEFT, boolean RIGHT, boolean UP, boolean DOWN)
    {
        int speed = 1;

        //moving
        float dx = 0;
        float dy = 0;        if (W){ dy -= speed;}
        if (A){ dx -= speed;}
        if (S){ dy += speed;}
        if (D){ dx += speed;}

        if(player != null)
            player.MoveInDirection(dx, dy);

        //aiming
        if (LEFT) {player.setRotation(180);}
        else if (RIGHT) {player.setRotation(0);}
        else if (UP) {player.setRotation(90);}
        else if (DOWN) {player.setRotation(270);}


        //shooting
        if (SPACE){
            player.setShootSpeed(1);
        }
        else {
            player.setShootSpeed(0);
        }

    }


}
