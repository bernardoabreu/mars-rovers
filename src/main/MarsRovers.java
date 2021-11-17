package main;

public class MarsRovers {

    public static void main(String[] args) {
    	try {
    		String filename = null;
    		if (0 < args.length) {
    		   filename = args[0];
    		}
    		else {
    		   System.err.println("Invalid arguments count:" + args.length);
    		   System.exit(0);
    		}

    		Reader reader = new Reader(filename);
			RoverController controller = new RoverController();

	    	Plateau plateau = reader.setupPlateau();

	    	while(reader.hasNext()) {
	    		Rover rover = reader.setupRover();

	        	controller.setRover(rover);
	        	controller.issueCommands(reader.getCommands());

	        	System.out.println(rover);
	    	}
	    	reader.close();
    	} catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}