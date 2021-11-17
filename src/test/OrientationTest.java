package test;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import main.Orientation;

class OrientationTest {

	static Stream<Arguments> anglesProvider() {
	    return Stream.of(
	        Arguments.of(0.0, Math.toRadians(0.0)),
	        Arguments.of(90.0, Math.toRadians(90.0)),
	        Arguments.of(180.0, Math.toRadians(180.0)),
	        Arguments.of(270.0, Math.toRadians(270.0))
	    );
	}


	static Stream<Arguments> degreeAngleAndDirectionProvider() {
	    return Stream.of(
	        Arguments.of(0.0, "E"),
	        Arguments.of(90.0, "N"),
	        Arguments.of(180.0, "W"),
	        Arguments.of(270.0, "S")
	    );
	}

	static Stream<Arguments> degreeAngleAndNewOrientationProvider() {
	    return Stream.of(
	        Arguments.of(0.0, 0.0, "E"),
	        Arguments.of(90.0, 90.0, "N"),
	        Arguments.of(-90.0, 270.0, "S"),
	        Arguments.of(180.0, 180.0, "W"),
	        Arguments.of(-180.0, 180.0, "W"),
	        Arguments.of(-270.0, 90.0, "N")
	    );
	}

	@ParameterizedTest
	@MethodSource("degreeAngleAndNewOrientationProvider")
	void testAddDegrees(double angle, double newAngle, String newDirection) {
		Orientation orientation = new Orientation();
		orientation.setAngleInDegrees(0);

		orientation.addDegrees(angle);

		Assertions.assertEquals(newAngle, orientation.getAngleInDegrees());
		Assertions.assertEquals(newDirection, orientation.getDirection());
	}


	@ParameterizedTest
	@MethodSource("anglesProvider")
	void testGetAngleInRadians(double degreeAngle, double radiansAngle) {
		Orientation orientation = new Orientation();
		orientation.setAngleInDegrees(degreeAngle);

		Assertions.assertEquals(radiansAngle, orientation.getAngleInRadians());
	}

	@ParameterizedTest
	@MethodSource("degreeAngleAndDirectionProvider")
	void testSetAngleInDegrees(double angle, String direction) {
		Orientation orientation = new Orientation();
		orientation.setAngleInDegrees(angle);

		Assertions.assertEquals(angle, orientation.getAngleInDegrees());
		Assertions.assertEquals(direction, orientation.getDirection());
	}

	@ParameterizedTest
	@MethodSource("degreeAngleAndDirectionProvider")
	void testSetDirection(double angle, String direction) {
		Orientation orientation = new Orientation();
		orientation.setDirection(direction);

		Assertions.assertEquals(angle, orientation.getAngleInDegrees());
		Assertions.assertEquals(direction, orientation.getDirection());
	}
}

