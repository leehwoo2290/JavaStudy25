package ch01;

public class PrintfExam {

	public static void main(String[] args) {
		// �������
		
		int i = 99;
		String s = "cqx";
		double f = 3.18f;
		System.out.printf("%d\n", i);//10����
		System.out.printf("%o\n",i);//8����
		System.out.printf("%x\n", i);//16����
		System.out.printf("%c\n",i);//charǥ
		System.out.printf("%5d\n",i);//5ĭ�� ������ 2ĭ
		System.out.printf("%05d\n",i);//5ĭ�� ������ 2ĭ ���� �� �� 0
		System.out.printf("%s\n",s);//����
		System.out.printf("%5s\n",s);//5ĭ�� ����
		System.out.printf("%-5s\n",s);//�������� ���ĵ� ����
		System.out.printf("%f\n",f);//����
		System.out.printf("%e\n",f);//����
		System.out.printf("%4.1f\n",f);//4ĭ�� �Ҽ��� �� ĭ �� �� ����
		System.out.printf("%04.1f\n",f);//�տ� 0������ �Ҽ��� �� ĭ �� �� ����
		System.out.printf("%-4.1f\n",f);//�������� ���ĵ� ����

	}

}//25.05.09
