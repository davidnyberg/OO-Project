package Controller;

import Model.*;
import View.GameView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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

    Game(JFrame window) {
      //init stuff
       this.window = window;
       walls = new ArrayList<>();
       enemies = new ArrayList<>();
       bullets = new ArrayList<>();

       width = 700;
       height = 400;

       initWalls();

       player = new Player(50, 50, 30, 0, 3, 1, 2);

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

    public class collisionData
    {
      public GameObject object;
      public int xdir;
      public int ydir;
      public collisionData(GameObject ob, int x, int y){
        this.object = ob;
        this.xdir = x;
        this.ydir = y;
      }
    }

    private List<GameObject> checkCollisions(DynamicObject object)
    {
      List<GameObject> collisionList = new ArrayList<>();
      List<GameObject> allObjects = getAllObjects();
      allObjects.remove(object);

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


        boolean horizontalOverlap = left || right;
        boolean verticalOverlap = top || bottom;

        if(horizontalOverlap && verticalOverlap) {
          collisionList.add(ob);
        }
      }

      return collisionList;
    }

    public void movePlayer(int x, int y){
        //move player
        player.MoveInDirection(x, y);
    }

    public void GameLoop(){

      //check for collisions
      List<GameObject> playerCollisions = checkCollisions(player);
      System.out.println(checkCollisions(player));


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

    public void HandleInput()
    {
      float moveVecX = 0;
      float moveVecY = 0;
      //if A
      //  move left
      //  moveVecX -= 1;
      //if S
      //  move down
      //  moveVecY -= 1;
      //if D
      //  move right
      //  moveVecX += 1;
      //if W
      //  move up
      //  moveVecY += 1;

      if(player != null)
        player.MoveInDirection(moveVecX, moveVecY);
    }


}
