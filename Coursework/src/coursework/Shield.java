package coursework;

/**
 * A class represent a shield.
 * A shield can be used during a fight, when used, no damage will cause to the player.
 * However, the shield has it's life, which is the number of time the shield can be used.
 * @author Gordon Lai
 */
public class Shield extends Item
{
	private int life;
	/**
	 * Constructor for a shield
	 */
	public Shield()
	{
		super("Bone Shield");
		life = 5;
	}
	
	/**
	 * Return the life of the shield remaining.
	 * @return life of the shield remaining
	 */
	public int getLife() {
		return life;
	}
	
	/**
	 * Set the life of the shield.
	 * @param life life of the shield to set.
	 */
	public void setLife(int life) {
		this.life = life;
	}
	
	/**
	 * Print the details of the shield.
	 */
	public void printShieldDetails()
	{
		System.out.println("--------------------------");
		System.out.println("Shield: " + getName());
		System.out.println("Times remaining to use: " + life);
		System.out.println("--------------------------");
	}
	
}
