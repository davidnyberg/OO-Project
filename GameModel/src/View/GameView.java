package View;

import Controller.Game;

import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {

    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel(new GridBagLayout());
    private GridBagConstraints c = new GridBagConstraints();
    private Game g;

    public GameView(Game g) {
        super("Main Menu");
        this.g = g;
        //this.displayMain = displayMain;
        setBackground(Color.red);
        setSize(700, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);

        p1.setBackground(Color.black);
        p2.setBackground(Color.black);

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);

        setVisible(true);
    }
}