package ch01;

public class CompareExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num1 = 10;
		int num2 = 10;
		
		boolean result1 = num1 == num2;	
		System.out.println(result1);
		
		char char1 = '1';
		char char2 =  1;
		
		boolean result2 = char1 == char2;	
		System.out.println(result2);
		
		int v2 = 1;
		double v3 = 1.0;
		System.out.println(v2 == v3);
		//�ǿ����� �ٸ��� �� �Ͼ�� �ڵ�Ÿ�� ���� -> ū������
		
		double V4 = 0.1;
		float v5 = 0.1F;
		System.out.println((float)V4 == v5);
		System.out.println(V4 == (double)v5);
		//System.out.println(V4 == v5);
		//�Ҽ����� �ε� �Ҽ������� ����
		//true�� ����� ���ؼ� ����Ÿ�Ժ�ȯ�� �ʿ�
		
		System.out.println((int)V4 * 10 == (int)v5 * 10);
	}

}
