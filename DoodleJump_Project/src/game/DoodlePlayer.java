package game;

import java.awt.Point;

public class DoodlePlayer extends DoodleObject{
	
	private int speed = -24;
	private double force = 2.1; 
	private String name;
 
	
	public DoodlePlayer (Point point, int width, int height, String name) {
		super (point,width,height,"Images/Kreis.png");
		this.name = name;
		
	}
	
	
	public void moveLeft(int frameTime) {
		Point newPosition = new Point(point.x - (int) (force*frameTime) ,point.y);
//		DoodleBackground.teleportToBorder(); kommt das in Controlls oder hier her?
		point = newPosition;
		
	}
	public void moveRight(int frameTime) {
		Point newPosition = new Point(point.x + (int) (force*frameTime) ,point.y);
//		DoodleBackground.teleportToBorder();
		point = newPosition;
		
	}


	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println(speed);
		if (speed < 50)speed =  (speed +2);
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(speed == -10) speed = 2;
		this.point = newPlayerMoveUp(speed);
		
	}
//	public void constantBeschl (Point playerpoint) {
//		int con = 32;
//		while(con < 1) {
//			con = con /2;
//			playerpoint = new Point (this.point.x,this.point.y + con);
//			System.out.println(playerpoint.x + " :X  " + playerpoint.y + " :Y");
//		}
//		while (con == 1) {
//			con = 0;
//			playerpoint = new Point (this.point.x,this.point.y + con);
//			}
//		while (con == 0) {
//			con = -1;
//			playerpoint = new Point (this.point.x,this.point.y + con);
//			System.out.println(playerpoint.x + " :X  " + playerpoint.y + " :Y");
//		}
//		while (con < -1) {
//			con = con *2;
//			playerpoint = new Point (this.point.x,this.point.y + con);	
//			System.out.println(playerpoint.x + " :X  " + playerpoint.y + " :Y");
//		}
//		
//	}
	public Point newPlayerMoveUp(int speed) {

//			speed = (int) (speed *0.5) ;
			return new Point(this.point.x, (this.point.y + speed));


	}
	public void setSpeed(int x) {
		this.speed = x;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	
	

}
