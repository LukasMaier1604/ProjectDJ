package game;

import java.awt.Point;
import java.util.ArrayList;

public class DoodleBackground{
	private Point bottomPoint;		// Punkt der links-unteren Ecke
	private int width;
	private int height;
	private DoodlePlayer player;
	private ArrayList<DoodleObject> objects;					// zur Darstellung muss der springende Punkt auch in die Liste
																// einfache if/not-Abfrage f�r die Plattformen sp�ter

	public DoodleBackground(int width, int height) {
		this.width = width;
		this.height = height;
		objects = new ArrayList<>();
		bottomPoint = new Point(0,height);
		//f�r die Startposition
		player = new DoodlePlayer( new Point(width/2 -30, height/2-40), 60, 60, "Doodle");
		objects.add(player);
	}

	public DoodlePlayer getPlayer() {
		return player;
	}

	public ArrayList<DoodleObject> getObjects() {
		return objects;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	// warum braucht es den Punkt links-unten?
//	public DoodleBackground(Point bottomPoint, int width, int height, DoodlePlayer player) {
//
//		this.bottomPoint = bottomPoint;
//		this.player = player;
//		this.width = width;
//		this.height = height;
//	}



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
		if (score <= 100){
			for (int i = 0; i < 3; i++) {
				plat = new DoodlePlatform(new Point ((int)(width * Math.random())-50,(int)(Math.random()* -20)),"Images/blockblack.png");
				objects.add(plat);
			}
		}
		if (score >= 100){
			for (int i = 0; i < 2; i++) {
				plat = new DoodlePlatform(new Point ((int)(width * Math.random())-50,(int)(Math.random()* -20)),"Images/blockblack.png");
				objects.add(plat);
				}
		}
		if (score > 150){
			for (int i = 0; i < 1; i++) {
				plat = new DoodlePlatform(new Point ((int)(width * Math.random())-50,(int)(Math.random()* -20)),"Images/blockblack.png");
				objects.add(plat);
			}
		}
	}

}
