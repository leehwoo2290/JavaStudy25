package ch01;

public class IntToDouble {

	public static void main(String[] args) {
		//int -> float 같은 32bit사용 but float 소숫점 사용 누수발생
		int num1 = 123456789;
		int num2 = 123456789;
		
		double num3 = num1;
		num2 = (int)num3;
		
		System.out.println("num1: " +num1);
		System.out.println("num2: " +num2);
		System.out.println("num3: " +num3);

		int result = num1 - num2;
		System.out.println("(double 형변환 후의 num값의 차이)num1 - num2: " +result);
	}

}
