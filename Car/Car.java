package Car;

public class Car {

	private String carType = null;
	
	private double curCarSpeed = 0.0;
	private double curCarOil = 0.0;
	private double fuelEfficiency = 0.0f;
	
	private Engine engine;
	private Tire tire;
	private Gear gear;	
	
	public Car() {
		
		System.out.println("Car기본생성자");
	}
	
	public Car(String _carType, double _oil, double _fuelEfficiency) {
		
		System.out.println("Car 객체를 생성 \n(Engine, Tire, Gear 객체를 생성하고 차량의 타입, 연료량, 연비의 초기값을 정의)");
		
		//엔진 객체 생성과 동시에 엔진의 초기 값 설정
		engine = new Engine(100.0, 1000.0);
		
		//타이어 객체 생성과 동시에 타이어의 초기 값 설정
		tire = new Tire("금호타이어");
		
		//기어 상태를 파킹으로 초기 값 설정
		gear = new Gear(GearType.PARKING);
		
		//자동차 객체 생성과 동시에 Type과 기름 충전
		carType = _carType;
		curCarOil = _oil;
		fuelEfficiency = _fuelEfficiency;
	}

	public final Engine getEngine() {
		
		return engine;
	}

	public void printDashBoard() {
		
		System.err.println("연료: " + curCarOil + " || 스피드: " + curCarSpeed + " || Rpm: " + engine.getCurRpm() + " || 기어: " + gear.getCurGearType() + " || 차량타입: " + carType);
	}
	
	public void executePedaling(int _pedalTypeNum) {
		
		switch(_pedalTypeNum) {
		
		case 0:
			executeAccelerator();	
			break;
			
		case 1:
			executeBreak();
			break;
		}
	}
	
	public void executeAccelerator() {
		
		//연료 없으면 주행 불가
		if(curCarOil - fuelEfficiency <= 0.0) {
			
			System.out.println("@@@차량 연료 잔고 0@@@");
			curCarOil = 0.0;
			engine.engineOff();
			return;
		}
		
		if(gear.getCurGearType() == GearType.DRIVE || gear.getCurGearType() == GearType.REVERSE) {
			
			curCarSpeed = engine.executeAccelerator(tire, gear.getCurGearType());
			
			curCarOil -= fuelEfficiency;
		}	
	}
	
	public void executeBreak() {
		
		curCarSpeed = engine.executeBreak(tire);
	}
	
	public void executeGearShifting(int _gearTypeNum) {
		
		gear.SetCurGearType(_gearTypeNum);
	}
	
}
