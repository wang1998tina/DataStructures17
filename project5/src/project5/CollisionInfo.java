package project5;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CollisionInfo {

	/**
	 * Read file.
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			
			if(args.length==0) {
				throw new IOException("No file name specified.");
			}
			Scanner reader = new Scanner(new File(args[0]));
			String line = reader.nextLine(); //discard
			
			CollisionsData tree = new CollisionsData(); //initialize tree
			
			do {
				line = reader.nextLine();
				
				ArrayList<String> entries = splitCSVLine(line);
				
				Collision col = new Collision(entries); //CHECK
				tree.add(col);
				
			} while(reader.hasNext());
			
			
		//----end file input-----
			
		
			
			
		} catch(IOException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		} catch(IllegalArgumentException e) {
			System.err.println(e.getMessage());
			System.exit(2);
		}

	}
	
	/**
	 * Splits the given line of a CSV file according to commas and double quotes
	 * (double quotes are used to surround multi-word entries so that they may contain commas)
	 * @author Joanna Klukowska
	 * @param textLine	a line of text to be passed
	 * @return an Arraylist object containing all individual entries found on that line
	 */
	public static ArrayList<String> splitCSVLine(String textLine){
		
		ArrayList<String> entries = new ArrayList<String>(); 
		int lineLength = textLine.length(); 
		StringBuffer nextWord = new StringBuffer(); 
		char nextChar; 
		boolean insideQuotes = false; 
		boolean insideEntry= false;
		
		// iterate over all characters in the textLine
		for (int i = 0; i < lineLength; i++) {
			nextChar = textLine.charAt(i);
			
			// handle smart quotes as well as regular quotes
			if (nextChar == '"' || nextChar == '\u201C' || nextChar =='\u201D') {
					
				// change insideQuotes flag when nextChar is a quote
				if (insideQuotes) {
					insideQuotes = false; 
					insideEntry = false;
				}else {
					insideQuotes = true; 
					insideEntry = true;
				}
			} else if (Character.isWhitespace(nextChar)) {
				if ( insideQuotes || insideEntry ) {
				// add it to the current entry 
					nextWord.append( nextChar );
				}else { // skip all spaces between entries
					continue; 
				}
			} else if ( nextChar == ',') {
				if (insideQuotes){ // comma inside an entry
					nextWord.append(nextChar); 
				} else { // end of entry found
					insideEntry = false;
					entries.add(nextWord.toString());
					nextWord = new StringBuffer();
				}
			} else {
				// add all other characters to the nextWord
				nextWord.append(nextChar);
				insideEntry = true;
			} 
			
		}
		// add the last word ( assuming not empty ) 
		// trim the white space before adding to the list 
		if (!nextWord.toString().equals("")) {
			entries.add(nextWord.toString().trim());
		}

		return entries;
	}
	

}
