package scoreProcessing.dto;

public class StudentDTO {

	private String studentName;	
	private String studentNumber;
	private String schoolName; 
	
	public StudentDTO(String studentName, String studentNumber, String schoolName) {
		
		this.studentName = studentName;
		this.studentNumber = studentNumber;
		this.schoolName = schoolName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
}
