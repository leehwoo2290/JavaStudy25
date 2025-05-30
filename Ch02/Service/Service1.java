package Ch02.Service;

public class Service1 extends Service{

	
	public void Menu() {
		
		System.out.println("Service1 ");
		super.Menu();
		
		dTODataSingleton.addTest1DTOs();
	}
}
