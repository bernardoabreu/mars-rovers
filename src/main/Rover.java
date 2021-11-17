package main;

public class Rover {

	private Orientation orientation;

	private Point coordinates;

	private int distance;

	public Rover() {
		this.orientation = new Orientation();
		this.coordinates = new Point();
		this.distance = 1;
	}

	public Point getCoordinates() {
		return this.coordinates;
	}

	public String getDirection() {
		return this.orientation.getDirection();
	}

	public void Move() {
		double angleInRadians = orientation.getAngleInRadians();
		int pointX = (int) Math.round(coordinates.getX() + this.distance * Math.cos(angleInRadians));
		int pointY = (int) Math.round(coordinates.getY() + this.distance * Math.sin(angleInRadians));
		this.coordinates.setLocation​(pointX, pointY);
	}

	public void rotateLeft() {
		this.orientation.addDegrees(90);
	}

	public void rotateRight() {
		this.orientation.addDegrees(-90);
	}

	public void setCoordinates(Point p) {
		this.coordinates.setLocation(p);
	}

	public void setDirection(String direction) {
		this.orientation.setDirection(direction);
	}

	@Override
	public String toString() {
		return this.coordinates.toString() + " " + this.orientation.getDirection();
	}
}
