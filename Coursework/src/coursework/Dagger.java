package coursework;

/**
 * A class to represent dagger.
 * @author Gordon Lai
 */
public class Dagger extends Item implements Weapon
{
	private int attack;
	
	/**
	 * Constructor for a dagger.
	 */
	public Dagger() 
	{
		super("Dagger");
		attack = 10;
	}
	
	/**
	 * Return the attack power of the dagger.
	 * @return the attack power of the dagger
	 */
	public int getAttack() 
	{
		return attack;
	}
	
	/**
	 * Set the attack power of the dagger.
	 * @param attack the attack power of the dagger to set
	 */
	public void setAttack(int attack) 
	{
		this.attack = attack;
	}

	/**
	 * Print the details of the dagger.
	 */
	public void printWeaponDetails()
	{
		System.out.println("--------------------------");
		System.out.println("Weapon: " + getName());
		System.out.println("Attack boost: " + attack);
		System.out.println("--------------------------");
	}
}
