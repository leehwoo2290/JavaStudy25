package Ch02;

import java.util.ArrayList;

import Ch02.DTO.*;

public class DTODataSingleton {

	 private static DTODataSingleton singletonObject;
	
	 private ArrayList<Test1DTO> test1DTOs;
	 private ArrayList<Test2DTO> test2DTOs;

		// private 생성자
	    private DTODataSingleton() {
	    }
	    
	    // getInstance()
	    public static DTODataSingleton getInstance() {
	        if (singletonObject == null) {
	            singletonObject = new DTODataSingleton();
	        }
	        
	        return singletonObject;
	    }
	    
	    public ArrayList<Test1DTO> getTest1DTOs() {
			return test1DTOs;
		}

		public void addTest1DTOs(Test1DTO test1DTO) {
			test1DTOs.add(test1DTO);
		}

		public ArrayList<Test2DTO> getTest2DTOs() {
			return test2DTOs;
		}

		public void addTest2DTOs(Test2DTO test2DTO) {
			test2DTOs.add(test2DTO);
			
			//test2DTOs.remove(test2DTO);
		}
}
