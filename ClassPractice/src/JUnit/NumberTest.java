package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberTest {

	@Test
	public void testNumber() {
		try {
			Number n = new Number();
			assertNotNull("Default returned null", n);
			assertEquals("Default value should be 0", 0, n.getNumber());
			
		} catch (Exception e) {
			fail("testNumber failed");
		}
		
	}

	@Test
	public void testNumberInt() {
		Number c = new Number(4);
		assertTrue(c.getNumber()==4);
		
	}

	@Test
	public void testAdd() {
		try{
			Number x = null;
			Number c = new Number(4);
			c.add(x);
		} catch (Exception e) {
			assertEquals(e.getClass(), NullPointerException.class);
		}
		
	}

	@Test
	public void testSubtract() {
		try{
			Number x = null;
			Number c = new Number(4);
			c.add(x);
		} catch (Exception e) {
			assertEquals(e.getClass(), NullPointerException.class);
		}
	}

	@Test
	public void testMultiply() {
		fail("Not yet implemented");
	}

	@Test
	public void testDivide() {
		fail("Not yet implemented");
	}

	@Test
	public void testDuplicate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

}
