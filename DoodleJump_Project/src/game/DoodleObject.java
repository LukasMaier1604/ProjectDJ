package game;

import java.awt.Point;

public class DoodleObject {

	protected Point point;
	protected int width;
	protected int height;
	private String imgPath;



	public DoodleObject(){
	}

	public DoodleObject( Point point, int width, int height, String imgPath){
		this.point = point;
		this.width = width;
		this.height = height;
		this.imgPath =imgPath;

	}


	public Point getPoint() {
		return point;
	}


	public void setPoint(Point point) {
		this.point = point;
	}

	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}

	
	public String getImgPath() {
		return imgPath;
	}

	
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	
}
