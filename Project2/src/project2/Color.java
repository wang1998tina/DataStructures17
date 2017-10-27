package project2;

/**
 * <p>A class that stores information on a single color.</p>
 * <p>Can construct a color object using only hex value, 
 * hex value and str name, or int RGB values.</p> 
 * <p>Includes methods to return RGB, hex value, name data fields, convert between
 * hex and RGB, and compare different Color objects.</p>
 * 
 * @author wang1998tina
 *
 */


public class Color implements Comparable<Color>{
	

	//data fields for Color
	private int red, green, blue;
	private String name;
	private String hexValue = null;
	
	/**
	 * <p>Constructor takes in string and then iterates through
	 * to see if in #XXXXXX form. If correct, creates new Color object
	 * with hex value.</p>
	 * 
	 * @param colorHexValue 
	 * @throws IllegalArgumentException if input not in #XXXXXX form.
	 */
	public Color(String colorHexValue) throws IllegalArgumentException{
		//check if hex value is correct format
		if(colorHexValue.charAt(0) !='#') {
			throw new IllegalArgumentException();
		} else if(colorHexValue.length()!=7) {
			throw new IllegalArgumentException("invalid hex value");
		}
		//check if hex value has correct digits
		for(int i = 1; i<colorHexValue.length();i++) {
			if(Character.digit(colorHexValue.charAt(i), 16) == -1) {
				throw new IllegalArgumentException("invalid hex value");
			} 
		}
		this.hexValue=colorHexValue;
		
		
	}
	
	/**
	 * <p>Constructor takes in two strings - hex value and name,
	 * and if hex in #XXXXXX format, creates Color object with hex 
	 * and name field</p>
	 * 
	 * @param colorHexValue string
	 * @param colorName string
	 * @throws IllegalArgumentException if hex value not in 
	 * specified #XXXXXX format or correct digits.
	 */
	public Color(String colorHexValue, String colorName) throws IllegalArgumentException{
		//check if hex is correct format
		if(colorHexValue.charAt(0) !='#') {
			throw new IllegalArgumentException();
		} else if(colorHexValue.length()!=7) {
			throw new IllegalArgumentException("Invalid hex value");
		}
		//check if hex has valid digits
		for(int i = 1; i<colorHexValue.length();i++) {
			if(Character.digit(colorHexValue.charAt(i), 16) == -1) {
				throw new IllegalArgumentException("Invalid hex value");
			} 
		}
		this.name = colorName;
		this.hexValue = colorHexValue;
	}
	
	
	/**
	 * <p> Constructor creates Color object with RGB inputs</p>
	 * 
	 * @param integer red value
	 * @param int green value
	 * @param int blue value
	 * @throws IllegalArgumentException if not a valid int RGB
	 * value (above 255, below 0)
	 */
	public Color(int red, int green, int blue) throws IllegalArgumentException{
		if(red >255 || blue>255 || green>255 || red<0 || blue<0 || green<0) {
			throw new IllegalArgumentException("invalid RGB value in constructor.");
		}
		this.red = red;
		this.blue = blue;
		this.green = green;
		
	}
	
	/**
	 * <p>constructor creates a color object with specified hex value and 
	 * RGB ints.</p>
	 * 
	 * @param colorHexValue
	 * @param int red RGB value
	 * @param green RGB value
	 * @param blue RGB value
	 * @throws IllegalArgumentException if hex not in #XXXXXX format
	 * or int value below 0 or above 255
	 */
	public Color(String colorHexValue, int red, int green, int blue) throws IllegalArgumentException{
		//make sure int values are valid
		if(red >255 || blue>255 || green>255 || red<0 || blue<0 || green<0) {
			throw new IllegalArgumentException("invalid RGB value in constructor.");
		}
		this.red = red;
		this.blue = blue;
		this.green = green;
		//check if hex value is valid format
		if(colorHexValue.charAt(0) !='#') {
			throw new IllegalArgumentException();
		} else if(colorHexValue.length()!=7) {
			throw new IllegalArgumentException("Invalid hex value");
		}
		//check if hex value input has only hex digits.
		for(int i = 1; i<colorHexValue.length();i++) {
			if(Character.digit(colorHexValue.charAt(i), 16) == -1) {
				throw new IllegalArgumentException("Invalid hex value");
			} 
		}
		this.hexValue = colorHexValue;
		
	}
	
