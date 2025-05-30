package scoreProcessing.service;

import java.util.Scanner;

import scoreProcessing.dto.*;

public class SubjectsModifyService extends Service {

	public SubjectsModifyService() {
		
		
	}
	
	public void Menu(StudentGradeInfoDTO studentGradeInfoDTO,Scanner inputInt, Scanner inputStr) {
				
		System.out.println("1. 과목 추가 || 2. 과목 삭제 || 3. ");
		System.out.print("입력 >>");
		
		String inputVal = inputStr.next();
		
		switch (inputVal) {
		case "1": 
			create(studentGradeInfoDTO, inputStr);
			break;
			
		case "2":
			delete();
			break;
		default:
			System.out.println("올바른 값을 입력해주세요.");
		}
	}

	private void create(StudentGradeInfoDTO studentGradeInfoDTO,Scanner inputStr) {
		
		System.out.print("과목 이름 입력 >>");
		String inputVal = inputStr.next();
		
		GradeDTO gradeDTO = new GradeDTO(inputVal);
		
		studentGradeInfoDTO.addGradeDTOs(gradeDTO);	
		
	}
}
