import java.util.Scanner;

public class Driver 
{
	private Scanner input;
	private Bank bank;
	
	
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
	
	
	
		
		
}
