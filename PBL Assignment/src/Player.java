
public class Player {

	int balance;
	boolean loanStatus;
	String userName;
	int motorStocks;
	int shippingStocks;
	int storesStocks;
	int steelStocks;
	
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
	
	public void setBalance(int balance)
	{
		this.balance = balance; 
	}
	
	public String getUserName()
	{
		return this.userName;
	}
	
	public boolean getLoanStatus()
	{
		return this.loanStatus;
	}
	
	public void changeStockAmount(String stockType, int value)
	{
		if(stockType == "Motors")
		{
			this.motorStocks += value;
		}
		else if(stockType == "Shipping")
		{
			this.shippingStocks += value;
		}
		else if(stockType == "Steel")
		{
			this.steelStocks += value;
		}
		else if(stockType == "Stores")
		{
			this.storesStocks += value;
		}
	}
}
