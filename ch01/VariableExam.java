package ch01;

public class VariableExam {

	public static void main(String[] args) {
		
		int mach;
		int distance;
		mach = 340;
		distance = mach * 60 * 60; //���� m/s ���
		
		System.out.println("�Ҹ��� �ѽð� ���� ���� �Ÿ�: " + distance + "m");
		
		double radius, area;	//�Ǽ� Ÿ�� ���� ����
		
		radius = 10;			//�ʱⰪ ���� but �Ǽ� Ÿ������ ��ȯ��
		area = radius * radius * 3.14;
		
		System.out.print("�������� " + radius + "��");
		System.out.println(" ���� ����:" + area);
	}

}
