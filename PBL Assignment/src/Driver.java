import java.util.Scanner;
import java.util.ArrayList;
/**
 * This class displays a basic version of a menu for the game board game 'Stock and Shares'.
 * 
 * @author Chris, David, Patrick, Brian, Igor 
 */


public class Driver 
{
	private Scanner input;
	private Bank bank;
	private ArrayList<Player> players, highScore;
	private ArrayList<String> bankruptPlayers;
	
	/**
	 * This method starts the whole application
	 * @param args
	 * @throws Exception
	 */
	
	public Driver() throws Exception 
	{
		bank = new Bank();
		bankruptPlayers = new ArrayList<String>();
		input = new Scanner(System.in);
		runMenu();		
	}
	
	/**
	 *  This method shows the menu for the application, and shows the 
	 *  menu options for user. It also reads the options user has entered
 	 *  and returns it.
	 * @return		the users menu choice
 	 */
	public static void main (String args[]) throws Exception
	{
		Driver app = new Driver();
	}
	
	/**
	 * This is the starting menu for the driver. 
	 * @return
	 */
	private int mainMenu()
	{
		System.out.println(" ___________________________________________\n" + 
                "|                                           |\n" + 
                "|  Welcome to the Shares and Stocks!        |\n" +
                "|___________________________________________|\n");

		System.out.println("What would you like to do?");
		System.out.println("  1) Start game");
		System.out.println("  2) Previous game final score");
		System.out.println("  0) Exit");
		System.out.print("==>> ");
		
		boolean inputOk = false;
		int option = 0;
		do
		{
			try
			{
				option = input.nextInt();
				inputOk = true;	
			}
			catch(Exception e)
			{
				String throwOut = input.nextLine();
				System.out.println("Numbers expected - you entered text");
			}
		}while(!inputOk);
		return option;
	}

	/*
	 * This method controls the whole loop of options
 	 */
	private void runMenu() throws Exception 
	{
		int option = mainMenu();
		boolean inputOk = false;
		do
		{
			try
			{
				while (option != 0) 
				{
					System.out.println("\f");
					switch (option) 
					{
						case 1:
							addPlayer();
						break;
						case 2:		
							try
								{lastScore();}
							catch (Exception e)
							{System.out.println("Error reading from file: " + e);}
						break;

						default:
							System.out.println("Invalid option entered: " + option);
						break;
					}

					System.out.println("\nPress any key to continue...");
					input.nextLine();
					input.nextLine(); 

					System.out.println("\f"); //clear the terminal window
					option = mainMenu(); // this displays the main menu again
				}
				// option 0 was chosen, so the program is exiting
				System.out.println("Exiting... bye");
				System.exit(0);
				inputOk = true;
			}
			catch(Exception e)
			{
				String throwOut = input.nextLine();
				System.out.println("Numbers expected - you entered text");
			}
		}while(!inputOk);

	}
	/**
	 * Round menu, a 'sub' main menu, as to what you want to do in the game when the 
	 * players round comes.
	 * @return		the users menu choice.
	 */
	private int roundMenu()
	{
		System.out.println("  1) Buy shares");
		System.out.println("  2) Sell shares");
		System.out.println("  3) Check your current balance and stocks");
		System.out.println("  4) Check stock prices and available stocks");
		System.out.println("  5) Check your card for this round");
		System.out.println("  6) Take loan");
		System.out.println("  7) Repay loan (if currently on loan)");
		System.out.println("  8) Save Player Scores to leaderboard");
		System.out.println("  0) End turn");
	
		boolean inputOk = false;
		int option = 0;
		do
		{
			try
			{
				option = input.nextInt();
				inputOk = true;
				
			}
			catch(Exception e)
			{
				String throwOut = input.nextLine();
				System.out.println("Numbers expected - you entered text");
			}
		}while(!inputOk);
		return option;
	}
	
