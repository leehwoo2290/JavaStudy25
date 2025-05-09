package ch01;

public class StringConcatExam {

	public static void main(String[] args) {
		// 문자열 연결 Test
		// 피연산자중 한쪽이 문자열이면 문자열 연결 가능
		
		String str1 ="JDK" + 17.0;
		System.out.println(str1);
		
		String str2 = str1 + "특징";
		System.out.println(str2);
		
		String str3 = "jdk" + 3 + 3.0;
		System.out.println(str3);
		
		String str4 = 3 + 3.0 + "jdk";
		System.out.println(str4);
		//코드의 흐름 좌->우 3+3.0먼저계산됨
	}

}
