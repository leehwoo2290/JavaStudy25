package ch01;

public class CastingExam {

	public static void main(String[] args) {
		// 강제 타입 변환
		//큰 크기의 타입은 작은 크기의 타입으로 자동변환 불가능
		//이를 강제로 타입 변환할 수 있다.
		
		int intVal = 123456789;
		byte byteVal = (byte)intVal;
		System.out.println("int타입 값: " +intVal);
		System.out.println("강제타입 된 byte: " +byteVal); // 누수발생
		//byte타입의 8bit를 만들고 앞 앖을 날려버림
		
		int kor = 85, eng = 99, math = 97;
		int total = kor + eng + math;
		System.out.println("과목 총점: " +total);
		
		double avg = total / 3; //자동 타입 변환
		System.out.println("과목 평균(자동): " +avg);
		//문제 발생 : 소수점 계산 x
		// 이유 int type이 3으로 나눠짐
		avg = (double)total / 3; //자동 타입 변환
		System.out.println("과목 평균(강제): " +avg);
	}

}
