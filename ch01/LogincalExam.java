package ch01;

import java.util.Scanner;

public class LogincalExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String loginid = "hh";
		String loginpw = "1234";
		String pwcaptcha = "0000";
		Scanner input = new Scanner(System.in);
		
		System.out.print("�α��� id�� �Է��ϼ��� :"	);
		String id = input.nextLine();
		System.out.println("�Է��Ͻ� id�� : " + id + "�Դϴ�");
		
		System.out.print("��й�ȣ�� �Է��ϼ��� : ");
		String pw = input.nextLine();
		System.out.println("==Ȯ�� ���Դϴ�==");
		
		if( (loginid.equals(id)) & loginpw.equals(pw)) {
			
			System.out.println("id�� pw�� ��ġ�մϴ�");
			System.out.println("�α����� �Ǿ����ϴ�");
		}else {
			System.out.println("id�� pw�� �ٸ��ϴ�");
			System.out.println("�α��� ����");
			
		}
		
		System.out.print("���ȹ��ڸ� �Է��ϼ��� :");
		String captcha = input.nextLine();
		System.out.println("==Ȯ�� ���Դϴ�==");
		
		if( (loginid.equals(id)&loginpw.equals(pw))& pwcaptcha.equals(captcha)) {
			
			System.out.println("��ġ�մϴ�. �α����� �Ǿ����ϴ�");
		
		}else 
			System.out.println("����ġ�մϴ�.�ٽ� �غ��ñ� �ٶ��ϴ�");
		}
	}//25.05.08




