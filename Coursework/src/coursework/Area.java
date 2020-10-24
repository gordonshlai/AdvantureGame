package coursework;

/**
 * A class represent the Area of the game board.
 * @author Gordon Lai
 */
public class Area 
{
	private String type;
	private LivingCreatures livingCreature;
	private int yCoordinate;
	private int xCoordinate;
	
	/**
	 * Constructor for the Area of the game board.
	 */
	public Area(int yCoordinate, int xCoordinate) 
	{
		type = "";
		livingCreature = null;
		this.yCoordinate = yCoordinate;
		this.xCoordinate = xCoordinate;
	}

	/**
	 * Return the type of the Area.
	 * @return type of the Area
	 */
	public String getType() 
	{
		return type;
	}

	/**
	 * Set the type of the Area.
	 * @param type type of the Area to set.
	 */
	public void setType(String type) 
	{
		this.type = type;
	}

	/**
	 * Return the LivingCreature object in the Area.
	 * @return the LivingCreature object in the Area
	 */
	public LivingCreatures getLivingCreature() {
		return livingCreature;
	}

	/**
	 * Set the LivingCreature object in the Area.
	 * @param livingCreature the LivingCreature object to put into the area.
	 */
	public void setLivingCreature(LivingCreatures livingCreature) {
		this.livingCreature = livingCreature;
	}
	
	/**
	 * Return the y coordinate of the Area.
	 * @return y coordinate of the Area
	 */
	public int getyCoordinate() 
	{
		return yCoordinate;
	}

	/**
	 * Set the y coordinate of the Area.
	 * @param yCoordinate y coordinate of the Area to set
	 */
	public void setyCoordinate(int yCoordinate) 
	{
		this.yCoordinate = yCoordinate;
	}

	/**
	 * Return the x coordinate of the Area.
	 * @return x coordinate of the Area
	 */
	public int getxCoordinate() 
	{
		return xCoordinate;
	}

	/**
	 * Set the x coordinate of the Area.
	 * @param xCoordinate x coordinate of the Area to set
	 */
	public void setxCoordinate(int xCoordinate) 
	{
		this.xCoordinate = xCoordinate;
	}

	/**
	 * Print all the details of the area.
	 */
	public void printAreaDetails()
	{
		System.out.println("Type: " + type);
		System.out.println("Living Creature: " + livingCreature);
	}

}
