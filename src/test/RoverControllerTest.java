package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import main.Point;
import main.Rover;
import main.RoverController;

class RoverControllerTest {

	@ParameterizedTest
	@MethodSource("multipleCommandsProvider")
	void testIssueCommands(Point initialPoint, String initialDirection, String commands, Point destination, String finalDirection) {
		Rover rover = new Rover();
    	rover.setCoordinates(initialPoint);
    	rover.setDirection(initialDirection);
    	
    	RoverController controller = new RoverController();
    	controller.setRover(rover);
    	
    	controller.issueCommands(commands);
    	
    	Assertions.assertEquals(destination, rover.getCoordinates());
    	Assertions.assertEquals(finalDirection, rover.getDirection());
	}

	@ParameterizedTest
	@MethodSource("destinationProvider")
	void testIssueCommand(Point initialPoint, String initialDirection, char command, Point destination, String finalDirection) {
		Rover rover = new Rover();
    	rover.setCoordinates(initialPoint);
    	rover.setDirection(initialDirection);
    	
    	RoverController controller = new RoverController();
    	controller.setRover(rover);
    	
    	controller.issueCommand(command);
    	
    	Assertions.assertEquals(destination, rover.getCoordinates());
    	Assertions.assertEquals(finalDirection, rover.getDirection());
	}
	
	static Stream<Arguments> destinationProvider() {
	    return Stream.of(
	        Arguments.of(new Point(1, 1), "N", 'M', new Point(1, 2), "N"),
	        Arguments.of(new Point(1, 1), "N", 'L', new Point(1, 1), "W"),
	        Arguments.of(new Point(1, 1), "N", 'R', new Point(1, 1), "E")
	    );
	}
	
	static Stream<Arguments> multipleCommandsProvider() {
	    return Stream.of(
	        Arguments.of(new Point(1, 1), "N", "MMM", new Point(1, 4), "N"),
	        Arguments.of(new Point(1, 1), "N", "LL", new Point(1, 1), "S"),
	        Arguments.of(new Point(1, 1), "N", "LLM", new Point(1, 0), "S")
	    );
	}

}
