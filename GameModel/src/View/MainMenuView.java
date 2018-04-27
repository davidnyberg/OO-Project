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

public class MainMenuView{

    DisplayMain displayMain;
    private JPanel p1=new JPanel();
    private JPanel p2=new JPanel(new GridBagLayout());
    private GridBagConstraints c = new GridBagConstraints();
    private JButton play=new JButton("Play Game");
    private JButton ldrboard=new JButton("View Leaderboard");
    private JLabel l=new JLabel("Java Shooter Game");


    public MainMenuView(JFrame window, DisplayMain displayMain) {
        this.displayMain = displayMain;
        p2.add(play,c);
        p2.add(ldrboard,c);

        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                play.setText("clicked play");
                //set view to the game screen
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

        window.getContentPane().removeAll();
        window.add(p1, BorderLayout.NORTH);
        window.add(p2, BorderLayout.CENTER);
        window.getContentPane().revalidate();
        window.getContentPane().repaint();
    }

    public void actionPerformed(ActionEvent e){

    }

}