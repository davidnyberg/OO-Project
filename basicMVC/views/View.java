package views;

import java.awt.*;
import javax.swing.*;

public class View
{
  private JFrame frame;
  private JLabel label;
  private JButton button;
  
  public View(String text)
  {
    frame = new JFrame("View");
    frame.getContentPane().setLayout(new BorderLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200,200);
    
    label = new JLabel(text, JLabel.CENTER);
    frame.getContentPane().add(label, BorderLayout.CENTER);
    
    button = new JButton("Button");
    frame.getContentPane().add(button, BorderLayout.SOUTH);
    frame.setVisible(true);
  }
  public JButton getButton()
  {
    return button;
  }
  public void setText(String text)
  {
    label.setText(text);
  }
  
  public void drawSquare()
  {
    System.out.println("drawSquare called");
    Graphics2D g = (Graphics2D)frame.getGraphics();
    
    //this can be made into it's own class, such as "class Wall extends JPanel"
    //but must have @Override on paintComponent for custom shape
    JPanel panel = new JPanel(){
      @Override
      public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(0, 0, 100, 100);
      }
    };

    frame.add(panel); 
    frame.validate();
    frame.repaint();
  }
}