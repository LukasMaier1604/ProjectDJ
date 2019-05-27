package game;

import java.awt.EventQueue;

public class App {

	private static DoodleAPP spiel;
	private static StartMenue menue;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menue = new StartMenue(spiel);
					menue.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
			}
		}
	});
}
}
