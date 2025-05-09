package ch01;

public class OperationExam {

	public static void main(String[] args) {
		// 연산자는 프로그램에서 데이터를 처리하여 결과를 산출함
		// 피연산자는 변수, 값을 말함
		
		//단항 연산 (변수가 한개)
		
		int x = 10;
		x++;	// x = x+1
		System.out.println("++ 단항연산: " + x);
		
		x--;	//x = x-1
		System.out.println("-- 단항연산: " + x);
		
		//이항 연산(변수 두개)
		int y = 20;
		int result = x+y;
		System.out.println("+ 이항 연산: " + result);
		
		boolean bResult = result > 10 ? true : false;
		//삼항 연산
		
		System.out.println("삼항 연산 result > 10결과: " + bResult);
		
		String resultS1 = result > 10 ? "크다" : "작다";
		System.out.println("삼항 연산 result > 10결과: " + resultS1);
		
		int x1 = 10 * 10;
		System.out.println("10 * 10 = " + x1);
		
		int x2 = 10 / 10;		
		System.out.println("10 / 10 = " + x2);
		
		int x3 = 10 % 10;		
		System.out.println("10 % 10 = " + x3);
		
		String resultS2 = x1 % 2 == 0 ? "짝수" : "홀수";
		System.out.println("x1은 " + resultS2);
		
		String resultS3 = x1 % 4 == 0 ? "4의배수 O" : "4의배수 X";
		System.out.println("x1은 " + resultS3);
		
		//증감 연산자 테스트
		
		System.out.println("증감 연산자 위치에 따른 결과");
		int a = 10;
		int c = a++; // c에 값 넣은 후 ++후위연산 ++a 일 시 정상 출력
		System.out.println("c: " + c);
		
		//System.out.println("a=11 ++a: " + ++a);
		
		c = ++a + a++; // a++은 c의값에 +1한 영향을 못준다.(후위 연산)
		System.out.println("c ++a + a++: " + c);
		
	}

}
