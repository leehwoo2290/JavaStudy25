package ch01;

public class StringEqualsExam {

	public static void main(String[] args) {
		// string - ��ü�� ����� ����ؾ� �ϸ� ���Ǹ� ���� ��������
		
		String strVal1 = "����";
		String strVal2 = "����";
		String strVal3 = new String("����");
		
		System.out.println(strVal1 == strVal2);//�ȿ� �޼��尡 �ٸ��� Ʋ���� ����
		System.out.println(strVal1 == strVal3);
	
		boolean eq1 = strVal1.equals(strVal3);
		System.out.println(eq1);
	}

}
