
public class Stock {

	String stockType;
	int stockAmount;
	int stockValue;
	
	public Stock(String stockType)
	{
		this.stockValue = 10;
		this.stockAmount = 28; //Check this number
		this.stockType = stockType;
	}
	
	public int getStockAmount()
	{
		return this.stockAmount;
	}
	
	public void setStockAmount(int stockAmount)
	{
		if(stockAmount >= 0 && stockAmount <= 28)
		{
			this.stockAmount += stockAmount;
		}
	}
	
	public int getStockValue()
	{
		return this.stockValue;
	}
	
	public void setStockValue(int stockValue)
	{
		if(stockValue >= 0 && stockValue <=20)
		{
			this.stockValue = stockValue;
		}
	}
	
	public String toString()
	{
		return "Stock Type: " + stockType + "/nStock Amount: " + stockAmount + "/nStock Value: " + stockValue;
	}
}
