package View;

import Controller.Game;
import Model.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.util.List;

import static java.awt.Color.black;
import static java.awt.Color.gray;

public class GameView extends Canvas {

    private JFrame window;
    private Game g;
    private int height;
    private int width;

    public GameView(JFrame window, Game gameController, int height, int width, List<GameObject> o) {

        this.window = window;
        this.window.setResizable(false);
        window.getContentPane().removeAll();
        this.window.add(this);

        this.height = height;
        this.width = width;

        this.g = gameController;
    }

    //renders all objects and refresh window
    public void paint(Graphics g) {
        //window.getContentPane().removeAll();
        //background
        g.setColor(gray);
        g.fillRect(0, 0, width, height);
        for (GameObject ob : this.g.getAllObjects()){
            ob.render(g);
        }
    }
}

