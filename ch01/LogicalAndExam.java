package ch01;

import java.util.Scanner;

public class LogicalAndExam {

	public static void main(String[] args) {
		// ���� �׽�Ʈ
		// �ǿ����ڰ� ��� ���̿��� �� ��ȯ
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("������ �Է��ϸ� ��ҹ��ڳ� ���ڸ� �Ǻ�(�����ڵ� ǥ ����)");
		System.out.print("�����Է�: ");
		
		int charCode = input.nextInt();
		
		if(charCode >=65 && charCode <=90) {
			System.out.println("�빮�� " + (char)charCode);
		}
		else if(charCode >=97 && charCode <=122) {
			System.out.println("�ҹ��� " + (char)charCode);
		}
		else if(!(charCode < 48) && !(charCode > 57)) {
			System.out.println("���� " + (char)charCode);
		}
		else {
			System.out.println("�빮�� �ҹ��� ���� �����ڵ忡 ���ԾȵǴ� ����");
		}

	}

}
