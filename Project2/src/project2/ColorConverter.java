package project2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class ColorConverter { 

	public static void main(String[] args)throws IOException,IllegalArgumentException{
		
		/**Main calling class. I call Color and ColorList here as well.
		 * 
		 * @author Xiaotong (Tina) Wang xw1338
		 */
		
		/**
		 * Try/catch block below. Try block contains the entire program I'm running,
		 * and catch blocks will handle exceptions that arise.
		 * 
		 */
		try {
			Scanner reader = new Scanner(new File(args[0]));
		
			if (args[0].length()<1) {
				throw new IllegalArgumentException("Usage Error: the program "
						+ "expects file name as an argument.");
			} 
		
			//create arraylist
			ColorList<Color> colors = new ColorList<>();
			String name, hexColor, line;
			
			//populate arraylist
			//scrolls thru the file using next method
			do {
				line = reader.nextLine();
				line.trim();
				System.out.println(line);
				
				name = line.split(",")[0];
				name = name.trim();
				hexColor = line.split(",")[1];
				hexColor = hexColor.trim();
				System.out.println(hexColor+name); 
				
				
				//create new color object with each input
				Color c = new Color(hexColor, name);
				//add to arraylist
				colors.add(c);
				
			} while (reader.hasNext());//while there is more of file to be read
			
			reader.close();
			
			

			boolean checkForQuit = true;
			boolean inArray=false;
			Scanner input = new Scanner(System.in);
			//takes user input - hex or quit. This part runs until "quit"
			while(checkForQuit) {
				String hex ="";
				System.out.println("Enter color in HEX(#RRGGBB) or 'quit' "
						+ "to stop");
				hex = input.next();
				//if "quit"
				if(hex.equalsIgnoreCase("quit")){
					checkForQuit = false;
					System.err.print("Program terminated.");
					System.exit(3);
					} 
				
				//check if value is hex value 
				if(hex.charAt(0) !='#') {
					System.err.println("Not a valid hex value. Try again");
					continue;
				} 
				boolean isHex=true;
				
				for(int i = 1; i<hex.length();i++) {
					if(Character.digit(hex.charAt(i), 16) == -1) {
						System.out.println("Not a valid hex val. Try again");
						break;
					} else if(hex.length()!=7) {
						System.out.println("Not a valid hex val. Try again");
						break;
					}
				}
				
				//if hex is not valid hex value
				if(!isHex) {
					System.err.println("Not a valid hex value. Try again.");
					continue;
				}
				
				//convert and print from ColorList
				if(colors.getColorByHexValue(hex)!=null) {
					colors.getColorByHexValue(hex).convertToRGB();
					System.out.println(colors.getColorByHexValue(hex).toString());
					inArray = true;
				} else {
					inArray = false;
				}
				
				//in case hex value is valid but not in ColorList
				if (!inArray&&hex.length()==7) {
					int r = convertToRGB(hex.substring(1, 3));
					int g = convertToRGB(hex.substring(3, 5));
					int b = convertToRGB(hex.substring(5));
					System.out.println(hex + ", (" + r + ", " + g 
							+ ", " + b + ")");
				}
				
			}
			
			
			
		
		}catch (IOException e) {
			//file cant be found or opened
			System.err.print
			("Error: the file" + args[0]
					+"cannot be opened.");
			System.exit(1);
		} catch (IllegalArgumentException e) {
			System.err.print("Illegal argument");
			System.exit(2);
		}

}
	
	/**
	 * Converts substring of hex value to RGB.
	 * 
	 * @param hexSubstr is two characters in the hex value that get converted
	 * into either a red, green, or blue value.
	 * @return int (0-256) representing an RGB value
	 */
	
	
	public static int convertToRGB(String hexSubstr) {
		//TODO check if right
		return Integer.valueOf(hexSubstr,16);
	}
}

