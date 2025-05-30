package scoreProcessing.service;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Scanner;

import scoreProcessing.dto.GradeDTO;
import scoreProcessing.dto.StudentDTO;
import scoreProcessing.dto.StudentGradeInfoDTO;

public class PrintInfoService extends Service{

	public PrintInfoService() {
		
		
	}
	
	public void Menu(StudentGradeInfoDTO studentGradeInfoDTO,Scanner inputInt, Scanner inputStr) {
		
		System.out.println("1. 점수 출력 || 2.  || 3. ");
		System.out.print("입력 >>");
		
		String inputVal = inputStr.next();
		
		switch (inputVal) {
		case "1": 
			print(studentGradeInfoDTO);
			break;
		default:
			System.out.println("올바른 값을 입력해주세요.");
		}
	}
	
	private void print(StudentGradeInfoDTO studentGradeInfoDTO) {

		for(Entry<StudentDTO, ArrayList<GradeDTO>> entryList : studentGradeInfoDTO.getStudentGradeInfo().entrySet()) {
			
			System.out.println(entryList.getKey().getStudentName() + "학생의 점수 \n");		
			
			for(int i = 0; i < entryList.getValue().size(); i++) {
		   		
				System.out.println(entryList.getValue().get(i).getSubjectName() + ": " + entryList.getValue().get(i).getScore()  + "점");
			}
		}		
		
	}
}
