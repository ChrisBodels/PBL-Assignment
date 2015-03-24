/**
 * This class is dedicated towards the 26 cards that exist in the Stock and Share game.
 * 
 * @author Chris, David, Patrick, Brian, Igor 
 */
public class Card {

	private String stockType;
	private int value;
	
	/**
	 * Constructor for the objects of class Card.
	 * @param stockType
	 * @param value
	 */
	public Card(String stockType, int value)
	{
		this.stockType = stockType;
		this.value = value;
	}
	
	/**
	 * This builds a string of all the information that this class holds, 
	 * then it displays it in a neat format of the object state that is very much user friendly.
	 * @return  's the details of a specific card.
	 */
public String toString()
	{
		
		
	return("--------------------.\n"+
	   "| .--------------. || \n"+ 
	   "| |              | || \n"+ 
	   "      "+stockType+"           \n"+ 
   	   "| |              | || \n"+ 
	   "| |              | || \n"+
	   "         "+value+"          \n"+ 
	   "| |              | || \n"+ 
	   "| |              | || \n"+ 
	   "|  --------------  || \n"+ 
	   " .----------------.   \n");
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
