package game;

import java.awt.Point;

public class DoodlePlayer extends DoodleObject{

	private int speed = -13;
	private double force = 1;
	private String name;


	public DoodlePlayer (Point point, int width, int height, String name) {
		super (point,width,height,"Images/Kreis.png");
		this.name = name;

	}


	public void moveLeft(int frameTime) {
		Point newPosition = new Point(point.x - (int) (force*frameTime) ,point.y);
		point = newPosition;

	}
	public void moveRight(int frameTime) {
		Point newPosition = new Point(point.x + (int) (force*frameTime) ,point.y);
		point = newPosition;

	}


	@Override
	public void move() {
		if (speed < 50)speed =  (speed +1);
		try {
			Thread.sleep(15);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.point = newPlayerMoveUp(speed);

	}

	public Point newPlayerMoveUp(int speed) {
			return new Point(this.point.x, (this.point.y + speed));


	}
	@Override
	public void setSpeed(int x) {
		this.speed = x;
	}

	public int getSpeed() {
		return this.speed;
	}




}
