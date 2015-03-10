import java.util.Scanner;

public class Driver 
{
	public static void main (String args[])
	{
		Driver app = new Driver();
	}
	
	private int mainMenu() {
		System.out.println("");
		System.out.println("-----------------");
		System.out.println("  	");
		System.out.println(" ");
		System.out.println("  ");
		System.out.println("  ");
		System.out.println(" ");
		System.out.println("-----------------");
		System.out.println("  ");
		System.out.println(" ");
		System.out.println("-----------------");
		System.out.println("  ");
		System.out.println("  ");
		System.out.println("-----------------");
		System.out.println("  0) Exit");
		int option = input.nextInt();
		return option;
	}
	private void runMenu()
	{
		int option = mainMenu();
		while (option != 0)
		{
			case 1:		;
			break;
			case 2:		;
			break;
			case 3:		;
			break;
			case 4:		;
			break;
			case 5:		;
			break;
			case 6:		;
			break;
			case 7:		;
			break;
		}
		System.out.println("/nPress any key to continue ")
	}

	public void addPlayer() {
		System.out.println("Please enter the amount of players");
		int playerAmount = input.nextInt();
		int counter = 0;
  
      while (counter < playerAmount && playerAmount >3 && playerAmount <6 );
     {
		System.out.println("Please enter the first name");
		String name = input.next();
		players.addPlayer(new Player(name));
		
     } 
	}
}
