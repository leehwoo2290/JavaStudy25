package ch01;

import java.util.Scanner;

public class LogicalOrExam {

	public static void main(String[] args) {
		// ���� �׽�Ʈ
		// �ǿ����� �� �ϳ��� ���̿��� �� ��ȯ
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("2�Ǵ� 3�� ����ΰ�");
		System.out.print("���� �Է�: ");
		int i = input.nextInt();
		
		if(i % 2 == 0 || i % 3 == 0){
			System.out.print("�´�");
		}
		else {
			System.out.print("�ƴϴ� ");
		}
	}

}
