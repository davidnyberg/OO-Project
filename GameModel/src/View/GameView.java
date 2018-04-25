package View;

import Controller.Game;
import Model.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.util.List;

import static java.awt.Color.black;

public class GameView extends Canvas {

    //private JPanel p1 = new JPanel();
    //private JPanel p2 = new JPanel(new GridBagLayout());
    private GridBagConstraints c = new GridBagConstraints();
    private Game g;
    private List<GameObject> gameObjects;
    private int HEIGHT = 400;
    private int WIDTH = 700;

    public GameView(JFrame window, Game gameController, List<GameObject> o) {
        this.g = gameController;
        this.gameObjects = o;
        //p1.setBackground(Color.black);
       // p2.setBackground(Color.black);


        //BufferStrategy bs = c.getBufferStrategy();
        //if (bs == null){
        //    c.createBufferStrategy(3);
        //}
        //Graphics g = bs.getDrawGraphics();
        //g.setColor(black);
        //g.fillRect(10,10,10,10);
        //bs.show();

      /*  if (gameObjects != null){
            for (GameObject ob : gameObjects) {
                     }
        }*/
       // window.getContentPane().add(j);
        //Rectangle square = new Rectangle(10,10,10,10);
        //window.add(p1, BorderLayout.NORTH);
        //window.add(p2, BorderLayout.CENTER);
        //square.setBounds(10,10,10,10);

        //g.drawRect(10,10,10,10);
        //g.setColor(black);
        //g.fillRect(10,10,10,10);
     //   window.add(j);
        
       // window.getContentPane().revalidate();
        //window.getContentPane().repaint();
    }

    public void paint(Graphics g) {
        g.fillRect(0, 0, WIDTH, HEIGHT);
        for (GameObject ob : gameObjects){
            ob.render(g);
        }

    }
}

