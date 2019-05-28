package game;

import java.util.ArrayList;

public class Engine {
	private DoodleAPP app;
	private DoodlePlayer player;
	private DoodleBackground umgebung;
	
	public Engine (DoodleAPP app) {
		this.app = app;
		this.umgebung = app.getUmgebung();
		this.player = umgebung.getPlayer();
	}
	
	public boolean checkCollision(ArrayList<DoodleObject> objects) {
		for(DoodleObject object : objects) {
//			System.out.println(object.point.y + "Y CORD PLAT");
//			System.out.println(player.point.y + "Y CORD PLAYER");
			if(((player.point.y + player.height >= (object.point.y +object.height -10 )
					&& player.point.y <= (object.point.y +10))		
					&& !object.equals(player))
					&& ((player.point.x + player.width) > object.point.x			//X Achse
					&& player.point.x < (object.point.x + object.width))) {

				
				return true;
				
			}
		}
		return false;
	}

	public boolean platformActive(ArrayList<DoodleObject> objectsActive, ArrayList<DoodleObject> objectsInactive) {
		for (DoodleObject inactiveObject : objectsInactive) {
			if ((inactiveObject.point.y - inactiveObject.height - 1) >= player.point.y && inactiveObject.width != player.width) {
				objectsActive.add(inactiveObject);
//				objectsInactive.remove(inactiveObject);
				return true;
			}
		}
//		for(DoodleObject object : objectsActive) {
//			if (umgebung.bottomReached(object.point.y ) && object.width != player.width) {
//				objectsActive.remove(object);
//				objectsInactive.remove(object);
//				return false;
//			}
//		}
		return false;
	}
//	public boolean gameOver() {
//		if (umgebung.bottomReached(player.point.y)) {
//			return true;
//		}
//		return false;
//	}
	

}
