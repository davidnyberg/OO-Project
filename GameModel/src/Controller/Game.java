package Controller;

import Model.*;
import View.GameView;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private DataBase con = new DataBase();

    private int width;
    private int height;

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

      //create view
       new GameView(window, this, height, width, getAllObjects());
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

    public void GameLoop(){
        //start game loop
        while (true) {
            //score++;
            //con.setScore(1, "test", score);
          //--Move objects--
          //move player
          HandleInput();
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
