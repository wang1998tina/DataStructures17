package project2;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColorTest {

	@Test
	//PASSED - two same hex values equal
	public void testEqualsColor() {
		Color color1 = new Color("#FF0000");
		Color color2 = new Color("#FF0000");
		assertTrue(color1.equals(color2));
	}
	
	@Test
	//PASSED - two diff hex values not equal
	public void testEqualsColor2() {
		Color color1 = new Color("#FF0001");
		Color color2 = new Color ("#FF0000");
		assertFalse(color1.equals(color2));
	}

	@Test
	//PASSED - compareTo works with hex constructors
	public void testCompareTo() {
		Color color1 = new Color ("#000000");
		Color color2 = new Color ("#FFFFFF");
		assertTrue(color1.compareTo(color2)<0);
		Color color3 = new Color ("#FFFFFF");
		Color color4 = new Color ("#000000");
		assertTrue(color2.compareTo(color4)>0);
		Color color5 = new Color ("#DDDDDD");
		Color color6 = new Color ("#DDDDDD");
		assertTrue(color5.compareTo(color6)==0);
		
	}
	
	

}
