package ch01;

public class IntExam {

	public static void main(String[] args) {
		
		int var1 = 10;
		int var2 = 012;
		int var3 = 0xA;
		int var4 = 0b0010;
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
		System.out.println(var4);
		
		//longŸ��
		
		long var11 = 10;
		long var12 = 20L;
		long var13 = 1000000000000L; //L�� ������ ������ ��� 0�� �̾���. L�� �ٿ��� ó����.
		
		System.out.println(var11);
		System.out.println(var12);
		System.out.println(var13);
		
		
		
		
		
		byte byteValue = 10;
		int intValue = byteValue ; // �ڵ�Ÿ�Ժ�ȯ
		System.out.println(intValue); //10�� ���
		//byte bytevalue1 = intValue ; ūŸ�Կ��� ���� Ÿ���� ����
		
		char charValue = '��';
		intValue = charValue ;
		System.out.println("���� �����ڵ� �� = " + intValue);
		
		intValue = 500;
		long longValue = intValue ;
		System.out.println(longValue);
		

		
	}

}
