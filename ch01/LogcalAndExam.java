package ch01;

import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

public class LogcalAndExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("������ �Է��Ͻø� ��ҹ��ڳ� ���ڸ� �Ǵ��մϴ�: ");
		
		int charCode = input.nextInt();
		
		if((charCode>=65)&(charCode<=90)) {
			System.out.println("�Է°��� �빮�� �Դϴ� :" +(char)charCode);
			
			
		}else if((charCode>=97)&&(charCode<=122)) {
			System.out.println("�Է°��� �ҹ��� �Դϴ� :"+(char)charCode);
			
		}else if(!(charCode < 48)&&!(charCode > 57)) {
			System.out.println("�Է°��� �����Դϴ� :"+(char)charCode);
			
		}else {
			System.out.println("��ҹ��ڳ� ���ڰ� �ƴմϴ�");
		}
		
	}

}//25.05.09
