package mbcboard.dto;

import java.sql.Date;

public class BoardDTO {
	//게시판의 객체를 담당하고 게터/세터
	
	private int nbo;
	private String btitle;
	private String bcontent;      
	private String bwrite;
	private Date bdate;
	
	
	public int getNbo() {
		return nbo;
	}
	public void setNbo(int nbo) {
		this.nbo = nbo;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBwrite() {
		return bwrite;
	}
	public void setBwrite(String bwrite) {
		this.bwrite = bwrite;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
}
