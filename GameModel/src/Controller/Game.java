package Controller;

import Model.*;
import View.GameView;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private DataBase con = new DataBase();

    private JFrame window;
    private List<GameObject> walls;
    private Player player;
    private List<Enemy> enemies;
    private List<Bullet> bullets;
    private int score = 0;
    private BufferedImage a,b;


    Game(JFrame window) {
       //create view
       this.window = window;
       walls = new ArrayList<GameObject>();
       walls.add(new Wall(10,10,10,1, a));
       walls.add(new Wall(15,15, 10, 1 , b));

        window.getContentPane().removeAll();
        window.add(new GameView(window, this, walls));
        //new GameView(window,this, walls);

        window.getContentPane().revalidate();
        window.getContentPane().repaint();
       //initialize objects
       //player = new Player(0,0,1,0, a, 1,1);
       //create walls
        //score = 0;

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
