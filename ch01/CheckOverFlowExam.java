package ch01;

public class CheckOverFlowExam {

	public static void main(String[] args) {
		
			int result = safeAdd(70,80);
			System.out.println(result);
			
			
			
		}


	private static int safeAdd(int left, int right) {
		if(right>0) {
			if(left>(Integer.MAX_VALUE - right)) {
				throw new ArithmeticException("�����÷ο�߻�");
			}
		}else {
			if(left<(Integer.MIN_VALUE - right)) {
				throw new ArithmeticException("�����÷ο�߻�");
			}
		}
		return left + right ;
	}

}
