import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;//NEW Method 20/3/

public class Bank {
	
	private Card card0, card1, card2, card3, card4, card5, card6, card7, card8, card9, card10,
				 card11, card12, card13, card14, card15, card16, card17, card18, card19, card20,
				 card21, card22, card23, card24, card25;
				 
	private Stock motors, shipping, steel, stores;
	
	private ArrayList<Player> players;
	private ArrayList<Card> cards;
	private ArrayList<Card> removeCards;//new
	Random randomGenerator = new Random();
	
	
	
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
	
	public void initialiseCards()//UPDATED!!!!
	{
		
		card0 = new Card("Motors",-4);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(0,card0);
		removeCards.set(0,card0);

		card1 = new Card("Motors",-3);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(1,card1);
		removeCards.set(1,card1);
		

		card2 = new Card("Motors",-2);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(2,card2);
		removeCards.set(2,card2);
		

		card3 = new Card("Motors",2);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(3,card3);
		removeCards.set(3,card3);

		card4 = new Card("Motors",3);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(4,card4);
		removeCards.set(4,card4);

		card5 = new Card("Motors",4);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(5,card5);
		removeCards.set(5,card5);

		card6 = new Card("Shipping",-4);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(6,card6);
		removeCards.add(6,card6);

		card7 = new Card("Shipping",-3);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(7,card7);
		removeCards.set(7,card7);

		card8 = new Card("Shipping",-2);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(8,card8);
		removeCards.set(8,card8);
		
		card9 = new Card("Shipping",2);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(9,card9);
		removeCards.set(9,card9);

		card10 = new Card("Shipping",3);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(10,card10);
		removeCards.set(10,card10);

		card11 = new Card("Shipping",4);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(11,card11);
		removeCards.set(11,card11);

		card12 = new Card("Steel",-4);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(12,card12);
		removeCards.set(12,card12);

		card13 = new Card("Steel",-3);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(13,card13);
		removeCards.set(13,card13);

		card14 = new Card("Steel",-2);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(14,card14);
		removeCards.set(14,card14);

		card15 = new Card("Steel",2);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(15,card15);
		removeCards.set(15,card15);

		card16 = new Card("Steel",3);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(16,card16);
		removeCards.set(16,card16);

		card17 = new Card("Steel",4);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(17,card17);
		removeCards.set(17,card17);

		card18 = new Card("Stores",-4);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(18,card18);
		removeCards.set(18,card18);

		card19 = new Card("Stores",-3);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(19,card19);
		removeCards.set(19,card19);

		card20 = new Card("Stores",-2);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(20,card20);
		removeCards.set(20,card20);

		card21 = new Card("Stores",2);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(21,card21);
		removeCards.set(21,card21);

		card22 = new Card("Stores",3);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(22,card22);
		removeCards.set(22,card22);

		card23 = new Card("Stores",4);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(23,card23);
		removeCards.set(23,card23);

		card24 = new Card("Bear",-4);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(24,card24);
		removeCards.set(24,card24);

		card25 = new Card("Bull",4);
		cards.add(card0);
		removeCards.add(card0);
		cards.set(25,card25);
		removeCards.set(25,card25);

		
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
    	
    public void generateCardIndex(Player currentPlayer) {//UPDATED!!

		int index = randomGenerator.nextInt(removeCards.size());
		currentPlayer.setCard(index);

	}
	
	public void removeCard(Player currentPlayer) {//UPDATED!!
	
		removeCards.remove(currentPlayer.getCard());
	}
	
	public String generateCard(Player currentPlayer) {

		return cards.get(currentPlayer.getCard()).toString();
	}
	
	public int cardValue(Player currentPlayer){//UPDATED
		
		return   cards.get(currentPlayer.getCard()).getValue();
	}
	
	public String getStockType(Player currentPlayer){//UPDATED
	
		return  cards.get(currentPlayer.getCard()).getStockType();
		
	}
	
	/*
	 * New method to reset the remove cards array
	 * 
	 */
	public void resetArray(){
		
		Collections.copy(cards, removeCards);
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
