package game;

public class DoodleObject {

	protected Point point;
	protected int width;
	protected int height;
	private String imgPath;

}

	public DoodleObject(){
	}

	public DoodleObject( Point point, int width, int height){
		this.point = point;
		this.width = width;
		this.height = height;

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

	/**
	* Returns value of imgPath
	* @return
	*/
	public String getImgPath() {
		return imgPath;
	}

	/**
	* Sets new value of imgPath
	* @param
	*/
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	/**
	* Returns value of t
	* @return
	*/
	public DoodleObjec getT() {
		return t;
	}

	/**
	* Sets new value of t
	* @param
	*/
	public void setT(DoodleObjec t) {
		this.t = t;
	}

	/**
	* Returns value of t
	* @return
	*/
	public DoodleObjec getT() {
		return t;
	}

	/**
	* Sets new value of t
	* @param
	*/
	public void setT(DoodleObjec t) {
		this.t = t;
	}
}
