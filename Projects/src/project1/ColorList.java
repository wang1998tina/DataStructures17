package project1;

import java.util.ArrayList;
class ColorList<T> extends ArrayList<Color> {
	
	/**ColorList class, subclass of ArrayList. 
	 * @author Tina Wang
	 * 
	 */
	
	public ColorList(){
		super();
	}
	
	/**Below two method: getColorByName and getColorByHexValue. Both return Color object 
	 * that matches the params
	 * 
	 * @param colorName or colorHexValue
	 * @return reference to the object that matches the parameters.
	 */
	
	public Color getColorByName(String colorName) {
		colorName=colorName.toUpperCase();
		//scrolls thru this arraylist
		for (int i = 0; i<this.size(); i++) {
			//if obj at i's name equals param
			String upperCase = this.get(i).getName().toUpperCase();
			System.out.println(upperCase);
			if(upperCase.equals(colorName)) {
				return this.get(i);
			}
		}
		return null;
	}
	
	public Color getColorByHexValue(String colorHexValue) {
		colorHexValue=colorHexValue.toUpperCase();
		//scrolls thru this arraylist
		for(int i = 0; i<this.size(); i++){
			//if color obj at i's hex value equals param
			if((this.get(i)).getHexValue().equals(colorHexValue)) {
				System.out.print(4);
				return this.get(i);
			}
		}
		return null;
	}
	
	
}
