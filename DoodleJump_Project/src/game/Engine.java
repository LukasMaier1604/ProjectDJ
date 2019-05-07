package game;

import java.util.ArrayList;

public class Engine {
	private DoodlePlayer player;
	private ArrayList<DoodlePlatform> plat;
	private DoodleBackground umgebung;
	
	public Engine (DoodleBackground umgebung) {
		this.umgebung = umgebung;
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
			if (DoodleBackground.bottomReached(plat.point.y + plat.height)
		}
	}

}
