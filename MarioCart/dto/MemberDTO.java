package MarioCart.dto;

public class MemberDTO {

	private String id  = null;
	private String pw  = null;
	private String nickName  = null;
	
	public MemberDTO(String id, String pw, String nickName) {
		
		this.id = id;
		this.pw = pw;
		this.nickName = nickName;
	}
	
	public final String getID() {
		
		return id;
	}
	
	public final String getPW() {
		
		return pw;
	}

	public final String getNickName() {
	
		return nickName;
	}
}
