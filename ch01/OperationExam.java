package ch01;

public class OperationExam {

	public static void main(String[] args) {
		// �����ڴ� ���α׷����� �����͸� ó���Ͽ� ����� ������
		// �ǿ����ڴ� ����, ���� ����
		
		//���� ���� (������ �Ѱ�)
		
		int x = 10;
		x++;	// x = x+1
		System.out.println("++ ���׿���: " + x);
		
		x--;	//x = x-1
		System.out.println("-- ���׿���: " + x);
		
		//���� ����(���� �ΰ�)
		int y = 20;
		int result = x+y;
		System.out.println("+ ���� ����: " + result);
		
		boolean bResult = result > 10 ? true : false;
		//���� ����
		
		System.out.println("���� ���� result > 10���: " + bResult);
		
		String resultS1 = result > 10 ? "ũ��" : "�۴�";
		System.out.println("���� ���� result > 10���: " + resultS1);
		
		int x1 = 10 * 10;
		System.out.println("10 * 10 = " + x1);
		
		int x2 = 10 / 10;		
		System.out.println("10 / 10 = " + x2);
		
		int x3 = 10 % 10;		
		System.out.println("10 % 10 = " + x3);
		
		String resultS2 = x1 % 2 == 0 ? "¦��" : "Ȧ��";
		System.out.println("x1�� " + resultS2);
		
		String resultS3 = x1 % 4 == 0 ? "4�ǹ�� O" : "4�ǹ�� X";
		System.out.println("x1�� " + resultS3);
		
		//���� ������ �׽�Ʈ
		
		System.out.println("���� ������ ��ġ�� ���� ���");
		int a = 10;
		int c = a++; // c�� �� ���� �� ++�������� ++a �� �� ���� ���
		System.out.println("c: " + c);
		
		//System.out.println("a=11 ++a: " + ++a);
		
		c = ++a + a++; // a++�� c�ǰ��� +1�� ������ ���ش�.(���� ����)
		System.out.println("c ++a + a++: " + c);
		
	}

}
