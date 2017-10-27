package project2;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderedLinkedListTest {

	@SuppressWarnings("unchecked")
	@Test
	public void testCloneWNum() {
		OrderedLinkedList<Integer> list=new OrderedLinkedList<>();
		int integer = 17;
		list.add(integer);
		assertTrue(list.toString().equals("[17]"));
		try{
			OrderedLinkedList<Integer> list2 = (OrderedLinkedList<Integer>) list.clone();
			assertTrue(list2.toString().equals("[17]"));
		} catch (CloneNotSupportedException e){
			
		}
		
		
		
		
		
		
	}
	/*
	@Test
	public void testaddStringsWIndex() {
		OrderedLinkedList<String> list = new OrderedLinkedList<>();
		String one = "arc";
		String two = "able";
		String three = "apple";
		list.add(one);
		list.add(two);
		list.add(three);
		assertTrue(list.getHead().getElement().equals(two));
		assertTrue(list.getTail().getElement().equals(one));
		*/
	}
	
	
	/*@Test
	 //FAILED
	public void testRemoveWithObject() {
		OrderedLinkedList<Color> list= new OrderedLinkedList<>();
		Color color = new Color("#000001");
		Color color1 = new Color("#000002");
		Color color2 = new Color("#000003");
		
		list.add(color);
		list.add(color1);
		list.add(color2);
		
		assertTrue(list.getHead().getElement().equals(color2));
		assertTrue(list.remove(color2)); 
		assertTrue(list.getHead().getElement().equals(color1));
		
	}*/
	
	/*@Test
	//PASSED - removes specified obj and also moves down the indexed
	public void testRemoveWithIndex() {
		OrderedLinkedList<Color> list= new OrderedLinkedList<>();
		Color color = new Color("#000001");
		Color color1 = new Color("#000002");
		Color color2 = new Color("#000003");
		Color color3 = new Color ("#000000");
		
		list.add(color);
		list.add(color1);
		list.add(color2);
		list.add(color3); 
		
		assertTrue(list.remove(1).equals(color1)); 
		assertTrue(list.get(1).equals(color)); 
	}*/
	
	/*@Test
	//PASSED - RETURNS CORRECT index and -1 if obj not in list
	public void testIndexOf() {
		OrderedLinkedList<Color> list= new OrderedLinkedList<>();
		Color color = new Color("#000000");
		Color color1 = new Color("#000001");
		Color color2 = new Color("#000002");
		Color color3 = new Color ("#000000");
		list.add(color);
		list.add(color1);
		list.add(color2);
		assertEquals(list.indexOf(color2), 0);
		assertEquals(list.indexOf(color), 2);
		assertEquals(list.indexOf(color3), -1);
	}*/
	
	/*@Test
	//PASSED - returns the correct object w spec index and
	//throws indexoutofbounds of index too high
	public void testGetWithIndex() {
		OrderedLinkedList<Color> list= new OrderedLinkedList<>();
		Color color = new Color("#000000");
		Color color1 = new Color("#000001");
		Color color2 = new Color("#000002");
		list.add(color);
		list.add(color1);
		list.add(color2);
		assertEquals(list.get(2), color);
		assertEquals(list.get(0), list.getHead().getElement());
		try {
			list.get(3);
		} catch (IndexOutOfBoundsException e) {
			assertEquals(e.getClass(), IndexOutOfBoundsException.class);
		}
		
	}*/
	
	/*@Test
	//PASSED - contains color objs in the list, doesn't contain valid color objs 
	//not in list, and also throws the right exceptions when null and invalid
	//obj passed
	public void testContains() {
		OrderedLinkedList<Color> list= new OrderedLinkedList<>();
		Color color = new Color("#000003");
		Color color1 = new Color("#000002");
		Color color2 = new Color("#FFFFF0");
		String str = "yay";
		Color nullColor = null;
		list.add(color);
		list.add(color1);
		assertTrue(list.contains(color));//passed
		assertFalse(list.contains(color2));//passed
		try {
			list.contains(nullColor);
			fail();
		} catch (NullPointerException e) {
			assertEquals(e.getClass(), NullPointerException.class);
		} 
		try {
			list.contains(str);
			fail();
		} catch (ClassCastException e){
			assertEquals(e.getClass(), ClassCastException.class);
		}
		
		 
	}*/
	
	
	
	/*@Test
	//PASSED BUT test later to make sure list is actually inaccessible
	public void testClear() {
		OrderedLinkedList<Color> list= new OrderedLinkedList<>();
		Color color = new Color("#000003");
		Color color1 = new Color("#000002");
		list.add(color);
		list.add(color1);
		list.clear();
		assertTrue(list.getHead()==null);
	}*/
	
	/*@Test
	//PASSED - added two with equal hex values and still sorted
	public void testAddMultipleEqualNodes() {
		OrderedLinkedList<Color> list= new OrderedLinkedList<>();
		Color color = new Color("#000004");
		Color color1 = new Color("#000003");
		Color color2 = new Color("#000003");
		assertTrue(list.add(color));
		assertTrue(list.add(color1));
		assertTrue(list.add(color2));
		assertEquals(list.get(0), color);
		assertEquals(list.get(1), color2);
		assertEquals(list.get(2), color1);
	}*/
	
	
	/*
	@Test
	//PASSED - multiple nodes
	public void testAddMultipleSortedNodes() {
		OrderedLinkedList<Color> list= new OrderedLinkedList<>();
		Color color = new Color("#000003");
		Color color1 = new Color("#000002");
		Color color2 = new Color("#000004");
		Color color3 = new Color ("#000001");
		Color color4 = new Color("#000005");
		
		// doesn't mean anything, just that it looped thru.
		//will return true even if it doesn't add properly
		list.add(color);
		list.add(color1);
		list.add(color2);
		list.add(color3);
		
		assertTrue(list.getHead().getElement().equals(color2));
		assertTrue(list.getHead().getNext().getElement().equals(color));
		assertTrue(list.getTail().getElement().equals(color3));
		//test a node larger than head
		list.add(color4);
		assertTrue(list.getHead().getElement().equals(color4));
		
	}*/


	
	/*@Test
	//PASSED - successfully added a node to head of empty list
	public void testAdd() {
		OrderedLinkedList<Color> list= new OrderedLinkedList<>();
		Color color = new Color("#FF0000");
		assertTrue(list.add(color));
		assertTrue(color.equals(list.getHead().getElement()));
	}*/
	
	/*@Test
	//PASSED - created 2 color objs and added to list. Also tail is set.
	public void testAddMore() {
		OrderedLinkedList<Color> list = new OrderedLinkedList<>();
		Color color = new Color("#000000");
		Color color1 = new Color ("#FFEEEE");
		assertTrue(list.add(color));
		assertTrue(list.add(color1));
		assertTrue(list.size()==2);
		assertTrue(list.getHead().getElement().equals(color1));
		assertTrue(list.getHead().getNext().getElement().equals(color));
		assertTrue(list.getTail().getElement().equals(color));
		
	}*/
	
	/*@Test
	//PASSED - NullPointerEx if null passed to add
	public void testAddFalseNode() {
		OrderedLinkedList<Color> list = new OrderedLinkedList<>();
		Color colorNull = null;
		try {
			list.add(colorNull);
			fail();
		} catch (NullPointerException e) {
			assertEquals(e.getClass(), NullPointerException.class);
		}
		
	}*/

}
