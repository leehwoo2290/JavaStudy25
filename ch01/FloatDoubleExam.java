package ch01;

public class FloatDoubleExam {

	public static void main(String[] args) {
		double var1 =3.14;
		float var3 = 3.14F; //F�� ������ ������ ��� �̾���
		
		//���е� �׽�Ʈ
		double var4 = 0.123456789123456789;
		float var5 = 0.123456789123456789F;
		
		System.out.println(var1);
		System.out.println(var3);
		System.out.println(var4);
		System.out.println(var5);
		
		
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
		
		intValue = 200;
		double doubleValue = intValue; // int(4)�� ū Ÿ���� double(8)�� ��ȯ
		System.out.println(doubleValue);
		

	}

}
