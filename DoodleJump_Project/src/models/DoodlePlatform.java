package models;

import java.awt.Point;

public class DoodlePlatform extends DoodleObject{
	public int speed = 0;

	public DoodlePlatform ( Point point, String imgPath) {
		super(point, 70, 20, imgPath);							/*Standard Platform
																* aktuell 70x20
																* Nur hier anpassen um die Standardgr��e zu gew�hrleisten
																*/


	}

	@Override
	public void move() {
		this.point = new Point(this.point.x, (this.point.y + speed));
		

	}
	
	@Override
	public int getSpeed(){
		return speed;
	}

	@Override
	public void setSpeed(int speed){
		this.speed = speed;
	}


}
