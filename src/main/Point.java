package main;

public class Point{
	private int x;
	private int y;

	public Point() {
		this.x = 0;
		this.y = 0;
	}

	public Point(int x, int y) {
		this.setLocation​(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

        if (obj == null || !(obj instanceof Point)) {
        	return false;
        }

        Point other = (Point) obj;

		return this.x == other.x && this.y == other.y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setLocation​(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setLocation(Point p) {
		this.x = p.x;
		this.y = p.y;
	}

	@Override
	public String toString() {
		return this.x + " " + this.y;
	}

}

