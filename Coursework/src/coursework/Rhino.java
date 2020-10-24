package coursework;

/**
 * a class represent Rhino
 * @author Gordon Lai
 */
public class Rhino extends Character implements LivingCreatures, Fightable
{
	/**
	 * Constructor for a Rhino
	 * @param yCoordinate initial y coordinate on the game board
	 * @param xCoordinate initial x coordinate on the game board
	 */
	public Rhino(
		int yCoordinate, 
		int xCoordinate)
	{
		super(yCoordinate, xCoordinate, 50, 50, 20, 10, "Rhino");
	}
	
	/**
	 * Print the loot after killing
	 */
	public void printLoot()
	{

		System.out.println("# Rhino's bone\tx 1\tGold x 20");
		System.out.println("# Rhino's skin\tx 1");
		System.out.println("# Rhino's blood\tx 1");
		System.out.println("# Rhino's skull\tx 1");
	}

}
