package project2;


public class OLLMainTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*try {
		OrderedLinkedList<String> list = new OrderedLinkedList<>();
		OrderedLinkedList<String> clone = (OrderedLinkedList) list.clone();
		System.out.print(clone.equals(list));
		} catch (CloneNotSupportedException e) {
			
		}*/
		
		OrderedLinkedList<Integer> list = new OrderedLinkedList<>();
		list.add(45);
		list.add(39);
		list.add(78);
		list.add(65);
		
		System.out.print(list.toString());
		try {
			OrderedLinkedList<Integer> list2 = (OrderedLinkedList) list.clone();
			System.out.print(list2.toString());
		} catch (CloneNotSupportedException e) {
			System.err.print("no");
		}
		
		
		/*OrderedLinkedList<Integer> list=new OrderedLinkedList<>();
		int integer = 45;
		int int2 = 39;
		int int3 = 78;
		int int4 = 65;
		list.add(integer);
		list.add(int2);
		list.add(int3);
		list.add(int4);
		
		try{
			OrderedLinkedList<Integer> list2 = (OrderedLinkedList<Integer>) list.clone();
			System.out.print(list2.toString());
		} catch (CloneNotSupportedException e){
			System.out.print("clone not sup");
		}*/
		/*
		ColorList<Color> list = new ColorList<>();
		Color one =new Color("#0000ff", "blue");
		Color two = new Color ("#000000", "white");
		Color three = new Color ("#ffffff", "black");
		Color four = new Color ("#ff0000", "red");
		list.add(one);
		list.add(two);
		list.add(three);
		list.add(four);
		//System.out.print(list.toString());
		
		Color five = new Color (100, 100, 100);
		five.convertToHex();
		System.out.print(five.getHexValue());
		
		list.getHead().setNext(newest);*/
	}

}
