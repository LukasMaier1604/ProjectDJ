package models;

import java.awt.Point;

public class DoodlePlatform extends DoodleObject{
	public int speed = 0;

	public DoodlePlatform ( Point point, String imgPath) {
		super(point, 50, 7, imgPath);							/*Standard Platform
																* aktuell 100x10
																* Nur hier bitte anpassen
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
