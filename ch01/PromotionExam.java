package ch01;

public class PromotionExam {

	public static void main(String[] args) {
		// 자동 타입 변환연습
		// 작은 타입 값을 큰 손실 없이 큰 타입 값으로 변환
		//byte(1byte : 8bit)
		//short(2byte : 16bit)
		//int(4byte : 32bit)
		//long(8byte : 64bit)	 접미사L
		//float(4byte : 32bit)	 접미사F
		//double(8byte : 64bit)
		
		byte byteVal = 10;
		int intVal = byteVal; // 자동 타입변환
		System.out.println("자동타입 된 int: " +intVal);
		
		char charVal = '가';
		intVal = charVal;
		System.out.println("자동타입 된 int: " +intVal);
		
		intVal = 500;
		long longVal = intVal; // 자동 타입변환
		System.out.println("자동타입 된 long: " +longVal);
		
		double doubleVal = intVal;// 자동 타입변환
		System.out.println("자동타입 된 double: " +doubleVal);
	}

}
