package game;

import java.util.ArrayList;

public class Engine {
	private DoodleAPP app;
	private DoodlePlayer player;
	private ArrayList<DoodleObject> objects;
	private DoodleBackground umgebung;
	
	public Engine (DoodleAPP app) {
		this.umgebung = app.getUmgebung();
		this.objects = umgebung.getObjects();
		this.player = umgebung.getPlayer();
	}
	
	public boolean checkCollision() {
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
	
	public boolean platformActive() {
		for(DoodleObject object : objects) {
			if (umgebung.bottomReached(object.point.y - object.height) && !object.equals(player)) {
				return false;
			}
			if ((object.point.y - object.height - 1) == player.point.y || (object.point.y - object.height - 1) > player.point.y && !object.equals(player)) {
				return true;
			}
		}
		return false;
	}
	public boolean gameOver() {
		if (umgebung.bottomReached(player.point.y)) {
			return true;
		}
		return false;
	}
	

}
