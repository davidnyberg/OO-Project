import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.JLabel;

public class SwingMenu extends JFrame{
	
	JPanel p1=new JPanel();
	JPanel p2=new JPanel(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	JButton b1=new JButton("Play Game");
	JButton b2=new JButton("View Leaderboard");
	JLabel l=new JLabel("Java Shooter Game");
	
	public static void main(String[] args) {
		new SwingMenu();
	}
	
	public SwingMenu() {
		super("Main Menu");
		setBackground(Color.red);
		setSize(700, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		p2.add(b1,c);
		p2.add(b2,c);
		
		l.setFont(new Font("Helvetica", Font.PLAIN, 40));
		l.setHorizontalAlignment(JLabel.CENTER);
		l.setForeground(Color.WHITE);
		p1.setBackground(Color.black);
		p2.setBackground(Color.black);
		p1.add(l);
		p2.add(b1);
		p2.add(b2);
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		
		setVisible(true);
	}
}