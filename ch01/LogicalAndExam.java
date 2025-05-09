package ch01;

import java.util.Scanner;

public class LogicalAndExam {

	public static void main(String[] args) {
		// 논리곱 테스트
		// 피연산자가 모두 참이여야 참 반환
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("정수를 입력하면 대소문자나 숫자를 판별(유니코드 표 참고)");
		System.out.print("숫자입력: ");
		
		int charCode = input.nextInt();
		
		if(charCode >=65 && charCode <=90) {
			System.out.println("대문자 " + (char)charCode);
		}
		else if(charCode >=97 && charCode <=122) {
			System.out.println("소문자 " + (char)charCode);
		}
		else if(!(charCode < 48) && !(charCode > 57)) {
			System.out.println("숫자 " + (char)charCode);
		}
		else {
			System.out.println("대문자 소문자 숫자 유니코드에 포함안되는 숫자");
		}

	}

}
