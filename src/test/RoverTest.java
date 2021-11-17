package test;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import main.Point;
import main.Rover;

class RoverTest {

	static Stream<Arguments> destinationProvider() {
	    return Stream.of(
	        Arguments.of(new Point(1, 1), "N", new Point(1, 2)),
	        Arguments.of(new Point(1, 1), "W", new Point(0, 1)),
	        Arguments.of(new Point(1, 1), "S", new Point(1, 0)),
	        Arguments.of(new Point(1, 1), "E", new Point(2, 1))
	    );
	}

	static Stream<Arguments> rotationProvider() {
	    return Stream.of(
	        Arguments.of("N", "W"),
	        Arguments.of("W", "S"),
	        Arguments.of("S", "E"),
	        Arguments.of("E", "N")
	    );
	}

	@ParameterizedTest
	@MethodSource("destinationProvider")
	void testMove(Point initial, String direction, Point destination) {
		Rover rover = new Rover();
		rover.setCoordinates(initial);
		rover.setDirection(direction);

		rover.Move();
		Assertions.assertEquals(destination, rover.getCoordinates());
	}

	@ParameterizedTest
	@MethodSource("rotationProvider")
	void testRotateLeft(String initialOrientation, String newOrientation) {
		Rover rover = new Rover();
		rover.setDirection(initialOrientation);

		rover.rotateLeft();
		Assertions.assertEquals(newOrientation, rover.getDirection());
	}

	@ParameterizedTest
	@MethodSource("rotationProvider")
	void testRotateRight(String newOrientation, String initialOrientation) {
		Rover rover = new Rover();
		rover.setDirection(initialOrientation);

		rover.rotateRight();
		Assertions.assertEquals(newOrientation, rover.getDirection());
	}
}
