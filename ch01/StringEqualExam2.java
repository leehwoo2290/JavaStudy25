package ch01;

import java.util.Scanner;

public class StringEqualExam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = in.nextLine();
		System.out.print("���̸� �Է��ϼ��� : ");
		String age = in.nextLine();
		System.out.print("E-mail�� �Է��ϼ��� : ");
		String email = new String(in.nextLine());
		
		System.out.println("====Ȯ����====");
		System.out.println(name + "�� �ȳ��ϼ���");
		System.out.println(name +"���� ���̴�"+age+"�Դϴ�");
		System.out.println(name+"���� E-mail�� "+email+"�Դϴ�");
		System.out.println("���ȿ� �����Ͻñ� �ٶ��ϴ�");
	}

}//25.05.09