	/**
	 * @return int value of red from RGB 
	 */
	public int getRed() {
		this.convertToRGB();
		return this.red;
	}
	
	/**
	 * @return int value of green from RGB
	 */
	public int getGreen() {
		this.convertToRGB();
		return this.green;
	}
	
	/**
	 * 
	 * @return int value of blue from RGB
	 */
	public int getBlue() {
		this.convertToRGB();
		return this.blue;
	}
	
	/**
	 * 
	 * @return string name field of color object
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Converts color object hex if is has not already been done
	 * @return hex value of format #XXXXXX
	 */
	public String getHexValue() {
		this.convertToHex();
		return this.hexValue;
	}
	
	
	/**
	 * This method splits hex value into substrings and then
	 * converts them to RGB values and sets them to the RGB fields
	 * in this class.
	 * 
	 */
	
	public void convertToRGB() {
		String redstr = this.hexValue.substring(1, 3);
		String greenstr = this.hexValue.substring(3, 5);
		String bluestr = this.hexValue.substring(5);
		this.red = Integer.valueOf(redstr,16);
		this.blue = Integer.valueOf(bluestr,16);
		this.green = Integer.valueOf(greenstr,16);
		}
	
	
	/**
	 * Converts RGB values to hex using string.format to 
	 * format according to #XXXXXX.
	 * %x refers to a formatted int that will output a hex value, two digits that will
	 * be padded with a 0 if it ends up being a one digit value (02). '#' adds
	 * the hashtag in the front of the hex value.
	 */
	
	public void convertToHex() {
		//only convert if there isn't already a hex value. 
		if(this.hexValue==null) {
			String hex = String.format("#%02x%02x%02x", this.red, this.green, this.blue)
					.toUpperCase(); 
			this.hexValue=hex;
		}
		
	}
	
	
	/**
	 *Checks to see if two color objects are equal by comparing
	 *the hex values, iterating through each character, ignoring case for letters.
	 * 
	 * @param valid non-null color object
	 * @return <b> true</b> if hex values equal, <b>false</b> otherwise.
	 */
	
	public boolean equals(Color c) {
		//invalid Color input
		if(c==null) {
			return false;
		}
		
		this.convertToHex();
		c.convertToHex();
		
		this.hexValue=this.hexValue.toUpperCase();
		c.hexValue=c.hexValue.toUpperCase();
		//iterate through both hex values to see if each char identical
		for(int i = 0; i<this.hexValue.length();i++) {
			if(this.hexValue.charAt(i) != c.hexValue.charAt(i)) {
				return false;
			}
		}
		 
			return true;
		
	}
	
	
	/**Overrides compareTo method in Comparable<><p>
	 * Compares the string hex values of two color objects, disregarding
	 * case of the characters if they are letters..<p>
	 * 
	 * @return an int - positive if this.hexValue is greater on ASCII table
	 * (ex: F.compareTo(B) will return a positive int. F.compareTo(f) returns 0.)
	 * @params Color object o
	 * 
	 */
	
	@Override
	public int compareTo(Color o) {
		return this.hexValue.compareToIgnoreCase(o.hexValue);
	}
	

	/**Overrides toString method in Object class<p>
	 * Converts to RGB in case there is no hex field yet. 
	 * 
	 * Then uses string.format to format the fields so that
	 * they come out identical, whether it is a one digit or
	 * two digit int. <p>
	 * 
	 * @return a string with format "#XXXXXX, (R, G, B), Name" or
	 * "#XXXXXX, (R, G, B)" if there is no name field or it is null.
	 * 
	 */
	@Override
	public String toString() {
			this.convertToRGB();
			//regex to format RGB
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

