package FSM;

public class StateMachine {
	
    private static StateMachine singleStateMachine = null;
		 
	private Actor ownerActor = null;
	
	private State prevState = null;
	private State curState = null;
	
	//생성자
	private StateMachine() {
			
	}
	
	   // getInstance()
    public static StateMachine getInstance() {
        if (singleStateMachine == null) {
        	singleStateMachine = new StateMachine();
        }
        
        return singleStateMachine;
    }

    public void initialSetting(Actor _actor, State _startState) {
    	
    	ownerActor = _actor;
		curState = _startState;
		curState.Enter(ownerActor);
    }
	
	public boolean checkStateMachineNullException(State _checkState) {
		
		if(curState == null) {
			
			System.err.println("NullException!! curState = null");
			return false;
		}
		
		if(ownerActor == null) {
			
			System.err.println("NullException!! ownerActor = null");
			return false;
		}
		return true;
	}
	
	public void chageState(Actor _newActor, State _newState) {
		
		if(!checkStateMachineNullException(_newState)) {
			
			return;
		}
		
		//State 변경
		curState.Exit(ownerActor);			//현 State 종료
		prevState = curState;
		
		curState = _newState;
		curState.Enter(ownerActor);			//바뀐 새로운 State 시작
	}
	
	public void update() {
		
		if(!checkStateMachineNullException(curState)) {
			
			return;
		}

		curState.Execute(ownerActor);
	}
}
