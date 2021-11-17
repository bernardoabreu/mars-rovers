package main;

public class Plateau {
	private int width;
	private int height;

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}

	public void setSize(Point p) {
		this.width = p.getX();
		this.height = p.getY();
	}
}
