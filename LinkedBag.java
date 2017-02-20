package com.astoma.cs111c.week5;

import com.astoma.cs111c.week4.BagInterface;

/**
 * A class of bags whose entries are stored in a chain of linked nodes. The bag
 * is never full.
 * 
 * @author A.Stoma Feb 17, 2017
 */
public class LinkedBag<T extends Comparable> implements BagInterface<T> {
	public Node firstNode; // reference to first node
	public int numberOfEntries;

	public LinkedBag() {
		firstNode = null;
		numberOfEntries = 0;
	}// end default constructor

	public boolean isDivisibleBy(LinkedBag<Integer>.Node firstNode, int divisor) {
		boolean divisible = true;
		LinkedBag<Integer>.Node currentNode = firstNode;
		while ((divisible) && (currentNode != null) ) {
			if (currentNode.data % divisor != 0) {
				divisible = false;
			}else {currentNode = currentNode.next;
			}}
		return divisible;
	}

	/**
	 * Retrieves all entries that are in this bag
	 * 
	 * @return a newly allocated array of all the entries in the bag
	 */
	@Override
	public T[] toArray() {
		// the cast is safe because new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result =  (T[]) new Comparable[numberOfEntries];
		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = (T) currentNode.data;
			index++;
			currentNode = currentNode.next;
		}
		return result;
	}

	/**
	 * Adds a new entry to this bag.
	 * 
	 * @param newEntry
	 *            the object to be added as a new entry
	 * @return true
	 */
	@Override
	public boolean add(T newEntry) // OutOfMemoryError possible
	{
		// add to the beginning of chain:
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;
		firstNode = newNode;
		numberOfEntries++;
		return true;
		// TODO Auto-generated method stub

	}

	@Override
	public Integer capacity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T replace(T replacement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeEvery(T item) {
		// TODO Auto-generated method stub

	}

	public class Node // inner class
	{
		T data; // entry in bag
		Node next; // link to next node

		public Node(T dataPortion) {
			this(dataPortion, null);
		}// end constructor

		public Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}// end constructor
	}// end node

}// end LinkedBag
