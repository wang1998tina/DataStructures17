package JUnit;

public class Number {
	private int num;
	
	public Number ( ) {
		num = 0;
	}

	public Number ( int num ) {
		this.num = num;
	}

	public void add ( Number n )  {
		if (n==null) {
			throw new NullPointerException();
		}
		num = num + n.getNumber();
	}
	
	public void subtract ( Number n ) {
		if(n==null) {
			throw new NullPointerException();
		}
		num = num - n.getNumber();
	}
	
	public void multiply ( Number n ) {
		//TODO: needs to be implemented 
	}
	
	public void divide ( Number n ) {
		//TODO: needs to be implemented 
	}
	
	public Number duplicate ( ) {
		//TODO: needs to be implemented 
		return null; 
	}
	
	public int getNumber () { 
		return num; 
	}
	
	public String toString ( ) {
		//TODO: needs to be implemented 
		return null; 
	}
	
	@Override
	public boolean equals (Object o ) {
		//TODO: needs to be implemented 
		return false;
	}
	
}
