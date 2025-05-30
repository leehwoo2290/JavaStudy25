package scoreProcessing.dto;

public class GradeDTO {

	private String subjectName;	
	private int score;
	
	public GradeDTO(String subjectName) {
		
		this.subjectName = subjectName;
		//추가 될때 디폴트값
		this.score = -1;
	}
	
	public GradeDTO(String subjectName, int score) {
		
		this.subjectName = subjectName;
	
		this.score = score;
	}


	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
}
