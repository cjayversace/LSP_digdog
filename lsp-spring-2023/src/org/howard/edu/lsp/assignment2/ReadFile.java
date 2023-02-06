package org.howard.edu.lsp.assignment2;
/*
 * Class: LSP
 * Name: Charlie Seigler
 * 
 * 
 */
import java.io.FileNotFoundException;
import java.util.*;

public class ReadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader();
		HashMap<String, Integer> my_map = new HashMap<String, Integer>(); // creating hashmap to store all words in file
		
		try {
			String file_string = fr.readToString("main/java/resources/Word.txt"); //store the text from the file in a string
			String[] separated = file_string.replaceAll("[^a-zA-z ]", "").toLowerCase().split(" "); //put each word into an array removing all punctuation and spaces
			for (int x = 0; x < separated.length; x++) {
				if (separated[x].length() > 3) {
					if (my_map.get(separated[x]) == null) { //if it is not in the hash map, add it and set its value to zero
						my_map.put(separated[x], 1);
					}
					else { //if it is in the hash map increment its count
						my_map.put(separated[x], my_map.get(separated[x]) + 1);
					}
				}
			}
			for (String i : my_map.keySet()) {
				System.out.println(i + " " + my_map.get(i));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open resource");
		}

	}

}