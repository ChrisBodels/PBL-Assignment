import java.util.ArrayList;
import java.util.Random;

public class Bank {
	
	private Card card0, card1, card2, card3, card4, card5, card6, card7, card8, card9, card10,
				 card11, card12, card13, card14, card15, card16, card17, card18, card19, card20,
				 card21, card22, card23, card24, card25;
				 
	private Stock motors, shipping, steel, stores;
	
	private ArrayList<Player> players;
	private ArrayList<Card> cards;
	Random randomGenerator = new Random();
	private ArrayList<Card> removeCards;//new
	
	
	public Bank()
	{
	
		motors = new Stock("Motors");
		shipping = new Stock("Shipping");
		steel = new Stock("Steel");
		stores = new Stock("Stores");
		
		players = new ArrayList<Player>();
		cards =  new ArrayList<Card>();
		removeCards = new ArrayList<Card>();//new
		
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
	
	public void initialiseCards()//changed
	{
		{
		card0 = new Card("Motors  ", -4);
		cards.add(card0);
		removeCards.add(card0);
		
		card1 = new Card("Motors  ", -3);
		cards.add(card1);
		removeCards.add(card1);
		
		card2 = new Card("Motors  ", -2);
		cards.add(card2);
		removeCards.add(card2);
		
		card3 = new Card("Motors  ",  2);
		cards.add(card3);
		removeCards.add(card3);
		
		card4 = new Card("Motors  ",  3);
		cards.add(card4);
		removeCards.add(card4);
		
		card5 = new Card("Motors  ",  4);
		cards.add(card5);
		removeCards.add(card5);
		
		card6 = new Card("Shipping", -4);
		cards.add(card6);
		removeCards.add(card6);
		
	        card7 = new Card("Shipping", -3);
	        cards.add(card7);
	        removeCards.add(card7);
	    
		card8 = new Card("Shipping", -2);
		cards.add(card8);
		removeCards.add(card8);
		
		card9 = new Card("Shipping",  2);
		cards.add(card9);
		removeCards.add(card9);
		
		card10 = new Card("Shipping", 3);
		cards.add(card10);
		removeCards.add(card10);
		
		card11 = new Card("Shipping", 4);
		cards.add(card11);
		removeCards.add(card11);
		
		card12 = new Card("Steel   ", -4);
		cards.add(card12);
		removeCards.add(card12);
		
		card13 = new Card("Steel   ", -3);
		cards.add(card13);
		removeCards.add(card13);
		
		card14 = new Card("Steel   ", -2);
		cards.add(card14);
		removeCards.add(card14);
		
		card15 = new Card("Steel   ",  2);
		cards.add(card15);
		removeCards.add(card15);
		
		card16 = new Card("Steel   ",  3);
		cards.add(card16);
		removeCards.add(card16);
		
		card17 = new Card("Steel   ",  4);
		cards.add(card17);
		removeCards.add(card17);
		
		
		card18 = new Card("Stores  ", -4);
		cards.add(card18);
		removeCards.add(card18);
		
		card19 = new Card("Stores  ", -3);
		cards.add(card19);
		removeCards.add(card19);
		
		card20 = new Card("Stores  ", -2);
		cards.add(card20);
		removeCards.add(card20);
		
		card21 = new Card("Stores  ",  2);
		cards.add(card21);
		removeCards.add(card21);
		
		card22 = new Card("Stores  ",  3);
		cards.add(card22);
		removeCards.add(card22);
		
		card23 = new Card("Stores  ",  4);
		cards.add(card23);
		removeCards.add(card23);
		
		card24 = new Card("Bear    ", -4);
		cards.add(card24);
		removeCards.add(card24);
		
		card25 = new Card("Bull    ",  4);
		cards.add(card25);
		removeCards.add(card25);
		
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
	
	/*public void load() throws Exception
 	{
    		players = HandleXML.read("players.xml");
    	}
    
	 public void save() throws Exception
    	{
    		HandleXML.write(players, "players.xml");
    	}*/
    	
    	/*
     * I changed how the stocks are done and this method is now giving errors so I'm just commenting it 
     * out for now as I can't see it being used anywhere at the moment.
     * -Chris	
     */
    	/*public String checkCurrentBankStock()
	{String str = "";

		str += ("The current stock in the bank is"+ "\n" + "Motors = " + motorPool + "\n" +"Steel = " + steelPool +
		"\n"+ "Shipping = " +shippingPool+ "\n" + "Stores = " + storesPool  );

		return str;
}  */
	public String updatedStockValue(){
    		String str = "";
    		
    		str += ("The current value of stocks"+ "\n" + "Moters = " + motors.getStockValue() + "\n" +"Steel +" +steel.getStockValue() +
    		"\n"+ "Shipping = " +shipping.getStockValue() + "\n" + "Stores = " + stores.getStockValue());
    		
    		return str;
    	}
    	
    public int generateCardIndex(Player currentPlayer) {//changed
		int num;
		int index = randomGenerator.nextInt(removeCards.size());
		num = index;
		currentPlayer.setCard(num);
		return index;
	}
	/*
	NEW METHOD
	*/
	public void removeCard(Player player)
	{
		removeCards.remove(player.getCard());
	}
	
	public String generateCard(Player currentPlayer) {

		return cards.get(currentPlayer.getCard()).toString();
	}

}
