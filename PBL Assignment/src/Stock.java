/**
 * This is the stocks class, it holds crucial information about the stocks.
 * 
 * @author Chris, David, Patrick, Brian, Igor 
 */
public class Stock {

	String stockType;
	int stockAmount;
	int stockValue;
	
	/**
	 * Constructor for objects of class Stock.
	 * @param stockType
	 */
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
			this.stockAmount += stockAmount;
	}
	
	public int getStockValue()
	{
		return this.stockValue;
	}
	
	public void setStockValue(int stockValue)
	{
		int i = this.stockValue += stockValue;
		if(i >= 0 && i <= 20)
		{
			this.stockValue += stockValue;
		}
		else if(i < 0)
		{
			this.stockValue = 0;
		}
		else if(i > 20)
		{
			this.stockValue = 20;
		}
	}
	
	/**
	 * This builds a string of all the information that this class holds, then it displays it in a neat format of the object state.
	 * @return  's the details of a specific stock. 
	 */
	public String toString()
	{
		return "Stock Type: " + stockType + "/nStock Amount: " + stockAmount + "/nStock Value: " + stockValue;
	}
}
