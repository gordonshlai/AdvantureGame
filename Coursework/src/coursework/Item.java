package coursework;

/**
 * A class represent an Item
 * @author Gordon Lai
 */
public class Item 
{
	private String name;
	/**
	 * A constructor for an Item
	 */
	public Item(String name)
	{
		this.name = name;
	}
	
	/**
	 * Return the String that contain the name of the item
	 * @return the String that contain the name of the item
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * the name of the item to set
	 * @param name name of the item to set
	 */
	public void setName(String name) 
	{
		this.name = name;
	}
}