	/*
	 * Basic version of the main round method which will be called at the start of the game and run until game is over
	 * Not sure on specifics yet, just doing it to get things working and working through things in my head.
	 * -Chris
	*/
	public void mainRound() throws Exception 
	{
		int roundNumber = 1;
		while (roundNumber < 13) 
		{
			System.out.println("Now beginning round number " + roundNumber);
			players = bank.getPlayers();
			bank.generateCardIndex();
			
			for (Player currentPlayer : players) 
			{
				System.out.println(currentPlayer.getUserName() + "'s turn");
				if (currentPlayer.getLoanStatus() && currentPlayer.getBalance() >= 20)
				{
					currentPlayer.setBalanceDown(20);
					System.out.println("You currently have a loan so £20 was automatically withdrawn from your balance");
					System.out.println("Press any key to continue to your main round menu...");
					input.nextLine();
					input.nextLine();
				}
				else if(currentPlayer.getLoanStatus() && currentPlayer.getBalance() < 20 && currentPlayer.getTotalStocks() >= 1)
				{
					while(currentPlayer.getBalance() < 20 && currentPlayer.getTotalStocks() != 0)
					{
						System.out.println("You do not have enough in your current balance to pay your £20 loan fee for this turn. You will have to "
								+ "sell stocks in order to attempt to pay it.");
						displayPlayerStockInfo(currentPlayer);
						displayBankStockInfo();
						chooseStock("sell", currentPlayer);
					}
					if(currentPlayer.getBalance() >= 20)
					{
						System.out.println("Congratulations, you have succesfully sold enough stocks to pay your loan fee for this round."
								+ "\n £20 will be automatically removed from your balance");
						System.out.println("Press any key to continue to your main round menu...");
						input.nextLine();
						input.nextLine();
						currentPlayer.setBalanceDown(20);
					}
					else
					{
						System.out.println("Unfortunately you are bankrupt and have been eliminated from the game. Thanks for playing!");
						System.out.println("Press any key to continue...");
						input.nextLine();
						input.nextLine();
						removeBankruptPlayer(currentPlayer);
					}
				}
				else if(currentPlayer.getLoanStatus() && currentPlayer.getBalance() < 20 && currentPlayer.getTotalStocks() < 1)
				{
					System.out.println("Unfortunately you are bankrupt and have been eliminated from the game. Thanks for playing!");
					System.out.println("Press any key to continue...");
					input.nextLine();
					input.nextLine();
					removeBankruptPlayer(currentPlayer);
				}
				
				int option = -1;
				boolean inputOk = false;
				do
				{
					try
					{
						while (option != 0) 
						{
							System.out.println("\f");
							option = roundMenu();
							switch (option) 
							{
								case 1:
									chooseStock("buy", currentPlayer);
								break;
								case 2:
									chooseStock("sell", currentPlayer);
								break;
								case 3:
									displayPlayerStockInfo(currentPlayer);
								break;
								case 4:
									displayBankStockInfo();
								break;
								case 5:
									System.out.println(bank.generateCard(currentPlayer));
									System.out.println("\nPress any key to continue..");
									input.nextLine();
									input.nextLine();
								break;
								case 6:
									if(!currentPlayer.getLoanStatus())
									{
										System.out.println("Loan taken. Your balance has been increased by £80 and you will lose £20 per"
												+ " turn until you pay off a lump sum of £100 or go bankrupt.");
										System.out.println("Press any key to continue..");
										input.nextLine();
										input.nextLine();
										currentPlayer.setLoanStatus(true);
										currentPlayer.setBalanceUp(80);
									}
									else
									{
										System.out.println("You already have a loan. Repay current one before taking another!");
										System.out.println("Press any key to continue");
										input.nextLine();
										input.nextLine();
									}
								break;
								case 7:
									if(currentPlayer.getLoanStatus() && currentPlayer.getBalance() >= 100)
									{
										System.out.println("Loan successfully paid off!");
										System.out.println("Press any key to continue...");
										input.nextLine();
										input.nextLine();
										currentPlayer.setBalanceDown(100);
										currentPlayer.setLoanStatus(false);
									}
									else if(currentPlayer.getLoanStatus() && currentPlayer.getBalance() < 100)
									{
										System.out.println("You do not have sufficient funds to pay off your loan.");
										System.out.println("Press any key to continue...");
										input.nextLine();
										input.nextLine();
									}
									else
									{
										System.out.println("You are not currently on loan");
										System.out.println("Press any key to continue...");
										input.nextLine();
										input.nextLine();
									}
								break;
								case 8:
									try
									{
										bank.save();}
									catch (Exception e)
									{
										System.out.println("Error writing to file: " + e);
									}
								break; // new save with exception handling
							}
						}
						inputOk=true;
					}
					catch(Exception e)
					{
						String throwOut = input.nextLine();
						System.out.println("Numbers expected - you entered text");
					}
				}while(!inputOk);
			}
			roundNumber++;
			setUpdatedStockValue();
		}
        System.out.println(finalResults()+ "\n" +getBankruptResults());
	}
	/**
	 * This method adds players to the game.
	 * @throws Exception
	 */
	public void addPlayer() throws Exception 
	{
		System.out.println("Please enter the amount of players");
		int playerAmount = input.nextInt();
		int counter = 1;
  
		if(playerAmount >=3 && playerAmount <=6 )
		{ 
			while (counter <= playerAmount)
			{
				boolean inputOk = false;
				do
				{
					try
					{
						System.out.println("Please enter player number "  +counter+ "'s name");
						String name = input.next();
						bank.add(new Player(name));
						counter ++;
						inputOk = true;
					}
					catch(Exception e)
					{
						String throwOut = input.nextLine();
						System.out.println("Text expected - you entered numbers");
					}
				}while(!inputOk);
			}	
		}
		else
		{	
			System.out.println("Please enter a value between 3 and 6.");
		}	  
		mainRound();
	}
	/**
	 * A menu for buying or selling the stocks.
	 * @param buyOrSell
	 * @return		the users menu choice.
	 */
	private int chooseStockMenu(String buyOrSell)
	{
		System.out.println("What type of stock would you like to " + buyOrSell + "?");
		System.out.println("  1) Motors");
		System.out.println("  2) Shipping");
		System.out.println("  3) Steel");
		System.out.println("  4) Stores");
		System.out.println("  0) Cancel");
		
		int option = 0;
		boolean inputOk = false;
		do
		{
			try
			{
				option = input.nextInt();
				inputOk = true;
			}
			catch(Exception e)
			{
				String throwOut = input.nextLine();
				System.out.println("Numbers expected - you entered text");
			}
		}while(!inputOk);
		return option;
	}
	
