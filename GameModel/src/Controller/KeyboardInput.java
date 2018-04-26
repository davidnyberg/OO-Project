package Controller;

import Controller.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardInput extends KeyAdapter{
    Game g;
    boolean W = false;
    boolean A = false;
    boolean S = false;
    boolean D = false;

    boolean SPACE = false;

    boolean LEFT = false;
    boolean RIGHT = false;
    boolean UP = false;
    boolean DOWN = false;

    public KeyboardInput(Game game_){
        this.g = game_;

    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        //moving
        if (key == KeyEvent.VK_W){
            W = true;
        }
        if (key == KeyEvent.VK_A){
            A = true;
        }
        if (key == KeyEvent.VK_S){
            S = true;
        }
        if (key == KeyEvent.VK_D){
            D = true;
        }
        //aiming
        if (key == KeyEvent.VK_LEFT){
            LEFT = true;
        }
        if (key == KeyEvent.VK_RIGHT){
            RIGHT = true;
        }
        if (key == KeyEvent.VK_UP){
            UP = true;
        }
        if (key == KeyEvent.VK_DOWN){
            DOWN = true;
        }
        //shooting
        if (key == KeyEvent.VK_SPACE){
            SPACE = true;
        }
        //send to game object
        this.g.HandleInput(W,A,S,D, SPACE, LEFT, RIGHT, UP, DOWN);

    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        //moving
        if (key == KeyEvent.VK_W){
            W = false;
        }
        if (key == KeyEvent.VK_A){
            A = false;
        }
        if (key == KeyEvent.VK_S){
            S = false;
        }
        if (key == KeyEvent.VK_D){
            D = false;
        }
        //aiming
        if (key == KeyEvent.VK_LEFT){
            LEFT = false;
        }
        if (key == KeyEvent.VK_RIGHT){
            RIGHT = false;
        }
        if (key == KeyEvent.VK_UP){
            UP = false;
        }
        if (key == KeyEvent.VK_DOWN){
            DOWN = false;
        }
        //shooting
        if (key == KeyEvent.VK_SPACE){
            SPACE = false;
        }
        //send to game object
        this.g.HandleInput(W,A,S,D, SPACE, LEFT, RIGHT, UP, DOWN);


    }
}