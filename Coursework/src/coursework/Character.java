package coursework;

import java.util.ArrayList;

public class Character {
	private int yCoordinate;
	private int xCoordinate;
	private int maxHealth;
	private int health;
	private int baseAttack;
	private int totalAttack;
	private int baseDefence;
	private int totalDefence;
	private String name;
	private ArrayList<Item> items;
	private Weapon weapon;
	private Shield shield;
	private Armor armor;
	
	/**
	 * A constructor for the player.
	 */
	public Character(
		int yCoordinate, 
		int xCoordinate,
		int maxHealth,
		int health,
		int baseAttack,
		int baseDefence,
		String name)
	{
		this.yCoordinate = yCoordinate;
		this.xCoordinate = xCoordinate;
		this.maxHealth = maxHealth;
		this.health = health;
		this.baseAttack = baseAttack;
		totalAttack = baseAttack;
		this.baseDefence = baseDefence;
		totalDefence = baseDefence;
		this.name = name;
		items = new ArrayList<Item>();
		weapon = null;
		armor = null;
	}

	/**
	 * Return the y coordinate of the character.
	 * @return y coordinate of the character
	 */
	public int getyCoordinate() 
	{
		return yCoordinate;
	}

	/**
	 * Set the y coordinate of the character
	 * @param yCoordinate y coordinate to set
	 */
	public void setyCoordinate(int yCoordinate) 
	{
		this.yCoordinate = yCoordinate;
	}

	/**
	 * Return the x coordinate of the character.
	 * @return x coordinate of the character
	 */
	public int getxCoordinate() 
	{
		return xCoordinate;
	}

	/**
	 * Set the x coordinate of the character
	 * @param xCoordinate x coordinate to set
	 */
	public void setxCoordinate(int xCoordinate) 
	{
		this.xCoordinate = xCoordinate;
	}

	/**
	 * Return the maximum health of the character.
	 * @return maximum health of the character
	 */
	public int getMaxHealth() 
	{
		return maxHealth;
	}

	/**
	 * Set the maximum health of the character
	 * @param maxHealth maximum health to set
	 */
	public void setMaxHealth(int maxHealth) 
	{
		this.maxHealth = maxHealth;
	}

	/**
	 * Return the current health of the character.
	 * @return current health of the character
	 */
	public int getHealth() 
	{
		return health;
	}

	/**
	 * Set the current health of the character
	 * @param health current health to set
	 */
	public void setHealth(int health) 
	{
		this.health = health;
	}

	/**
	 * Return the base attack of the character.
	 * @return base attack of the character
	 */
	public int getBaseAttack() 
	{
		return baseAttack;
	}

	/**
	 * Set the base attack of the character
	 * @param baseAttack base attack to set
	 */
	public void setBaseAttack(int baseAttack) 
	{
		this.baseAttack = baseAttack;
	}

	/**
	 * Return the total attack of the character.
	 * @return total attack of the character
	 */
	public int getTotalAttack() 
	{
		return totalAttack;
	}

	/**
	 * Set the total attack of the character
	 * @param totalAttack attack to set
	 */
	public void setTotalAttack(int totalAttack) 
	{
		this.totalAttack = totalAttack;
	}

	/**
	 * Return the base attack of the character.
	 * @return base attack of the character
	 */
	public int getBaseDefence() 
	{
		return baseDefence;
	}

	/**
	 * Set the base defence of the character
	 * @param baseDefence base attack to set
	 */
	public void setBaseDefence(int baseDefence) 
	{
		this.baseDefence = baseDefence;
	}

	/**
	 * Return the total defence of the character.
	 * @return total defence of the character
	 */
	public int getTotalDefence() 
	{
		return totalDefence;
	}

	/**
	 * Set the total defence of the character
	 * @param totalDefence total defence to set
	 */
	public void setTotalDefence(int totalDefence) 
	{
		this.totalDefence = totalDefence;
	}
	
	/**
	 * Return the name of the character.
	 * @return name of the character
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * Set the name of the character
	 * @param name name of the character to set
	 */
	public void setName(String name) 
	{
		this.name = name;
	}
	
	/**
	 * Return the items ArrayList of the character.
	 * @return items ArrayList of the character
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * Set the items ArrayList of the character.
	 * @param items items ArrayList of the character to set
	 */
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	/**
	 * Return the shield equipped.
	 * @return the shield equipped
	 */
	public Shield getShield() 
	{
		return shield;
	}
	
	/**
	 * Set the shield to be equipped
	 * @param shield the shield to be equipped
	 */
	public void setShield(Shield shield) 
	{
		this.shield = shield;
	}

	/**
	 * Return the weapon equipped.
	 * @return the weapon equipped
	 */
	public Weapon getWeapon() {
		return weapon;
	}

	/**
	 * Set the weapon to be equipped
	 * @param weapon the weapon to be equipped
	 */
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	/**
	 * Return the armor equipped.
	 * @return the armor equipped
	 */
	public Armor getArmor() {
		return armor;
	}

