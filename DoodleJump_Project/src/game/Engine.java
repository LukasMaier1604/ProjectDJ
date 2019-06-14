package game;

import java.util.ArrayList;

import models.DoodleObject;
import models.DoodlePlayer;

public class Engine {
	private DoodleAPP app;
	private DoodlePlayer player;
	private DoodleBackground umgebung;
	private DoodleObject aktuel = null;
	public boolean gleich = true;
	
	public Engine (DoodleAPP app) {
		this.app = app;
		this.umgebung = app.getUmgebung();
		this.player = umgebung.getPlayer();
	}
	
	public boolean checkCollision(ArrayList<DoodleObject> objects) {
		for(DoodleObject object : objects) {
//			System.out.println(gleich);
//			System.out.println(object.point.y + "Y CORD PLAT");
//			System.out.println(player.point.y + "Y CORD PLAYER");
			if(((player.getPoint().y + player.getHeight() >= (object.getPoint().y +object.getHeight() -5 )
					&& player.getPoint().y <= (object.getPoint().y +5))		
					&& !object.equals(player))
					&& ((player.getPoint().x + player.getWidth()) > object.getPoint().x			//X Achse
					&& player.getPoint().x < (object.getPoint().x + object.getWidth()))&& player.getSpeed()>0) {
				if (object.equals(aktuel)) gleich = true;
				if (!object.equals(aktuel)) gleich = false;
				aktuel = object;
				return true;
			}
		}
		return false;
	}

	/*public boolean platformActive(ArrayList<DoodleObject> objectsActive, ArrayList<DoodleObject> objectsInactive) {
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
	}*/
//	public boolean gameOver() {
//		if (umgebung.bottomReached(player.point.y)) {
//			return true;
//		}
//		return false;
//	}
	

}
