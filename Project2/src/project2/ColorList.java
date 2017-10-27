package project2;

/**
 * A subclass of OrderedLinkedList that only works with Color objects.
 * As well as OrderedLinkedList methods, ColorList also implements methods that search through
 * itself and return specific Color objects.
 * If there are duplicates, they only return the first found.
 * 
 * 
 * @author wang1998tina
 *
 * @param <T> type of elements
 */

public class ColorList<T> extends OrderedLinkedList<Color> {
	

	/**
	 * Constructor creates an empty ColorList. 
	 * 
	 */
	public ColorList(){
		super();
		}
	
	/**
	 * Searches through sorted ColorList from head node to tail node to find a Color
	 * object whose name field is identical to the param using string 
	 * equalsIgnoreCase() method.
	 * 
	 * @param String colorName to compare with object name
	 * @return reference to the first object that matches the name.
	 * Will not return a second if there are duplicates in the sorted list.
	 * will return null if method iterates through entire list and no
	 * object has a name field that matches colorName.
	 */
	
	public Color getColorByName(String colorName) {
		
		//scrolls thru this arraylist
		for (int i = 0; i<this.size(); i++) {
			//if obj at index i equals colorName. next iteration if
			//obj does not contain a name field.
			if(this.get(i).getName()!=null 
					&& this.get(i).getName().equalsIgnoreCase(colorName)) {
				return this.get(i);
			}
		}
		return null;
	}
	
	
	/**
	 * Searches through sorted ColorList from head node to tail node to 
	 * find a Color pbject whose hex value is identical to the parameter.
	 * 
	 * 
	 * @param String colorHexValue
	 * @return reference to the first object that matches hex value.
	 * Does not return another if there are duplicates. Will return null if none
	 * of the Color objects has a hex value that matches colorHexValue.
	 */
	
	
	public Color getColorByHexValue(String colorHexValue) {
		colorHexValue=colorHexValue.toUpperCase();
		//scrolls thru this arraylist
		for(int i = 0; i<this.size(); i++){
			//if color obj at i's hex value equals param
			if((this.get(i)).getHexValue().equalsIgnoreCase(colorHexValue)) {
				return this.get(i);
			}
		}
		return null;
	}
	
	
}


