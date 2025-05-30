package scoreProcessing.service;

import java.util.Scanner;

import scoreProcessing.dto.*;

public class StudentModifyService extends Service {

	public StudentModifyService() {
		
		
	}
	
	public void Menu(StudentGradeInfoDTO studentGradeInfoDTO,Scanner inputInt, Scanner inputStr) {
		
		System.out.println("1. 학생 추가 || 2.  || 3. ");
		System.out.print("입력 >>");
		
		String inputVal = inputStr.next();
		
		switch (inputVal) {
		case "1": 
			create(studentGradeInfoDTO, inputStr);
			break;
		default:
			System.out.println("올바른 값을 입력해주세요.");
		}
	}

	private void create(StudentGradeInfoDTO studentGradeInfoDTO,Scanner inputStr) {
		
		System.out.print("학생 이름 입력 >>");
		String inputStudentName = inputStr.next();
		
		System.out.print("학생 학번 입력 >>");
		String inputStudentNumber = inputStr.next();
		
		System.out.print("학교 명 입력 >>");
		String inputStudentSchoolName = inputStr.next();
		
		StudentDTO studentDTO = new StudentDTO(inputStudentName, inputStudentNumber, inputStudentSchoolName);
		
		studentGradeInfoDTO.addStudentDTOs(studentDTO);
		
	}
}
