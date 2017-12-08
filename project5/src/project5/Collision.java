package project5;

import java.util.ArrayList;

/**
 * This class creates an instance of a Collision object,
 * referring to a single Collision that happened in NYC. Keeps track
 * of zip code, date it happened, a unique key, and fatalities and 
 * injuries. 
 * Also allows for comparison of different Collision objects.
 * 
 * @author wang1998tina
 *
 */
public class Collision implements Comparable<Collision>{

	String zip;
	Date date;
	String key;
	int personsInjured;
	int pedestriansInjured;
	int cyclistsInjured;
	int motoristsInjured;
	int personsKilled;
	int pedestriansKilled;
	int cyclistsKilled;
	int motoristsKilled;
	
	
	/**
	 * Constructor for Collision object. An ArrayList of String objects is 
	 * passed as a parameter. Required to have at least 24 entries, but only 
	 * certain entries have specific requirements (aka the others can be empty
	 * entries). 
	 * 
	 * @param ArrayList of String objects
	 * @throws IllegalArgumentException if any entry that corresponds to a data
	 * field is invalid. Other entries are ignored.
	 */
	public Collision (ArrayList<String> entries)throws IllegalArgumentException{
		
		//size
		if(entries.size()<24) {
			throw new IllegalArgumentException("Input not long enough");
		}
		
		//date
		try {
			this.date = new Date(entries.get(0));
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Invalid date input to "
					+ "Collision constructor");
		}
		
		//zip
		if(isDigit(entries.get(3)) && entries.get(3).length()==5 
				&& Integer.parseInt(entries.get(3))>0){
			zip = entries.get(3);
			
		} else {
			throw new IllegalArgumentException("Invalid zip code in constructor");
		}
		
		//num of injuries/deaths
		//attempt to parse into int
		try {
			personsInjured = Integer.parseInt(entries.get(10));
			personsKilled = Integer.parseInt(entries.get(11));
			pedestriansInjured = Integer.parseInt(entries.get(12));
			pedestriansKilled = Integer.parseInt(entries.get(13));
			cyclistsInjured = Integer.parseInt(entries.get(14));
			cyclistsKilled = Integer.parseInt(entries.get(15));
			motoristsInjured = Integer.parseInt(entries.get(16));
			motoristsKilled = Integer.parseInt(entries.get(17));
			
			
		
		}catch(Exception e) {
			throw new IllegalArgumentException("Injuries/deaths should be a "
					+ "nonnegative integer");
		}
		//check if negative
		if(personsInjured<0 || personsKilled<0 || pedestriansInjured<0 ||
			pedestriansKilled<0 || cyclistsInjured<0 || cyclistsKilled<0 ||
			motoristsInjured<0 || motoristsKilled<0) {
			throw new IllegalArgumentException("Injuries/deaths should be a "
					+ "nonnegative integer");
		}
		
		//key
		key = entries.get(23);
		
	}
	
	
	
	/**
	 * Overrides Comparable. Based on zip code, date, key, in order of priority. If comparing
	 * based on zip code, pos int returned if this object has larger int value. If comparing
	 * Dates, based on Date compareTo (pos value returned if this Date obj's date is later).
	 * If comparing by key, String compareTo is used.
	 * 
	 * @return int based on comparison. Larger if this is larger, 0 if equals, negative if
	 * this is smaller.
	 * 
	 */
	@Override
	public int compareTo(Collision o){
		
		if(this.zip.compareTo(o.zip)==0) {
			if(this.date.compareTo(o.date)==0) {
				if(this.key.compareTo(o.key)==0) {
					return 0;
				}
				return this.key.compareTo(o.key);
			}
			return this.date.compareTo(o.date);
		}
		return this.zip.compareTo(o.zip);	
	}
	
	/**
	 * Based on same specifications as compareTo, except zip, date, key all must
	 * be equal in order to return true.
	 * Overrides Object equals(), so if Object o is not a Collision object,
	 * false is returned.
	 * 
	 * @return true if two Collision objects have same zip, date, key, false if not.
	 */
	@Override
	public boolean equals(Object o) {
	
		if(o.getClass()!=this.getClass()) {
			return false;
		}
		
		Collision obj = (Collision) o;
		if(zip.equals(obj.zip)) {
			if(date.equals(obj.date)) {
				if(key.equals(obj.key)) {
					return true;
				}
				return false;
			}
			return false;
		}
		return false;
		
	}
	

	/**
	 * Method I created to check if a given string contains
	 * an integer
	 * @param String
	 * @return true if String contains int, false if not.
	 */
	protected boolean isDigit(String str) {
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
	 * Getter methods below, for zip, date, key, fatalities, and injuried
	 * @return data fields they are retrieving.
	 */
	
	public String getZip() {
		return this.zip;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public String getKey() {
		return this.key;
	}
	
	public int getPersonsInjured() {
		return personsInjured;
	}
	
	public int getPersonsKilled() {
		return personsKilled;
	}
	
	public int getPedestriansInjured() {
		return pedestriansInjured;
	}
	
	public int getPedestriansKilled() {
		return pedestriansKilled;
	}
	
	public int getCyclistsInjured() {
		return cyclistsInjured;
	}
	
	public int getCyclistsKilled() {
		return cyclistsKilled;
	}
	
	public int getMotoristsInjured() {
		return motoristsInjured;
	}
	
	public int getMotoristsKilled() {
		return motoristsKilled;
	}
	
	
	
	
	
	
}
