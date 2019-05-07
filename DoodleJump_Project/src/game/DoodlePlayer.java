package game;

import java.awt.Point;

public class DoodlePlayer extends DoodleObject{
	
	private double speed = 0.1;
	private String name;
 
	
	public DoodlePlayer (Point point, int width, int height, String imgPath, DoodleBackground umgebung, String name) {
		super (point,width,height,imgPath);
		this.name = name;
	}
	
	
	public void moveLeft(int frameTime) {
		Point newPosition = new Point(point.x - (int) (speed*frameTime) ,point.y);
//		DoodleBackground.teleportToBorder(); kommt das in Controlls oder hier her?
		point = newPosition;
		
	}
	public void moveRight(int frameTime) {
		Point newPosition = new Point(point.x - (int) (speed*frameTime) ,point.y);
//		DoodleBackground.teleportToBorder();
		point = newPosition;
		
	}
	

}
