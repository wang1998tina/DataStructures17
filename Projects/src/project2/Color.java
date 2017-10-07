package project2;

public class Color implements Comparable<Color>{
	
	/**Class for Color objects. They can store hex values, String names,
	 * RGB values, as well as methods for converting and comparing
	 * Colors objs
	 * 
	 * @author Xiaotong (Tina) Wang xw1338
	 */

	private int red, green, blue;
	private String name;
	private String hexValue = null;
	
	/**
	 * Constructors below(overloaded)
	 * @param colorHexValue #XXXXXX form
	 * @param colorName ex 'black' 'mauve'
	 * @param red, green, blue (0-256) ints
	 * @throws IllegalArgumentException as params are read directly from file
	 */
	public Color(String colorHexValue) throws IllegalArgumentException{
		
		if(colorHexValue.charAt(0) !='#') {
			throw new IllegalArgumentException();
		} else if(colorHexValue.length()!=7) {
			throw new IllegalArgumentException("invalid hex value");
		}
		for(int i = 1; i<colorHexValue.length();i++) {
			if(Character.digit(colorHexValue.charAt(i), 16) == -1) {
				throw new IllegalArgumentException("invalid hex value");
			} 
		}
		this.hexValue=colorHexValue;
		
		
	}
	
	
	public Color(String colorHexValue, String colorName) throws IllegalArgumentException{
		if(colorHexValue.charAt(0) !='#') {
			throw new IllegalArgumentException();
		} else if(colorHexValue.length()!=7) {
			throw new IllegalArgumentException("Invalid hex value");
		}
		for(int i = 1; i<colorHexValue.length();i++) {
			if(Character.digit(colorHexValue.charAt(i), 16) == -1) {
				throw new IllegalArgumentException("Invalid hex value");
			} 
		}
		this.name = colorName;
		this.hexValue = colorHexValue;
	}
	public Color(int red, int green, int blue) throws IllegalArgumentException{
		if(red >255 || blue>255 || green>255 || red<0 || blue<0 || green<0) {
			throw new IllegalArgumentException("invalid RGB value in constructor.");
		}
		this.red = red;
		this.blue = blue;
		this.green = green;
		
	}
	public Color(String colorHexValue, int red, int green, int blue) throws IllegalArgumentException{
		if(red >255 || blue>255 || green>255 || red<0 || blue<0 || green<0) {
			throw new IllegalArgumentException("invalid RGB value in constructor.");
		}
		this.red = red;
		this.blue = blue;
		this.green = green;
		if(colorHexValue.charAt(0) !='#') {
			throw new IllegalArgumentException();
		} else if(colorHexValue.length()!=7) {
			throw new IllegalArgumentException("Invalid hex value");
		}
		for(int i = 1; i<colorHexValue.length();i++) {
			if(Character.digit(colorHexValue.charAt(i), 16) == -1) {
				throw new IllegalArgumentException("Invalid hex value");
			} 
		}
		this.hexValue = colorHexValue;
		
	}
	
	/**
	 * Getter methods for RGB values, name, and hexValue
	 * @returns the private fields
	 */
	
	public int getRed() {
		this.convertToRGB();
		return this.red;
	}
	public int getGreen() {
		this.convertToRGB();
		return this.green;
	}
	public int getBlue() {
		this.convertToRGB();
		return this.blue;
	}
	public String getName() {
		return this.name;
	}
	public String getHexValue() {
		this.convertToHex();
		return this.hexValue;
	}
	
	
	/**
	 * This method splits hex value into substrs and then
	 * converts them to RGB values and sets them to the RGB fields
	 * in this class.
	 * @return none
	 */
	
	public void convertToRGB() {
		String redstr = this.hexValue.substring(1, 3);
		String greenstr = this.hexValue.substring(3, 5);
		String bluestr = this.hexValue.substring(5);
		this.red = Integer.valueOf(redstr,16);
		this.blue = Integer.valueOf(bluestr,16);
		this.green = Integer.valueOf(greenstr,16);
		}
	
	public void convertToHex() {
		if(this.hexValue==null) {
			String hex = String.format("#%02x%02x%02x", this.red, this.green, this.blue).toUpperCase(); 
			this.hexValue=hex;
		}
		char [] hexChars = new char[6];
		for(int i = 1; i<this.hexValue.length();i++) {
			hexChars[i-1] = this.hexValue.charAt(i);
			if(Character.digit(this.hexValue.charAt(i), 16) == -1) {
				hexChars[i-1] = '0';
			}
		}
		this.hexValue = '#' + String.valueOf(hexChars).toUpperCase();
		
	}
	
	
	/**
	 * Two color objects are equal if hex values equals
	 * 
	 * @param Color object
	 * @return boolean
	 */
	
	public boolean equals(Color c) {
		this.convertToHex();
		c.convertToHex();
		this.hexValue=this.hexValue.toUpperCase();
		c.hexValue=c.hexValue.toUpperCase();
		for(int i = 0; i<this.hexValue.length();i++) {
			if(this.hexValue.charAt(i) != c.hexValue.charAt(i)) {
				return false;
			}
		}
		 
			return true;
		
	}
	
	/**Overrides compareTo method in Comparable<>
	 * @return an int - positive if this.hexValue is greater on ASCII table
	 * (ex: F is greater than B)
	 * @params Color object o
	 * 
	 */
	
	@Override
	public int compareTo(Color o) {
		return this.hexValue.compareToIgnoreCase(o.hexValue);
	}
	

	/**Overrides toString method in Object.
	 * @return a string with format "#FFFFFF, (R, G, B), Name"
	 * 
	 */
	@Override
	public String toString() {
			this.convertToRGB();
			String redstr = String.format("%3d", this.red);
			String greenstr = String.format("%3d", this.green);
			String bluestr = String.format("%3d", this.blue);
			if(this.name!= null) {
			return String.format(this.hexValue.toUpperCase() +  ", (" + redstr + ","
					+ greenstr + "," +  bluestr + "), "
					+ this.name);
			} else {
				return String.format(this.hexValue.toUpperCase() +  ", (" + redstr + ","
						+ greenstr + "," +  bluestr + ")");
			}
		
	}
}
