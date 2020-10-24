package coursework;

/**
 * a class to represent Wolf
 * @author Gordon Lai
 */
public class Wolf extends Character implements LivingCreatures, Fightable
{
	/**
	 * Constructor for a Wolf
	 * @param yCoordinate initial y coordinate on the game board
	 * @param xCoordinate initial x coordinate on the game board
	 */
	public Wolf(
		int yCoordinate, 
		int xCoordinate)
	{
		super(yCoordinate, xCoordinate, 30, 30, 10, 5, "Wolf");
	}

	/**
	 * Print the loot after killing
	 */
	public void printLoot()
	{
		System.out.println("# Wolf's bone\tx 1\tgold x 10");
		System.out.println("# Wolf's skin\tx 1");
		System.out.println("# Wolf's blood\tx 1");
	}
}
