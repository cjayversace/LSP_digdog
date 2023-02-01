package org.howard.edu.lsp.assignment2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class WordCounter {

	public static void main(String[] args) {
		HashMap<String, Integer> wordCount = new HashMap<>();
		// creating hashmap to store all words in file
		try { 
			
			Scanner input = new Scanner(new File("File.txt"));
		// using Scanner function to read text file line by line	
			while (input.hasNext()) {
				String word = input.next().toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
				//while conditional to make strings lowercase and get rid of all character that are not letters
				if (wordCount.containsKey(word)) {
					wordCount.put(word, wordCount.get(word) + 1);
					// when there is a word it is counted
				} else {
					wordCount.put(word, 1);
				}
			}		
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("No File Found!");
			//catch for when there is no file inputed
		}
		
		for (String word : wordCount.keySet()) {
			System.out.println(word + wordCount.get(word));
			// print out objects of hashmap and display count of each word
		}
	}
}
