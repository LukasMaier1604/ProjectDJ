package game;

import java.awt.Point;
import java.util.ArrayList;

public class DoodleBackground{
	private Point bottomPoint;		// Punkt der links-unteren Ecke
	private int width;
	private int height;
	private DoodlePlayer player;
	
		
	
	public DoodleBackground(Point bottomPoint, int width, int height, DoodlePlayer player) {
		
		this.bottomPoint = bottomPoint;
		this.player = player;
		this.width = width;
		this.height = height;
		this.player = player;
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
	
}
