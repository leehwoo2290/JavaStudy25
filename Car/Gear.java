package Car;

public class Gear {

	private GearType curGearType = null;
	
	public Gear(GearType _gearType){
		
		System.out.println("Gear 객체를 생성(기어의 초기 타입을 정의)\n");
		//기어 타입 초기화
		curGearType = _gearType;
	}
	
	public final GearType getCurGearType() {
		
		return curGearType;
	}
	
	public void SetCurGearType(int _gearTypeNum) {
		
		switch(_gearTypeNum) {
		
		case 1:
			curGearType = GearType.PARKING;
			break;
		case 2:
			curGearType = GearType.REVERSE;
			break;
		case 3:
			curGearType = GearType.NEUTRAL;
			break;
		case 4:
			curGearType = GearType.DRIVE;
			break;
		}
	}
}
