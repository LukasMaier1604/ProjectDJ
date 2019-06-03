package game;

import java.awt.Point;

public class DoodlePlatform extends DoodleObject{
	public int speed = 1;

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

}
