package coursework;

/**
 * A class represent Wizard.
 * @author Gordon Lai
 */
public class Wizard extends Character implements LivingCreatures
{
	
	/**
	 * Constructor for a Wizard.
	 * @param yCoordinate Starting y coordinate
	 * @param xCoordinate Starting x coordinate
	 * @param maxHealth Maximum health
	 * @param health Current health
	 * @param baseAttack base attack
	 * @param baseDefence base defence
	 * @param name name
	 */
	public Wizard(
		int yCoordinate, 
		int xCoordinate)
	{
		super(yCoordinate, xCoordinate, 100, 100, 0, 0, "Wizard");
	}

	/**
	 * Print the text for wizard's brief on the console.
	 */
	public void printBriefing()
	{
		System.out.println("\n###########################################################");
		System.out.println("# The wizard is possessing the key for Gordon's room,     #");
		System.out.println("# you can beat the wizard by winning the two challenges   #");
		System.out.println("# in a row.                                               #");
		System.out.println("#                                                         #");
		System.out.println("# Challenge one: Dice rolling                             #");
		System.out.println("# Winning criteria: roll a number greater than the wizard #");
		System.out.println("#                                                         #");
		System.out.println("# Challenge two: Rock Paper Scissors                      #");
		System.out.println("# Winning criteria: beat the wizard                       #");
		System.out.println("#                                                         #");
		System.out.println("# Upon winning, you can take the key from the wizard.     #");
		System.out.println("###########################################################\n");
	}
	
	/**
	 * Print the text for challenge 1 on the console.
	 */
	public void printChallenge1()
	{
		System.out.println("\n###########################################################");
		System.out.println("# Challenge one: Dice rolling                             #");
		System.out.println("# Winning criteria: roll a number greater than the wizard #");
		System.out.println("###########################################################\n");
	}
	
	/**
	 * Print the text for the dice rolled of the wizard on the console.
	 */
	public void printRoll(int wizardRoll)
	{
		System.out.println("\n###########################################################");
		System.out.println("# The wizard has rolled: " + wizardRoll + "                                #");
		System.out.println("###########################################################\n");
	}
	
	/**
	 * Print the text for the result of the dice rolling on the console.
	 */
	public void printDiceRollingResult(int wizardRoll, int playerRoll)
	{
		System.out.println("\n#######################################");
		System.out.println("# The wizard has rolled: " + wizardRoll + "            #");
		System.out.println("# You have rolled: " + playerRoll + "                  #");
		System.out.println("#######################################\n");
	}
	
	/**
	 * Print the text for winning a challenge on the console.
	 */
	public void printWinChallenge()
	{
		System.out.println("\n###########################################");
		System.out.println("# You beat the wizard for this challenge! #");
		System.out.println("###########################################\n");
	}
	
	/**
	 * Print the text for draw for a challenge on the console.
	 */
	public void printDrawChallenge()
	{
		System.out.println("#######################################");
		System.out.println("# Draw                                #");
		System.out.println("#######################################");
	}
	
	/**
	 * Print the text for losing a challenge on the console.
	 */
	public void printLossChallenge()
	{
		System.out.println("\n#######################################");
		System.out.println("# You got beaten by the wizard        #");
		System.out.println("#######################################\n");
	}
	
	/**
	 * Print the text for challenge 2 on the console.
	 */
	public void printChallenge2()
	{
		System.out.println("\n######################################");
		System.out.println("# Challenge two: Rock Paper Scissors #");
		System.out.println("# Winning criteria: beat the wizard  #");
		System.out.println("######################################\n");
	}
	
	/**
	 * Print the text for the result of the rock paper scissors on the console.
	 */
	public void printRockPaperScissorsResult(String playerRockPaperScissors, String wizardRockPaperScissors)
	{
		System.out.println("\n#######################################");
		System.out.println("# You put: " + playerRockPaperScissors);
		System.out.println("# The wizard put: " + wizardRockPaperScissors);
		System.out.println("#######################################\n");
	}
	
	/**
	 * Print the text for beating the wizard entirely on the console.
	 */
	public void printBeatTheWizardEntirely()
	{
		System.out.println("\n#####################################");
		System.out.println("# You have beat the wizard entirely #");
		System.out.println("#####################################\n");
	}
	
	/**
	 * Print the text for Sorry try again later on the console.
	 */
	public void printSorryTryAgainLater()
	{
		System.out.println("\n##########################");
		System.out.println("# Sorry, try again later #");
		System.out.println("##########################\n");
	}
}
