package project3;

import java.util.EmptyStackException;


public class PossibleLocationsStack implements PossibleLocations{
	
/**
 * This is the PossibleLocationsStack. It implements the PossibleLocations interface to 
 * accept type of Location. 
 * It creates a singly linked list of Node<Location> objects, which is a private internal class of 
 * OrderedLinkedList for better encapsulation. The nodes can only contain Location objects, and
 * new objects are added to the tail of the stack, and are removed from the tail as well, according
 * to LIFO (last in first out) of a stack implementation.
 * 
 * Data fields in PossibleLocationsStack include size, a  Node<Location> reference to the head, 
 * and a Node<Location> reference to the tail.
 * 
 * @author wang1998tina
 *
 * @param <Location>
 */
	

	/**
	 * This is the nested Node class within OrderedLinkedList. The class and private
	 * data fields cannot be accessed outside OrderedLinkedList, except for the
	 * public getter and setter methods that can be accessed outside the class. <p>
	 * 
	 * The Node class creates an object that holds an element of type Location, as well
	 * as a reference to the next Node in the linked list, which is in the var next.
	 * Getters and setters allow users outside OrderedLinkedList to traverse the linked
	 * list and set a next element for a node.
	 * 
	 * 
	 * @author wang1998tina
	 *
	 * @param <Location> type of element Node can use
	 */
	private static class Node<Location>{

		private Node<Location> next;
		private Location element;
		
		/**
		 * Constructor creates a new node with the element and reference
		 * to the next node. 
		 * @param elem of type Location
		 * @param n which is a Node<Location>. Can be null.
		 */
		public Node(Location elem, Node<Location> next){
			this.element = elem;
			this.next = next;
		}
		
		/**
		 * Returns the element contained within this node.
		 * @return element of type Location 
		 */
		public Location getElement() {
			return element;
		}
		
		/**
		 * Returns next node in the linked list.
		 * @return reference to next node
		 */
		public Node<Location> getNext(){
			return next;
		}
		
		/**
		 * Sets the reference to the current next node to a new node,
		 * which replaces it as the next node.
		 * @param newest Node<Location>
		 */
		public void setNext(Node<Location> newest){
			next = newest;
		}
	}
	
	//end node class 
	
	
	
	/**
	 * data fields
	 */
	private int size=0;
	private Node<Location> head=null;
	private Node<Location> tail=null;
	
	
	/**
	 * Default constructor with list of size 0.
	 */
	public PossibleLocationsStack() {
		super();
		this.size =0;
	}
	

	/**
	 * Adds a Location object to linked list. If list is empty, head and
	 * tail both set to the object passed. Otherwise, it is added to the 
	 * list and tail reference set to it. 
	 * 
	 * @param Location object to be added. Does not accept null.
	 * @throws NullPointerException if a null object is passed.
	 */
	@Override
	public void add(Location s) {
		if (s == null) {
			throw new NullPointerException();
		}
		//if e is valid to be added
		Node<Location> newElem = new Node<Location>(s, null);
		//add first node in empty list
		if(isEmpty()) {
			head = newElem;
			tail = newElem;
			size++;
		} else if (!isEmpty()) {
			newElem.setNext(tail);
			tail = newElem;
			size++;
		}
		
	}

	/**
	 * Removes the tail (which is also the most recently added)
	 * from the list, and updates tail and size data fields. 
	 * 
	 * @throws EmptyStackException if remove() called on
	 * an empty list.
	 * @returns the Location object of the Node that is removed.
	 */
	@Override
	public Location remove() {
		if (isEmpty()) {
			return null;
		}
		Node<Location> target = tail;
		tail = target.next;
		size--;
		if(isEmpty()) {
			head=null;
			tail=null;
		}
		return target.element;
	}

	/**
	 * Check if list is empty.
	 * @returns true if list empty, false if not.
	 */
	@Override
	public boolean isEmpty() {
		return size==0;
	}
	
	/**
	 * For testing purposes.
	 * @return size of list
	 */
	protected int getSize() {
		return size;
	}
	
	/**
	 * For testing purposes.
	 * @return element of type Location stored
	 * at the head.
	 */
	protected Location getHeadElement() {
		return head.getElement();
	}
	
	/**
	 * For testing purposes.
	 * @return elem of type Location stored at
	 * the tail
	 */
	protected Location getTailElement() {
		return tail.getElement();
	}
	
	/**
	 * For testing purposes.
	 * @return Node at the head
	 */
	protected Node<Location> getHead(){
		return head;
	}
	
	/**
	 * For testing purposes.
	 * @return Node at the tail.
	 */
	protected Node<Location> getTail(){
		return tail;
	}

}
