package Car;

public class Tire {

	private String tireType = null;
	
	public Tire(String _tireType) {
		
		System.out.println("Tire 객체를 생성(타이어의 초기 타입을 정의)");
		tireType = _tireType;
	}
	
	public void tireSpinning_SpeedUp() {
		
		System.out.println("@@@타이어 회전속도 증가 중@@@");
	}
	
	public void tireSpinning_MaxSpeed() {
		
		System.out.println("@@@타이어 최대 회전속도@@@");
	}
	
	public void tireSpinning_SpeedDown() {
		
		System.out.println("@@@타이어 회전속도 감소중@@@");
	}
	
	public void tireSpinning_Stop() {
		
		System.out.println("@@@타이어 회전종료@@@");
	}
}
