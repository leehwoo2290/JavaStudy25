package Ch02;

import java.util.Random;

public class InfiniteSpiralSwitchMaze {

	public static void main(String[] args) {
		
		Random random = new Random();
		
		boolean bLoopFlag = true;
		int maxRandomMazeVal = 2;
		double maxRandomVal = 100;
		double exitPercent = 0.1;
		double eventPercent = 0.5;
		int cnt = 0;
		
		System.out.println("무한 나선 미로 탐색시작");
		
		while(bLoopFlag) {
			
			cnt++;
			System.out.print(cnt + "번째 탐색중");
			
			for(int i = 0; i < 3; i++) {
				
				 try { 			 	
					 Thread.sleep(700);	
					 
					 System.out.print(".");
						
						if(i == 2) {
							System.out.print("\n");			
						}
					  
			        } catch (InterruptedException e) {
			            System.err.println(e.getMessage());
			        }
							
			}
			
			System.out.println("----------------------\n");
			
			//0~1 랜덤
			int randomMazeVal = random.nextInt(maxRandomMazeVal);
			
			switch (randomMazeVal) {
			case 0: {
				System.out.println("무한 나선 미로 탐색 재시작");
				break;
			}
			case 1: {
			
				//0~99 랜덤
				double randomRoomVal =  random.nextDouble(maxRandomVal);
				randomRoomVal = Math.round(randomRoomVal * 10) / 10.0;
				
				System.out.println("탈출 확률의 방 시작 \n(탈출 확률: " +  exitPercent + " %)");			
				System.out.println("탈출 랜덤 값: " + randomRoomVal + "( 0 ~ " + Math.round(exitPercent * 10) / 10.0 + " )시 탈출\n");
				
				if(randomRoomVal <= exitPercent) {
					
					System.out.println("무한 나선 미로 탈출 성공");
					bLoopFlag = false;
				}
				else {
					
					//0~99 랜덤
					double randomEventVal = random.nextDouble(maxRandomVal);
					randomEventVal = Math.round(randomEventVal * 10) / 10.0; 
				
					System.out.println("(이벤트 확률: " +  eventPercent + " %)" );
					System.out.println("이벤트 랜덤 값: " + randomEventVal + "( 0 ~ " + eventPercent * 10 + " )시 탈출\n");
					
					if(randomEventVal <= eventPercent) {
						
						System.out.println("무한 나선 미로 탈출 확률 증가 이벤트 발동");
						double randomPlusVal = random.nextDouble(2) + 1;
						randomPlusVal = Math.round(randomPlusVal * 10) / 10.0;
						
						exitPercent = Math.min(100, exitPercent + randomPlusVal) ; // 100 못넘어가게
						exitPercent = Math.round(exitPercent * 10) / 10.0;
						eventPercent = Math.min(100, Math.max(exitPercent * 2, eventPercent)) ; // 100 못넘어가게
						eventPercent = Math.round(eventPercent * 10) / 10.0;
					}
					else {
						
						System.out.println("무한 나선 미로 탈출 실패");
					}
						
				}
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + randomMazeVal);
			}
			
			System.out.println("----------------------\n");
		}
		
	}

}