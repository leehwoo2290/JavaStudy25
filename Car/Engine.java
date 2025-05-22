package Car;

public class Engine {

	private double acceleration = 0.0;
	
	private double maxRpm = 0.0;
	private double curRpm = 0.0;
	private boolean bEngineRun = false;
	
	public Engine(double _acceleration, double _maxRpm) {
		
		System.out.println("Engine 객체를 생성(엔진 on, 엔진의 가속도 최대Rpm제한 정의)");
		//엔진의 가속능력
		acceleration = _acceleration;
		
		//엔진의 최대 rpm
		maxRpm = _maxRpm;
		
		bEngineRun = true;
	}
	
	public final double getCurRpm() {
		
		return curRpm;
	}
	
	public final boolean getEngineRun() {
		
		return bEngineRun;
	}
	
	public void engineOff() {
		
		System.out.println("@@@차량 엔진 OFF@@@");
		bEngineRun = false;
	}
	
	public double executeAccelerator(Tire _tire, GearType _gearType) {
		
		//GearType.DRIVE -> 전진 GearType.REVERSE -> 후진
		int plusMinus = _gearType == GearType.DRIVE ? 1 : -1;

		curRpm += acceleration;
		
		if(curRpm > maxRpm) {
			
			curRpm = maxRpm;
			_tire.tireSpinning_MaxSpeed();
		}
		else {
			
			_tire.tireSpinning_SpeedUp();
		}
			
		double calSpeed = curRpm * 0.1 * plusMinus;
		
		return calSpeed;
	}
	
	
	public double executeBreak(Tire _tire) {
		
		curRpm -= acceleration;
		
		if(curRpm < 0.0) {
			
			curRpm = 0.0;
			_tire.tireSpinning_Stop();
		}
		else {
			
			_tire.tireSpinning_SpeedDown();
		}
		
		double calSpeed = curRpm * 0.1;
		
		return calSpeed;
	}
	
}
