package ch01;

public class AccuracyExam2 {

	public static void main(String[] args) {
		
		int apple = 1;
		int totalPieces = apple * 10;
		int number = 7;
		int temp = totalPieces - number; // ����� ������ * 10�� ��
		
		double result = temp / 10.0;
		
		System.out.println(result);
	}

}
