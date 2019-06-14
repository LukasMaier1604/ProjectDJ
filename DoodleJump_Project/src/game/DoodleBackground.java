package game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import models.DoodleObject;
import models.DoodlePlatform;
import models.DoodlePlayer;

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

	public void setAbstand(int abstand) {
		this.abstand = abstand;
	}

	public int getAbstand() {
		return abstand;
	}
	
	public DoodleBackground(int width, int height) {
		this.width = width;
		this.height = height;
		objects = new ArrayList<>();
		bottomPoint = new Point(0,height);
		//f�r die Startposition
		player = new DoodlePlayer( new Point(width/2 -30, height/2-40), 70, 70, "Doodle");
		objects.add(player);
	}

	
	public int getObjectSpeed() {
		for(DoodleObject o: objects) {
			if(!o.equals(player)) return o.getSpeed();
		}
	return 0;
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
		if (player.getPoint().x <= bottomPoint.x) {
			newPosition = new Point(player.getPoint().x + width -player.getWidth(),player.getPoint().y);
			player.setPoint(newPosition);
		}
		if (player.getPoint().x >= (bottomPoint.x + width)) {
			newPosition = new Point(player.getPoint().x - width,player.getPoint().y);
			player.setPoint(newPosition);
		}

	}


	public boolean bottomReached(DoodleObject player) {
		if (player.getPoint().y >= this.height) {
			return true;
		}

		return false;

	}

	public void generateStartingPlatform() {
		int y = 3;
		for (int i = 0; i < 15; i++) {

			DoodleObject plat = new DoodlePlatform(new Point ((int)(width * Math.random()*0.7),y),"Images/blockblack.png");
			objects.add(plat);
			y+=70;
		}
		abstand = player.getPoint().y; 
		
	
	}


	public boolean generateRadomPlatform() {
		DoodlePlatform plat;
		DoodleObject remove = null;
		boolean liste = true;
//		System.out.println(abstand + " ABSTAND");
//		System.out.println((abstand+200) + " ABSTAND +200");
//		System.out.println(player.getPoint().y + " PLAYER Y");
		plat = new DoodlePlatform(new Point ((int)(width * Math.random()*0.7),(int)(Math.random()* -10)-yVariable),"Images/blockblack.png");
		objects.add(plat);
		yVariable += 70;
		while(liste) {
			for(DoodleObject o: objects) {
				if(bottomReached(o)) {
					remove = o;
					liste = true;
					break;
				}
				else liste = false;
			
			}
			objects.remove(remove);
		}
			
			return true;

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
