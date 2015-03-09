
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
		this.userName = userName;
		//Add validation for username
		this.motorStocks = 0;
		this.shippingStocks = 0;
		this.storesStocks = 0;
		this.steelStocks = 0;
	}
	
	public void setLoanStatus(boolean loanStatus)
	{
		 
			if (!loanStatus) {
				this.loanStatus = true;
			} else {
				this.loanStatus = false;
			}
		 
	
	public int getBalance()
	{
		return this.balance;
	}
	
	public void setUsername()
	{
		
	}
	
	public void setBalance()
	{
		
	}
	
	public String getUserName()
	{
		return this.userName;
	}
	
	public boolean getLoanStatus()
	{
		return this.loanStatus;
	}
}
