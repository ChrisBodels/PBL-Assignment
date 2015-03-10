import java.util.Scanner;

public class Driver 
{
	private Scanner input;
	private Bank bank;
	
	
	public Driver() {
		
		
		bank = new Bank();

		
	}
	public static void main (String args[])
	{
		Driver app = new Driver();
	}
	
	private int mainMenu() {
		System.out.println("Welcome to The Stocks and Shares Game");
		System.out.println("-----------------");
		System.out.println("  	");
		System.out.println("  	");
		System.out.println(" ");
		System.out.println("What would you like to do?");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("  ");
		System.out.println("Start new game");
		System.out.println("Load Saved Game");
		System.out.println("  0) Exit");
		System.out.print("==>> ");
		int option = input.nextInt();
		return option;
	}
	private void runMenu()
	{
		int option = mainMenu();
		while (option != 0)
		{
		case 1:		newGame();
		break;
		case 2:		loadSavedGame();
		break;
		}
		System.out.println("/nPress any key to continue ");
	}

	public void addPlayer() {
		System.out.println("Please enter the amount of players");
		int playerAmount = input.nextInt();
		int counter = 0;
  
	if(playerAmount >3 && playerAmount <6 ){
	
     
		while (counter < playerAmount)
		{
			System.out.println("Please enter the first name");
			String name = input.next();
			bank.add(new Player(name));
			counter ++;
		}
		
	}else{
			System.out.println("Please enter a value between 3 and 6.");
		}
		     
	}
}
