package ch01;

import java.util.Scanner;

public class LogcalOrExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("2�� ����� 3�� ����� ���� Ȯ���غ����?");
		System.out.print(">>");
		
		int value = input.nextInt();
		if ((value%2==0) | (value%3==0)) {
			System.out.println("2 �Ǵ� 3�� ��� �Դϴ� :"+value);
		}else {
			System.out.println("2 �Ǵ� 3�� ����� �ƴմϴ�"+value);
		}
	}

}//25.05.09
