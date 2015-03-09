
public class Stock {

	String stockType;
	int stockAmount;
	int stockValue;
	
	public Stock(String stockType)
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
