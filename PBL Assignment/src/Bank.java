import java.util.ArrayList;
import java.util.Random;
/**
 * In this class, most of the calculations are done which are crucial.
 * 
 * @author Chris, David, Patrick, Brian, Igor 
 */
public class Bank {
	
	private Card card0, card1, card2, card3, card4, card5, card6, card7, card8, card9, card10,
				 card11, card12, card13, card14, card15, card16, card17, card18, card19, card20,
				 card21, card22, card23, card24, card25;
				 
	private Stock motors, shipping, steel, stores;
	
	private ArrayList<Player> players;
	private ArrayList<Card> cards;
	private ArrayList<Integer> randomNumber;
	private Random randomGenerator;
	private ArrayList<Player> bankruptPlayers, highScore;//new for skip turn - Paddy
	
	
	/**
	 * Constructor for the objects of class Card.
	 */
	public Bank()
	{
	
		motors = new Stock("Motors");
		shipping = new Stock("Shipping");
		steel = new Stock("Steel");
		stores = new Stock("Stores");
		
		players = new ArrayList<Player>();
		cards =  new ArrayList<Card>();
		randomNumber = new ArrayList<Integer>();
		bankruptPlayers = new ArrayList<Player>();// new for skip turn - Paddy
		highScore = new ArrayList<Player>();//moved to bank from driver - Paddy
		randomGenerator = new Random();
		
		initialiseCards();
	
	}
	
	public ArrayList<Player> getPlayers()
	{
		return players;
	}
	
	public void add (Player player)
	{
		players.add(player);
	}
	
	public void initialiseCards()//UPDATED!!!!
	{
		card0 = new Card("Motors", -4);
		cards.add(card0);
		cards.set(0, card0);

		card1 = new Card("Motors", -3);
		cards.add(card1);
		cards.set(1, card1);

		card2 = new Card("Motors", -2);
		cards.add(card2);
		cards.set(2, card2);

		card3 = new Card("Motors", 2);
		cards.add(card3);
		cards.set(3, card3);

		card4 = new Card("Motors", 3);
		cards.add(card4);
		cards.set(4, card4);

		card5 = new Card("Motors", 4);
		cards.add(card5);
		cards.set(5, card5);

		card6 = new Card("Shipping", -4);
		cards.add(card6);
		cards.set(6, card6);

		card7 = new Card("Shipping", -3);
		cards.add(card7);
		cards.set(7, card7);

		card8 = new Card("Shipping", -2);
		cards.add(card8);
		cards.set(8, card8);

		card9 = new Card("Shipping", 2);
		cards.add(card9);
		cards.set(9, card9);

		card10 = new Card("Shipping", 3);
		cards.add(card10);
		cards.set(10, card10);

		card11 = new Card("Shipping", 4);
		cards.add(card11);
		cards.set(11, card11);

		card12 = new Card("Steel", -4);
		cards.add(card12);
		cards.set(12, card12);

		card13 = new Card("Steel", -3);
		cards.add(card13);
		cards.set(13, card13);

		card14 = new Card("Steel", -2);
		cards.add(card14);
		cards.set(14, card14);

		card15 = new Card("Steel", 2);
		cards.add(card15);
		cards.set(15, card15);

		card16 = new Card("Steel", 3);
		cards.add(card16);
		cards.set(16, card16);

		card17 = new Card("Steel", 4);
		cards.add(card17);
		cards.set(17, card17);

		card18 = new Card("Stores", -4);
		cards.add(card18);
		cards.set(18, card18);

		card19 = new Card("Stores", -3);
		cards.add(card19);
		cards.set(19, card19);

		card20 = new Card("Stores", -2);
		cards.add(card20);
		cards.set(20, card20);

		card21 = new Card("Stores", 2);
		cards.add(card21);
		cards.set(21, card21);

		card22 = new Card("Stores", 3);
		cards.add(card22);
		cards.set(22, card22);

		card23 = new Card("Stores", 4);
		cards.add(card23);
		cards.set(23, card23);

		card24 = new Card("Bear", -4);
		cards.add(card24);
		cards.set(24, card24);

		card25 = new Card("Bull", 4);
		cards.add(card25);
		cards.set(25, card25);

		randomNumber.add(0);
		randomNumber.add(1);
		randomNumber.add(2);
		randomNumber.add(3);
		randomNumber.add(4);
		randomNumber.add(5);
		randomNumber.add(6);
		randomNumber.add(7);
		randomNumber.add(8);
		randomNumber.add(9);
		randomNumber.add(10);
		randomNumber.add(11);
		randomNumber.add(12);
		randomNumber.add(13);
		randomNumber.add(14);
		randomNumber.add(15);
		randomNumber.add(16);
		randomNumber.add(17);
		randomNumber.add(18);
		randomNumber.add(19);
		randomNumber.add(20);
		randomNumber.add(21);
		randomNumber.add(22);
		randomNumber.add(23);
		randomNumber.add(24);
		randomNumber.add(25);
	}
	
