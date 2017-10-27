package project2;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColorListTest {

	@Test
	public void testGetColorByName() {
		ColorList<Color> list = new ColorList<>();
		Color one =new Color("#0000ff", "blue");
		Color two = new Color ("#000000", "white");
		Color three = new Color ("#ffffff", "black");
		Color four = new Color ("#ff0000", "red");
		list.add(one);
		list.add(two);
		list.add(three);
		list.add(four);
		assertTrue(list.getColorByName("red").equals(four));
	}

}
