package ch01;

public class CheckOverFlowExam {

	public static void main(String[] args) {
		// 입력할 값을 사전 제어할 필요가 있음
		// main메서드 이외에 또다른 함수 메서드를 추가하여 사용

		int result = SafeAdd(70, 20);
		System.out.println(result);
	}

	public static int SafeAdd(int left, int right) {

		if (right > 0) {
			if (left > (Integer.MAX_VALUE - right)) {
				// Integer.MAX_VALUE = int최댓값
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
