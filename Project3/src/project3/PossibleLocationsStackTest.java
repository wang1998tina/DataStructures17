package project3;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Test;

public class PossibleLocationsStackTest {

	/**
	 * tested add and remove again, and make sure head and tail
	 * node and size updates correctly.
	 */
	@Test
	public void testAddRemove2() {
		PossibleLocationsStack s = new PossibleLocationsStack();
		Location a = new Location(3,5);
		Location b = new Location(5,5);
		Location c = new Location(4,5);
		Location d = new Location(5,5);
		Location e = new Location(4,5);
		s.add(a);
		s.add(b);
		assertTrue(s.getHeadElement().equals(a));
		assertTrue(s.getTailElement().equals(b));
		s.remove();
		s.add(c);
		assertEquals(s.getSize(), 2);
		assertTrue(s.getHeadElement().equals(a));
		assertTrue(s.getTailElement().equals(c));
		s.add(d);
		s.add(e);
		s.remove();
		assertTrue(s.getTailElement().equals(d));
	}
	
	/**
	 * 
	 */
	@Test
	public void testHeadTail() {
		PossibleLocationsStack s = new PossibleLocationsStack();
		Location a = new Location(3,5);
		Location b = new Location(5,5);
		s.add(a);
		s.add(b);
		s.remove();
		s.remove();
		assertTrue(s.getHead()==null);
		assertTrue(s.getTail()==null);
	}
	
	
	/**
	 * tests to make sure size data field is accurate
	 */
	@Test
	public void testSize() {
		PossibleLocationsStack s = new PossibleLocationsStack();
		Location a = new Location(3,5);
		Location b = new Location(5,5);
		Location c = new Location(4,5);
		s.add(a);
		s.add(b);
		s.add(c);
		assertEquals(s.getSize(), 3);
		s.remove();
		assertEquals(s.getSize(), 2);
		s.remove();
		s.remove();
		assertTrue(s.isEmpty());
	}
	
	
	/**
	 * tested a basic add and remove. made sure tail node consistently
	 * pointed to the right thing
	 */
	@Test
	public void testAddRemove() {
		PossibleLocationsStack s = new PossibleLocationsStack();
		Location a = new Location(3,5);
		Location b = new Location(5,5);
		Location c = new Location(4,5);
		s.add(a);
		s.add(b);
		s.add(c);
		Location d = s.remove();
		assertTrue(d.equals(c));
		assertTrue(s.getTailElement().equals(b));
		Location e = s.remove();
		assertTrue(e.equals(b));
		assertTrue(s.getTailElement().equals(a));
		s.remove();
		assertTrue(s.isEmpty());
	}
	
	/**
	 * attempted to remove from empty stack, and add null, both should throw 
	 * exceptions. Also made sure if only one thing is in the
	 * stack, both head and tail are pointing to it.
	 */
	@Test
	public void testAddRemoveWInvalidInputs() {
		PossibleLocationsStack s = new PossibleLocationsStack();
		Location a = null;
		Location b = new Location(5,5);
		Location x = s.remove();
		assertTrue(x==null);
		try {
			s.add(a);
			fail();
		} catch(Exception e) {
			assertEquals(e.getClass(), NullPointerException.class);
		}
		s.add(b);
		assertTrue(s.getHeadElement().equals(b));
		assertTrue(s.getTailElement().equals(b));
		
	}
	
	/**
	 * Tested add() method and checked if head and tail are pointing to the
	 * right objs
	 */
	@Test
	public void testPossibleLocationsStackAdd() {
		PossibleLocationsStack s = new PossibleLocationsStack();
		Location a = new Location(3,5);
		Location b = new Location(5,5);
		Location c = new Location(4,5);
		s.add(a);
		s.add(b);
		s.add(c);
		assertTrue(s.getSize()==3);
		assertTrue(s.getHeadElement().equals(a));
		assertTrue(s.getTailElement().equals(c));
		
	}

	

}
