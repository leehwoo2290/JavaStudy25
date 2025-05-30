package Ch02;

import java.util.ArrayList;

import Ch02.Service.*;

public class TestExam {

	static public ArrayList<Service> services;
	
	static {
		
		services.add(new Service1());
		services.add(new Service2());
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int inputVal = 0;
		
		services.get(inputVal).Menu();
	}

}
