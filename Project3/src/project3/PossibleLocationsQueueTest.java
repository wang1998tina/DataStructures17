package project3;

import static org.junit.Assert.*;

import org.junit.Test;

public class PossibleLocationsQueueTest {

	
	/**
	 * A third test to test wrapping and makeLarger().
	 */
	@Test
	public void testWrapThenMakeLargerx2() {
		PossibleLocationsQueue q = new PossibleLocationsQueue(2);
		Location a = new Location(1,5);
		Location b = new Location(2,5);
		Location c = new Location(3,5);
		Location d = new Location(4,5);
		Location e = new Location(4,5);
		q.add(a);
		q.add(b);
		q.remove();
		q.add(c);
		q.add(d);
		q.add(e);
		q.remove();
		q.remove();
		q.add(a);
		q.add(b);
		q.add(c);
		assertTrue(q.getCapacity()==8);
		assertTrue(q.getHead()==0);
		assertTrue(q.getLength()==5);
		Location t = q.remove();
		assertTrue(t.equals(d));
		Location u = q.remove();
		assertTrue(u.equals(e));
		Location v = q.remove();
		assertTrue(v.equals(a));
		Location w = q.remove();
		assertTrue(w.equals(b));
		Location x = q.remove();
		assertTrue(x.equals(c));
		assertTrue(q.isEmpty());
		
	}
	
	/**
	 * testing to see if capacity will double more than one time if I keep adding
	 * objects.
	 */
	@Test
	public void testMakeLargerx2() {
		PossibleLocationsQueue q = new PossibleLocationsQueue(2);
		Location a = new Location(1,5);
		Location b = new Location(2,5);
		Location c = new Location(3,5);
		Location d = new Location(4,5);
		Location e = new Location(4,5);
		q.add(a);
		q.add(b);
		q.add(c);
		q.add(d);
		q.add(e);

		assertTrue(q.getCapacity()==8);
		assertTrue(q.getLength()==5);
	}
	
	/**
	 * A second test to keep testing wrapping and makelarger() 
	 */
	@Test
	public void testWrapThenMakeLarger() {
		PossibleLocationsQueue q = new PossibleLocationsQueue(4);
		Location a = new Location(1,5);
		Location b = new Location(2,5);
		Location c = new Location(3,5);
		Location d = new Location(4,5);
		Location e = new Location(4,5);
		q.add(a);
		q.add(b);
		q.add(c);
		q.add(d);
		q.remove();
		q.remove();
		q.add(e);
		q.add(a);
		q.add(b);
		assertTrue(q.getCapacity()==8);
		assertTrue(q.getLength()==5);
		assertTrue(q.getHead()==0);
		Location x = q.remove();
		assertTrue(x.equals(c));
		q.remove();
		Location y = q.remove();
		assertTrue(y.equals(e));
		Location z = q.remove();
		assertTrue(z.equals(a));
	}
	
	/**
	 * attempted to add a null object and Location objects with different parameters
	 */
	@Test
	public void testRandomInputs() {
		PossibleLocationsQueue q = new PossibleLocationsQueue();
		Location a = null;
		Location b = new Location(-10, 5);
		Location c = new Location(-10, 5);
		try {
			q.add(a);
			fail();
		} catch (NullPointerException e) {
			assertEquals(e.getClass(), NullPointerException.class);
		}
		q.add(b);
		q.add(c);
		assertTrue(q.getLength()==2);
		assertTrue(q.getHead()==0);
		Location x = q.remove();
		assertTrue(x.equals(b));
	}
	
	
	/**
	 * tests both the makeLarger() method and wrapping of objs in the queue. also tests 
	 * remove() when queue empty
	 */
	@Test
	public void testMakeLargerAndWrap() {
		PossibleLocationsQueue q = new PossibleLocationsQueue(2);
		Location a = new Location(1,5);
		Location b = new Location(2,5);
		Location c = new Location(3,5);
		Location d = new Location(4,5);
		Location e = new Location(5,5);
		q.add(a);
		q.add(b);
		q.add(c);
		q.add(d);
		q.remove();
		q.remove();
		q.add(e);
		assertTrue(q.getCapacity()==4);
		assertTrue(q.getHead()==2);
		q.remove();
		q.remove();
		assertTrue(q.getCapacity()==4);
		assertTrue(q.getHead()==0);
		assertTrue(q.getLength()==1);
		Location g = q.remove();
		assertTrue(g.equals(e));
		Location f = q.remove();
		assertTrue(f==null);
		
		
	}
	
