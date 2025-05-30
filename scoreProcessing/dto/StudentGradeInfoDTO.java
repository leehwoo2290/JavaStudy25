package scoreProcessing.dto;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class StudentGradeInfoDTO {

	private ArrayList<GradeDTO> gradeDTOs = new ArrayList<GradeDTO>();
	private ArrayList<StudentDTO> StudentDTOs = new ArrayList<StudentDTO>();
	
	private LinkedHashMap<StudentDTO, ArrayList<GradeDTO>> studentGradeInfo = 
			new LinkedHashMap<StudentDTO, ArrayList<GradeDTO>>();
	
	public StudentGradeInfoDTO() {
		
		
	}

	public LinkedHashMap<StudentDTO, ArrayList<GradeDTO>> getStudentGradeInfo() {
		return studentGradeInfo;
	}

	public void addStudentGradeInfo(StudentDTO studentDTO, ArrayList<GradeDTO> gradeDTOs) {
		
		studentGradeInfo.put(studentDTO, gradeDTOs);
	}
	
	public void deleteStudentGradeInfo(StudentDTO studentDTO, ArrayList<GradeDTO> gradeDTOs) {
		
		studentGradeInfo.put(studentDTO, gradeDTOs);
	}

	public ArrayList<GradeDTO> getGradeDTOs() {
		return gradeDTOs;
	}

	public void addGradeDTOs(GradeDTO gradeDTO) {
		gradeDTOs.add(gradeDTO);
	}

	public ArrayList<StudentDTO> getStudentDTOs() {
		return StudentDTOs;
	}

	public void addStudentDTOs(StudentDTO studentDTO) {
		StudentDTOs.add(studentDTO);
	}
}
