package coursework;

/**
 * A class represent the biggest villain, Gordon
 * @author Gordon Lai
 */
public class Gordon extends Character implements LivingCreatures, Fightable
{
	/**
	 * Constructor for the biggest villain, Gordon
	 */
	public Gordon(
		int yCoordinate, 
		int xCoordinate,
		int maxHealth,
		int health,
		int baseAttack,
		int baseDefence)
	{
		super(yCoordinate, xCoordinate, maxHealth, health, baseAttack, baseDefence, "Gordon");
	}
	
	/**
	 * Print the loot after killing
	 */
	public void printLoot()
	{
		System.out.println("# Gordon's head\tx 1");
	}
}
