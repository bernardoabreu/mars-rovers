package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {
	Scanner scanner;

	public Reader(String filename) throws FileNotFoundException {
		this.scanner = new Scanner(new File(filename));
	}

	public void close() {
		scanner.close();
	}

	public String getCommands() {
		return scanner.next();
	}

	public boolean hasNext() {
		return scanner.hasNext();
	}

	public Plateau setupPlateau() {
		Plateau plateau = new Plateau();
    	int xCoordinate = scanner.nextInt();
    	int yCoordinate = scanner.nextInt();
    	plateau.setSize(new Point(xCoordinate, yCoordinate));
    	return plateau;
	}

	public Rover setupRover() {
		int xPos = scanner.nextInt();
		int yPos = scanner.nextInt();
		String direction = scanner.next();

		Rover rover = new Rover();
		rover.setCoordinates(new Point(xPos, yPos));
		rover.setDirection(direction);
		return rover;
	}
}
