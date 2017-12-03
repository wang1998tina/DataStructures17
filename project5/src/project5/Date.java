package project5;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class represents calendar dates. 
 * 
 * @author Joanna Klukowska
 */
public class Date implements Comparable<Date>{
	private int year;
	private int month;
	private int day;
	
	
	/**
	 * Creates a Date object using a string in the format mm/dd/yyy. 
	 * @param s string in the format mm/dd/yyyy
	 * @throws IllegalArgumentException when s does not contain valid values or is not formatted
	 * correctly 
	 */
	public Date(String s) throws IllegalArgumentException{
		Scanner tokenizer = new Scanner(s);
		try {
			tokenizer.useDelimiter("/");
			
			month = tokenizer.nextInt();
			day = tokenizer.nextInt(); 
			year = tokenizer.nextInt() ;
			tokenizer.close();
		}
		catch (InputMismatchException ex ) {
				throw new IllegalArgumentException ( "year, month, day should be numbers"); 
		}
		catch (NoSuchElementException ex ){
			throw new IllegalArgumentException ( "invalid date format"); 
		}
		if (month < 1 || month > 12) 
			throw new IllegalArgumentException ("month < 1 or > 12 detected");
		if (day < 1 || day > 31) 
			throw new IllegalArgumentException ("day < 1 or > 31 detected");
		if (year < 1900 || year > 2020) 
			throw new IllegalArgumentException ("year < 1900 or > 2020 detected");
		
		
	}

	
	
	/**
	 * Creates a Date object using individual integer values for year, month and day. 
	 * @param year year for this date
	 * @param month month for this date 
	 * @param day day for this date 
	 * @throws IllegalArgumentException when s does not contain valid values or is not formatted
	 * correctly 
	 */
	public Date(int year, int month, int day)  throws IllegalArgumentException{
		this.year = year;
		this.month = month;
		this.day = day;
		if (year < 1900 || year > 2020) 
			throw new IllegalArgumentException ("year < 1900 or > 2020 detected");
		if (month < 1 || month > 12) 
			throw new IllegalArgumentException ("month < 1 or > 12 detected");
		if (day < 1 || day > 31) 
			throw new IllegalArgumentException ("day < 1 or > 31 detected");
		
	}



	/**
	 * Compares two Date objects for equality.
	 * @param obj the other Date object
	 * @return true if the two Date objects represent the same date 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Date))
			return false;
		Date other = (Date) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	

	/**
	 * Returns string representation of this Date object in the format
	 * mm/dd/yyy.
	 * @return string representation of the object 
	 */
	@Override
	public String toString() {
		return String.format("%02d/%02d/%4d",month, day, year);
	}
	
	

	/**Compares two Date objects.
	 * @return returns zero if two Date objects represent the same date, returns 
	 * a negative value if this date object represents smaller/earlier date, returns 
	 * a positive value if this date object represents larger/later date 
	 */
	@Override
	public int compareTo(Date o) {
		if (this.year != o.year) 
			return this.year - o.year;
		if (this.month != o.month)
			return this.month - o.month;
		return this.day - o.day; 
	}
	
	

}