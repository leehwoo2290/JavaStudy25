package ch01;

public class StringConcatExam {

	public static void main(String[] args) {
		// ���ڿ� ���� Test
		// �ǿ������� ������ ���ڿ��̸� ���ڿ� ���� ����
		
		String str1 ="JDK" + 17.0;
		System.out.println(str1);
		
		String str2 = str1 + "Ư¡";
		System.out.println(str2);
		
		String str3 = "jdk" + 3 + 3.0;
		System.out.println(str3);
		
		String str4 = 3 + 3.0 + "jdk";
		System.out.println(str4);
		//�ڵ��� �帧 ��->�� 3+3.0��������
	}

}
