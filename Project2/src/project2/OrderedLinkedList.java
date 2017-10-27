package project2;

/**
 * A class with generic type E that implements OrderedList interface. It creates
 * a singly linked list of Node<E> objects, which is a private internal class of 
 * OrderedLinkedList for better encapsulation. Nodes in the list are sorted through
 * the add() method using compareTo() which will vary depending on type of object<p>
 * 
 * Data fields contain references to head and tail nodes and size of list.
 * Methods allow adding, removing, clearing, cloning of list, and allow user to search
 * the list for a specific index or object.<p>
 * 
 * As with OrderedList interface, null elements are not allowed, but duplicates are.
 * 
 * 
 * @author wang1998tina
 *
 * @param <E> type of elements in this list
 */

public class OrderedLinkedList<E extends Comparable<E>> implements OrderedList<E>{
	
	/**
	 * This is the nested Node class within OrderedLinkedList. The class and private
	 * data fields cannot be accessed outside OrderedLinkedList, except for the
	 * public getter and setter methods that can be accessed outside the class. <p>
	 * 
	 * The Node class creates an object that holds an element of type E, as well
	 * as a reference to the next Node in the linked list, which is in the var next.
	 * Getters and setters allow users outside OrderedLinkedList to traverse the linked
	 * list and set a next element for a node.
	 * 
	 * I used the textbook code to guide me through creating this Node class.
	 * 
	 * @author wang1998tina
	 *
	 * @param <E> type of element Node can use
	 */
	
	private static class Node<E>{
		//based on TB code
		private Node<E> next;
		private E element;
		
		/**
		 * Constructor creates a new node with the element and reference
		 * to the next node. 
		 * @param elem of type E
		 * @param n which is a Node<E>. Can be null.
		 */
		public Node(E elem, Node<E> next){
			this.element = elem;
			this.next = next;
		}
		
		/**
		 * Returns the element contained within this node.
		 * @return element of type E 
		 */
		public E getElement() {
			return element;
		}
		
		/**
		 * Returns next node in the linked list.
		 * @return reference to next node
		 */
		public Node<E> getNext(){
			return next;
		}
		
		/**
		 * Sets the reference to the current next node to a new node,
		 * which replaces it as the next node.
		 * @param newest Node<E>
		 */
		public void setNext(Node<E> newest){
			next = newest;
		}
	}
	
	
	
	
	//OrderedLinkedList data fields
	private Node<E> head=null;
	private Node<E> tail=null;
	private int size=0;
	
	/**
	 * Constructs an empty OrderedLinkedList. Head and tail are both
	 * set to null be default, and size is 0.
	 */
	public OrderedLinkedList() {
		size=0;
	}
	
	/**
	 * Returns the Node that is the head of the linked list.
	 * @return head Node<E>
	 */
	public Node<E> getHead(){
		return head;
	}
	
	
	/**
	 * Returns the Node that is the tail, or last node, of
	 * the linked list.
	 * 
	 * @return tail Node<E>
	 */
	public Node<E> getTail(){
		return tail;
	}
	
	
	
	 /**
	  * Creates a new Node containing a valid element e and adds it
	  * to the OrderedLinkedList. Three cases: Node becomes new head, node becomes
	  * new tail, or node is inserted in the middle. <p>
	  * 
	  * CompareTo method is used, and its exact implementation depends on
	  * which type OLL contains, but it's always sorted from smallest to
	  * biggest based on compareTo(). <p>
	  * 
	  * @return true if node e is added successfully, false if nothing changed.
	  * @param element e of type E
	  * @throws NullPointerException if e is null
	  * @throws ClassCastException if e is not Comparable
	  */
	@Override
	public boolean add(E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		
		if (!(e instanceof Comparable<?>)) {
			throw new ClassCastException();
		}
		
		//if e is valid to be added
		Node<E> newElem = new Node<E>(e, null);
		Node<E> current = head;
		//add first node in empty list
		if(isEmpty()) {
			head = newElem;
			tail = newElem;
			size++;
			return true;
		} else if (!isEmpty()){
			//starting at head, until we iterate to the end
			while (current!=null) {
				//compare the hex values of the objs. small-->big
				//if node is smaller than head
				if (current.element.compareTo(e) >= 0) {
					newElem.setNext(current);
					head = newElem;
					size++;
					return true;
				}
				//if node is in middle
				if(current.getNext()!=null && current.element.compareTo(e) < 0 
						&& current.getNext().element.compareTo(e) >=0) {
					newElem.setNext(current.getNext());
					current.setNext(newElem);
					size++;
					return true;
				} else if (current.getNext()==null) {//if we hit end of list 
					current.setNext(newElem);
					//set tail
					tail = newElem;
					size++;
					return true;
				}
				current = current.getNext();
			}
			
		}
		return false;
	}

	
	
