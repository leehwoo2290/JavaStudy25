package ch01;

public class StringEqualsExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "이현우"; 
		String str2 = "이현우";
		String str3 = new String("이현우");
		
		//string 비교 연산은 주소값을 비교하네
		System.out.println(str1 == str3);
		System.out.println(str1.toString() + " " + str3.toString());
		System.out.println(str1.equals(str3));
		//객체비교 서야함
	}

}
