import java.util.ArrayList;
import java.util.Random;

public class Bank {
	
	private Card card0, card1, card2, card3, card4, card5, card6, card7, card8, card9, card10,
				 card11, card12, card13, card14, card15, card16, card17, card18, card19, card20,
				 card21, card22, card23, card24, card25;
				 
	private Stock motors, shipping, steel, stores;
				 
	private int motorPool, shippingPool, steelPool, storesPool;
	
	private ArrayList<Player> players;
	private ArrayList<Card> cards;
	Random randomGenerator = new Random();
	
	
	public Bank()
	{
	
		motors = new Stock("Motors");
		shipping = new Stock("Shipping");
		steel = new Stock("Steel");
		stores = new Stock("Stores");
		
		motorPool = 28;
		shippingPool = 28;
		steelPool = 28;
		storesPool = 28;
		
		players = new ArrayList<Player>();
		cards =  new ArrayList<Card>();
		
		initialiseCards();
	
	}
	
	public void addStockToPool(String stockType, int value)
	{
		if(stockType == "Motors")
		{
			this.motorPool += value;
		}
		else if(stockType == "Shipping")
		{
			this.shippingPool += value;
		}
		else if(stockType == "Steel")
		{
			this.steelPool += value;
		}
		else if(stockType == "Stores")
		{
			this.storesPool += value;
		}
	}
	
	public void takeStockFromPool(String stockType, int value)
	{
		if(stockType == "Motors")
		{
			this.motorPool -= value;
		}
		else if(stockType == "Shipping")
		{
			this.shippingPool -= value;
		}
		else if(stockType == "Steel")
		{
			this.steelPool -= value;
		}
		else if(stockType == "Stores")
		{
			this.storesPool -= value;
		}
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
		{
		card0 = new Card("Motors  ", -4);
		cards.add(card0);
		card1 = new Card("Motors  ", -3);
		cards.add(card1);
		card2 = new Card("Motors  ", -2);
		cards.add(card2);
		card3 = new Card("Motors  ",  2);
		cards.add(card3);
		card4 = new Card("Motors  ",  3);
		cards.add(card4);
		card5 = new Card("Motors  ",  4);
		cards.add(card5);
		
		card6 = new Card("Shipping", -4);
		cards.add(card6);	
	        card7 = new Card("Shipping", -3);
	        cards.add(card7);
		card8 = new Card("Shipping", -2);
		cards.add(card8);
		card9 = new Card("Shipping",  2);
		cards.add(card9);
		card10 = new Card("Shipping", 3);
		cards.add(card10);
		card11 = new Card("Shipping", 4);
		cards.add(card11);
		
		card12 = new Card("Steel   ", -4);
		cards.add(card12);
		card13 = new Card("Steel   ", -3);
		cards.add(card13);
		card14 = new Card("Steel   ", -2);
		cards.add(card14);
		card15 = new Card("Steel   ",  2);
		cards.add(card15);
		card16 = new Card("Steel   ",  3);
		cards.add(card16);
		card17 = new Card("Steel   ",  4);
		cards.add(card17);
		
		card18 = new Card("Stores  ", -4);
		cards.add(card18);
		card19 = new Card("Stores  ", -3);
		cards.add(card19);
		card20 = new Card("Stores  ", -2);
		cards.add(card20);
		card21 = new Card("Stores  ",  2);
		cards.add(card21);
		card22 = new Card("Stores  ",  3);
		cards.add(card22);
		card23 = new Card("Stores  ",  4);
		cards.add(card23);
		
		card24 = new Card("Bear    ", -4);
		cards.add(card24);
		card25 = new Card("Bull    ",  4);
		cards.add(card25);
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
    	
    	public String generateCard()
	{
	  int index = randomGenerator.nextInt(cards.size());
	   return cards.get(index).toString();
	}

}
