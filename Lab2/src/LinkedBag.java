//Alex Simons CS220 Lab 2 Hyrda
/**
 * A class of bags whose entries are stored in a chain of linked nodes. The bag
 * is never full.


 */
public class LinkedBag<T> implements BagInterface<T> {
	private Node firstNode; // reference to first node
	private int numberOfEntries;

	public LinkedBag() {
		firstNode = null;
		numberOfEntries = 0;
	} // end default constructor

	public LinkedBag(T[] items, int numberOfItems) {
		this();

		for (int index = 0; index < numberOfItems; index++)
			add(items[index]);
	} // end constructor

	/**
	 * Task 1: Adds a new entry to this bag.
	 * 
	 * @param newEntry
	 *            the object to be added as a new entry
	 * @return true
	 */
	public boolean add(T newEntry) // OutOfMemoryError possible
	{
		// add to beginning of chain:
		
		Node newNode = new Node(newEntry);// make new node reference rest of chain
		newNode.next = firstNode;
		firstNode = newNode;// new node is at beginning of chain
		numberOfEntries++;// increase the numberOfEntries by 1
				
		return true;	

	} // end add

	/**
	 * Sees whether this bag is full.
	 * 
	 * @return false
	 */
	public boolean isFull() {
		return false;
	} // end isFull

	/**
	 * Retrieves all entries that are in this bag.
	 * 
	 * @return a newly allocated array of all the entries in the bag
	 */
	public T[] toArray() {
		// the cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries]; // unchecked cast

		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.data;
			index++;
			currentNode = currentNode.next;
		} // end while

		return result;
	} // end toArray

	/**
	 * Sees whether this bag is empty.
	 * 
	 * @return true if the bag is empty, or false if not
	 */
	public boolean isEmpty() {
		return numberOfEntries == 0;
	} // end isEmpty

	/**
	 * Gets the number of entries currently in this bag.
	 * 
	 * @return the integer number of entries currently in the bag
	 */
	public int getCurrentSize() {
		return numberOfEntries;
	} // end getCurrentSize

	/**
	 * Counts the number of times a given entry appears in this bag.
	 * 
	 * @param anEntry
	 *            the entry to be counted
	 * @return the number of times anEntry appears in the bag
	 */
	public int getFrequencyOf(T anEntry) {
		int frequency = 0;

		int counter = 0;
		Node currentNode = firstNode;
		while ((counter < numberOfEntries) && (currentNode != null)) {
			if (anEntry.equals(currentNode.data)) {
				frequency++;
			} // end if

			counter++;
			currentNode = currentNode.next;
		} // end while

		return frequency;
	} // end getFrequencyOf

	/**
	 * Tests whether this bag contains a given entry.
	 * 
	 * @param anEntry
	 *            the entry to locate
	 * @return true if the bag contains anEntry, or false otherwise
	 */
	public boolean contains(T anEntry) {
		return getReferenceTo(anEntry) != null;
	} // end contains

	// Locates a given entry within this bag.
	// Returns a reference to the node containing the entry, if located,
	// or null otherwise.
	private Node getReferenceTo(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;

		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.next;
		} // end while

		return currentNode;
	} // end getReferenceTo

	/** Removes all entries from this bag. */
	public void clear() {
		while (!isEmpty())
			remove();
	} // end clear

	/**
	 * Task 2: Removes one unspecified entry from this bag, if possible.
	 * 
	 * @return either the removed entry, if the removal was successful, or null
	 */
	public T remove() {
		T removed = null;//creates a variable of the generic type that currently holds null
		if(firstNode != null)//checks to see if the first node is not empty
		{
		removed = firstNode.data;//stores the data from the first node
		firstNode = firstNode.next;//makes firstNode reference the node next to it. So the old it will be deleted because nothing is referncing it.
		numberOfEntries--;//subtracts 1 from the total number of entries
		}//end if
		return removed;//returns removed.
		
	} // end remove

	/**
	 * Task 3: Removes one occurrence of a given entry from this bag, if possible.
	 * 
	 * @param anEntry
	 *            the entry to be removed
	 * @return true if the removal was successful, or false otherwise
	 */
	public boolean remove(T anEntry) {
		boolean removed = false;//creates a variable that holds a boolean value
		if(this.contains(anEntry))//checks to see if this bag contains the entry in the parameters
		{
			this.getReferenceTo(anEntry).data = firstNode.data;//takes found the node's data and replaces it with the first node's data.
			remove();//removes the first node.
			removed = true;//sets removed to true
		}//end if
		return removed;//Returns removed
	
	} // end remove

	private class Node {
		private T data; // entry in bag
		private Node next; // link to next node

		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
		} // end constructor

		// private Node(T dataPortion, Node nextNode)
		// {
		// data = dataPortion;
		// next = nextNode;
		// } // end constructor
	} // end Node
} // end LinkedBag
