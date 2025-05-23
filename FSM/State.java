package FSM;

public interface State {

	public abstract void Enter(Actor _actor);
	
	public abstract void Execute(Actor _actor);
	
	public abstract void Exit(Actor _actor);
}