	/*
	 * Think we're going to need a lot of validation for this stuff like checking whether or not the player/bank has
	 * the appropriate stocks/funds to carry out the action.
	 * -Chris
	 */
	
	public void chooseStock(String buyOrSell, Player currentPlayer)
	{
		if(buyOrSell == "buy")
		{
			int option = chooseStockMenu(buyOrSell);
			String stockType = "";
			while(option < 0 || option > 4 )
			{
				System.out.println("Invalid option entered. Please enter a valid option between 1 and 4");
				option = chooseStockMenu(buyOrSell);
			}
			if(option != 0)
			{
				switch(option)
				{
					case 1: 
						stockType = "Motors";
					break;
					case 2:
						stockType = "Shipping";
					break;
					case 3:
						stockType = "Steel";
					break;
					case 4:
						stockType = "Stores";
					break;
				}
				chooseAmount(stockType, buyOrSell, currentPlayer);
			}
		}
		else if(buyOrSell == "sell")
		{
			int option = chooseStockMenu(buyOrSell);
			String stockType = "";
			while(option < 0 || option > 4 )
			{
				System.out.println("Invalid option entered. Please enter a valid option between 1 and 4");
				option = chooseStockMenu(buyOrSell);
			}
			if(option != 0)
			{
				switch(option)
				{
					case 1: 
						stockType = "Motors";
					break;
					case 2:
						stockType = "Shipping";
					break;
					case 3:
						stockType = "Steel";
					break;
					case 4:
						stockType = "Stores";
					break;
				}
				chooseAmount(stockType, buyOrSell, currentPlayer);
			}
		}
		
	}
	/**
	 * This method allows the player to chose the amount of stock he/she wants to buy.
	 * @param stockType
	 * @param buyOrSell
	 * @param currentPlayer
	 */
	private int chooseAmountMenu(String buyOrSell)
	{
		//May want to add a 0 option here to allow the user to back out, we'll see.
		System.out.println("How many stocks would you like to " + buyOrSell + "?");
		System.out.println("  1) One stock");
		System.out.println("  2) Two stocks");
		System.out.println("  3) Three stocks");
		System.out.println("  4) Four stocks");
		System.out.println("  5) Five stocks");
		System.out.println("  6) Ten stocks");
		System.out.println("  7) Fifteen stocks");
		System.out.println("  8) Twenty stocks");
		System.out.println("  9) Twenty-Five stocks");
		
		int option = 0;
		boolean inputOk = false;
		do
		{
			try
			{
				option = input.nextInt();
				inputOk = true;
			}
			catch(Exception e)
			{
				String throwOut = input.nextLine();
				System.out.println("Numbers expected - you entered text");
			}
		}while(!inputOk);
		return option;
		
	}
	/**
	 * This method shows the amount of stocks that are avalible and to buy and sell stocks.
	 * @param stockType
	 * @param buyOrSell
	 * @param currentPlayer
	 */
	public void chooseAmount(String stockType, String buyOrSell, Player currentPlayer)
	{
		int option = chooseAmountMenu(buyOrSell);
		while(option != 0)
		{
		while(option < 1 || option > 9)
		{
			System.out.println("Invalid option entered. Please enter a valid option between 1 and 9");
			option = chooseAmountMenu(buyOrSell);
		}
		if(buyOrSell == "buy")
		{
			switch(option)
			{
				case 1:
					if(bank.getStockAmount(stockType) >= 1 && currentPlayer.getBalance() >= bank.getStockPrice(stockType))
					{
						buyStock(stockType, 1, currentPlayer);
					}
					else
					{
						menuCall(buyOrSell);
					}
				break;
				case 2:
					if(bank.getStockAmount(stockType) >= 2 && currentPlayer.getBalance() >= bank.getStockPrice(stockType)*2)
					{
						buyStock(stockType, 2, currentPlayer);
					}
					else
					{
						menuCall(buyOrSell);
					}
				break;
				case 3:
					if(bank.getStockAmount(stockType) >= 3 && currentPlayer.getBalance() >= bank.getStockPrice(stockType)*3)
					{
						buyStock(stockType, 3, currentPlayer);
					}
					else
					{
						menuCall(buyOrSell);
					}
				break;
				case 4:
					if(bank.getStockAmount(stockType) >= 4 && currentPlayer.getBalance() >= bank.getStockPrice(stockType)*4)
					{
						buyStock(stockType, 4, currentPlayer);
					}
					else
					{
						menuCall(buyOrSell);
					}
				break;
				case 5:
					if(bank.getStockAmount(stockType) >= 5 && currentPlayer.getBalance() >= bank.getStockPrice(stockType)*5)
					{
						buyStock(stockType, 5, currentPlayer);
					}
					else
					{
						menuCall(buyOrSell);
					}
				break;
				case 6:
					if(bank.getStockAmount(stockType) >= 10 && currentPlayer.getBalance() >= bank.getStockPrice(stockType)*10)
					{
						buyStock(stockType, 10, currentPlayer);
					}
					else
					{
						menuCall(buyOrSell);
					}
				break;
				case 7:
					if(bank.getStockAmount(stockType) >= 15 && currentPlayer.getBalance() >= bank.getStockPrice(stockType)*15)
					{
						buyStock(stockType, 15, currentPlayer);
					}
					else
					{
						menuCall(buyOrSell);
					}
				break;
				case 8:
					if(bank.getStockAmount(stockType) >= 20 && currentPlayer.getBalance() >= bank.getStockPrice(stockType)*20)
					{
						buyStock(stockType, 20, currentPlayer);
					}
					else
					{
						menuCall(buyOrSell);
					}
				break;
				case 9:
					if(bank.getStockAmount(stockType) >= 25 && currentPlayer.getBalance() >= bank.getStockPrice(stockType)*25)
					{
						buyStock(stockType, 25, currentPlayer);
					}
					else
					{
						menuCall(buyOrSell);
					}
				break;
			}
		}
		else if(buyOrSell == "sell")
		{
			switch(option)
			{
				case 1:
					if(currentPlayer.getStocks(stockType) >= 1)
					{
						sellStock(stockType, 1, currentPlayer);
					}
					else
					{
						menuCall(buyOrSell);
					}
				break;
				case 2:
					if(currentPlayer.getStocks(stockType) >= 2)
					{
						sellStock(stockType, 2, currentPlayer);
					}
					else
					{
						menuCall(buyOrSell);
					}
				break;
				case 3:
					if(currentPlayer.getStocks(stockType) >= 3)
					{
						sellStock(stockType, 3, currentPlayer);
					}
					else
					{
						menuCall(buyOrSell);
					}
				break;
				case 4:
					if(currentPlayer.getStocks(stockType) >= 4)
					{
						sellStock(stockType, 4, currentPlayer);
					}
					else
					{
						menuCall(buyOrSell);
					}
				break;
				case 5:
					if(currentPlayer.getStocks(stockType) >= 5)
					{
						sellStock(stockType, 5, currentPlayer);
					}
					else
					{
						menuCall(buyOrSell);
					}
				break;
				case 6:
					if(currentPlayer.getStocks(stockType) >= 10)
					{
						sellStock(stockType, 10, currentPlayer);
					}
					else
					{
						menuCall(buyOrSell);
					}
				break;
				case 7:
					if(currentPlayer.getStocks(stockType) >= 15)
					{
						sellStock(stockType, 15, currentPlayer);
					}
					else
					{
						menuCall(buyOrSell);
					}
				break;
				case 8:
					if(currentPlayer.getStocks(stockType) >= 20)
					{
						sellStock(stockType, 20, currentPlayer);
					}
					else
					{
						menuCall(buyOrSell);
					}
				break;
				case 9:
					if(currentPlayer.getStocks(stockType) >= 25)
					{
						sellStock(stockType, 25, currentPlayer);
					}
					else
					{
						menuCall(buyOrSell);
					}
				break;
			}
		}
	}
	}
	
