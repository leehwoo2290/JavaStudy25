package FSM;

public class VendingMachine extends Actor {

	public VendingMachine() {
		ActorType = "VendingMachine";
		stateMachine = new StateMachine(this, new Test_2State());
	}
}
