package org.howard.edu.lsp.assignment4;


import java.util.*; //for ArrayList<>()

/**
 * making our own data structure
 * complete with functions and an error
 * 
 * @author Charlie Seigler 
 *
 */
public class IntegerSet {

	private List<Integer> int_set;
	
	/**
	 * class constructor
	 * initializes int_set
	 */
	public IntegerSet() {
		int_set = new ArrayList<Integer>();
	}
	
	/**
	 * creating our own error that just prints out the string that is passed to it
	 * 
	 * @author Charlie Seigler
	 *
	 */
	public class IntegerSetException extends Exception {
		/**
		 * prints out error
		 * 
		 * @param error String instance to print when called
		 * 
		 */
		public IntegerSetException(String error) {
			super(error);
		}
	}
	
	//(O(1))
	/**
	 * getter method
	 * 
	 * @return ArrayList containing all integers in the set
	 */
	public List<Integer> get_set() {
		return int_set;
	}
	
	//(O(1))
	/**
	 * setter method
	 * 
	 * @param new_set List instance to declare to
	 */
	public void set_set(List<Integer> new_set) {
		int_set = new_set;
	}
	
	//(O(N))
	/**
	 * clears the integer set using the ArrayList function clear()
	 */
	public void clear() {
		int_set.clear();
	}
	
	//(O(1))
	/**
	 * returns the size of the array list
	 * 
	 * @return integer which represents the size of the list
	 */
	public int length() {
		return int_set.size();
	}
	
	//(O(N))
	/**
	 * checks if IntegerSet a is the exact same 
	 * 
	 * @param a IntegerSet instance to compare
	 * 
	 * @return false if unequal, otherwise true
	 */
	public boolean equals(IntegerSet a) {
		//if they have different lengths they cannot be equal
		if (int_set.size() != a.length()) {
			return false;
		}
		//if they have equal lengths check if all elements are the same
		else {
			return int_set.containsAll(a.int_set);
		}
	}
	
	//(O(N))
	/**
	 * check if the IntegerSet contains a value
	 * 
	 * @param value integer instance to check
	 * 
	 * @return false if absent, otherwise true
	 */
	public boolean contains(int value) {
		return int_set.contains(value);
	}
	
	//(O(N))
	/**
	 * returns the largest number in the set
	 * 
	 * @return integer the represents the largest value in the set
	 * 
	 * @throws IntegerSetException custom exception instance
	 */
	public int largest() throws IntegerSetException {
		//if the set is empty, throws an exception saying so
		if (int_set.isEmpty()) {
			throw new IntegerSetException("The Set is Empty.");
		}
		//search through the set and find the largest integer
		else {
			//set our comparison to something in the set already
			int large = int_set.get(0);
			//iterate through the set and compare the values to large
			for (int i = 0; i < int_set.size(); i++) {
				//set large to the bigger integer if found
				if (int_set.get(i) > large) {
					large = int_set.get(i);
				}
			}
			return large;
		}
	}
	
	//(O(N))
	/**
	 * returns the smallest integer in the set
	 * 
	 * @return integer that represents the smallest value in the set
	 * 
	 * @throws IntegerSetException custom exception instance
	 */
	public int smallest() throws IntegerSetException {
		//if the set is empty, throws an exception saying so
		if (int_set.isEmpty()) {
			throw new IntegerSetException("The Set is Empty.");
		}
		//search through the set and find the smallest integer
		else {
			//set our comparison to something in the set already
			int small = int_set.get(0);
			//iterate through the set and compare the values to small
			for (int i = 0; i < int_set.size(); i++) {
				//set small to the smaller integer if found
				if (int_set.get(i) < small) {
					small = int_set.get(i);
				}
			}
			return small;
		}
	}
	//(O(N))
	/**
	 * adds an integer to the set if it is not present
	 * 
	 * @param item integer instance to check
	 */
	public void add(int item) {
		if (int_set.contains(item) == false) {
			int_set.add(item);
		}
	}
	
	//(O(N))
	/**
	 * removes an integer from the set if it is present
	 * 
	 * @param item integer instance to check
	 */
	public void remove(int item) {
		if (int_set.contains(item) == true) {
			int_set.remove(int_set.indexOf(item));
		}
	}
	
	//(O(N))
	/**
	 * calculates the union of two sets
	 * 
	 * @param b IntegerSet instance to compare
	 */
	public void union(IntegerSet b) {
		for (int i = 0; i < b.length(); i++) {
			if (int_set.contains(b.int_set.get(i)) == false) {
				int_set.add(b.int_set.get(i));
			}
		}
	}
	
	//(O(N))
	/**
	 * calculates the intersection of two sets
	 * 
	 * @param b IntegerSet instance to compare
	 */
	public void intersect(IntegerSet b) {
		int_set.retainAll(b.int_set);
	}
	
	//(O(N))
	/**
	 * calculates the difference of two sets
	 * 
	 * @param b IntegerSet instance to compare
	 */
	public void diff(IntegerSet b) {
		for (int i = 0; i < b.length(); i++) {
			if (int_set.contains(b.int_set.get(i)) == true) {
				int_set.remove(b.int_set.get(i));
			}
		}
	}
	
	//(O(1))
	/**
	 * checks if the set is empty
	 * 
	 * @return true if empty, otherwise false
	 */
	public boolean isEmpty() {
		return int_set.isEmpty();
	}
	
	//(O(N))
	/**
	 * prints every integer in the set
	 * 
	 * @return String formatted to hold every integer in the set
	 */
	public String toString() {
		String list = "";
		for (int i = 0; i < int_set.size(); i++) {
			list += int_set.get(i).toString() + ", ";
		}
		return list;
	}
}