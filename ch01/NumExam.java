package ch01;

import java.util.Scanner;

public class NumExam {

	public static void main(String[] args) {
		// ���� Ȧ¦
		Scanner in = new Scanner(System.in);
		
		System.out.print("������ �Է��ϼ��� :");
		int num = in.nextInt();//���࿡�� ��ȣ�� ���� �Է�
		System.out.println(num%2 ==0 ? "¦��":"�P��");
		

	}

}//25.05.09
