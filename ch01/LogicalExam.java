package ch01;

import java.util.Scanner;

public class LogicalExam {

	public static void main(String[] args) {
		// &: ���� 2�� ��� ���� �� ��
		// |: ���� 2�� �� �ϳ��� ���̸� ��
		// !: �� ���� �� ���� ����
		// ^: ��Ÿ�� ���� ������ �������� 1+1=0���� ��г�
		
		String loginID = "kkw";
		String loginPW = "1234";
		
		Scanner input = new Scanner(System.in);
		//�ֿܼ� Ű����� �� �Է���
		
		System.out.print("id�Է�: ");
		String id = input.nextLine();
		//System.out.println(id);
		System.out.print("pw�Է�: ");
		String pw = input.nextLine();
		
		String successLogin;
		
		if(loginID.equals(id) && loginPW.equals(pw)) {
			successLogin = "�α��� ����";
		}
		else{
			successLogin = "�α��� ����";
		}
		System.out.println(successLogin);
	}

}
