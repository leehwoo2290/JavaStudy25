package ch01;

import java.util.Scanner;

public class LogicalOrExam {

	public static void main(String[] args) {
		// 논리합 테스트
		// 피연산자 중 하나만 참이여도 참 반환
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("2또는 3의 배수인가");
		System.out.print("숫자 입력: ");
		int i = input.nextInt();
		
		if(i % 2 == 0 || i % 3 == 0){
			System.out.print("맞다");
		}
		else {
			System.out.print("아니다 ");
		}
	}

}