	/**
	 * Clears the entire list by setting head to null, so that list
	 * can't ever be accessed and is garbage collected.
	 */
	@Override
	public void clear() {
		head = null;
		this.size =0;
	}
	
	
	/**
	 * Iterates through OrderedLinkedList to see if an element in a node
	 * matches the valid Object o. How they are deemed to be equal depends on 
	 * the individual class of the object and element.<p>
	 * 
	 * @returns true if o is in OrderedLinkedList, false if not.
	 * @param o of type Object which is to be compared with elements in the nodes
	 * @throws NullPointerException if o is null
	 * @throws ClassCastException if o is not the same type as elements in
	 * the list.
	 */
	@Override
	public boolean contains(Object o) {
		Node<E> current = head;
		if (o == null) {
			throw new NullPointerException();
		}
		if(size==0) {
			return false;
		}
		if (! (o.getClass()==current.element.getClass())) {
			throw new ClassCastException();
		}
	
		
		//iterate through linked list 
		while(current!=null) {
			//return true for first element that matches
			if (current.element.equals(o)) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}
	
	/**
	 * Checks to see if size is zero, so list is empty.
	 * 
	 * @return true if size is 0, false if size >0
	 */
	public boolean isEmpty() {
		return size==0;
	}
	
	
	/**
	 * Takes a valid index of the list, and iterates through until it reaches
	 * the Node at the index. Then, returns the element in the Node at the index.
	 * 
	 * @return object of type E
	 * @param index of type int
	 * @throws IndexOutOfBoundsException if input index is out of bounds
	 * for the list or smaller than 0.
	 */
	@Override
	public E get(int index) {
		//if index is higher than size of list
		if (index > this.size()-1 || index<0) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> current = head;
		//iterate to the element at index
		for (int i =0; i<index;i++) {
			current = current.getNext();
		}
		return current.element;
	}

	/**
	 * Iterates through list and returns the first occurrence of the element
	 * in the list.
	 * 
	 * @returns integer index of matching element in node. -1 if o not
	 * in list
	 * @param Object o to be compared to
	 */
	@Override
	public int indexOf(Object o) {
		int index = 0;
		Node<E> current = head;
		//iterate thru the list
		while(current!=null) {
			//use equals method for Color objs
			if (current.element.equals(o)) {
				return index;
			}
			index++;
			current = current.getNext();
		}
		//return -1 if no match
		return -1;
	}

	/**
	 * Removes the element at the valid index in the list so that size decreases by 
	 * one and the element before the removed now links to the one after the 
	 * removed. The removed element is then returned.
	 * 
	 * @return element of type E that was removed
	 * @param integer index of the node to be removed
	 * @throws IndexOutOfBoundsException if index out of range or 
	 * index<0.
	 */
	@Override
	public E remove(int index) {
		Node<E> current = head;
		if (index > this.size()-1 || index<0) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> target = current;
		//if head needs to be removed
		if(index == 0) {
			head = current.getNext();
			size--;
			return target.element;
		}
		//iterate to the index before index of the node
		for (int i = 0; i<index-1; i++) {
			current = current.getNext();
		}
		
		target = current.getNext();
		if (target.getNext()==null) {//if node to rem at the end
			current.setNext(null);
			tail = current;
			size--;
			return target.element;
		}  else {
			//set node before to node after the target.
			current.setNext(target.getNext());
			size--;
			return target.element;
		}
		
		
	}
	
	
	/**
	 * Iterates through the list and removes the first occurrence of the element 
	 * that matches o. Size decreases and node before removed is linked to node
	 * after removed. Returns false if this does not happen. 
	 * 
	 * @return true if specified Node successfully removed, false if not.
	 * @param o of type Object to be removed from list
	 * @throws NullPointerException if o is null
	 * @throws ClassCastException if o is not the same type as elements
	 * in the list.
	 */
	@Override
	public boolean remove(Object o) {
		
		//set to previous so that i can remove a node in middle
		Node<E> previous = head;
		if (o == null) {
			throw new NullPointerException();
		}
		
		if (! (o.getClass()==previous.element.getClass())) {
			throw new ClassCastException();
		}
	
		//if node to remove is the head
		if (previous.equals(o)) {
			//if node is only in list
			if(this.size()==1) {
				head = null;
				size--;
				return true;
			}
			head = head.getNext();
			size--;
			return true;
		} else {
			while(previous.getNext()!=null) {
				//if node to remove is tail
				if (previous.getNext().element.equals(o) 
						&& previous.getNext().getNext()==null) {
					previous.setNext(null);
					tail = previous;
					size--;
					return true;
				}
				//if node to remove is in middle
				if (previous.getNext().element.equals(o)
						&& previous.getNext().getNext()!=null) {
					previous.setNext(previous.getNext().getNext());
					size--;
					return true;
				}
			previous = previous.getNext();
			}
		}
		
		return false;
		
	}
	
	/**
	 * Returns size, of number of nodes, in the list.
	 * 
	 * @return integer size of list.
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * If this list can be cloned, iterates through each Node and creates a shallow
	 * copy of each node which are linked together into a new list. Cloned list is
	 * independent - if a Node is removed in the first list the second is not affected,
	 * but the elements themselves are not cloned.
	 * 
	 * Used textbook as a guide for this method.
	 * 
	 * @return the cloned list which is type Object
	 * @throws CloneNotSupportedException if this list isn't an
	 * instance of Cloneable and therefore can't be cloned.
	 */
	public Object clone() throws CloneNotSupportedException{
		OrderedLinkedList<E> clone = (OrderedLinkedList<E>) super.clone();
		//if this linked list can't be cloned
		if(!(this instanceof Cloneable)) {
			throw new CloneNotSupportedException();
		}
		
	
		if (this.size>0) {
			clone.size = size;
			Node<E> iterate = this.head;
			clone.head = new Node<E>(iterate.getElement(), null);
			Node<E> newCurrent = clone.head;//head of clone
			iterate = iterate.getNext();
			
			while(iterate!=null) {
				Node<E> target = new Node<>(iterate.getElement(), null);
				newCurrent.setNext(target);
				newCurrent = newCurrent.getNext();
				iterate = iterate.getNext();
				
			}
			
		} 
			
			return clone;
		
	
	
		
	}
	
	
	/**
	 * Compares two lists to see if they are equal. They are equal if both are 
	 * same length, contain same type, and every corresponding element are equal.
	 * So, if list1.get(j).equals(list2.get(j)) for every
	 * j in index, every corresponding element is equal.
	 * 
	 * 
	 * @return true if both lists are same size, contain the same element type,
	 * and every element in every index are equal to each other.
	 * @param o of type Object
	 * 
	 */
	@Override
	public boolean equals(Object o) {
		//make sure o and elements of list are same type
		if (o.getClass()==this.getClass()){
			OrderedLinkedList newList = (OrderedLinkedList) o;
			if(newList.size()==size) {
				Node<E> thisCurrent = this.getHead();
				Node<E> newListCurrent = newList.getHead();
				//iterate through list
				while(thisCurrent!=null || newListCurrent!=null) {
					//if elements in both lists at same index do not match return false
					if(!thisCurrent.getElement().equals(newListCurrent.getElement())) {
						return false;
					}
					thisCurrent = thisCurrent.getNext();
					newListCurrent = newListCurrent.getNext();
				}
				return true;
			}
		}
		return false;
	}
	
	/**Returns a formatted String version of OrderedLinkedList. Each element uses
	 * its own toString() method but are formatted in this method to be 
	 * in the order they are sorted.
	 * 
	 * @return String version of OrderedLinkedList, formatted to be
	 * within brackets [] and separated by commas and a space.
	 */
	
	@Override
	public String toString() {
		if(size==0) {
			return "[]";
		}
		Node<E> current = head;
		String nodeString ="[";
		while(current.getNext()!=null) {
			nodeString = nodeString + current.element.toString() + ", ";
			current = current.getNext();
		}
		nodeString = nodeString + current.element.toString() + "]";
		return nodeString;
	}
	
	

}