	/*
	 * The method that will be called whenever a player is buying stocks
	 * Still not 100% finished or anything but it's a basic version at least
	 * Need to add a way to remove stocks from the bank still
	 * No validation yet either
	 * -Chris
	 */
	 /**
	 * This method allows the user/players to buy stock.
	 * @param stockType
	 * @param amount
	 * @param currentPlayer
	 */
	public void buyStock(String stockType, int amount, Player currentPlayer)
	{
		if(stockType == "Motors")
		{
			bank.setStockAmount("Motors", -amount);
			currentPlayer.setStocksUp("Motors", amount);
			int counter = 0;
			while(counter < amount)
			{
				currentPlayer.setBalanceDown(bank.getStockPrice("Motors"));
				counter ++;
			}
		}
		else if(stockType == "Shipping")
		{
			bank.setStockAmount("Shipping", -amount);
			currentPlayer.setStocksUp("Shipping", amount);
			int counter = 0;
			while(counter < amount)
			{
				currentPlayer.setBalanceDown(bank.getStockPrice("Shipping"));
				counter ++;
			}
		}
		else if(stockType == "Steel")
		{
			bank.setStockAmount("Steel", -amount);
			currentPlayer.setStocksUp("Steel", amount);
			int counter = 0;
			while(counter < amount)
			{
				currentPlayer.setBalanceDown(bank.getStockPrice("Steel"));
				counter ++;
			}
		}
		else if(stockType == "Stores")
		{
			bank.setStockAmount("Stores", -amount);
			currentPlayer.setStocksUp("Stores", amount);
			int counter = 0;
			while(counter < amount)
			{
				currentPlayer.setBalanceDown(bank.getStockPrice("Stores"));
				counter ++;
			}
		}
	}
	
