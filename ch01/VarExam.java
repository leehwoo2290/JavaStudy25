package ch01;

public class VarExam {

	public static void main(String[] args) {
		
		//���� ���� �׽�Ʈ
		int x = 1;			//���� Ÿ���� x������ 1�Ҵ�
		char y = 65;			//��ǻ�ʹ� ���ڸ� �����ڵ�� ��ȯ�Ͽ� ó������ 65 == 'A'
		char z = 'A';			//char Ÿ���� z������ 'A'�Ҵ�

		System.out.println("int x = " + x); 
		System.out.println("char y = " + y); 
		System.out.println("char z = " + z); 
		//sysout ��Ʈ�� + �����̽� �ڵ��ϼ�
		//�ֿܼ� ����� ����մϴ�.
		
		//char z1 = 'zzz';
		
		int x1;				//�ʱ�ȭ �ȵ� ����
		x1 = 10;			//���� �� ����
		System.out.println(x1);
		
		//���� ���� ����
		int kor , math, eng, total, avg;
		
		kor = 90;
		math = 80;
		eng = 70;
		
		total =(kor+math+eng);	//����
		avg = total / 3;		//���
		
		System.out.println("����: " + total + "\n���: " + avg); //avg�� intŸ�� �̹Ƿ� ������ ���꿡 ������������
		
		//���� �ۼ� ��Ģ
		//������ ù���ڴ� ����, $,_ ��밡��(������ �������), ù���� ���� �ҹ��� ���� ���ο� �ܾ �߰��Ǹ� ù ���ڴ� �빮��
		
		//int $price(���� but �������), int @rr(����);
		
		//������ ��ҹ����� ���̿����� �ٸ� ������ �ν�
		char firstname = '��';
		char firstName = '��';
		
		System.out.println("��: " + firstname + "\n��: " + firstName);
		
		//������ ������ ��� �Ұ� ex)for, int, if
		
		//���ͷ�: ���� �Էµ� ��
		int literal1 = 75;			//10����
		int literal2 = 075;			//8����
		int literal3 = 0b0011;		//2����
		int literal4 = 0xA;			//16����
		
		System.out.println("10���� 75: " + literal1);
		System.out.println("8���� 75: " + literal2);
		System.out.println("2���� 0011: " + literal3);
		System.out.println("16���� A: " + literal4);
		
	}

}
