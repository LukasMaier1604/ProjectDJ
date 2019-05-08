package game;

import java.awt.Point;
import java.util.ArrayList;

public class DoodleBackground{
	private Point bottomPoint;		// Punkt der links-unteren Ecke
	private int width;
	private int height;
	private DoodlePlayer player;
	private ArrayList<DoodlePlatform> listPlat;
	
		
	
	public DoodlePlayer getPlayer() {
		return player;
	}

	public ArrayList<DoodlePlatform> getListPlat() {
		return listPlat;
	}

	public DoodleBackground(Point bottomPoint, int width, int height, DoodlePlayer player) {
		
		this.bottomPoint = bottomPoint;
		this.player = player;
		this.width = width;
		this.height = height;
	}
	
	public void teleportToBorder() {
		Point newPosition;
		if (player.point.x == bottomPoint.x) {
			newPosition = new Point(player.point.x + (width),player.point.y);
			player.point = newPosition;
		}
		if (player.point.x == (bottomPoint.x + width)) {
			newPosition = new Point(player.point.x - bottomPoint.x,player.point.y);
			player.point = newPosition;
		}
			
	}


	public boolean bottomReached(int yPosition) {
		if (yPosition == bottomPoint.y) {
			return true;
		}
		else {
			return false;
		}
		
	}
	public void generateRadomPlatform(int score) {
		DoodlePlatform plat;
		int y = player.point.y;
		if (score <= 100){
			for (int i = 0; i < 3; i++) {
				plat = new DoodlePlatform((new Point(),"");
			}
		}
		if (score >= 100){
			for (int i = 0; i < 2; i++) {
				
			}
		}
		if (score > 150){
			for (int i = 0; i < 1; i++) {
				
			}
		}
	}
	
}
