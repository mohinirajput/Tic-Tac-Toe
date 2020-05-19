import java.util.Scanner;
import java.util.Random;
public class TicTacToe {
	
	static int count = 0;
	
	public static void printGame(char[][] gameStructure) 
	{
		for(char[] row : gameStructure){
			for(char g : row){
				System.out.print(g);
			}
			System.out.println();
		}
		
		if(count==9)
		{
			System.out.println("Match drawn !!!");
			System.exit(0);
		}
	}
	
	public static boolean placePos(char[][] gameStructure, int pos ,String user) {
		count++;
		
		char symbol = ' ';
		if(user.equals("player"))
			symbol = 'X';
		else
			symbol = 'O';
		switch(pos) {
		case 1:if(gameStructure[0][0]==' ')
					gameStructure[0][0]=symbol;
				else{
					count--;
					if(symbol=='X')
					System.out.println("Sorry!! this place is occupied");
					return false;
				}
				break;
		case 2:if(gameStructure[0][2]==' ')
					gameStructure[0][2]=symbol;
				else {
					count--;
					if(symbol=='X')
					System.out.println("Sorry!! this place is occupied");
					return false;
				}
				break;
		case 3:if(gameStructure[0][4]==' ')
					gameStructure[0][4]=symbol;
				else {
					count--;
					if(symbol=='X')
						System.out.println("Sorry!! this place is occupied");
						return false;
				}
				break;
		case 4:if(gameStructure[2][0]==' ')
					gameStructure[2][0]=symbol;
				else {
					count--;
					if(symbol=='X')
					System.out.println("Sorry!! this place is occupied");
					return false;
				}
				break;
		case 5:if(gameStructure[2][2]==' ')
				gameStructure[2][2]=symbol;
				else {
					count--;
					if(symbol=='X')
					System.out.println("Sorry!! this place is occupied");
					return false;
				}
				break;
		case 6:if(gameStructure[2][4]==' ')
					gameStructure[2][4]=symbol;
				else {
					count--;
					if(symbol=='X')
					System.out.println("Sorry!! this place is occupied");
					return false;
		}
				break;
		case 7:if(gameStructure[4][0]==' ')
					gameStructure[4][0]=symbol;
				else {
					count--;
					if(symbol=='X')
					System.out.println("Sorry!! this place is occupied");
					return false;
				}
				break;
		case 8:if(gameStructure[4][2]==' ')
					gameStructure[4][2]=symbol;
				else{
					count--;
					if(symbol=='X')
					System.out.println("Sorry!! this place is occupied");
					return false;
				}
				break;
		case 9:if(gameStructure[4][4]==' ')
					gameStructure[4][4]=symbol;
				else{
					count--;
					if(symbol=='X')
					System.out.println("Sorry!! this place is occupied");
					return false;
				}
				break;
			default :System.out.println("You entered Invalid position");
					count--;
					return false;
		}
		return true;
	}
	
	public static boolean checkWinner(char[][] gameStructure) {
		for(int i = 0;i<=4;i=i+2) {
			if((gameStructure[i][0]=='X' && (gameStructure[i][2]=='X' && gameStructure[i][4]=='X')) || (gameStructure[0][i]=='X' && (gameStructure[2][i]=='X' && gameStructure[4][i]=='X')))
				{
					System.out.println("Congrats!! You Win The Game");
					return false;
				}
			else if((gameStructure[i][0]=='O' && (gameStructure[i][2]=='O' && gameStructure[i][4]=='O')) || (gameStructure[0][i]=='O' && (gameStructure[2][i]=='O' && gameStructure[4][i]=='O')) )
			{
				System.out.println("Oops!! You Lose The Game");
				return false;
			}
					
		}
		if(gameStructure[0][0]=='X' && (gameStructure[2][2]=='X' && gameStructure[4][4]=='X') || gameStructure[0][4]=='X' && (gameStructure[2][2]=='X' && gameStructure[4][0]=='X'))
		{
			System.out.println("Congrats!! You Win The Game");
			return false;
		}else if(gameStructure[0][0]=='O' && (gameStructure[2][2]=='O' && gameStructure[4][4]=='O') || gameStructure[0][4]=='X' && (gameStructure[2][2]=='X' && gameStructure[4][0]=='X'))
		{
			System.out.println("Sad, You Lose The Game");
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] gameStructure = {{' ','|',' ','|',' '},
								  {'-','+','-','+','-'},
								  {' ','|',' ','|',' '},
								  {'-','+','-','+','-'},
								  {' ','|',' ','|',' '}};
		printGame(gameStructure);
		boolean run = true , checkPlayer , checkCpu;
		while(run) {
			checkPlayer = true;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter position you want to enter");
			int playerPos = sc.nextInt();
			checkPlayer = placePos(gameStructure, playerPos, "player");
			if(checkPlayer)
			{
				run = checkWinner(gameStructure);
				if(run)
				{
					checkCpu = true;
					do{
						Random rand = new Random();
						int cpuPos = rand.nextInt(9) + 1;
						checkCpu = placePos(gameStructure, cpuPos, "cpu");
					}while(!checkCpu);
					run = checkWinner(gameStructure);
				}
				printGame(gameStructure);
			}
		}
	}

}
