package ch01;

public class AccuracyExam1 {

	public static void main(String[] args) {
		// 10/1 = 0.1
		
		int apple = 1;
		double pieceUnit = 0.1;
		int num = 7;
		
		double result = apple - num * pieceUnit;
		System.out.println(result);
		
		System.out.println(num * pieceUnit);
		//정확한 계산을 위해서는 가급적 실수타입 사용 x

	}

}
