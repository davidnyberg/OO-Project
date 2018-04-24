package View;

import Controller.Game;

import javax.swing.*;
import java.awt.*;

public class GameView{

    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel(new GridBagLayout());
    private GridBagConstraints c = new GridBagConstraints();
    private Game g;

    public GameView(JFrame window, Game gameController) {
        this.g = gameController;

        p1.setBackground(Color.black);
        p2.setBackground(Color.black);

        window.getContentPane().removeAll();
        window.add(p1, BorderLayout.NORTH);
        window.add(p2, BorderLayout.CENTER);
        window.getContentPane().revalidate();
        window.getContentPane().repaint();
    }
}