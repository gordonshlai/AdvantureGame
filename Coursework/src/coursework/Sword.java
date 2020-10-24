package coursework;

/**
 * A class represent a sword
 * @author Gordon Lai
 *
 */
public class Sword extends Item implements Weapon
{
	private int attack;
	/**
	 * A constructor for a sword
	 */
	public Sword()
	{
		super("Sword");
		attack = 30;
	}
	
	/**
	 * Return the attack power of the sword.
	 * @return the attack power of the sword
	 */
	public int getAttack() 
	{
		return attack;
	}
	
	/**
	 * Set the attack power of the sword.
	 * @param attack the attack power of the sword to set
	 */
	public void setAttack(int attack) 
	{
		this.attack = attack;
	}

	/**
	 * Print the details of the sword.
	 */
	public void printWeaponDetails()
	{
		System.out.println("--------------------------");
		System.out.println("Weapon: " + getName());
		System.out.println("Attack boost: " + attack);
		System.out.println("--------------------------");
	}
}
