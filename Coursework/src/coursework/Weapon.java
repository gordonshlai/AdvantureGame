package coursework;

/**
 * A class represent a weapon
 * @author Gordon Lai
 */
public interface Weapon
{
	public int getAttack();
	public void setAttack(int attack);
	public String getName();
	public void setName(String name);
	public void printWeaponDetails();
}
