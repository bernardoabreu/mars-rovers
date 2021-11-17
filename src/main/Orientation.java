package main;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Orientation {
	private static final String DIRECTIONS[] = {"E", "NE", "N", "NW",  "W", "SW", "S", "SE", "E"};

	private static final Map<String, Double> DIRECTION_TO_ANGLE = createMap();

    private static Map<String, Double> createMap() {
        Map<String, Double> result = new HashMap<>();
        result.put("E", 0.0);
        result.put("N", 90.0);
        result.put("W", 180.0);
        result.put("S", 270.0);
        return Collections.unmodifiableMap(result);
    }

	private double angle;

	private String direction;

	public void addDegrees(double degrees) {
		setAngleWithModulus(this.angle + degrees);
		setAngleWithModulus(angle);
		setDirectionFromAngle();
	}

	public double getAngleInDegrees() {
		return this.angle;
	}

	public double getAngleInRadians() {
		return Math.toRadians(angle);
	}

	public String getDirection() {
		return this.direction;
	}

	public void setAngleInDegrees(double angle) {
		setAngleWithModulus(angle);
		setDirectionFromAngle();
	}

	public void setAngleInRadians(double angle) {
		setAngleWithModulus(Math.toDegrees(angle));
		setDirectionFromAngle();
	}

	private void setAngleWithModulus(double angle) {
		angle %= 360;
		this.angle = (angle < 0) ? angle + 360.0 : angle;
	}

	public void setDirection(String direction) {
		this.direction = direction;
		this.angle = DIRECTION_TO_ANGLE.get(direction);
	}

	private void setDirectionFromAngle() {
		int index = (int)Math.round(((this.angle % 360) / 45));
		this.direction = DIRECTIONS[index];
	}
}
