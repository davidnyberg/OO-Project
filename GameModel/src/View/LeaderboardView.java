package View;

import Controller.DisplayMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeaderboardView{

  private DisplayMain displayMain;
  private JPanel p1=new JPanel();
  private JPanel p2=new JPanel(new GridBagLayout());
  private JButton back = new JButton("Back to Main Menu");
  private JLabel l=new JLabel("High Scores");


  public LeaderboardView(JFrame window, DisplayMain displayMain) {
    this.displayMain = displayMain;

    l.setHorizontalAlignment(JLabel.CENTER);
    l.setForeground(Color.WHITE);
    p1.setBackground(Color.black);
    p2.setBackground(Color.black);
    p1.add(l);
    p2.add(back);

    //clear window
    window.getContentPane().removeAll();

    //add new panels and refresh
    window.add(p1, BorderLayout.NORTH);
    window.add(p2, BorderLayout.CENTER);
    window.getContentPane().revalidate();
    window.getContentPane().repaint();

    back.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        displayMain.BackButton();
      }
    });
  }
}
