package project5;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class CollisionObjectTest {

	ArrayList<String> entries = new ArrayList<>();
	ArrayList<String> entries1 = new ArrayList<>();

	@Before
	public void defaultArrayList() {
		entries.add("3/17/2007"); //date 
		entries.add("");
		entries.add("");
		entries.add("10013"); //zip
		entries.add("");
		entries.add("");
		entries.add("");
		entries.add("");
		entries.add("0"); //persons inj
		entries.add("5"); //persons killed
		entries.add("3"); //pedestrians inj
		entries.add("0"); //ped killed
		entries.add("0"); //cyclists
		entries.add("1");
		entries.add("15"); //motorists
		entries.add("1");
		entries.add("1");
		entries.add("1");
		entries.add("1");
		entries.add("1");
		entries.add("1");
		entries.add("1");
		entries.add("1");
		entries.add("1");
		entries1.add("3/17/2007"); //date 
		entries1.add("");
		entries1.add("");
		entries1.add("10013"); //zip
		entries1.add("");
		entries1.add("");
		entries1.add("");
		entries1.add("");
		entries1.add("0"); //persons inj
		entries1.add("5"); //persons killed
		entries1.add("3"); //pedestrians inj
		entries1.add("0"); //ped killed
		entries1.add("0"); //cyclists
		entries1.add("1");
		entries1.add("15"); //motorists
		entries1.add("1");
		entries1.add("1");
		entries1.add("1");
		entries1.add("1");
		entries1.add("1");
		entries1.add("1");
		entries1.add("1");//key has to be nonempty
		entries1.add("1");
		entries1.add("1");
	}

	@Test
	public void testEmptyInjuries() {
		try {
			entries.set(10, "");
			Collision col = new Collision(entries);
			fail();
		} catch(Exception e) {
			assertTrue(e.getClass().equals(IllegalArgumentException.class));
		}
		
	}
	
	
	/*@Test 
	 public void testequals() {
		Collision col = new Collision(entries);
		Collision col1 = new Collision(entries1);
		assertTrue(col.equals(col1));
		
		entries.set(21, "0");
		Collision col2 = new Collision(entries);
		assertFalse(col2.equals(col1));
	}
	
	@Test
	public void testCompareToValid() {
		Collision col = new Collision(entries);
		Collision col1 = new Collision(entries1);
		assertTrue(col.compareTo(col1)==0);
		
		entries.set(0, "01/01/1998");
		Collision col2 = new Collision(entries);
		assertTrue(col2.compareTo(col1)<0);
		
		entries.set(0, "3/17/2007");
		entries.set(3, "10012");
		Collision col4= new Collision(entries);
		assertTrue(col4.compareTo(col1)==-1);
		
		
		entries.set(3, "10013");
		entries.set(21, "2");
		Collision col3 = new Collision(entries);
		assertTrue(col3.compareTo(col1)==1);
	}
	
	@Test
	public void testConstructorInvalidPersonsandZip() {
		entries.set(8, "-1");
		try {
			Collision col = new Collision(entries);
			fail();
		} catch(IllegalArgumentException e) {
			
		}
		entries.set(9, "");
		try {
			Collision col = new Collision(entries);
			fail();
		} catch(IllegalArgumentException e) {
			
		}
		entries.set(10, "15");
		
		entries.set(11, "e");
		try {
			Collision col = new Collision(entries);
			fail();
		} catch(IllegalArgumentException e) {
			
		}
		entries.set(12, "-100");
		try {
			Collision col = new Collision(entries);
			fail();
		} catch(IllegalArgumentException e) {
			
		}
		entries.set(13, "1/2");
		try {
			Collision col = new Collision(entries);
			fail();
		} catch(IllegalArgumentException e) {
			
		}
		entries.set(14, "17");
		
		entries.set(15, "0");
		
		entries.set(21, "");
		try {
			Collision col = new Collision(entries);
			fail();
		} catch(IllegalArgumentException e) {
			
		}
		
		
	}
	
	@Test
	public void testConstructorinvalidZip() {
		entries.set(0, "1001");
		try {
			Collision col = new Collision(entries);
			fail();
		} catch(IllegalArgumentException e) {
			
		}
		entries.set(0, "1eee1");
		try {
			Collision col1 = new Collision(entries);
			fail();
		} catch(IllegalArgumentException e) {
			
		}
		
	}
	
	@Test
	public void testConstructorInvalidDates() {
		entries.set(0, "");
		try {
			Collision col = new Collision(entries);
			fail();
		} catch(IllegalArgumentException e) {
			
		}
		entries.set(0, "19/34/1981938");
		try {
			Collision col1 = new Collision(entries);
			fail();
		} catch(IllegalArgumentException e) {
			
		}
		entries.set(0, "Jan 15 1998");
		try {
			Collision col2 = new Collision(entries);
			fail();
		} catch(IllegalArgumentException e) {
			
		}
		
	}
	
	@Test
	public void testConstructorProper() {
	
		try{
			Collision col = new Collision(entries);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getStackTrace().toString());
			fail();
		}
		
		
		
		
	}*/

	

}
