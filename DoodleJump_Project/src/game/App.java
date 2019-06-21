package game;

import java.awt.EventQueue;

import view.DoodleAPP;

public class App {

	private static StartMenue menue;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menue = new StartMenue();
					menue.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
			}
		}
	});
}
}
