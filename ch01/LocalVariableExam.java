package ch01;

public class LocalVariableExam {

	public static void main(String[] args) {
		// ������ �������� ��ȣ ������ ȿ���� ������
		
		int v1 = 15;
		int v2 = 0;
		
		if(v1>10){	//���ǹ� ������ ���̸� ��ȣ ���� �ڵ� ����
			v2 = v1+10;
		}
		
		int v3 = v1+v2+5;
		
		System.out.println("v1 ��: " + v1);
		System.out.println("v2 ��: " + v2);
		System.out.println("v3 ��: " + v3);
	}

}
