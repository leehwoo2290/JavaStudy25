package ch01;

public class VariableExam {

	public static void main(String[] args) {
		
		int mach;
		int distance;
		mach = 340;
		distance = mach * 60 * 60; //음속 m/s 계산
		
		System.out.println("소리가 한시간 동안 가는 거리: " + distance + "m");
		
		double radius, area;	//실수 타입 변수 선언
		
		radius = 10;			//초기값 정수 but 실수 타입으로 변환됨
		area = radius * radius * 3.14;
		
		System.out.print("반지름이 " + radius + "인");
		System.out.println(" 원의 넓이:" + area);
	}

}
