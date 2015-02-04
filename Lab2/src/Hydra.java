//Alex Simons CS220 Lab 2 Hyrda
import java.util.*;
import java.io.*;

/**
 * This class determines how long it would take to kill a hydra that is
 * represented as a bag of strings.
 * 
 * @author Charles Hoot
 * @author Frank M. Carrano
 * @version 3.0
 */
public class Hydra{
	/**
	 * Initializes the bag of strings.
	 * 
	 * @param hydra
	 *            a bag
	 */
	public static void initialize(BagInterface<String> hydra) {
		System.out.print("What is the inital string? ");
		Scanner fromKeyboard = new Scanner(System.in);
		String start = fromKeyboard.nextLine();
		
		System.out.println("The string is: " + start);
		System.out.println("The string has length " + start.length());
		hydra.add(start);
	}

	/**
	 * Removes heads from the hydra until all are gone.
	 * 
	 * @param hydra
	 *            the bag of strings
	 * @param showRemoved
	 *            true if the removed value should be displayed
	 * @param showNewHydra
	 *            true if the updated bag should be displayed
	 */
	public static void removeHead(BagInterface<String> hydra,
			boolean showRemoved, boolean showNewHydra) {
		System.out.println("Removing heads from the hydra.");

		// continue until the hydra is dead
		while (hydra.getCurrentSize() != 0) {
			String head = hydra.remove();
			if (showRemoved)
				System.out.println("Removed " + head);
			String headToAdd = head.substring(1);

			if (headToAdd.length() > 0) {
				hydra.add(headToAdd);
				hydra.add(headToAdd);
			}

			if (showNewHydra) {
				System.out.println("After adds, the hydara is now ");
				displayBag(hydra);
			}
		}
	}

	private static void displayBag(BagInterface<String> aBag) {
		Object[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++) {
			System.out.print(bagArray[index] + " ");
		} // end for

		System.out.println();
	} // end displayBag

	public static void main(String args[]) {
		BagInterface<String> hydraHeads = new LinkedBag<String>();
		initialize(hydraHeads);

		Date current = new Date(); // get current time
		long startTime = current.getTime();

		// removeHead(hydraHeads, true, true);
		removeHead(hydraHeads, false, false);

		current = new Date(); // get current time
		long stopTime = current.getTime();
		long elapsedTime = stopTime - startTime; // milliseconds

		System.out.println("The time required was " + elapsedTime
				+ " milliseconds");
	}
}
/*
 * What is the inital string? The Hydra was a monster. The string is: The Hydra
 * was a monster. The string has length 24 Removing heads from the hydra. The
 * time required was 336 milliseconds
 */