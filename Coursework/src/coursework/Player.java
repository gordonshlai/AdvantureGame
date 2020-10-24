package coursework;

/**
 * A class represent the player.
 * @author Gordon Lai
 */
public class Player extends Character implements LivingCreatures, Fightable
{
	private boolean fatherPermitted;
	private boolean killedAnimal;
	private boolean paidToEnterTown;
	private int gold;
	/**
	 * Constructor for the player
	 */
	public Player(
		int yCoordinate, 
		int xCoordinate,
		int maxHealth,
		int health,
		int baseAttack,
		int baseDefence)
	{
		super(yCoordinate, xCoordinate, maxHealth, health, baseAttack, baseDefence, "Player");
		fatherPermitted = false;
		killedAnimal = false;
		paidToEnterTown = false;
		gold = 0;
	}

	/**
	 * Return the boolean of father's permission for the player to enter the forest.
	 * @return true if father is permitted, false otherwise
	 */
	public boolean isFatherPermitted() 
	{
		return fatherPermitted;
	}

	/**
	 * Set the permission from father for the player to enter the forest
	 * @param fatherPermitted the permission from father for the player to enter the forest to set
	 */
	public void setFatherPermitted(boolean fatherPermitted) 
	{
		this.fatherPermitted = fatherPermitted;
	}

	/**
	 * Return the boolean that indicates the player has killed at least one wild animal, 
	 * determining whether the player can enter the shop.
	 * @return true if player has killed at least one wild animal, false otherwise
	 */
	public boolean isKilledAnimal() {
		return killedAnimal;
	}

	/**
	 * Set the boolean that indicates the player has killed at least one wild animal, 
	 * determining whether the player can enter the shop.
	 * @param killedAnimal indicator of the player has killed at least one wild animal to set
	 */
	public void setKilledAnimal(boolean killedAnimal) {
		this.killedAnimal = killedAnimal;
	}

	/**
	 * Return the boolean to indicate whether the player has paid to enter the town.
	 * @return true if the player has paid, false otherwise.
	 */
	public boolean isPaidToEnterTown() 
	{
		return paidToEnterTown;
	}

	/**
	 * Set whether the player has paid to enter the town.
	 * @param paidToEnterTown player has paid to enter the town to set
	 */
	public void setPaidToEnterTown(boolean paidToEnterTown) 
	{
		this.paidToEnterTown = paidToEnterTown;
	}

	/**
	 * Return the amount of gold.
	 * @return the amount of gold
	 */
	public int getGold() 
	{
		return gold;
	}

	/**
	 * Set the amount of gold
	 * @param gold amount of gold to set
	 */
	public void setGold(int gold) 
	{
		this.gold = gold;
	}

	/**
	 * A method to make a directional movement of the player on the game board
	 * @param decision decision of direction to move
	 * @return true if the player is moved, false otherwise
	 */
	public boolean move(String decision)
	{
		switch(decision)
		{
		case ("1"):
			setyCoordinate(getyCoordinate() - 1);
			return true;
		case ("2"):
			setxCoordinate(getxCoordinate() + 1);
			return true;
		case ("3"):
			setyCoordinate(getyCoordinate() + 1);
			return true;
		case ("4"):
			setxCoordinate(getxCoordinate() - 1);
			return true;
		default:
			return false;
		}
	}
	
	/**
	 * To reverse the directional movement of the player on the game board
	 * @param decision decision of direction to move
	 */
	public void reverseMove(String decision)
	{
		switch(decision)
		{
		case ("1"):
			setyCoordinate(getyCoordinate() + 1);
			break;
		case ("2"):
			setxCoordinate(getxCoordinate() - 1);
			break;
		case ("3"):
			setyCoordinate(getyCoordinate() - 1);
			break;
		case ("4"):
			setxCoordinate(getxCoordinate() + 1);
			break;
		default:
			break;
		}
	}
	
	/**
	 * Print the amount of gold possessed.
	 */
	public void printGold()
	{
		System.out.println("\n################################");
		System.out.println("You have " + gold + " gold");
		System.out.println("################################\n");
	}
	
	/**
	 * A dummy method, just to satisfy the interface.
	 */
	public void printLoot()
	{
		
	}
}
