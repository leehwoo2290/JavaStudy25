package FSM;

public class Test_2State implements State {

	public void Enter(Actor _actor) {
		System.out.println(_actor.ActorType + " " + "Test_2State Enter");
	}
	
	public void Execute(Actor _actor) {
		System.out.println(_actor.ActorType + " " + "Test_2State Execute");
	}
	
	public void Exit(Actor _actor) {
		System.out.println(_actor.ActorType + " " + "Test_2State Exit");
	}
}
