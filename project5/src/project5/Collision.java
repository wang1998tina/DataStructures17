package project5;

import java.util.ArrayList;

/**
 * 
 * 
 * @author wang1998tina
 *
 */

/*
 * TESTING NOTES
 * - for comapreTo and equals, can null be passed?
 * - for equals, if zip and date are diff but key same does it still equal?
 * 
 * 
 * 
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
	 * Constructor
	 * @param entries
	 * @throws IllegalArgumentException
	 */
	public Collision (ArrayList<String> entries)throws IllegalArgumentException{
		
		//TODO handle if entries.length==0
		
		//date
		try {
			this.date = new Date(entries.get(0));
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Invalid date input to "
					+ "Collision constructor");
		}
		
		//zip
		if(isDigit(entries.get(3)) && entries.get(3).length()==5 
				&& Integer.parseInt(entries.get(3))>0) {
			zip = entries.get(3);
			
		} else {
			throw new IllegalArgumentException("Invalid zip code in constructor");
		}
		
		//num of injuries/deaths
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
		if(personsInjured<0 || personsKilled<0 || pedestriansInjured<0 ||
			pedestriansKilled<0 || cyclistsInjured<0 || cyclistsKilled<0 ||
			motoristsInjured<0 || motoristsKilled<0) {
			throw new IllegalArgumentException("Injuries/deaths should be a "
					+ "nonnegative integer");
		}
			
		
		//key
		if(!(entries.get(24).length()==0)) {
			key = entries.get(24);
		} else {
			throw new IllegalArgumentException("invalid key in constructor");
		}
		
	}


	/**
	 * Overrides Comparable. Based on zip code, date, key, in order of priority. If comparing
	 * based on zip code, pos int returned if this object has larger int value. If comparing
	 * Dates, based on Date compareTo (pos value returned if this Date obj's date is later).
	 * If comparing by key, String compareTo is used.
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
	 * checks if a string contains an int
	 * @param str
	 * @return
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
	 * getter methods
	 * @return
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
