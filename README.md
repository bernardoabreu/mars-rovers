# mars-rover

## Description

This project simulates the behavior of robotic rovers. These rovers receive commands from a RoverController and walk over a rectangular plateau.

A main module, MarsRovers, contains the main class. A class Reader is implemented to load all the details pertaining the solution into their respective objects.
A RoverController object issues commands to a Rover object. The rover contains information about its orientation and position on the plateau.

The input is assumed to be contained in a file.

## Tests
The tests are written using JUnit 5. A standalone platform-console is included in the Makefile.

## How to compile and run

Run the following command to compile and run the tests.

```make```

To run the program use:

```make run $file```

where $file is the name of the input file.

An example file is included under the name ```test.txt```
