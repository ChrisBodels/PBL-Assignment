import java.util.ArrayList;

public class Bank {
	
	private Card[] cards;
	private Card card0, card1, card2, card3, card4, card5, card6, card7, card8, card9, card10,
				 card11, card12, card13, card14, card15, card16, card17, card18, card19, card20,
				 card21, card22, card23, card24, card25;
				 
	private Stock motors, shipping, steel, stores;
				 
	private int motorPool, shippingPool, steelPool, storesPool;
	
	private ArrayList<Player> players;
	
	public Bank()
	{
		cards = new Card[25];
		
		motors = new Stock("Motors");
		shipping = new Stock("Shipping");
		steel = new Stock("Steel");
		stores = new Stock("Stores");
		
		motorPool = 28;
		shippingPool = 28;
		steelPool = 28;
		storesPool = 28;
		
		
		initialiseCards();
		
		players = new ArrayList<Player>();
	
	}
	
	public ArrayList<Player> getPlayers()
	{
		return players;
	}
	
	public void add (Player player)
	{
		players.add(player);
	}
	
	public void initialiseCards()
	{
		cards[0] = card0 = new Card("Motors", -4);
		cards[1] = card1 = new Card("Motors", -3);
		cards[2] = card2 = new Card("Motors", -2);
		cards[3] = card3 = new Card("Motors", 2);
		cards[4] = card4 = new Card("Motors", 3);
		cards[5] = card5 = new Card("Motors", 4);
		
		cards[6] = card6 = new Card("Shipping", -4);
		cards[7] = card7 = new Card("Shipping", -3);
		cards[8] = card8 = new Card("Shipping", -2);
		cards[9] = card9 = new Card("Shipping", 2);
		cards[10] = card10 = new Card("Shipping", 3);
		cards[11] = card11 = new Card("Shipping", 4);
		
		cards[12] = card12 = new Card("Steel", -4);
		cards[13] = card13 = new Card("Steel", -3);
		cards[14] = card14 = new Card("Steel", -2);
		cards[15] = card15 = new Card("Steel", 2);
		cards[16] = card16 = new Card("Steel", 3);
		cards[17] = card17 = new Card("Steel", 4);
		
		cards[18] = card18 = new Card("Stores", -4);
		cards[19] = card19 = new Card("Stores", -3);
		cards[20] = card20 = new Card("Stores", -2);
		cards[21] = card21 = new Card("Stores", 2);
		cards[22] = card22 = new Card("Stores", 3);
		cards[23] = card23 = new Card("Stores", 4);
		
		cards[25] = card25 = new Card("Bear", -4);
		cards[24] = card24 = new Card("Bull", 4);
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
	
	public void load() throws Exception
 	{
    		players = HandleXML.read("players.xml");
    	}
    
	 public void save() throws Exception
    	{
    		HandleXML.write(players, "players.xml");
    	}
    	
    	public String checkCurrentBankStock()
	{String str = "";

		str += ("The current stock in the bank is"+ "\n" + "Motors = " + motorPool + "\n" +"Steel = " + steelPool +
		"\n"+ "Shipping = " +shippingPool+ "\n" + "Stores = " + storesPool  );

		return str;
}  
	public String updatedStockValue(){
    		String Str = "";
    		
    		Str += ("The current value of stocks"+ "\n" + "Moters = " + motors.getStockValue() + "\n" +"Steel +" +steel.getStockValue() +
    		"\n"+ "Shipping = " +shipping.getStockValue() + "\n" + "Stores = " + stores.getStockValue());
    		
    		return Str;
    	}
}
