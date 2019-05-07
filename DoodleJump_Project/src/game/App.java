package game;

import java.awt.EventQueue;

public class App {

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoodleApp frame = new DoodleApp();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
			}
		}
	});
}
}
