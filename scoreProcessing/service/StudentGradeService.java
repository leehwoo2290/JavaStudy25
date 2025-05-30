package scoreProcessing.service;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map.Entry;

import scoreProcessing.dto.*;

public class StudentGradeService extends Service{
	
	public StudentGradeService() {
		
		
	}
	
	public void Menu(StudentGradeInfoDTO studentGradeInfoDTO,Scanner inputInt, Scanner inputStr) {
		
		System.out.println("1. 학생 별 성적 입력 || 2.  || 3. ");
		System.out.print("입력 >>");
		
		String inputVal = inputStr.next();
		
		switch (inputVal) {
		case "1": 
			update(studentGradeInfoDTO, inputInt);
			break;
		default:
			System.out.println("올바른 값을 입력해주세요.");
		}
	}

	private void update(StudentGradeInfoDTO studentGradeInfoDTO, Scanner inputInt) {
		
		int i = 0;
		for(var studentDTO : studentGradeInfoDTO.getStudentDTOs()) {
			
			if(studentDTO == null) {
				
				continue;
			}
			System.out.println(studentDTO.getStudentName() + " 학생의 점수 입력");
			
			 
			ArrayList<GradeDTO> newStudentGrades = new ArrayList<GradeDTO>();
			
			
			for(var gradeDTO : studentGradeInfoDTO.getGradeDTOs()) {
				
				System.out.print(gradeDTO.getSubjectName() + "과목 점수 입력 >>");
				
				int inputVal = inputInt.nextInt();
				
				GradeDTO newGradeDTO = new GradeDTO(gradeDTO.getSubjectName(), inputVal);
				
				newStudentGrades.add(newGradeDTO);
			}			

			studentGradeInfoDTO.addStudentGradeInfo(studentDTO, newStudentGrades);
		}		
	}
}
