package coursework;

/**
 * A class represent wolf armor.
 * @author Gordon Lai
 */
public class WolfArmor extends Item implements Armor
{
	private int defence;
	/**
	 * Constructor for a wolf armor.
	 */
	public WolfArmor() {
		super("Wolf Armor");
		defence = 10;
	}

	/**
	 * Return the defence power of the armor.
	 * @return the defence power of the armor
	 */
	public int getDefence() 
	{
		return defence;
	}
	
	/**
	 * Set the defence power of the armor.
	 * @param defence the attack power of the armor to set
	 */
	public void setDefence(int defence) 
	{
		this.defence = defence;
	}

	/**
	 * Print the details of the armor.
	 */
	public void printArmorDetails() 
	{
		System.out.println("--------------------------");
		System.out.println("Armor: " + getName());
		System.out.println("Defence boost: " + defence);
		System.out.println("--------------------------");
	}
}
