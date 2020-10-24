package coursework;

/**
 * A class represent a potion, this can recover the players health for 30 points.
 * @author Gordon Lai
 */
public class Potion extends Item
{
	private int healthRecovery;
	
	/**
	 * A constructor for a potion
	 */
	public Potion()
	{
		super("Potion");
		healthRecovery = 30;
	}

	/**
	 * Return the health recovery amount of the potion
	 * @return the health recovery amount of the potion
	 */
	public int getHealthRecovery() {
		return healthRecovery;
	}

	/**
	 * Set the health recovery amount of the potion
	 * @param healthRecovery the health recovery amount of the potion to set
	 */
	public void setHealthRecovery(int healthRecovery) {
		this.healthRecovery = healthRecovery;
	}
}
