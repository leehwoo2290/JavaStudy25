package FSM;

public class Test_1State implements State {

	public void Enter(Actor _actor) {
		System.out.println(_actor.ActorType + " " + "Test_1State Enter");
	}
	
	public void Execute(Actor _actor) {
		System.out.println(_actor.ActorType + " " + "Test_1State Execute");
		_actor.GetStateMachine().chageState(new Test_2State());
	}
	
	public void Exit(Actor _actor) {
		System.out.println(_actor.ActorType + " " + "Test_1State Exit");
	}
}
