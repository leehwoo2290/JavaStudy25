package Car;

import java.util.Scanner;

public class MainExam {

	public static void main(String[] args) {
		
		//빈 car생성 더미
		//Car car1 = new Car();
		Car car2 = new Car("G80", 100.0, 4.0);
		
		Scanner input = new Scanner(System.in);
		
				
		while(car2.getEngine().getEngineRun()) {
			
			car2.printDashBoard();
			
			System.out.println("---------------------------------");
			System.out.println("차량 기어 변속");
			System.out.println("0.유지 1. Parking 2. Reverse 3. Neutral 4. Drive");
			System.out.println("---------------------------------");
			
			int inputGearTypeNum = input.nextInt();		
			car2.executeGearShifting(inputGearTypeNum);
			
			System.out.println("0. 엑셀 밟기 1. 브레이크 밟기");
			
			int inputPedalTypeNum = input.nextInt();	
			car2.executePedaling(inputPedalTypeNum);
		
		}
	}
}
