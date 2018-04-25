package Controller;

import Model.*;
import View.GameView;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class Game {
    private JFrame window;
    private List<Wall> walls;
    private Player player;
    private List<Enemy> enemies;
    private List<Bullet> bullets;

    Game(JFrame window) {
       //create view
       this.window = window;
       new GameView(window,this);

       //initialize objects
       //player = new Player(0,0,1,0, a, 1,1);
       //create walls

    }

    public void GameLoop(){
        //start game loop
        while (true){
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
