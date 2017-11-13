package project3;

public class PLQMainTest {

	public static void main(String[] args) {
		PossibleLocationsQueue q = new PossibleLocationsQueue(2);
		Location a = new Location(1,5);
		Location b = new Location(2,5);
		Location c = new Location(3,5);
		Location d = new Location(4,5);
		Location e = new Location(5,5);
		q.add(a);
		q.add(b);
		q.add(c);
		System.out.print(q.getCapacity());
		System.out.print(q.getHead());
		System.out.print(q.getLength());
		q.add(d);
		q.remove();
		System.out.print(q.getHead());
		q.remove();
		q.add(e);
		System.out.print(q.getHead());
		System.out.print(q.getCapacity());
		System.out.print(q.getLength());

	}

}
