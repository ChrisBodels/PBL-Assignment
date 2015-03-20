
public class Card {

	private String stockType;
	private int value;
	
	public Card(String stockType, int value)
	{
		this.stockType = stockType;
		this.value = value;
	}
	
	
	public String toString()
	{
		return (" __________________\n"+
	            "|     "+stockType+"     |\n" +
	            "|                  | \n"+
	            "|        " +value+"        | \n"+
	            "|                  | \n"+
	            "|__________________| \n");
	}
	
	public String getStockType()
	{
		return stockType;
	}
	
	public int getValue()
	{
		return value;
	}
}
