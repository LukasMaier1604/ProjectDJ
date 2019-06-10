package game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class DoodleBackground{
	private Point bottomPoint;		// Punkt der links-unteren Ecke
	private int width;
	private int height;
	private int speed;
	private DoodlePlayer player;
	private ArrayList<DoodleObject> objects;
	private int yVariable;
	private int grenze;
	private int abstand;
																// zur Darstellung muss der springende Punkt auch in die Liste
																// einfache if/not-Abfrage f�r die Plattformen sp�ter

	public int getAbstand() {
		return abstand;
	}

	public DoodleBackground(int width, int height) {
		this.width = width;
		this.height = height;
		objects = new ArrayList<>();
		bottomPoint = new Point(0,height);
		//f�r die Startposition
		player = new DoodlePlayer( new Point(width/2 -30, height/2-40), 30, 30, "Doodle");
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
		if (player.point.x <= bottomPoint.x) {
			newPosition = new Point(player.point.x + width -player.getWidth(),player.point.y);
			player.point = newPosition;
		}
		if (player.point.x >= (bottomPoint.x + width)) {
			newPosition = new Point(player.point.x - width,player.point.y);
			player.point = newPosition;
		}

	}


	public boolean bottomReached(DoodlePlayer player) {
		if (player.point.y >= this.height) {
			return true;
		}

		return false;

	}

	public void generateStartingPlatform() {
		int y = 3;
		for (int i = 0; i < 15; i++) {

			DoodleObject plat = new DoodlePlatform(new Point ((int)(width * Math.random()*0.7),y),"Images/blockblack.png");
			objects.add(plat);
			y+=50;
		}
		abstand = player.point.y; 
		
	
	}


	public boolean generateRadomPlatform() {
		DoodlePlatform plat;

		if (player.point.y  < abstand - 130 ){

			for (int i = 0; i<7; i++ ){
				plat = new DoodlePlatform(new Point ((int)(width * Math.random()*0.7),(int)(Math.random()* -10)-yVariable),"Images/blockblack.png");
				objects.add(plat);
				yVariable += 50;

			}
			yVariable = 0;
			abstand = player.point.y; 
			return true;
		}

		return false;

	}
	public void getConsoleObjects() {
		for(DoodleObject o: objects) {
			System.out.println("X CORD: " + o.getPoint().x);
			System.out.println("Y CORD: " + o.getPoint().y);
		}
	}




	public void moveAll () {
		for(DoodleObject o: objects) {
			o.move();
		}
	}
}
