package coursework;

/**
 * A class represent Father.
 * @author Gordon Lai
 */
public class Father extends Character implements LivingCreatures{

	/**
	 * Constructor for Father.
	 * @param yCoordinate Starting y coordinate
	 * @param xCoordinate Starting x coordinate
	 * @param maxHealth Maximum health
	 * @param health Current health
	 * @param baseAttack base attack
	 * @param baseDefence base defence
	 * @param name name
	 */
	public Father(
		int yCoordinate, 
		int xCoordinate)
	{
		super(yCoordinate, xCoordinate, 100, 100, 0, 0, "Father");
	}
	
	/**
	 * Print the correct answer text on the console.
	 */
	public void printCorrectAnswer()
	{
		System.out.println("\n###################");
		System.out.println("# Correct answer! #");
		System.out.println("###################\n");
	}
	
	/**
	 * Print the wrong answer text on the console.
	 */
	public void printWrongAnswer()
	{
		System.out.println("\n#################");
		System.out.println("# Wrong answer! #");
		System.out.println("#################\n");
	}
	
	/**
	 * Print the text for father's brief on the console.
	 */
	public void printbriefing()
	{
		System.out.println("\n###########################################################");
		System.out.println("# You are not allow to go into the forest without your    #");
		System.out.println("# father's permission.                                    #");
		System.out.println("#                                                         #");
		System.out.println("# In order to gain the permission, you have to prove to   #");
		System.out.println("# your father that you have adequate knowledge by solving #");
		System.out.println("# his puzzle.                                             #");
		System.out.println("#                                                         #");
		System.out.println("# The puzzle is a sequance of 4 questions. Answer them    #");
		System.out.println("# correctly at once will classify as puzzle solved.       #");
		System.out.println("###########################################################\n");
	}
	
	/**
	 * Print the text for question 1 on the console.
	 */
	public void printQuestion1()
	{
		System.out.println("\n######################################################");
		System.out.println("# Father:                                            #");
		System.out.println("#                                                    #");
		System.out.println("# Question 1.                                        #");
		System.out.println("# What is the winning creteria in this world?        #");
		System.out.println("# 1. Beat Gordon and take his head                   #");
		System.out.println("# 2. Beat Jackie Chan and take his head              #");
		System.out.println("# 3. Beat Bruce Lee and take his head                #");
		System.out.println("######################################################\n");
	}
	
	/**
	 * Print the text for question 2 on the console.
	 */
	public void printQuestion2()
	{
		System.out.println("\n######################################################");
		System.out.println("# Father:                                            #");
		System.out.println("#                                                    #");
		System.out.println("# Question 2.                                        #");
		System.out.println("# What creteria is needed to enter the armory?       #");
		System.out.println("# 1. You have got father's permission                #");
		System.out.println("# 2. Killed at least one wild animal from the forest #");
		System.out.println("# 3. You have more than 100 gold in your pocket      #");
		System.out.println("######################################################\n");
	}
	
	/**
	 * Print the text for question 3 on the console.
	 */
	public void printQuestion3()
	{
		System.out.println("\n######################################################");
		System.out.println("# Father:                                            #");
		System.out.println("#                                                    #");
		System.out.println("# Question 3.                                        #");
		System.out.println("# What creteria is needed to enter the town?         #");
		System.out.println("# 1. Equipped with a sword                           #");
		System.out.println("# 2. Pay 100 gold once and for all                   #");
		System.out.println("# 3. Killed a rhino                                  #");
		System.out.println("######################################################\n");
	}
	
	/**
	 * Print the text for question 4 on the console.
	 */
	public void printQuestion4()
	{
		System.out.println("\n######################################################");
		System.out.println("# Father:                                            #");
		System.out.println("#                                                    #");
		System.out.println("# Question 4.                                        #");
		System.out.println("# What creteria is needed to enter the castle?       #");
		System.out.println("# 1. Smash the door with an axe                      #");
		System.out.println("# 2. Knock on the door                               #");
		System.out.println("# 3. Obtain the key from the Wizard                  #");
		System.out.println("######################################################\n");
	}
	
	/**
	 * Print the text for puzzle completion.
	 */
	public void printPuzzleCompletion()
	{
		System.out.println("\n######################################################");
		System.out.println("# Father:                                            #");
		System.out.println("#                                                    #");
		System.out.println("# Well done son! You are ready. I give you           #");
		System.out.println("# permission to enter the forest!                    #");
		System.out.println("######################################################\n");
	}
	
	/**
	 * Print the text when the player has failed to solve the puzzle.
	 */
	public void printFailed()
	{
		System.out.println("\n######################################################");
		System.out.println("# Father:                                            #");
		System.out.println("#                                                    #");
		System.out.println("# You are not ready yet son! Prepare yourself and    #");
		System.out.println("# come back to me later.                             #");
		System.out.println("######################################################\n");
	}
	
	/**
	 * Print the text when the player has already completed father's puzzle.
	 */
	public void printPermitted()
	{
		System.out.println("\n##########################################");
		System.out.println("# you are ready son! I am pround of you. #");
		System.out.println("# you can go into the forest now.        #");
		System.out.println("##########################################\n");
	}
	
	/**
	 * Print the text of father's gift.
	 */
	public void printGift()
	{
		System.out.println("\n######################################################");
		System.out.println("# You have recieved");
		System.out.println("#");
		System.out.println("# Dagger x 1\tgold x 10");
		System.out.println("# Potion x 3");
		System.out.println("######################################################\n");
	}

}
