package Ch02;

class parents{
	
	public void testt() {
		
		System.out.println("parents");
	}
}

public class test extends parents{

	public void testt() {
		
		System.out.println("test");
	}
	public static void main(String[] args) {
		
		parents t = new test();
		
	
		t.testt();
	}
}