	/*
	 * The method that will be called whenever a player is selling stocks
	 * Still not 100% finished or anything but it's a basic version at least
	 * Need to add a way to add stocks back to the bank still
	 * No validation yet either 
	 * -Chris
	 */
	 /**
	 * This method allows the players to sell their Stocks.
	 * @param stockType
	 * @param amount
	 * @param currentPlayer
	 */
	public void sellStock(String stockType, int amount, Player currentPlayer)
	{
		if(stockType == "Motors")
		{
			bank.setStockAmount("Motors", amount);
			currentPlayer.setStocksDown("Motors", amount);
			int counter = 0;
			while(counter < amount)
			{
				currentPlayer.setBalanceUp(bank.getStockPrice("Motors"));
				counter ++;
			}
		}
		else if(stockType == "Shipping")
		{
			bank.setStockAmount("Shipping", amount);
			currentPlayer.setStocksDown("Shipping", amount);
			int counter = 0;
			while(counter < amount)
			{
				currentPlayer.setBalanceUp(bank.getStockPrice("Shipping"));
				counter ++;
			}
		}
		else if(stockType == "Steel")
		{
			bank.setStockAmount("Steel", amount);
			currentPlayer.setStocksDown("Steel", amount);
			int counter = 0;
			while(counter < amount)
			{
				currentPlayer.setBalanceUp(bank.getStockPrice("Steel"));
				counter ++;
			}
		}
		else if(stockType == "Stores")
		{
			bank.setStockAmount("Stores", amount);
			currentPlayer.setStocksDown("Stores", amount);
			int counter = 0;
			while(counter < amount)
			{
				currentPlayer.setBalanceUp(bank.getStockPrice("Stores"));
				counter ++;
			}
		}
	}
	/**
	 * This method allows the user to load the scores from previous game.
	 * @throws Exception
	 */
	public void lastScore() throws Exception
	{
		bank.load();
		
		highScore = new ArrayList<Player>();
	
		for(int i=0; i<players.size() ; i++)
		{
			if(highScore.size() == 0 || players.get(i).getBalance() > highScore.get(0).getBalance() )
			{
				highScore.add(0, players.get(i));
			}
			else if(players.get(i).getBalance() > highScore.get(1).getBalance())
			{
				highScore.add(1, players.get(i));
			}
			else if(players.get(i).getBalance() > highScore.get(2).getBalance())
			{
				highScore.add(2, players.get(i));
			}
			else if(players.get(i).getBalance() > highScore.get(3).getBalance())
			{
				highScore.add(3, players.get(i));
			}
			else if(players.get(i).getBalance() > highScore.get(4).getBalance())
			{
				highScore.add(4, players.get(i));
			}
			else
			{
				highScore.add(5, players.get(i));
			}
		}
		System.out.println("Here are the end scores of the last game: ");
		System.out.println("--------------------------------------------");
		System.out.println("Postion: Name:	Money");
		System.out.println("1		" + highScore.get(0).getUserName() +"	 " + highScore.get(0).getBalance() );
		System.out.println("2		" + highScore.get(1).getUserName() +"	 " + highScore.get(0).getBalance());
		System.out.println("3		" + highScore.get(2).getUserName() +"	 " + highScore.get(0).getBalance());
		System.out.println("4		" + highScore.get(3).getUserName() +"	 " + highScore.get(0).getBalance());
		System.out.println("5		" + highScore.get(4).getUserName() +"	 " + highScore.get(0).getBalance());
		System.out.println("6		" + highScore.get(5).getUserName() +"	 " + highScore.get(0).getBalance());
		System.out.println("");
		System.out.println("/nPress any key to continue...");
		
		input.nextLine();
		input.nextLine(); 

		
		System.out.println("\f");//clears the terminal window
		players.clear();
		runMenu();
	}
	/**
	 * This method removes a player that goes bankrupt.
	 * @param currentPlayer
	 */
	public void removeBankruptPlayer(Player currentPlayer) 
	{
			String userName = currentPlayer.getUserName();
			bankruptPlayers.add(userName);
			players.remove(currentPlayer);
	}

