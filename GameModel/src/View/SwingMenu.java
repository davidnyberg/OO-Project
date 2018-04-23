package View;

import Controller.*;
import Model.*;



import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SwingMenu extends JFrame implements ActionListener{

    public DisplayMain displayMain;
    private JPanel p1=new JPanel();
    private JPanel p2=new JPanel(new GridBagLayout());
    private GridBagConstraints c = new GridBagConstraints();
    private JButton play=new JButton("Play Game");
    private JButton ldrboard=new JButton("View Leaderboard");
    private JLabel l=new JLabel("Java Shooter Game");


    public SwingMenu(DisplayMain displayMain) {
        super("Main Menu");
        this.displayMain = displayMain;
        setBackground(Color.red);
        setSize(700, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);
        p2.add(play,c);
        p2.add(ldrboard,c);


        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                play.setText("clicked play");
                //set view to the game screen
                //new GameView();
                displayMain.PlayPressed();
            }
        });

        ldrboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //changes frame to leaderboard
                displayMain.Leaderboard();
            }
        });

        l.setFont(new Font("Helvetica", Font.PLAIN, 40));
        l.setHorizontalAlignment(JLabel.CENTER);
        l.setForeground(Color.WHITE);
        p1.setBackground(Color.black);
        p2.setBackground(Color.black);
        p1.add(l);
        p2.add(play);
        p2.add(ldrboard);
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

    }

}