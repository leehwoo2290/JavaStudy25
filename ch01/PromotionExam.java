package ch01;

public class PromotionExam {

	public static void main(String[] args) {
		// �ڵ� Ÿ�� ��ȯ����
		// ���� Ÿ�� ���� ū �ս� ���� ū Ÿ�� ������ ��ȯ
		//byte(1byte : 8bit)
		//short(2byte : 16bit)
		//int(4byte : 32bit)
		//long(8byte : 64bit)	 ���̻�L
		//float(4byte : 32bit)	 ���̻�F
		//double(8byte : 64bit)
		
		byte byteVal = 10;
		int intVal = byteVal; // �ڵ� Ÿ�Ժ�ȯ
		System.out.println("�ڵ�Ÿ�� �� int: " +intVal);
		
		char charVal = '��';
		intVal = charVal;
		System.out.println("�ڵ�Ÿ�� �� int: " +intVal);
		
		intVal = 500;
		long longVal = intVal; // �ڵ� Ÿ�Ժ�ȯ
		System.out.println("�ڵ�Ÿ�� �� long: " +longVal);
		
		double doubleVal = intVal;// �ڵ� Ÿ�Ժ�ȯ
		System.out.println("�ڵ�Ÿ�� �� double: " +doubleVal);
	}

}
