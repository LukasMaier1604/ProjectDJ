package game;

import java.util.ArrayList;

public class Engine {
	private DoodleAPP app;
	private DoodlePlayer player;
	private ArrayList<DoodlePlatform> plat;
	private DoodleBackground umgebung;
	
	public Engine (DoodleAPP app) {
		this.umgebung = app.getUmgebung();
		this.plat = umgebung.getListPlat();
		this.player = umgebung.getPlayer();
	}
	
	public boolean checkCollision() {
		for(DoodlePlatform plat : plat) {
			if(player.point.y == plat.point.y 
					&& (player.point.x + player.width) > plat.point.x
					&& player.point.x < (plat.point.x + plat.width)) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	
	public boolean platformVisible() {
		for(DoodlePlatform plat : plat) {
			if (umgebung.bottomReached(plat.point.y + plat.height)) {
				return false;
			}
			if ((plat.point.y + plat.height + 1) == player.point.y || (plat.point.y + plat.height + 1) > player.point.y) {
				return true;
			}
		}
		return false;
	}

}
