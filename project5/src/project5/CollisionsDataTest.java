package project5;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class CollisionsDataTest {

	CollisionsData tree = new CollisionsData();
	ArrayList<String> entries = new ArrayList<>();
	
	@Before
	public void defaultTest() {
		entries.add("01/01/2000"); //date 
		entries.add("");
		entries.add("");
		entries.add("10013"); //zip
		entries.add("");
		entries.add("");
		entries.add("");
		entries.add("");
		entries.add("0"); 
		entries.add("0"); 
		entries.add("0"); //persons injured
		entries.add("0"); 
		entries.add("0"); //pedestrians
		entries.add("0");
		entries.add("0"); //cyclists
		entries.add("0");
		entries.add("0");//motorists
		entries.add("0");
		entries.add("1");
		entries.add("1");
		entries.add("1");
		entries.add("1");
		entries.add("1");
		entries.add("1");//key
		entries.add("0");
		
	}
	
	
	
	
	/*@Test
	public void testRemoveThreeNodes() {
		entries.set(3, "10011");
		Collision col = new Collision(entries);
		entries.set(3, "10012");
		Collision col1 = new Collision(entries);
		entries.set(3, "10013");
		Collision col2 = new Collision(entries);
		entries.set(3, "10010");
		Collision col3 = new Collision(entries);
		entries.set(3, "10009");
		Collision col4 = new Collision(entries);
		entries.set(3, "10014");
		Collision col5 = new Collision(entries);
		tree.add(col);
		tree.add(col1);
		tree.add(col2);
		tree.add(col3);
		tree.add(col4);
		tree.add(col5);
		tree.remove(col1);
		assertTrue(tree.root.data.equals(col));
		assertTrue(tree.root.right.data.equals(col2));
		assertTrue(tree.root.height==2);
		
	}*/
	
	/*@Test
	public void testSimpleRemove() {
		
		Collision col = new Collision(entries);
		entries.set(3, "10012");
		Collision col1 = new Collision(entries);
		tree.add(col);
		tree.add(col1);
		tree.remove(col1);
		assertTrue(tree.root.data.equals(col));
		assertTrue(tree.root.left==null);
	}*/

	/*@Test
	public void testLLMultipleNodes() {
		entries.set(3, "10011");
		Collision col = new Collision(entries);
		entries.set(3, "10012");
		Collision col1 = new Collision(entries);
		entries.set(3, "10013");
		Collision col2 = new Collision(entries);
		entries.set(3, "10014");
		Collision col3 = new Collision(entries);
		entries.set(3, "10015");
		Collision col4 = new Collision(entries);
		entries.set(3, "10016");
		Collision col5 = new Collision(entries);
		entries.set(3, "10014");
		Collision col6 = new Collision(entries);
		tree.add(col);
		tree.add(col1);
		tree.add(col2);
		tree.add(col3);
		tree.add(col4);
		tree.add(col5);
		tree.add(col6);
		assertTrue(tree.root.data.equals(col3));
		assertTrue(tree.root.left.data.equals(col1));
		assertTrue(tree.root.right.data.equals(col4));
		assertTrue(tree.root.right.right.data.equals(col5));
		assertTrue(tree.root.left.left.data.equals(col));
		assertTrue(tree.root.left.right.data.equals(col2));
		
	}*/
	
	/*@Test
	public void testThreeNodesRotationRL() {
		Collision col = new Collision(entries);
		entries.set(3, "10012");
		Collision col1 = new Collision(entries);
		entries.set(3, "10011");
		Collision col2 = new Collision(entries);
		tree.add(col2);
		tree.add(col);
		tree.add(col1);
		assertTrue(tree.root.data.equals(col1));
		assertTrue(tree.root.left.data.equals(col2));
		assertTrue(tree.root.right.data.equals(col));
		assertTrue(tree.root.height==1);
	}*/
	
	/*@Test
	public void testThreeNodeRotationLR() {
		Collision col = new Collision(entries);
		entries.set(3, "10012");
		Collision col1 = new Collision(entries);
		entries.set(3, "10011");
		Collision col2 = new Collision(entries);
		tree.add(col);
		tree.add(col2);
		tree.add(col1);
		assertTrue(tree.root.data.equals(col1));
		assertTrue(tree.root.left.data.equals(col2));
		assertTrue(tree.root.right.data.equals(col));
		assertTrue(tree.root.height==1);
	}*/
	
	/*@Test
	public void testThreeNodeRotationRR() {
		Collision col = new Collision(entries);
		entries.set(3, "10012");
		Collision col1 = new Collision(entries);
		entries.set(3, "10011");
		Collision col2 = new Collision(entries);
		tree.add(col2);
		tree.add(col1);
		tree.add(col);
		assertTrue(tree.root.data.equals(col1));
		assertTrue(tree.root.left.data.equals(col2));
		assertTrue(tree.root.right.data.equals(col));
		assertTrue(tree.root.height==1);
		//should give same results as test below
	}*/
	
	/*@Test
	public void testThreeNodeRotationLL() {
		Collision col = new Collision(entries);
		entries.set(3, "10012");
		Collision col1 = new Collision(entries);
		entries.set(3, "10011");
		Collision col2 = new Collision(entries);
		entries.set(3, "10014");
		Collision col3 = new Collision(entries);
		tree.add(col);
		tree.add(col1);
		tree.add(col2);
		tree.add(col3);
		assertTrue(tree.root.data.equals(col1));
		assertTrue(tree.root.left.data.equals(col2));
		assertTrue(tree.root.right.data.equals(col));
		assertTrue(tree.root.height==2);
		
		
	}*/
	
	/*@Test
	public void testNodeClass() {
		Collision col = new Collision(entries);
		tree.add(col);
		entries.set(3, "10014");
		Collision col1 = new Collision(entries);
		tree.add(col1);
		assertTrue(tree.root.data.equals(col));
		assertTrue(tree.root.right.data.equals(col1));
	}*/
	
	/*@Test
	public void testAddThreeDiffThings() {
		Collision col = new Collision(entries);
		entries.set(3, "10002");
		Collision col1 = new Collision(entries);
		entries.set(3, "10014");
		Collision col2 = new Collision(entries);
		tree.add(col);
		tree.add(col1);
		tree.add(col2);
		assertTrue(tree.size()==3);
		
		
	}*/

	


}
