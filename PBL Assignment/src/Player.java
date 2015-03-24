/**
 * This class is for player.
 * 
 * @author Chris, David, Patrick, Brian, Igor 
 */
public class Player {

	private int balance, card;
	private boolean loanStatus;
	private String userName;
	private Stock playerMotors, playerShipping, playerSteel, playerStores;
	
	/**
	 * Constructor for objects of class Player.
	 * @param userName
	 */
	public Player(String userName)
	{
		this.balance = 80;
		this.loanStatus = false;
		if(userName.length() >= 3 && userName.length() <=10)
		{
		this.userName = userName;
		}
		else
		{
			this.userName = userName.substring(0, 9);
		}
		
		this.card = 0;//this really stores the index number for the card
		
		playerMotors = new Stock("Motors");
		playerShipping = new Stock("Shipping");
		playerSteel = new Stock("Steel");
		playerStores = new Stock("Stores");
		
		playerMotors.setStockAmount(-28);
		playerShipping.setStockAmount(-28);
		playerSteel.setStockAmount(-28);
		playerStores.setStockAmount(-28);
	}
	
	//This blank constructor is needed for saving the xml file - Paddy
	public Player()
	{
		
	}
	
	public void setCard(int card) //sets the card to that of the index number
	{
		this.card = card;
	}
			
	public int getCard() //returns the int of the index number
	{
		return this.card;
	}
	
	public void setLoanStatus(boolean loanStatus)
	{
		this.loanStatus = loanStatus;
	}
	
	public int getBalance()
	{
		return this.balance;
	}
	/**
	 * This method sets the user name when entered. 
	 * @param userName
	 */
	public void setUsername(String userName)
	{
		if(userName.length() >= 3 && userName.length() <=10)
		{
		this.userName = userName;
		}
	}
	/**
	 * This method will increase the balance.
	 * @param balance
	 */
	public void setBalanceUp(int balance)
	{
		this.balance += balance; 
	}
	/**
	 * This method will decrease the balance.
	 * @param balance
	 */
	public void setBalanceDown(int balance)
	{
		this.balance -= balance; 
	}
	
	public String getUserName()
	{
		return this.userName;
	}
	
	public boolean getLoanStatus()
	{
		return this.loanStatus;
	}
	/**
	 * This method will change the amount of stocks up if the player has bought stocks. 
	 * @param stockType
	 * @param amount
	 */
	public void setStocksUp(String stockType, int amount)
	{
		if(stockType == "Motors")
		{
			playerMotors.setStockAmount(amount);
		}
		else if(stockType == "Shipping")
		{
			playerShipping.setStockAmount(amount);
		}
		else if(stockType == "Steel")
		{
			playerSteel.setStockAmount(amount);
		}
		else if(stockType == "Shipping")
		{
			playerStores.setStockAmount(amount);
		}
	}
	/**
	 * This method will change the amount of stocks down if the player has sold stocks. 
	 * @param stockType
	 * @param amount
	 */
	public void setStocksDown(String stockType, int amount)
	{
		if(stockType == "Motors")
		{
			playerMotors.setStockAmount(-amount);
		}
		else if(stockType == "Shipping")
		{
			playerShipping.setStockAmount(-amount);
		}
		else if(stockType == "Steel")
		{
			playerSteel.setStockAmount(-amount);
		}
		else if(stockType == "Stores")
		{
			playerStores.setStockAmount(-amount);
		}
	}
	
	public int getStocks(String stockType)
	{
		if(stockType == "Motors")
		{
			return playerMotors.getStockAmount();
		}
		else if(stockType == "Shipping")
		{
			return playerShipping.getStockAmount();
		}
		else if(stockType == "Steel")
		{
			return playerSteel.getStockAmount();
		}
		else if(stockType == "Stores")
		{
			return playerStores.getStockAmount();
		} 
		else
		{
			return -1;
		}
	}
	/**
	 * In this method we are gathering all the stocks the current player has.
	 * @return Stocks. The amount of stocks as type int. 
	 */
	public int getTotalStocks()
	{
		int i = getStocks("Motors");
		i += getStocks("Shipping");
		i += getStocks("Steel");
		i += getStocks("Stores");
		return i;
	}
}
