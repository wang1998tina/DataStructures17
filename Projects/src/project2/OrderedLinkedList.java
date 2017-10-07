package project2;

public class OrderedLinkedList<E extends Comparable<E>> implements OrderedList<E>{
	
	
	//TODO check for more places to throw exceptions
	//TODO change visibility of Node class back to private after testing
	
	static class Node<E>{//do i want it to be static or not
		//javadoc based on TB code
		private E element;
		private Node<E> next;
		public Node(E elem, Node<E> n){
			element = elem;
			next = n;
		}
		public E getElement() {
			return element;
		}
		public Node<E> getNext(){
			return next;
		}
		public void setNext(Node<E> newest){
			next = newest;
		}
	}
	
	//data fields
	private Node<E> head=null;
	private Node<E> tail=null;
	private int size=0;
	
	public OrderedLinkedList() {
		
	}
	
	public Node<E> getHead(){
		return head;
	}
	
	public Node<E> getTail(){
		return tail;
	}
	
	//TESTED
	@Override
	public boolean add(E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		
		if (!(e instanceof Comparable<?>)) {
			throw new ClassCastException();
		}
		//TODO check if e is of type of existin list??? or does above do that
		
		Node<E> newElem = new Node<E>(e, null);
		Node<E> current = head;
		if(isEmpty()) {
			head = newElem;
			tail = newElem;
			size++;
			return true;
		} else if (!isEmpty()){
			//starting at head, until we hit the end
			while (current!=null) {
				//compare the hex values of the objs
				//if node is larger than head
				if (current.element.compareTo(e)<= 0) {
					newElem.setNext(current);
					head = newElem;
					size++;
					return true;
				}
				//if node is in middle
				if(current.getNext()!=null && current.element.compareTo(e) > 0 
						&& current.getNext().element.compareTo(e) <=0) {
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

	//TESTED
	@Override
	public void clear() {
		//TODO check on this - does the rest of the list still exist? or garbage collected
		head = null;
		this.size =0;
	}
	
	//TESETED
	@Override
	public boolean contains(Object o) {
		Node<E> current = head;
		if (o == null) {
			throw new NullPointerException();
		}
		//TODO check on this
		if (! (o.getClass()==current.element.getClass())) {
			throw new ClassCastException();
		}
		//use equals method
		while(current!=null) {
			
			if (current.element.equals(o)) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}
	
	//not tested but prob correct
	public boolean isEmpty() {
		return size==0;
	}
	
	
	//TESTED
	@Override
	public E get(int index) {
		if (index > this.size()-1) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> current = head;
		for (int i =0; i<index;i++) {
			current = current.getNext();
		}
		return current.element;
	}

	//TESTED
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

	//TESTED
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
	
	
	@Override
	//TODO rewrite in terms of remove index
	//
	public boolean remove(Object o) {
		
		Node<E> current = head;
		if (o == null) {
			throw new NullPointerException();
		}
		
		if (! (o.getClass()==current.element.getClass())) {
			throw new ClassCastException();
		}
		//if node to remove is the head
		if (head.equals(o)) {
			head = head.getNext();
			size--;
		} else {
			while(current.getNext()!=null) {
				//if current gets to tail
				if (current.element.equals(o) 
						&& current.getNext()==null) {
					
				}
				//if node to rem is in middle
				if (true) {
					current = current.getNext().getNext();
					size--;
					return true;
				}
			current = current.getNext();
			}
		}
		
		return false;
		
	}

	@Override
	public int size() {
		return this.size;
	}

	
	public Object clone() throws CloneNotSupportedException{
		//idea for test - is clone same size, if i remove a node from one list will the other 
		//be changed (it's not supposed to)
		//safe cast from TB
		OrderedLinkedList<E> clone = (OrderedLinkedList) super.clone();
		if(!(this instanceof Cloneable)) {
			throw new CloneNotSupportedException();
		}
		if (this.size>0) {
			//inspiration from TB
			clone.head = new Node<E>(this.head.getElement(), null);
			Node<E> newCurrent = clone.head;//tail of clone
			size++;
			while(this.head.getNext()!=null) {
				Node<E> target = new Node<>(this.head.getElement(), null);
				newCurrent.setNext(target);
				newCurrent = newCurrent.getNext();
				size++;
			}
		}
		
		return clone;
		
	}
	
	@Override
	public String toString() {
		Node<E> current = head;
		String nodeString ="( ";
		while(current.getNext()!=null) {
			nodeString = nodeString + "[" + current.element.toString() + "]";
		}
		nodeString = nodeString + " )";
		return nodeString;
	}
	
	

}
