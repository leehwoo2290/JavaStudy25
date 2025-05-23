package FSM;

public class MainSystem {

	public static void main(String[] args) {
		
		//StateMachine stateMacine = new StateMachine(new Test_1State());
		
		Actor account = new AdminAccount("leelee", "1234", "admin");
		Actor vendingMachine = new VendingMachine();

		//account.printAccountInfo();
		account.update();
		vendingMachine.update();
		account.update();
		vendingMachine.update();
		account.update();
		vendingMachine.update();
		
	}

}
