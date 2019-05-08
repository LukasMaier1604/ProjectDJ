package game;

import java.awt.EventQueue;

public class App {

	private static DoodleAPP spiel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoodleAPP frame = new DoodleAPP();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
			}
		}
	});
}
}
