package movement;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		System.out.println(key);
		System.out.println(handler.object.size());
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.Player) {
				if(key == KeyEvent.VK_UP) tempObject.setY(tempObject.getY()-15);
				else if(key == KeyEvent.VK_DOWN) tempObject.setY(tempObject.getY()+15);
				else if(key == KeyEvent.VK_RIGHT) tempObject.setX(tempObject.getX()+15);
				else if(key == KeyEvent.VK_LEFT) tempObject.setX(tempObject.getX()-15);
			}
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
	}
}
