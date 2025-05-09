package ch01;

public class VarExam {

	public static void main(String[] args) {
		
		//변수 선언 테스트
		int x = 1;			//정수 타입의 x변수에 1할당
		char y = 65;			//컴퓨터는 문자를 유니코드로 변환하여 처리가능 65 == 'A'
		char z = 'A';			//char 타입의 z변수에 'A'할당

		System.out.println("int x = " + x); 
		System.out.println("char y = " + y); 
		System.out.println("char z = " + z); 
		//sysout 컨트롤 + 스페이스 자동완성
		//콘솔에 결과를 출력합니다.
		
		//char z1 = 'zzz';
		
		int x1;				//초기화 안된 변수
		x1 = 10;			//변수 값 정의
		System.out.println(x1);
		
		//다중 변수 선언
		int kor , math, eng, total, avg;
		
		kor = 90;
		math = 80;
		eng = 70;
		
		total =(kor+math+eng);	//총점
		avg = total / 3;		//평균
		
		System.out.println("총점: " + total + "\n평균: " + avg); //avg는 int타입 이므로 나눗셈 연산에 적합하지않음
		
		//변수 작성 규칙
		//변수의 첫글자는 영문, $,_ 사용가능(가급적 사용제한), 첫글자 영문 소문자 이후 새로운 단어가 추가되면 첫 문자는 대문자
		
		//int $price(가능 but 사용제한), int @rr(에러);
		
		//변수명 대소문자의 차이에따라 다른 변수로 인식
		char firstname = '김';
		char firstName = '이';
		
		System.out.println("성: " + firstname + "\n성: " + firstName);
		
		//변수명에 예약어는 사용 불가 ex)for, int, if
		
		//리터럴: 직접 입력된 값
		int literal1 = 75;			//10진수
		int literal2 = 075;			//8진수
		int literal3 = 0b0011;		//2진수
		int literal4 = 0xA;			//16진수
		
		System.out.println("10진수 75: " + literal1);
		System.out.println("8진수 75: " + literal2);
		System.out.println("2진수 0011: " + literal3);
		System.out.println("16진수 A: " + literal4);
		
	}

}
