package ch01;

public class StringEqualsExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "������"; 
		String str2 = "������";
		String str3 = new String("������");
		
		//string �� ������ �ּҰ��� ���ϳ�
		System.out.println(str1 == str3);
		System.out.println(str1.toString() + " " + str3.toString());
		System.out.println(str1.equals(str3));
		//��ü�� ������
	}

}
