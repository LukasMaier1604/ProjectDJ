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
			if(player.point.y == (object.point.y + object.height) 
					&& (player.point.x + player.width) > object.point.x
					&& player.point.x < (object.point.x + object.width) && !object.equals(player)) {
				return true;
				
			}
			else {
				return false;
			}
		}
		return false;
	}

	public boolean platformActive(ArrayList<DoodleObject> objectsActive, ArrayList<DoodleObject> objectsInactive) {
		for (DoodleObject inactiveObject : objectsInactive) {
			if ((inactiveObject.point.y - inactiveObject.height - 1) >= player.point.y && !inactiveObject.equals(player)) {
				objectsActive.add(inactiveObject);
				objectsInactive.add(inactiveObject);
			}
		}
		for(DoodleObject object : objectsActive) {
			if (umgebung.bottomReached(object.point.y ) && !object.equals(player)) {
				objectsActive.remove(object);
				objectsInactive.remove(object);
				return false;
			}
		}
		return false;
	}
//	public boolean gameOver() {
//		if (umgebung.bottomReached(player.point.y)) {
//			return true;
//		}
//		return false;
//	}
	

}
