package View;

import Controller.DisplayMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Leadboard extends JFrame {

    private DisplayMain displayMain;
    private JPanel p1=new JPanel();
    private JPanel p2=new JPanel(new GridBagLayout());
    private GridBagConstraints c = new GridBagConstraints();
    private JButton back = new JButton("Back to Main Menu");
    private JLabel l=new JLabel("High Scores");


    public Leadboard(DisplayMain displayMain) {
        super("High Scores");
        this.displayMain = displayMain;
        setBackground(Color.red);
        setSize(700, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);
        l.setHorizontalAlignment(JLabel.CENTER);
        l.setForeground(Color.WHITE);
        p1.setBackground(Color.black);
        p2.setBackground(Color.black);
        p1.add(l);
        p2.add(back);
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMain.BackButton();
            }
        });

        setVisible(true);
    }
}
