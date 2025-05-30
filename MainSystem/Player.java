package MainSystem;
import java.util.Scanner;

public class Player {
	
	boolean CheckPlayerInbutCorrect(int[] _playerInput) {
		return false;
	}
	
	int[] ExecutePlayerTurn(){
		
		//0 -> Y 1 -> X
		int[] playerInput = new int[2];
		
		int playerInput_Y = 0;
		int playerInput_X = 0;	
		
		Scanner sc = new Scanner(System.in);
		System.out.print("확인하고 싶은 X 축을 입력하시오: ");
		playerInput_X = sc.nextInt();
		playerInput[1] = playerInput_X;
		
		System.out.print("확인하고 싶은 Y 축을 입력하시오: ");
		playerInput_Y = sc.nextInt();		
		playerInput[0] = playerInput_Y;
		
		return playerInput;
	}
}