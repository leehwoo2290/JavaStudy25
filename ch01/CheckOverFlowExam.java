package ch01;

public class CheckOverFlowExam {

	public static void main(String[] args) {
		// �Է��� ���� ���� ������ �ʿ䰡 ����
		// main�޼��� �̿ܿ� �Ǵٸ� �Լ� �޼��带 �߰��Ͽ� ���

		int result = SafeAdd(70, 20);
		System.out.println(result);
	}

	public static int SafeAdd(int left, int right) {

		if (right > 0) {
			if (left > (Integer.MAX_VALUE - right)) {
				// Integer.MAX_VALUE = int�ִ�
				throw new ArithmeticException("overflow");
			}
		} else {
			if (left < (Integer.MIN_VALUE - right)) {
				throw new ArithmeticException("d");
			}
		}
		return left + right;
	}
}
