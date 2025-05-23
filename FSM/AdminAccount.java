package FSM;

public class AdminAccount extends Account {

	public AdminAccount(String _id, String _pw, String _accountType) {
		
		super(_id, _pw);
		accountType = _accountType;
		stateMachine = new StateMachine(this, new Test_1State());
	}
}
