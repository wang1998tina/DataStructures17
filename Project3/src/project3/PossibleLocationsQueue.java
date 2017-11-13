package project3;

public class PossibleLocationsQueue implements PossibleLocations{
	
/**
 * 
 * PossibleLocationsQueue implements the PossibleLocations interface to
 * accept types of Location.
 * It creates an array-based queue implementation. Location objects are
 * added and removed according to the FIFO (first in first out) principle
 * of queues. Objects are added to the end and removed from the front.If 
 * objects reach the end of the array and the beginning is empty, objects 
 * will wrap around. Once capacity is reached, though, 
 * a new array is created with twice the capacity. 
 * 
 * 
 * @author wang1998tina
 * @param Location
 * 	
 */
	
	
	/**
	 * Data fields
	 */
	private int length=0;
	private int capacity;
	private int head = 0;
	Location[] queue;
	
	
	/**
	 * Default constructor, sets length to 0 and creates new array of default size
	 * 10. Arrays can only hold Location objects.
	 * 
	 */
	public PossibleLocationsQueue (){
		super();
		this.length=0;
		queue = new Location[10];
		this.capacity = 10;
		
	}
	
	/**
	 * Constructor creates empty array of length n in the parameter. Length itself is 
	 * set to 0 still. 
	 * @param integer n, length of the array. NOT length of queue, as nothing has
	 * been added yet.
	 * @throws ArrayIndexOutOfBounds if negative length n is passed.
	 */
	public PossibleLocationsQueue(int n) {
		if(n<1) {
			throw new ArrayIndexOutOfBoundsException();
		}
		this.length = 0;
		queue = new Location[n];
		this.capacity = n;
	}
	
	/**
	 * Adds a new element to the queue, at the end of the 
	 * queue. The index of the element is specified with 
	 * (head + length)%capacity. If the length of the queue equals
	 * capacity, a new array with double the capacity will be
	 * created.
	 * 
	 * @throws NullPointerException if null object
	 * passed
	 * 
	 */
	@Override
	public void add(Location s) {
		if (s==null) {
			throw new NullPointerException();
		}
		if (length == capacity) {
			makeLarger();
		}	
		int i = (head + length) % capacity;
		queue[i] = s;
 		length++;
		
	}

	
	/**
	 * Removes object from the array queue. The head reference is shifted
	 * to the next object, and the temp field hold the original head,
	 * which is returned.
	 * @return Location object that was removed. Null if queue is empty.
	 */
	@Override
	public Location remove() {
		if (isEmpty()) {
			return null;
		}
		Location temp = queue[head];
		head = (head + 1) % capacity;
		length--;
		return temp;
	}

	/**
	 * Checks if queue is empty.
	 * @return true if empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return length==0;
	}
	
	/**
	 * Called by the add method. Creates a new array that's
	 * twice the capacity of the old array, and iterates
	 * through the queue to copy over objects, in order,
	 * to the new array.
	 */
	private void makeLarger() {
		Location[] newQueue = new Location[capacity*2];
		for (int i = 0; i<length; i++) {
			newQueue[i] = queue[(head + i) % capacity];
		}
		capacity = newQueue.length;
		head = 0;
		queue = newQueue;
		
		
	}
	
	/**
	 * For testing.
	 * @return capacity
	 */
	protected int getCapacity() {
		return this.capacity;
	}
	
	/**
	 * For testing.
	 * @return length of queue
	 */
	protected int getLength() {
		return this.length;
	}
	
	/**
	 * For testing.
	 * @return element at the head of queue
	 */
	protected int getHead() {
		return this.head;
	}
	
	/**
	 * For testing.
	 * @param index of the object to be fetched.
	 * @return object at specified index
	 * @throws ArrayIndexOutOfBoundsException if an
	 * invalid index is passed.
	 */
	protected Location getObject(int index) {
		if(index<0 || index>capacity) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return queue[index];
	}
	
	

}