	/**
	 * Tests queue to make sure capacity doubles and the objs are in the right locations
	 * when makeLarger() is called..
	 */
	@Test
	public void testMakeLarger1() {
		PossibleLocationsQueue q = new PossibleLocationsQueue(3);
		Location a = new Location(1,5);
		Location b = new Location(2,5);
		Location c = new Location(3,5);
		Location d = new Location(4,5);
		q.add(a);
		q.add(b);
		q.add(c);
		q.add(d);
		assertTrue(q.getCapacity()==6);
		q.remove();
		q.remove();
		assertTrue(q.getHead()==2);
		q.remove();
		Location e = q.remove();
		assertTrue(e.equals(d));
		
	}
	
	
	/**
	 * test wrapping of objs in the queue. makes sure each object is in the correct location.
	 */
	@Test 
	public void testQueueWrap1() {
		PossibleLocationsQueue q = new PossibleLocationsQueue(6);
		Location a = new Location(1,5);
		Location b = new Location(2,5);
		Location c = new Location(3,5);
		Location d = new Location(4,5);
		Location e = new Location(5,5);
		q.add(a);
		q.add(b);
		q.add(c);
		q.add(d);
		q.remove();
		q.add(e);
		assertTrue(q.getHead()==1);
		Location f = q.remove();
		assertTrue(f.equals(b));
		assertTrue(q.getHead()==2);
		assertTrue(q.getLength()==3);
		
		
	}
	
	
	/**
	 * tests constructors. makes sure their capacities are right, and
	 * attempts to initialize a param of 0.
	 */
	@Test
	public void testPossibleLocationsQueueConstructor() {
		PossibleLocationsQueue q1 = new PossibleLocationsQueue();
		PossibleLocationsQueue q2 = new PossibleLocationsQueue(5);
		assertTrue(q1.getCapacity()==10);
		assertTrue(q2.getCapacity()==5);
		assertTrue(q1.getLength()==0);
		assertTrue(q2.getLength()==0);
		try {
			PossibleLocationsQueue q3 = new PossibleLocationsQueue(0);
			fail();
		} catch (ArrayIndexOutOfBoundsException e) {
			assertEquals(e.getClass(), ArrayIndexOutOfBoundsException.class);
		}
		
	}
	
	/**
	 * adds and removes objects - tests to make sure the right objs removed
	 */
	@Test
	public void testPLQAddRemove1() {
		PossibleLocationsQueue q1 = new PossibleLocationsQueue();
		Location a = new Location(3,5);
		Location b = new Location(4,5);
		q1.add(a);
		q1.add(b);
		assertTrue(q1.getLength()==2);
		Location c = q1.remove();
		assertTrue(c.equals(a));
		assertTrue(q1.getLength()==1);
		Location d = q1.remove();
		assertTrue(d.equals(b));
		assertTrue(q1.isEmpty());
	}
	
	/**
	 * adds a null Location object. should throw a NullPointerException.
	 */
	@Test
	public void testPLQAddNull() {
		try {
			PossibleLocationsQueue q = new PossibleLocationsQueue();
			Location a = null;
			q.add(a);
			fail();
		} catch (NullPointerException e) {
			assertEquals(e.getClass(), NullPointerException.class);
		}
		
	}

	

}
