package ch01;

public class IntToDouble {

	public static void main(String[] args) {
		//int -> float ���� 32bit��� but float �Ҽ��� ��� �����߻�
		int num1 = 123456789;
		int num2 = 123456789;
		
		double num3 = num1;
		num2 = (int)num3;
		
		System.out.println("num1: " +num1);
		System.out.println("num2: " +num2);
		System.out.println("num3: " +num3);

		int result = num1 - num2;
		System.out.println("(double ����ȯ ���� num���� ����)num1 - num2: " +result);
	}

}