	public int getStockPrice(String stockType)
	{
		if(stockType == "Motors")
		{
			return motors.getStockValue();
		}
		else if(stockType == "Shipping")
		{
			return shipping.getStockValue();
		}
		else if(stockType == "Steel")
		{
			return steel.getStockValue();
		}
		else if(stockType == "Stores")
		{
			return stores.getStockValue();
		}
		//Not sure about this part, just did it to get it working.
		else
		{
			return -1;
		}
	}
	
	public int getStockAmount(String stockType)
	{
		if(stockType == "Motors")
		{
			return motors.getStockAmount();
		}
		else if(stockType == "Shipping")
		{
			return shipping.getStockAmount();
		}
		else if(stockType == "Steel")
		{
			return steel.getStockAmount();
		}
		else if(stockType == "Stores")
		{
			return stores.getStockAmount();
		}
		//Not sure about this part, just did it to get it working.
		else
		{
			return -1;
		}
	}
	
	public void setStockAmount(String stockType, int amount)
	{
		if(stockType == "Motors")
		{
			motors.setStockAmount(amount);
		}
		else if(stockType == "Shipping")
		{
			shipping.setStockAmount(amount);
		}
		else if(stockType == "Steel")
		{
			steel.setStockAmount(amount);
		}
		else if(stockType == "Stores")
		{
			stores.setStockAmount(amount);
		}
	}
	
	public void setStockValue(String stockType, int amount) {
		if (stockType == "Motors") {
			motors.setStockValue(amount);
		} else if (stockType == "Shipping") {
			shipping.setStockValue(amount);
		} else if (stockType == "Steel") {
			steel.setStockValue(amount);
		} else if (stockType == "Stores") {
			stores.setStockValue(amount);
		}
	}
    
	/**
	 * This method shows the updated value of stocks. 
	 * @return
	 */
	public String updatedStockValue(){
    		String str = "";
    		
    		str += ("The current value of stocks"+ "\n" + "Moters = " + motors.getStockValue() + "\n" +"Steel +" +steel.getStockValue() +
    		"\n"+ "Shipping = " +shipping.getStockValue() + "\n" + "Stores = " + stores.getStockValue());
    		
    		return str;
    	}
    	
        public void generateCardIndex() {// UPDATED!!

		for (Player currentPlayer : players) {

			int index = randomGenerator.nextInt(randomNumber.size());
			int i = randomNumber.get(index);
			currentPlayer.setCard(i);
			randomNumber.remove(index);

		}
		initialiseCards();
	}
	
	public String generateCard(Player currentPlayer) {

		int i = currentPlayer.getCard();
		return cards.get(i).toString();
	}
	
	public int cardValue(Player currentPlayer){//UPDATED
		
		int i = currentPlayer.getCard();
		return   cards.get(i).getValue();
	}
	
	public String getStockType(Player currentPlayer){//UPDATED
	        
	        int i = currentPlayer.getCard();
		return  cards.get(i).getStockType();
		
	}

	
	public void load() throws Exception
    {
    	players = HandleXML.read("players.xml");
    }
    
    public void save() throws Exception
    {
    	HandleXML.write(players, "players.xml");
    }

}
