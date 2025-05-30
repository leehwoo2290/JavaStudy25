package Ch02.Service;

import Ch02.DTODataSingleton;

public class Service {

	protected DTODataSingleton dTODataSingleton = DTODataSingleton.getInstance();
		
	public void Menu() {
		
		System.out.println("메뉴 시작");
	}
}
