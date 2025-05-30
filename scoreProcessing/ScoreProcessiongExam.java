package scoreProcessing;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

import scoreProcessing.dto.GradeDTO;
import scoreProcessing.dto.StudentDTO;
import scoreProcessing.dto.StudentGradeInfoDTO;
import scoreProcessing.service.*;

public class ScoreProcessiongExam {

	public static Scanner inputInt = new Scanner(System.in);
	public static Scanner inputStr = new Scanner(System.in);
	
	public static ArrayList<Service> services = new ArrayList<Service>();
	
	public static StudentGradeInfoDTO studentGradeInfoDTO;
	
	
	static {
		
		studentGradeInfoDTO = new StudentGradeInfoDTO();
		
		services.add(new SubjectsModifyService());
		services.add(new StudentModifyService());
		services.add(new StudentGradeService());
		services.add(new PrintInfoService());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean bRun = true;
		
		System.out.println("-------성적 처리 시스템 시작--------");
		
		while(bRun) {
			
			System.out.println("1. 과목 추가 || 2. 학생 추가 || 3. 학생 성적 추가 || 4. 출력");
			System.out.print("입력 >>");
			
			int inputVal = inputInt.nextInt();
			
			if(inputVal <= 0 || inputVal > services.size()) {
				
				System.out.println("올바른 값을 입력해주세요.");
				continue;
			}
			
			services.get(inputVal - 1).Menu(studentGradeInfoDTO, inputInt, inputStr);
		
		}

	}
}
