package MainSystem;
import java.util.Scanner;
import java.util.Random;

public class DrawScene {

	public static final int DEFAULT_BOARDSIZE_VALUE = 7;
	public static final int MIN_BOARDSIZE_VALUE = 3;
	public static final int MAX_BOARDSIZE_VALUE = 100;
	
	private int boardSize = DEFAULT_BOARDSIZE_VALUE;
	private int bombCnt = 0;
	private int[][] map;
	
	public final int GetBoardSize() {
		return boardSize;
	}
	
	void SettingGame(){				
		
		Scanner sc = new Scanner(System.in);
		System.out.print("N * N 만큼 게임보드을 세팅한다.\n N의 값을 입력하라: ");
		boardSize = sc.nextInt();
		
		if(boardSize < MIN_BOARDSIZE_VALUE){
			
			boardSize = MIN_BOARDSIZE_VALUE;
			System.out.println("게임보드 최소 크기 미달로 인한 N값 강제조정 N = " + boardSize);		
		}
		else if(boardSize > MAX_BOARDSIZE_VALUE) {
			
			boardSize = MAX_BOARDSIZE_VALUE;
			System.out.println("게임보드 최대 크기 초과로 인한 N값 강제조정 N = " + boardSize);	
		}
		
		map = new int[boardSize][boardSize];
				
		System.out.print("N만큼 폭탄을 세팅한다.\n N의 값을 입력하라: ");
		bombCnt = sc.nextInt();	
		
		if(bombCnt < 1)	{
			
			bombCnt = 1;
			System.out.println("폭탄의 최소값 미달로 인한 N값 강제조정 N = " + bombCnt);	
		}
		else if(bombCnt > boardSize * boardSize - MIN_BOARDSIZE_VALUE){
			
			bombCnt = boardSize * boardSize - MIN_BOARDSIZE_VALUE - 1;
			System.out.println("폭탄의 최댓값 초과로 인한 N값 강제조정 N = " + bombCnt);		
		}
		

		SettingBomb(bombCnt);
	}
	
	void SettingBomb(int _bombCnt){
		
		Random random = new Random();
		
		for(int i = 0; i < _bombCnt; i++){

			int randomBomb_X = random.nextInt(boardSize - 1);
			int randomBomb_Y = random.nextInt(boardSize - 1);
			
			if(map[randomBomb_Y][randomBomb_X] != 1) {
				
				map[randomBomb_Y][randomBomb_X] = 1;
			}
			else{
				
				i--;
			}
		}
	}
	
	void CheckBombFromPlayerInput(int[] _playerInput) {
		

	}
	
	void ExecuteGame(int[] _playerInput){
		
		for(int j = 0; j < map.length; j++){
			System.out.print("\n\n");
		}	
		
		
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				System.out.print(map[i][j] + " ");
			}	
			System.out.print("\n\n");
		}	
		
	}

}