	public String getBankruptResults() 
	{
		String str = "";
		if (bankruptPlayers.size() > 0) 
		{
			for (int i = 0; i <= bankruptPlayers.size(); i++)
			str += (bankruptPlayers.get(i) + " was kicked from the game as they were bankrupt." + "\n");
			return str;
		} 
		else 
		{
			str += ("No one finished the game bankrupt.");
			return str;
		}
	}
	/**
	 * This method shows the final results of players for this game.
	 * @return
	 */
	public String finalResults() {

		String str = "";
		if (players.size() > 0) 
		{
			for (Player currentPlayer : players)
			{
				str += (currentPlayer.getUserName()
						+ " ended the game with a balance of £" + currentPlayer
						.getBalance())+ ".\n";
			}
			return str;
		} 
		else 
		{
			str += ("No one finished the game.");
			return str;
		}

	}
	
	/**
	 * This method updates the stock value in the bank in accordance
	 * with the value of the cards drawn from the deck.
	 *
	 */
	public void setUpdatedStockValue() 
	{
		int motorsNew = 0;
		int shippingNew = 0;
		int steelNew = 0;
		int storesNew = 0;

		for (Player currentPlayer : players) 
		{
			if (bank.getStockType(currentPlayer) == "Motors") 
			{
				motorsNew += bank.cardValue(currentPlayer);
			} 
			else if (bank.getStockType(currentPlayer) == "Shipping") 
			{
				shippingNew += bank.cardValue(currentPlayer);
			} 
			else if (bank.getStockType(currentPlayer) == "Steel")
			{
				steelNew += bank.cardValue(currentPlayer);
			} 
			else if (bank.getStockType(currentPlayer) == "Bull") 
			{
				motorsNew += 4;
				shippingNew += 4;
				steelNew += 4;
				storesNew += 4;
			} 
			else if (bank.getStockType(currentPlayer) == "Stores") 
			{
				storesNew += bank.cardValue(currentPlayer);
			} 
			else if (bank.getStockType(currentPlayer) == "Bear") 
			{
				motorsNew -= 4;
				shippingNew -= 4;
				steelNew -= 4;
				storesNew -= 4;
			}
		}
		bank.setStockValue("Motors", motorsNew);
		bank.setStockValue("Steel", steelNew);
		bank.setStockValue("Shipping", shippingNew);
		bank.setStockValue("Stores", storesNew);
	}
	
