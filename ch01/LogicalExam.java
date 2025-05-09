package ch01;

import java.util.Scanner;

public class LogicalExam {

	public static void main(String[] args) {
		// &: 논리곱 2개 모두 참일 시 참
		// |: 논리합 2개 중 하나라도 참이면 참
		// !: 논리 부정 참 거짓 반전
		// ^: 배타적 논리합 논리합의 마지막인 1+1=0으로 결론남
		
		String loginID = "kkw";
		String loginPW = "1234";
		
		Scanner input = new Scanner(System.in);
		//콘솔에 키보드로 값 입력함
		
		System.out.print("id입력: ");
		String id = input.nextLine();
		//System.out.println(id);
		System.out.print("pw입력: ");
		String pw = input.nextLine();
		
		String successLogin;
		
		if(loginID.equals(id) && loginPW.equals(pw)) {
			successLogin = "로그인 성공";
		}
		else{
			successLogin = "로그인 실패";
		}
		System.out.println(successLogin);
	}

}
