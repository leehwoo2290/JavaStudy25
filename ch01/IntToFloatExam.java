package ch01;

public class IntToFloatExam {

	public static void main(String[] args) {
		// float�� 32bit�� �Ǿ��մ� �ε��Ҽ��� ���꿡 ���
		// ���� -> �Ǽ��� ��ȯ�� �ս� �߻�
		//int(32bit) = float(32bit)
		
		int num1 = 123456789;
		int num2 = 123456789;
		
		float num3 = num1;
		num2 = (int)num3;
		
		System.out.println("num1: " +num1);
		System.out.println("num2: " +num2);
		System.out.println("num3: " +num3);
		//um3: 1.23456792E8 E���� ���� �ε� �Ҽ��� ó��
		//     1234567.92 E2-> �Ҽ����� ��ġ
		
		int result = num1 - num2;
		System.out.println("(float ����ȯ ���� num���� ����)num1 - num2: " +result);
	}

}
