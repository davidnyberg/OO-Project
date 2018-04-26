package Controller;

import Controller.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardInput extends KeyAdapter{
    Game g;
    public KeyboardInput(Game game_){
        this.g = game_;

    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        int dx = 0;
        int dy = 0;
        if (key == KeyEvent.VK_W){
            dy --;
        }
        if (key == KeyEvent.VK_A){
            dx--;
        }
        if (key == KeyEvent.VK_S){
            dy++;
        }
        if (key == KeyEvent.VK_D){
            dx++;
        }

        this.g.movePlayer(dx, dy);

        System.out.println(key);
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

    }
}
