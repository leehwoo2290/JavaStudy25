package MainSystem;

public class MainSystem { 
	
	 static boolean bGameExit = false;	
	 
	 public static void main(String[] args) {
			
		DrawScene drawScene = new DrawScene();
		Player player = new Player();
		
		drawScene.SettingGame();
		
		 while(!bGameExit){
			 
			 try { 			 	
				 	Thread.sleep(1);

				 	drawScene.ExecuteGame(player.ExecutePlayerTurn());				   				   
				  
		        } catch (InterruptedException e) {
		            System.err.println(e.getMessage());
		        }
		 }
		 
	 }

}
