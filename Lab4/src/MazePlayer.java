/**
 * 	Alex Simons Siu 851287084
 * 	CS 220 
 *	Lab 4
 */




import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class MazePlayer {

	private Maze maze;
	private Scanner keyboard;

	// main method that creates the MazePlayer object and calls its start method
	public static void main(String[] args) {
		int[][] aSolvableMaze = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
				{ 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1 },
				{ 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1 },
				{ 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

		int[][] anUnsolvableMaze = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
				{ 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

		// creates the MazePlayer object
		MazePlayer player = new MazePlayer(new Maze(aSolvableMaze, 1, 0, 1, 12));

		// call its start method
		player.start();

		// new Maze(anUnsolvableMaze);
	}

	// The MazePlayer constructor should accept the Maze object to be played
	public MazePlayer(Maze m) {

		maze = m;
		keyboard = new Scanner(System.in);

	}

	/*
	 * Write a public method start that displays the maze and prompts the user
	 * if they want to play the maze, have the program solve the maze, or exit
	 */
	public void start() {
		maze.display();
		System.out.println();

		System.out.println("p: play the maze");
		System.out.println("s: get the solution to the maze");
		System.out.println("x: exit");

		String selection = keyboard.nextLine();
		if (selection.length() > 0) {
			selection = ("" + selection.charAt(0)).toLowerCase();
		}
		System.out.println();

		if (selection.equals("p")) {
			// play the maze
			play();
		} else if (selection.equals("s")) {
			// have the program solve the maze

			if (maze.solveMaze(maze.getCurrentRow(), maze.getCurrentCol())) {
				System.out.println("Maze can be solved:");
				maze.display();
			} else {
				System.out.println("Maze cannot be solved");
				maze.display();
			}
		} else {
			System.out.println("Not a valid choice, exiting.");
		}
	}

	// Write a private method play that prompts the user if they want to go up,
	// down, left, or right
	private void play() {
		maze.display();
		System.out.println();

		while (!maze.isSolved()) {

			System.out.println("u: up");
			System.out.println("d: down");
			System.out.println("l: left");
			System.out.println("r: right");
			System.out.println("What is your move? ");
			String selection = keyboard.nextLine();
			if (selection.length() > 0) {
				selection = ("" + selection.charAt(0)).toLowerCase();
				selection = getMovement(selection);
				if (!maze.makeMove(selection))
					System.out.println("Player cannot move there.");
			} else
				System.out.println("Not a valid move");

			maze.display();
			System.out.println();
		}

		System.out.println("You've completed the maze!");
	}

	private String getMovement(String selection) {

		selection = ("" + selection.charAt(0)).toLowerCase();

		while (!selection.equals("u") && !selection.equals("d")
				&& !selection.equals("l") && !selection.equals("r")) {
			System.out.println("Invalid selection, try again.");
			selection = keyboard.nextLine();
			selection = ("" + selection.charAt(0)).toLowerCase();
		}
		return selection;
	}

}
	