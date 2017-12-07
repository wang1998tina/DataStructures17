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
		
		CollisionsData tree = new CollisionsData(); //initialize tree
		Scanner reader;
		String line;
		
		try {
			
			
			if(args.length==0) {
				throw new IOException("No file name specified.");
			}
			
			reader = new Scanner(new File(args[0]));
			line = reader.nextLine(); //discard header line
			
			do {
				line = reader.nextLine();
				
				ArrayList<String> entries = splitCSVLine(line);
				
				//creates objects and adds to tree if valid
				//will skip over line if not valid
				try {
					Collision col = new Collision(entries); 
					tree.add(col);
				} catch(IllegalArgumentException e) {
					//System.err.println(e.getMessage());
					continue;
				}
			
				
			} while(reader.hasNext());
			
			reader.close();
		}	
		catch(IOException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		} catch(IllegalArgumentException e) {
			System.err.println(e.getMessage());
			System.exit(2);
		}
		
		
			
		//----end file input-----
			
		//var used for while loop
		boolean checkForQuit = true;
		Scanner input = new Scanner(System.in);
		
		//user input block
		while(checkForQuit) {
			String zip = "";
			String startDateStr = "";
			String endDateStr = "";
			
			//ask for zip
			System.out.println("Enter a zip code (or 'quit' to exit):");
			zip = input.next();
			
			//if quit
			if(zip.equalsIgnoreCase("quit")) {
				checkForQuit = false;
				System.err.println("Program terminated.");
				System.exit(3);
			}
			
			//validate zip
			if(!isDigit(zip) || zip.length()!=5 
					|| Integer.parseInt(zip)<0) {
				System.err.println("Not a valid zip. Try again");
				continue;
			}
			//ask for start date
			System.out.println("Enter start date (MM/DD/YYYY):");
			startDateStr = input.next();
			Date startDate;
			
			//validate format
			try {
				startDate = new Date(startDateStr);
			} catch(Exception e) {
				System.err.println("Invalid date format. Make sure it is" 
						+ "in MM/DD/YYYY format.");
				continue;
			}
			
			//ask for end date
			Date endDate;
			System.out.println("Enter end date (MM/DD/YYYY):");
			endDateStr = input.next();
			
			//validate correct format
			try {
				endDate = new Date(endDateStr);
				
			} catch(IllegalArgumentException e) {
				System.err.println("Invalid date format. Make sure it is" 
						+ "in MM/DD/YYYY format.");
				continue;
			} 
			
			//validate that end date is after start
			try {
				if(endDate.compareTo(startDate)<0) {
					throw new IllegalArgumentException("End date"
							+ "cannot be before start date");
				}
			} catch(IllegalArgumentException e) {
				System.err.println(e.getMessage());
				continue;
			}
			
			
			//print report
			System.out.println(tree.getReport(zip, startDate, endDate));

				
		}//end of while
			
		

	}//end of main
	
	
	/**
	 * c
	 * hecks if a string contains an int
	 * @param str
	 * @return
	 */
	protected static boolean isDigit(String str) {
		if(str.length()==0) {
			return false;
		}
		for(int i = 0; i<str.length(); i++) {
			if(!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
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
