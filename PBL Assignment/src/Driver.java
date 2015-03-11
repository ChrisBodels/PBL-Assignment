import java.util.Scanner;
import java.util.ArrayList;

public class Driver 
{
	private Scanner input;
	private Bank bank;
	private ArrayList<Player> players;
	
	
	public Driver() {
		bank = new Bank();
		input = new Scanner(System.in);
		runMenu();		
	}
	
	public static void main (String args[])
	{
		Driver app = new Driver();
		
	}
	
	private int mainMenu() {
		System.out.println(" ___________________________________________\n" + 
                "|                                           |\n" + 
                "|  Welcome to the Shares and Stocks!        |\n" +
                "|___________________________________________|\n");

		System.out.println("What would you like to do?");
		System.out.println("  1) Start game");
		System.out.println("  0) Exit");
		System.out.print("==>> ");
		int option = input.nextInt();
		return option;
	}



	private void runMenu() {
		int option = mainMenu();
		while (option != 0) {
			// clear the terminal window
			System.out.println("\f");

			switch (option) {
			case 1:
				addPlayer();
				break;
			case 2:
				//
				break;

			default:
				System.out.println("Invalid option entered: " + option);
				break;
			}

			
			System.out.println("\nPress any key to continue...");
			input.nextLine();
			input.nextLine(); 

			
			System.out.println("\f");
			option = mainMenu();
		}
		
		System.out.println("Exiting... bye");
		System.exit(0);

	}
	
	private int roundMenu()
	{
		System.out.println("");
		System.out.println("");
		System.out.println("");
		int option = input.nextInt();
		return option;
	}
	
	/*
	 * Basic version of the main round method which will be called at the start of the game and run until game is over
	 * Not sure on specifics yet, just doing it to get things working and working through things in my head.
	 * -Chris
	*/
	public void mainRound()
	{
		int roundNumber = 0;
		while(roundNumber < 12)
		{
			players = bank.getPlayers();
			for(Player currentPlayer : players)
			{
				int option = roundMenu();
				
				while(option != 0)
				{
					switch(option)
					{
						case 1:
							
						break;
						case 2:
						break;
					
					}
				}
			}
			roundNumber += 1;
		}
	}
	
	public void addPlayer() {
		System.out.println("Please enter the amount of players");
		int playerAmount = input.nextInt();
		int counter = 1;
  
	if(playerAmount >=3 && playerAmount <=6 ){
	
     
		while (counter <= playerAmount)
		{
			System.out.println("Please enter player number "  +counter+ "'s name");
			String name = input.next();
			bank.add(new Player(name));
			counter ++;
		}
		
	}else{
		
			System.out.println("Please enter a value between 3 and 6.");
		}
		     
	}
	
	/*
	 * The method that will be called whenever a player is buying or selling stocks
	 * Still not 100% finished or anything but it's a basic version at least
	 * -Chris
	 */
	public void changeStockAmount(String stockType, int value, Player currentPlayer)
	{
		if(stockType == "Motors")
		{
			currentPlayer.motorStocks += value;
			currentPlayer.balance += bank.getStockPrice("Motors");
		}
		else if(stockType == "Shipping")
		{
			currentPlayer.shippingStocks += value;
			currentPlayer.balance += bank.getStockPrice("Shiping");
		}
		else if(stockType == "Steel")
		{
			currentPlayer.steelStocks += value;
			currentPlayer.balance += bank.getStockPrice("Steel");
		}
		else if(stockType == "Stores")
		{
			currentPlayer.storesStocks += value;
			currentPlayer.balance += bank.getStockPrice("Stores");
		}
	}
	
	
	
		
		
}
