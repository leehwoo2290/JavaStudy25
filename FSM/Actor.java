package FSM;

public class Actor {

	protected StateMachine stateMachine = null;
	
	public String ActorType = null;
	
	public StateMachine GetStateMachine() {
		
		return stateMachine;
	}
	
	public void update() {
		
		if(stateMachine == null) {
			
			System.err.println("NullException!! stateMachine = null");
			return;
		}
		stateMachine.update();
	}
}
