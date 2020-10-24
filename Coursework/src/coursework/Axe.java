package coursework;

/**
 * A class represent a spear.
 * @author Gordon Lai
 *
 */
public class Axe extends Item implements Weapon
{
	private int attack;	
	/**
	 * Constructor for a Axe.
	 */
	public Axe()
	{
		super("Axe");
		attack = 50;
	}
	
	/**
	 * Return the attack power of the Axe.
	 * @return the attack power of the Axe
	 */
	public int getAttack() 
	{
		return attack;
	}
	
	/**
	 * Set the attack power of the Axe.
	 * @param attack the attack power of the Axe to set
	 */
	public void setAttack(int attack) 
	{
		this.attack = attack;
	}
	
	/**
	 * Print the details of the Axe.
	 */
	public void printWeaponDetails()
	{
		System.out.println("--------------------------");
		System.out.println("Weapon: " + getName());
		System.out.println("Attack boost: " + attack);
		System.out.println("--------------------------");
	}
}
