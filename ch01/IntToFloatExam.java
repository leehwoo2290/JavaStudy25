package ch01;

public class IntToFloatExam {

	public static void main(String[] args) {
		// float은 32bit로 되어잇는 부동소수점 연산에 사용
		// 정수 -> 실수로 변환시 손실 발생
		//int(32bit) = float(32bit)
		
		int num1 = 123456789;
		int num2 = 123456789;
		
		float num3 = num1;
		num2 = (int)num3;
		
		System.out.println("num1: " +num1);
		System.out.println("num2: " +num2);
		System.out.println("num3: " +num3);
		//um3: 1.23456792E8 E뒤의 숫자 부동 소숫점 처리
		//     1234567.92 E2-> 소숫점의 위치
		
		int result = num1 - num2;
		System.out.println("(float 형변환 후의 num값의 차이)num1 - num2: " +result);
	}

}
