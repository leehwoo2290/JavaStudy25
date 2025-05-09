package ch01;

public class LocalVariableExam {

	public static void main(String[] args) {
		// 변수의 사용범위는 괄호 내에서 효과를 발휘함
		
		int v1 = 15;
		int v2 = 0;
		
		if(v1>10){	//조건문 조건이 참이면 괄호 내의 코드 실행
			v2 = v1+10;
		}
		
		int v3 = v1+v2+5;
		
		System.out.println("v1 값: " + v1);
		System.out.println("v2 값: " + v2);
		System.out.println("v3 값: " + v3);
	}

}
