package ch01;

public class ByteExam {

	public static void main(String[] args) {
		
		byte var1 = 125;
		int var2 =125;
		for(int i =0 ; i<5; i++) { //����i�� 0~5���� 1�� �����ϴ� �ݺ���
			var1++; //byte 125�� 1�� ����
			var2++; //int 125�� 1�� ����
			System.out.println("var1 : " +var1 + "   var2 : " + var2);
		}
		
		byte var3 = -125;
		int var4 =125;
		for(int i =0 ; i<5; i++) {
			var3--;
			var4--;
			System.out.println("var3 : " +var3 + "   var4 : " + var4);
		}
		
		byte byteValue = 10;
		int intValue = byteValue ; // �ڵ�Ÿ�Ժ�ȯ
		System.out.println(intValue); //10�� ���
		//byte bytevalue1 = intValue ; ūŸ�Կ��� ���� Ÿ���� ����
		
	}

}
