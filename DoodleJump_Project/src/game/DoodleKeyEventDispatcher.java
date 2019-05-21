package game;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class DoodleKeyEventDispatcher implements KeyEventDispatcher {

	private ArrayList<Integer> keysPressed;
	
	public DoodleKeyEventDispatcher(ArrayList<Integer> keysPressed) {
		this.keysPressed = keysPressed;
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
//		System.out.println("KeyPressed: " + e.getKeyCode());
		if(e.getID() == KeyEvent.KEY_PRESSED) {
			if(!keysPressed.contains(e.getKeyCode())) {
				keysPressed.add(e.getKeyCode());
			}
		} else if(e.getID() == KeyEvent.KEY_RELEASED) {
			keysPressed.remove((Integer) e.getKeyCode());
		}

		return false;
	}

}

