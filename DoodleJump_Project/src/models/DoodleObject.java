package models;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Image;

public abstract class DoodleObject {

	protected Point point;
	protected int width;
	protected int height;
	private String imgPath;
	private BufferedImage  img; 


	public DoodleObject(){
	}

	public DoodleObject( Point point, int width, int height, String imgPath){
		this.point = point;
		this.width = width;
		this.height = height;
		this.imgPath =imgPath;
		loadImage(imgPath);
	}


	public void loadImage(String imgPath) {
		try {
			img = ImageIO.read( new File( imgPath ) );
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
//	private void loadImage() {
//		try {
//			img = ImageIO.read( new File( imgPath ) );
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	public Image getImage() {
		return img;
	}
	
	public abstract void move();
	public abstract void setSpeed(int x);
	public abstract int getSpeed();
	
}
