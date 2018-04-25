package View;

import Controller.DisplayMain;
import Model.DataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeaderboardView{

  private DataBase con = new DataBase();
  private DisplayMain displayMain;
  private JPanel p1=new JPanel();
  private JPanel p2=new JPanel(new GridBagLayout());
  private JButton back = new JButton("Back to Main Menu");
  private JLabel l=new JLabel("High Scores");
  private JTextField s1 = new JTextField("score 1");
  private JTextField s2 = new JTextField("score 2");
  private JTextField s3 = new JTextField("score 3");
  private JTextField s4 = new JTextField("score 4");
  private JTextField s5 = new JTextField("score 5");

  public LeaderboardView(JFrame window, DisplayMain displayMain) {
    this.displayMain = displayMain;

    l.setHorizontalAlignment(JLabel.CENTER);
    //l.setVerticalAlignment(JTextField.CENTER);
    l.setForeground(Color.WHITE);
    p1.setBackground(Color.black);
    p2.setBackground(Color.black);
    s1.setBounds(30,40, 200,40);
    s2.setBounds(30,60, 200,40);
    s3.setBounds(30,80, 200,40);
    s4.setBounds(30,100, 200,40);
    s5.setBounds(30,120, 200,40);
    s1.setEditable(false); s2.setEditable(false); s3.setEditable(false);
    s4.setEditable(false); s5.setEditable(false);
    //String a = con.getScore();
    //for (int i = 0; i < arr.length; i++){

    //}
    //String a = (String)con.getScore();
    s1.setText(con.getScore());
    s2.setText(con.getScore());
    p2.add(s1);
    p2.add(s2);
    p2.add(s3);
    p2.add(s4);
    p2.add(s5);
    p1.add(l);
    p2.add(back);

    //clear window
    window.getContentPane().removeAll();

    //add new panels and refresh
    window.add(p1, BorderLayout.NORTH);
    window.add(p2, BorderLayout.CENTER);
    //window.add(s1, BorderLayout.CENTER);
    //window.add(s2, BorderLayout.CENTER);
    //window.add(s3, BorderLayout.CENTER);
    //window.add(s4, BorderLayout.CENTER);
    //window.add(s5, BorderLayout.CENTER);
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
