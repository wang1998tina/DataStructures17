package project2;


public class OLLMainTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OrderedLinkedList<Integer> list=new OrderedLinkedList<>();
		int integer = 17;
		int int2 = 15;
		int int3 = 10;
		list.add(integer);
		list.add(int2);
		list.add(int3);
		
		try{
			OrderedLinkedList<Integer> list2 = (OrderedLinkedList<Integer>) list.clone();
			System.out.print(list2.toString());
		} catch (CloneNotSupportedException e){
			System.out.print("clone not sup");
		}
	}

}
