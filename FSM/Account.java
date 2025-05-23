package FSM;

public class Account extends Actor {
	
	private String id = null;
	private String pw = null;
	
	protected String accountType = null;
	
	public Account(String _id, String _pw) {
		
		ActorType = "Account";
		id = _id;
		pw = _pw;		
	}
	
	public void printAccountInfo() {
		
		System.out.println(id + " " + pw + " " + accountType);
	}
}