	public void menuCall(String buyOrSell)
	{
		if(buyOrSell == "buy")
		{
			System.out.println("Not enough of the chosen stock type currently in bank or not enough funds. Purchase cancelled");
			System.out.println("Press any key to continue...");
			input.nextLine();
			input.nextLine();
		}
		else
		{
			System.out.println("Not enough of the chosen stock type currently owned. Selling cancelled");
			System.out.println("Press any key to continue...");
			input.nextLine();
			input.nextLine();
		}
	}
	
	public void displayPlayerStockInfo(Player currentPlayer)
	{
		System.out.println("\nYour current balance is £"
				+ currentPlayer.getBalance());
		System.out.println("\nYour current Motors stock: "
				+ currentPlayer.getStocks("Motors"));
		System.out.println("Your current Shipping stock: "
				+ currentPlayer.getStocks("Shipping"));
		System.out.println("Your current Steel stock: "
				+ currentPlayer.getStocks("Steel"));
		System.out.println("Your current Stores stock: "
				+ currentPlayer.getStocks("Stores"));
		System.out.println("\nPress any key to continue...");
		input.nextLine();
		input.nextLine();
	}
	
	public void displayBankStockInfo()
	{
		System.out.println("\nMotors current stock price: £"
				+ bank.getStockPrice("Motors"));
		System.out.println("Shipping current stock price: £"
				+ bank.getStockPrice("Shipping"));
		System.out.println("Steel current stock price: £"
				+ bank.getStockPrice("Steel"));
		System.out.println("Stores current stock price: £"
				+ bank.getStockPrice("Stores"));
		System.out.println("\nMotors current stock amount: "
				+ bank.getStockAmount("Motors"));
		System.out.println("Shipping current stock amount: "
				+ bank.getStockAmount("Shipping"));
		System.out.println("Steel current stock amount: "
				+ bank.getStockAmount("Steel"));
		System.out.println("Stores current stock amount: "
				+ bank.getStockAmount("Stores"));
		System.out.println("\nPress any key to continue...");
		input.nextLine();
		input.nextLine();
	}
	
 	
}