	/**
	 * Set the armor to be equipped
	 * @param armor the armor to be equipped
	 */
	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	/**
	 * Print all the details of the character.
	 */
	public void printCharacterDetails()
	{
		String weaponPossessed = "";
		String shieldPossessed = "";
		String armorPossessed = "";
		int shieldLife = 0;
		if(weapon == null)
		{
			weaponPossessed = "No weapon";
		}
		else
		{
			weaponPossessed = weapon.getName();
		}
		
		if(shield == null)
		{
			shieldPossessed = "No shield";
		}
		else
		{
			shieldPossessed = shield.getName();
			shieldLife = shield.getLife();
		}
		
		if(armor == null)
		{
			armorPossessed = "No armor";
		}
		else
		{
			armorPossessed = armor.getName();
		}
		System.out.println("-------------------------------------------------------------");
		System.out.println("Health: " + health + " / " + maxHealth + "   \t\tWeapon:\t\t" + weaponPossessed);
		System.out.println("Total attack: " + totalAttack + "\t\tShield(life):\t" + shieldPossessed + "(" + shieldLife + ")");
		System.out.println("Total defence: " + totalDefence + "\t\tArmor:\t\t" + armorPossessed);
		System.out.println("-------------------------------------------------------------");
	}
	
	/**
	 * Print the numbers of each item the character in possess on the console.
	 */
	public void printAllItems()
	{
		int potion = 0;
		int gordonHead = 0;
		int dagger = 0;
		int sword = 0;
		int axe = 0;
		int shield = 0;
		int wolfArmor = 0;
		int rhinoArmor = 0;
		int key = 0;
		int wolfBone = 0;
		int wolfSkin = 0;
		int wolfBlood = 0;
		int rhinoBone = 0;
		int rhinoSkin = 0;
		int rhinoSkull = 0;
		int rhinoBlood = 0;
		
		for(Item item : items)
		{
			if(item instanceof GordonHead)
			{
				gordonHead++;
			}
			else if(item instanceof Potion)
			{
				potion++;
			}
			else if(item instanceof Dagger)
			{
				dagger++;
			}
			else if(item instanceof Sword)
			{
				sword++;
			}
			else if(item instanceof Axe)
			{
				axe++;
			}
			else if(item instanceof Shield)
			{
				shield++;
			}
			else if(item instanceof WolfArmor)
			{
				wolfArmor++;
			}
			else if(item instanceof RhinoArmor)
			{
				rhinoArmor++;
			}
			else if(item instanceof WolfBone)
			{
				wolfBone++;
			}
			else if(item instanceof WolfSkin)
			{
				wolfSkin++;
			}
			else if(item instanceof WolfBlood)
			{
				wolfBlood++;
			}
			else if(item instanceof RhinoBone)
			{
				rhinoBone++;
			}
			else if(item instanceof RhinoSkin)
			{
				rhinoSkin++;
			}
			else if(item instanceof RhinoSkull)
			{
				rhinoSkull++;
			}
			else if(item instanceof RhinoBlood)
			{
				rhinoBlood++;
			}
			else if(item instanceof Key)
			{
				key++;
			}
		}
		System.out.println("\n################################################################");
		System.out.println("Item\t\tQuantity\t| Item\t\t\tQuantity");
		System.out.println("\t\t\t\t|");
		System.out.println("Potion:\t\t" + potion + "\t\t| Gordon's Head:\t" + gordonHead);
		System.out.println("Dagger:\t\t" + dagger + "\t\t| Wolf Bone:\t\t" + wolfBone);
		System.out.println("Sword:\t\t" + sword + "\t\t| Wolf Skin:\t\t" + wolfSkin);
		System.out.println("Axe:\t\t" + axe + "\t\t| Wolf Blood:\t\t" + wolfBlood);
		System.out.println("Shield:\t\t" + shield + "\t\t| Rhino Bone:\t\t" + rhinoBone);
		System.out.println("Wolf Armor:\t" + wolfArmor + "\t\t| Rhino Skin:\t\t" + rhinoSkin);
		System.out.println("Rhino Armor:\t" + rhinoArmor + "\t\t| Rhino Skull:\t\t" + rhinoSkull);
		System.out.println("\t\t\t\t| Rhino Blood:\t\t" + rhinoBlood);
		System.out.println("\t\t\t\t| Key:\t\t\t" + key);
		System.out.println("################################################################\n");
	}
	
	/**
	 * Print the details of all the weapons possessed.
	 */
	public void printWeaponPossessed()
	{
		int number = 1;
		for(Item item : items)
		{
			if(item instanceof Weapon)
			{
				Weapon weapon = (Weapon)item;
				System.out.println(number + ".");
				weapon.printWeaponDetails();
				System.out.println();
				number++;
			}
		}
	}
	
	/**
	 * Print the details of all the shields possessed.
	 */
	public void printShieldPossessed()
	{
		int number = 1;
		for(Item item : items)
		{
			if(item instanceof Shield)
			{
				Shield weapon = (Shield)item;
				System.out.println(number + ".");
				weapon.printShieldDetails();
				System.out.println();
				number++;
			}
		}
	}
	
	/**
	 * Print the details of all the armors possessed.
	 */
	public void printArmorPossessed()
	{
		int number = 1;
		for(Item item : items)
		{
			if(item instanceof Armor)
			{
				Armor armor = (Armor)item;
				System.out.println(number + ".");
				armor.printArmorDetails();
				System.out.println();
				number++;
			}
		}
	}
	
	/**
	 * Calculate the total attack value of the character and return it.
	 * @return total attack of the character
	 */
	public int CalculateTotalAttack()
	{
		int calculatedTotalAttack = 0;
		if(weapon == null)
		{
			calculatedTotalAttack = baseAttack;
		}
		else
		{
			calculatedTotalAttack = baseAttack + weapon.getAttack();
		}
		return calculatedTotalAttack;
	}
	
	public int CalculateTotalDefence()
	{
		int calculatedTotalDefence = 0;
		if(armor == null)
		{
			calculatedTotalDefence = baseDefence;
		}
		else
		{
			calculatedTotalDefence = baseDefence + armor.getDefence();
		}
		return calculatedTotalDefence;
	}
	
}
