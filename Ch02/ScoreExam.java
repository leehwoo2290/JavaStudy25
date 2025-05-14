package Ch02;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map.Entry;

public class ScoreExam {
	 
	//의문: 왜 enum 크기 반환 해주는 메서드는 없는가?
	
	//학생 정보 enum
	//값 추가 및 수정 가능 but 무조건 enumEnd을 마지막에 둘것
	public enum StudentInfoType {
		학교, 이름, 학번, enumEnd //enum크기 반환을 위해 선언
	}
	
	//클래스 하나로 만드니까 변수들 임시 static 선언
	public static ArrayList<String> subjects = new ArrayList<String>();
	
	public static ArrayList<String> studentInfo = new ArrayList<String>();    
	
	//LinkedHashMap== 입력 순서에 대한 저장을 보장받음
	//ArrayList<String> == studentInfo, ArrayList<Integer> == studentGrade
	public static LinkedHashMap<ArrayList<String>, ArrayList<Integer>> student_Info_Grade = new LinkedHashMap<ArrayList<String>, ArrayList<Integer>>();
	
	
	//프로그램 종료 단어와 입력 단어가 일치하는지 반환
	public static boolean CheckProgramEnd(String _inputWord, String _programEndWord) {
		
		//equalsIgnoreCase == 대소문자 구분 없이 string값 판단
		return !_inputWord.equalsIgnoreCase(_programEndWord);
	}
	//과목 종류 추가 메서드
	public static void AddSubject() {
			
		//경고 해결법은 close, but 함수 종료 전에 close사용 했으나 에러
		Scanner input = new Scanner(System.in);	
		
		boolean bFlag = true;		
		
		while(bFlag) {
			
			String subject;
			System.out.println("-------------------------------------");
			System.out.print("추가하고 싶은 과목을 입력하시오. \n 과목: ");	
			subject = input.next();
			
			//입력 받은 subject값 subjects에 삽입
			subjects.add(subject);
			
			System.out.print("프로그램 종료 (end) || 프로그램 반복 (아무 문자): \n\n");
			
			bFlag = CheckProgramEnd(input.next(), "end");			
		}
		
		//scanner 종료
		//input.close();
	}
	
	//학생 정보
	public static void AddStudentInfo() {
		
		//경고 해결법은 close, but 함수 종료 전에 close사용 했으나 에러
		Scanner input = new Scanner(System.in);
		
		int studentCnt = 0;
		
		boolean bFlag = true;
		
		while(bFlag) {	
			
			System.out.println("-------------------------------------");
			System.out.println(++studentCnt + " 번째 학생의 정보를 입력하세요.\n");
			
			for (StudentInfoType infoType : StudentInfoType.values()) {
				
				//enumEnd는 enum의 크기를 위해 추가한 임시값 정보 입력 시 무시한다.
				if(infoType == StudentInfoType.enumEnd)continue;
				
				String studentInfoVal;
				
				System.out.print(infoType + ": ");	
				studentInfoVal = input.next();
				
				//첫 번째 학생의 studentInfo
				//ex) studentInfo[0][한국대학교]
				//ex) studentInfo[1][20171248]
				//ex) studentInfo[2][이현우]
				//	  studentInfo[3] 2번째 학생의 Info...
				studentInfo.add(studentInfoVal);
			}

			System.out.println("프로그램 종료 (end) || 프로그램 반복 (아무 문자): \n\n");
			
			bFlag = CheckProgramEnd(input.next(), "end");	
		}
		
		//scanner 종료
		//input.close();
	}
		
	//학생의 정보와 성적 추가 메서드
	public static void AddStudentGrade(){
		
		//경고 해결법은 close, but 함수 종료 전에 close사용 했으나 에러
		Scanner input = new Scanner(System.in);
		
		//_studentInfo의 이름만 순회 / i = 1 -> 4 -> 7 ...
		for (int i = StudentInfoType.이름.ordinal(); i < studentInfo.size(); i += StudentInfoType.enumEnd.ordinal()) {
			
			System.out.println("-------------------------------------");
			System.out.println("'" + studentInfo.get(i) + "' 학생의 ");	
					
			//studentInfo의 인덱스 0~2 / 3~5 / 6~8 ... 값을 저장 합니다. 
			//enum의 이름 위치가 바뀌더라도 정상작동
			ArrayList<String> studentInfoSubList = 
					new ArrayList<String>(studentInfo.subList(i - StudentInfoType.이름.ordinal(), i +  StudentInfoType.enumEnd.ordinal() - StudentInfoType.이름.ordinal()));  
			
			ArrayList<Integer> studentGrade = new ArrayList<Integer>(); 
			
			//subjects 저장된 과목들 순회하면서 studentGrade에 점수 입력
			//studentGrade[0] = grade || studentGrade[0]은 subjects[0]의 점수라는 의미를 가짐
			for(var subject : subjects) {
				
				System.out.print(subject + "과목 점수 입력: ");
				
				int grade = input.nextInt();
				studentGrade.add(grade);
			}
			
			//LinkedHashMap<ArrayList<String>, ArrayList<Integer>>
			//ArrayList<String> == studentInfo, ArrayList<Integer> == studentGrade
			student_Info_Grade.put(studentInfoSubList, studentGrade);
		}
		
		//scanner 종료
		//input.close();
	}
	
	
	public static void PrintStudentInfoAndGrade() {
		
		int cnt = 0;

		for(Entry<ArrayList<String>, ArrayList<Integer>> entryList : student_Info_Grade.entrySet()) {
			
			System.out.println("-------------------------------------");
			System.out.println(++cnt + " 번째 학생의 정보\n");	
			
			String curStudentName = "defaultValue";
			
			//entryList.getKey() == studentInfo 순회 (134번줄 참고)
			for(int i = 0; i < entryList.getKey().size(); i++) {
				  
				//이름만 curStudentName에 따로 저장
				if(StudentInfoType.values()[i] == StudentInfoType.이름) {
					curStudentName = entryList.getKey().get(i);
				}
				System.out.println(StudentInfoType.values()[i] + ": " + entryList.getKey().get(i));  
			}			
			
			System.out.println(curStudentName + "  학생의 점수\n");	
	
			//entryList.getValue() == studentGrade 순회 (134번줄 참고)
			for(int i = 0; i < entryList.getValue().size(); i++) {
		   		
				System.out.println(subjects.get(i) + ": " + entryList.getValue().get(i) + "점");
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		//과목 종류 추가
		AddSubject();
		
		//학생 정보 추가
		AddStudentInfo();
		
		//학생 성적 추가
		AddStudentGrade();
		
		//출력
		PrintStudentInfoAndGrade();
		
		//기능추가? ex) 사용자가 원하는 특정 값에 따른 정렬 or 탐색, 잘못 입력된 데이터에 대한 반환 및 재입력
	}

}
