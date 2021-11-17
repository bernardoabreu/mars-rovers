package main;

public class RoverController {

	private Rover rover;

	public void setRover(Rover rover) {
		this.rover = rover;
	}

	public void issueCommands(String commands) {
		for (char c : commands.toCharArray()) {
			issueCommand(c);
		}
	}

	public void issueCommand(char command) {
		if (command == 'L') {
			this.rover.rotateLeft();
		}
		else if (command == 'R') {
			this.rover.rotateRight();
		}
		else if (command == 'M'){
			this.rover.Move();
		}
	}
}
