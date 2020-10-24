package coursework;

/**
 * Interface for all fightable characters
 * @author Gordon Lai
 */
public interface Fightable {
	//Character
		public int getyCoordinate();
		public void setyCoordinate(int yCoordinate);
		public int getxCoordinate();
		public void setxCoordinate(int xCoordinate);
		public int getMaxHealth();
		public void setMaxHealth(int maxHealth);
		public int getHealth();
		public void setHealth(int health);
		public int getBaseAttack();
		public void setBaseAttack(int baseAttack);
		public int getTotalAttack();
		public void setTotalAttack(int attack);
		public int getBaseDefence();
		public void setBaseDefence(int baseDefence);
		public int getTotalDefence();
		public void setTotalDefence(int defence);
		public String getName();
		public void setName(String name);
		public void printCharacterDetails();
		public void printLoot();
}
