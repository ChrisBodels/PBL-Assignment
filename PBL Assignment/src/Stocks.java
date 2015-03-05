
public class Stocks {

	String stockType;
	int stockAmount;
	int stockValue;
	
	public Stocks(String stockType)
	{
		this.stockValue = 10;
		this.stockAmount = 30; //Check this number
		this.stockType = stockType;
	}
	
	public int getStockAmount()
	{
		return this.stockAmount;
	}
	
	public void setStockAmount()
	{
		
	}
	
	public int getStockValue()
	{
		return this.stockValue;
	}
	
	public void setStockValue()
	{
		
	}
	
	public String toString()
	{
		return ""; //Fill this in
	}
}
