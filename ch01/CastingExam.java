package ch01;

public class CastingExam {

	public static void main(String[] args) {
		// ���� Ÿ�� ��ȯ
		//ū ũ���� Ÿ���� ���� ũ���� Ÿ������ �ڵ���ȯ �Ұ���
		//�̸� ������ Ÿ�� ��ȯ�� �� �ִ�.
		
		int intVal = 123456789;
		byte byteVal = (byte)intVal;
		System.out.println("intŸ�� ��: " +intVal);
		System.out.println("����Ÿ�� �� byte: " +byteVal); // �����߻�
		//byteŸ���� 8bit�� ����� �� ���� ��������
		
		int kor = 85, eng = 99, math = 97;
		int total = kor + eng + math;
		System.out.println("���� ����: " +total);
		
		double avg = total / 3; //�ڵ� Ÿ�� ��ȯ
		System.out.println("���� ���(�ڵ�): " +avg);
		//���� �߻� : �Ҽ��� ��� x
		// ���� int type�� 3���� ������
		avg = (double)total / 3; //�ڵ� Ÿ�� ��ȯ
		System.out.println("���� ���(����): " +avg);
	}

}
