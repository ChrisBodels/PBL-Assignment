/**
 * This is the stocks class, it holds crucial information about the stocks.
 * 
 * @author Chris, David, Patrick, Brian, Igor 
 */
public class Stock {

	private String stockType;
	private int stockAmount, stockValue;
	
	/**
	 * Constructor for objects of class Stock.
	 * @param stockType
	 */
	public Stock(String stockType)
	{
		this.stockValue = 10;
		this.stockAmount = 28;
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
	
	/**
	 * This method sets the stock value so it will not go over 20 and cannot go less than 0.
	 * @param stockValue
	 */
	public void setStockValue(int stockValue)
	{
		int i = getStockValue() + stockValue;
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
}
