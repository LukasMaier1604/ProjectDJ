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
																// zur Darstellung muss der springende Punkt auch in die Liste
																// einfache if/not-Abfrage f�r die Plattformen sp�ter

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
		if (player.point.x == bottomPoint.x) {
			newPosition = new Point(player.point.x + (this.width),player.point.y);
			player.point = newPosition;
		}
		if (player.point.x == (bottomPoint.x + width)) {
			newPosition = new Point(player.point.x - bottomPoint.x,player.point.y);
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
		for (int i = 0; i < 7; i++) {

			DoodleObject plat = new DoodlePlatform(new Point ((int)(width * Math.random()*0.7),y),"Images/blockblack.png");
			objects.add(plat);
			y+=64;
		}
	
	}


	public boolean generateRadomPlatform(int runTime) {
		DoodlePlatform plat;
//		if (score <= 100){
//		for (int i = 0; i < 3; i++) {
//				plat = new DoodlePlatform(new Point ((int)(width * Math.random())-50,(int)(Math.random()* -20)),"Images/blockblack.png");
//				objects.add(plat);
//			}
//		}
//		if (score >= 100){
//			for (int i = 0; i < 2; i++) {
/*				plat = new DoodlePlatform(new Point ((int)(width * Math.random())-50,(int)(Math.random()* -20)),"Images/blockblack.png");
				objects.add(plat);
				}
		}
		if (score > 150){
			for (int i = 0; i < 1; i++) {
				plat = new DoodlePlatform(new Point ((int)(width * Math.random())-50,(int)(Math.random()* -20)),"Images/blockblack.png");
				objects.add(plat);
			}
		}
		*/
		if (runTime >= 7){
			System.out.println(runTime + "    <--   RunTime");

			for (int i = 0; i<7; i++ ){
				plat = new DoodlePlatform(new Point ((int)(width * Math.random()),(int)(Math.random()* -10)-yVariable),"Images/blockblack.png");
				objects.add(plat);
				yVariable += 64;

			}
			yVariable = 0;
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

//	public void playerMoveUp () {
//
//		int speed = -128;
//		System.out.println(player.point.x+ " :X  " + player.point.y + " :Y");
//
//
//		while(speed < -1) {
//			speed = speed /2;
//			player.point = new Point(player.point.x, (player.point.y + speed));
//			System.out.println(player.point.x+ " :X  " + player.point.y + " :Y");
//		}
//		while (speed == -1) {
//			speed = 0;
//			player.point = new Point(player.point.x, (player.point.y + speed));
//
//		}
//		while (speed == 0) {
//			speed = 1;
//			player.point = new Point(player.point.x, (player.point.y + speed));
//			System.out.println(player.point.x+ " :X  " + player.point.y + " :Y");
//
//		}
//		while (speed >= 1) {
//			if (speed< 64)speed = speed *2;
//			player.point = new Point(player.point.x, (player.point.y + speed));
//			System.out.println(player.point.x+ " :X  " + player.point.y + " :Y");
//			if(player.point.y > 800) break;
//		}
//
//	}
//	public Point newPlayerMoveUp(int speed) {
//		while(speed < -1) {
//			speed = speed /2;
//			return new Point(player.point.x, (player.point.y + speed));
//		}
//		return null;
//	}
//	public void newPlayerPoint (Point point){
//		player.point = point;
//	}


	public void moveAll () {
		for(DoodleObject o: objects) {
			o.move();
//			teleportToBorder();
		}
	}
}
