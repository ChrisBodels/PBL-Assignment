
public class Player {

	private int balance, motorStocks, shippingStocks, storesStocks, steelStocks, card;
	private boolean loanStatus;
	private String userName;
	
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
		
		this.motorStocks = 0;
		this.shippingStocks = 0;
		this.storesStocks = 0;
		this.steelStocks = 0;
		this.card = 0;//this really stores the index number for the card
	}
	public void setCard(int card) {//sets the card to that of the index number
		this.card = card;
	}

	public int getCard() {//returns the int of the index number
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
	
	public void setUsername(String userName)
	{
		if(userName.length() >= 3 && userName.length() <=10)
		{
		this.userName = userName;
		}
	}
	
	public void setBalanceUp(int balance)
	{
		this.balance += balance; 
	}
	
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
	
	public void setStocksUp(String stockType, int amount)
	{
		if(stockType == "Motors")
		{
			this.motorStocks += amount;
		}
		else if(stockType == "Shipping")
		{
			this.shippingStocks += amount;
		}
		else if(stockType == "Steel")
		{
			this.steelStocks += amount;
		}
		else if(stockType == "Shipping")
		{
			this.storesStocks += amount;
		}
	}
	
	public void setStocksDown(String stockType, int amount)
	{
		if(stockType == "Motors")
		{
			this.motorStocks -= amount;
		}
		else if(stockType == "Shipping")
		{
			this.shippingStocks -= amount;
		}
		else if(stockType == "Steel")
		{
			this.steelStocks -= amount;
		}
		else if(stockType == "Shipping")
		{
			this.storesStocks -= amount;
		}
	}
	
	public int getStocks(String stockType)
	{
		int amount = 0;
		if(stockType.equals("Motor"))
		{
			return motorStocks +=amount;
		}
		else if(stockType.equals("Shipping"))
		{
			return shippingStocks =+ amount;
		}
		else if(stockType.equals("Steel"))
		{
			return steelStocks =+amount;
		}
		else if(stockType.equals("Shipping"))
		{
			return shippingStocks =+amount;
		} 
		return amount;
	}
}
