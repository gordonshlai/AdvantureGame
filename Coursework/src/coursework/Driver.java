package coursework;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.Iterator;

/**
 * A class represent the driver of the game.
 * @author Gordon Lai
 */
public class Driver 
{
	private Scanner in;
	private Random random;
	private GameBoard gameBoard;
	private Player player;
	private Gordon gordon;
	private Father father;
	private Wizard wizard;
	
	/**
	 * A constructor for a driver of the game.
	 */
	public Driver()
	{
		in = new Scanner(System.in);
		random = new Random();
		gameBoard = new GameBoard();
		player = new Player(0, 0, 100, 100, 10, 0);
		gordon = new Gordon(4, 0, 100, 100, 50, 50);
		father = new Father(1, 0);
		wizard = new Wizard(3, 1);
	}
	
	/**
	 * To run the game
	 */
	public void runTheGame()
	{
		gameBoard.gameBoardSetup();
		
		allocateCoordinate(player);
//		Potion potion1 = new Potion();
//		player.getItems().add(potion1);
//		Potion potion2 = new Potion();
//		player.getItems().add(potion2);
//		Sword sword = new Sword();
//		player.getItems().add(sword);
		Axe axe1 = new Axe();
		player.getItems().add(axe1);
		RhinoArmor rhinoArmor1 = new RhinoArmor();
		player.getItems().add(rhinoArmor1);
		player.setGold(100);
		Shield shield1 = new Shield();
		player.getItems().add(shield1);
		
		allocateCoordinate(gordon);
		GordonHead gordonHead = new GordonHead();
		
		allocateCoordinate(father);
		
		allocateCoordinate(wizard);
		Key key = new Key();
		wizard.getItems().add(key);
		
		GAME:
		while(		player.getHealth() > 0
				&& !player.getItems().contains(gordonHead))
		{
			System.out.println("**************************    Messages up to date from here    *****************************\n");
			randomAnimalGeneration();
			gameBoard.printGameBoardDetails();
			System.out.println("Your current status:");
			player.printCharacterDetails();
			System.out.println();
			System.out.println("What would you like to do?");
			System.out.println("1. Move");
			System.out.println("2. Check materials possessing");
			System.out.println("3. Gear up");
			System.out.println("4. Take a potion");
			System.out.print("Please enter the number corresponding to choice of action: ");
			String game = in.nextLine();
			System.out.println("============================================================================================");
			System.out.println("========================       New messages start from here      ===========================");
			
			if(game.equals("1"))/*GAME loop. Option 1. Move*/
			{
				boolean moved = false;
				/*MOVE loop*/
				while(!moved)
				{
					System.out.println("Which direction would you like to go?");
					System.out.println("1. North");
					System.out.println("2. East");
					System.out.println("3. South");
					System.out.println("4. West");
					System.out.println("5. Cancel");
					System.out.print("Please enter the number corresponding to the direction you want to go: ");
					String move = in.nextLine();
					System.out.println("============================================================================================");
					System.out.println("========================       New messages start from here      ===========================");
					
					int y = player.getyCoordinate();
					int x = player.getxCoordinate();
					if(    move.equals("1")
						|| move.equals("2")
						|| move.equals("3")
						|| move.equals("4") )/*MOVE loop. Option 1.North, 2.East, 3.South and 4.West*/
					{
						if(	   (move.equals("1") && ((y == 0) || (y == 2 && x <= 2))) 
							|| (move.equals("2") && ((x == (gameBoard.getNumberOfColumns() - 1)) || (y >= 3 && x == 0) || (y >= 1 && y <= 3 && x == 2)))
							|| (move.equals("3") && ((y == ((gameBoard.getNumberOfRows() - 1))) || (y == 1 && x <= 2)))
							|| (move.equals("4") && ((x == 0) || (y >= 3 && x == 1) || (y >= 1 && y <= 3 && x == 3))) )
						{
							printWalkedIntoAWall();
							acknowledgement();
							continue;
						}
						else
						{
							deallocateCoordinate(player);
							moved = player.move(move);
							y = player.getyCoordinate();
							x = player.getxCoordinate();
							
							if(gameBoard.getAreas()[y][x].getType().equals("Forest"))
							{
								if(!player.isFatherPermitted())
								{
									System.out.println("\n####################################################");
									System.out.println("# Sorry, you are not allowed to enter the Forest.  #");
									System.out.println("#                                                  #");
									System.out.println("# You have to have your father's permission        #");
									System.out.println("# in order to get in the forest.                   #");
									System.out.println("# Go find your father first.                       #");
									System.out.println("####################################################\n");
									acknowledgement();
									player.reverseMove(move);
									allocateCoordinate(player);
									break;
								}
							}
							else if(gameBoard.getAreas()[y][x].getType().equals("Armory"))
							{
								if(!player.isKilledAnimal())
								{
									System.out.println("\n####################################################");
									System.out.println("# Sorry, you are not allowed to enter the armory.  #");
									System.out.println("#                                                  #");
									System.out.println("# You have to kill at least one wild animal from   #");
									System.out.println("# the forest in order to get in the shop           #");
									System.out.println("####################################################\n");
									acknowledgement();
									player.reverseMove(move);
									allocateCoordinate(player);
									break;
								}
								else
								{
									System.out.println("\n##################################################");
									System.out.println("# You have entered the armory.                   #");
									System.out.println("##################################################\n");
									System.out.println("You have the following materials in possessed:");
									System.out.println("\n\tGold: " + player.getGold());
									player.printAllItems();
									
									boolean doneWithArmory = false;
									/*ARMORY loop*/
									while(!doneWithArmory)
									{
										System.out.println("What would you like to do?");
										System.out.println("1. Get weapon");
										System.out.println("2. Get shield");
										System.out.println("3. Get armor");
										System.out.println("4. Get potion");
										System.out.println("5. Check materials possessing");
										System.out.println("6. Exit the armory");
										System.out.print("Please enter the number corresponding to your choice of action: ");
										String armory = in.nextLine();
										System.out.println("============================================================================================");
										System.out.println("========================       New messages start from here      ===========================");
										
										if(armory.equals("1"))/*ARMORY loop. Option 1. Get weapon*/
										{
											boolean doneWithGetWeapon = false;
											/*GET WEAPON loop*/
											while(!doneWithGetWeapon)
											{
												System.out.println("Which weapon would you like to have?");
												System.out.println("---------------------------------------------------");
												System.out.println("1. | Sword");
												System.out.println("   |                           Required materials:");
												System.out.println("   | Attack Boost: 30          Wolf bone  x1");
												System.out.println("   |                           Rhino bone x1");
												System.out.println("   |                           Gold      x20");
												System.out.println("---------------------------------------------------");
												System.out.println("---------------------------------------------------");
												System.out.println("2. | Axe");
												System.out.println("   |                           Required materials:");
												System.out.println("   | Attack Boost: 50          Wolf bone  x3");
												System.out.println("   |                           Rhino bone x3");
												System.out.println("   |                           Gold       x50");
												System.out.println("---------------------------------------------------");
												System.out.println("3. Cancel");
												System.out.print("Please enter the number corresponding to your choice: ");
												String getWeapon = in.nextLine();
												System.out.println("============================================================================================");
												System.out.println("========================       New messages start from here      ===========================");
												
												int wolfBone = 0;
												int rhinoBone = 0;
												for(Item item : player.getItems())
												{
													
													if(item instanceof WolfBone)
													{
														wolfBone++;
													}
													else if(item instanceof RhinoBone)
													{
														rhinoBone++;
													}
												}
												
												if(getWeapon.equals("1"))/*GET WEAPON loop. Option 1. Sword*/
												{
													int wolfBoneRequired = 1;
													int rhinoBoneRequired = 1;
													if(    wolfBone < wolfBoneRequired 
														|| rhinoBone < rhinoBoneRequired 
														|| player.getGold() < 20)
													{
														printNotEnoughMaterial();
														acknowledgement();
														break;
														
													}
													else
													{
														removeItemsForGetWeapon(wolfBoneRequired, rhinoBoneRequired);
														Sword sword = new Sword();
														player.getItems().add(sword);
														System.out.println("\n#############################");
														System.out.println("# You have Obtained a sword #");
														System.out.println("#############################\n");
														acknowledgement();
														break;
													}
												}
												else if(getWeapon.equals("2"))/*GET WEAPON loop. Option 2. Axe*/
												{
													int wolfBoneRequired = 3;
													int rhinoBoneRequired = 3;
													if(    wolfBone < wolfBoneRequired 
														|| rhinoBone < rhinoBoneRequired 
														|| player.getGold() < 50)
													{
														printNotEnoughMaterial();
														acknowledgement();
														break;
													}
													else
													{
														removeItemsForGetWeapon(wolfBoneRequired, rhinoBoneRequired);
														Axe axe = new Axe();
														player.getItems().add(axe);
														System.out.println("\n############################");
														System.out.println("# You have Obtained an Axe #");
														System.out.println("############################\n");
														acknowledgement();
														break;
													}
												}
												else if(getWeapon.equals("3"))/*GET WEAPON loop. Option 3. Cancel*/
												{
													break;
												}
												else/*GET WEAPON loop. Invalid input*/
												{
													printInvalidInput();
													continue;
												}
											}/*End of GET WEAPON loop*/
											
										}
										else if(armory.equals("2"))/*ARMORY loop. Option 2. Get shield*/
										{
											boolean doneWithGetShield = false;
											/*GET SHIELD loop*/
											while(!doneWithGetShield)
											{
												System.out.println("---------------------------------------------");
												System.out.println("Bone Shield:");
												System.out.println("                        Required materials:");
												System.out.println("Life of shield: 5       Wolf bone   x1");
												System.out.println("                        Rhino Bone  x1");
												System.out.println("                        Rhino Skull x2");
												System.out.println("                        Gold        x50");
												System.out.println("---------------------------------------------");
												System.out.println("The shield can protect you from an attack.");
												System.out.println("When you use it during a fight, you won't take any damage from an attack.");
												System.out.println("The life of the shield indicates how many times you can use it before it breaks.\n");
												System.out.println("Do you want to make a shield?");
												System.out.println("1. Yes");
												System.out.println("2. No");
												System.out.print("Please enter the number corresponding to your choice: ");
												String getShield = in.nextLine();
												System.out.println("============================================================================================");
												System.out.println("========================       New messages start from here      ===========================");
												
												int wolfBone = 0;
												int rhinoBone = 0;
												int rhinoSkull = 0;
												for(Item item : player.getItems())
												{
													
													if(item instanceof WolfBone)
													{
														wolfBone++;
													}
													else if(item instanceof RhinoBone)
													{
														rhinoBone++;
													}
													else if(item instanceof RhinoSkull)
													{
														rhinoSkull++;
													}
												}
												
												if(getShield.equals("1"))/*GET SHIELD loop. Option 1. Yes*/
												{
													int wolfBoneRequired = 1;
													int rhinoBoneRequired = 1;
													int rhinoSkullRquired = 2;
													if(    wolfBone < wolfBoneRequired 
														|| rhinoBone < rhinoBoneRequired 
														|| rhinoSkull < rhinoSkullRquired
														|| player.getGold() < 50)
													{
														printNotEnoughMaterial();
														acknowledgement();
														break;
														
													}
													else
													{
														removeItemsForGetShield(wolfBoneRequired, rhinoBoneRequired, rhinoSkullRquired);
														Shield shield = new Shield();
														player.getItems().add(shield);
														System.out.println("\n#############################");
														System.out.println("# You have Obtained a shield #");
														System.out.println("#############################\n");
														acknowledgement();
														break;
													}
												}
												else if(getShield.equals("2"))/*GET SHIELD loop. Option 1. No*/
												{
													break;
												}
												else/*GET SHIELD loop. Invalid input*/
												{
													printInvalidInput();
													continue;
												}
											}/*End of GET SHIELD loop*/
										
										}
										else if(armory.equals("3"))/*ARMORY loop. Option 3. Get armour*/
										{
											boolean doneWithGetArmor = false;
											/*GET ARMOR loop*/
											while(!doneWithGetArmor)
											{
												System.out.println("Which armor would you like to have?");
												System.out.println("---------------------------------------------------");
												System.out.println("1. | Wolf Armor");
												System.out.println("   |                           Required materials:");
												System.out.println("   | Defence Boost: 10         Wolf bone  x2");
												System.out.println("   |                           Wolf skin  x2");
												System.out.println("   |                           Gold      x20");
												System.out.println("---------------------------------------------------");
												System.out.println("---------------------------------------------------");
												System.out.println("2. | Rhino Armor");
												System.out.println("   |                           Required materials:");
												System.out.println("   | Defence Boost: 20         Rhino bone x3");
												System.out.println("   |                           Rhino skin x3");
												System.out.println("   |                           Gold       x50");
												System.out.println("---------------------------------------------------");
												System.out.println("3. Cancel");
												System.out.print("Please enter the number corresponding to your choice: ");
												String getArmor = in.nextLine();
												System.out.println("============================================================================================");
												System.out.println("========================       New messages start from here      ===========================");
												
												int wolfBone = 0;
												int wolfSkin = 0;
												int rhinoBone = 0;
												int rhinoSkin = 0;
												for(Item item : player.getItems())
												{
													if(item instanceof WolfBone)
													{
														wolfBone++;
													}
													else if(item instanceof WolfSkin)
													{
														wolfSkin++;
													}
													else if(item instanceof RhinoBone)
													{
														rhinoBone++;
													}
													else if(item instanceof RhinoSkin)
													{
														rhinoSkin++;
													}
												}
												
												if(getArmor.equals("1"))/*GET ARMOR loop. Option 1. Wolf Armor*/
												{
													int wolfBoneRequired = 2;
													int wolfSkinRequired = 2;
													if(    wolfBone < wolfBoneRequired 
														|| wolfSkin < wolfSkinRequired 
														|| player.getGold() < 20)
													{
														printNotEnoughMaterial();
														acknowledgement();
														break;
													}
													else
													{
														removeItemsForGetWolfArmor(wolfBoneRequired, wolfSkinRequired);
														WolfArmor wolfArmor = new WolfArmor();
														player.getItems().add(wolfArmor);
														System.out.println("\n##################################");
														System.out.println("# You have Obtained a wolf armor #");
														System.out.println("##################################\n");
														acknowledgement();
														break;
													}
												}
												else if(getArmor.equals("2"))/*GET ARMOR loop. Option 2. Rhino Armor*/
												{
													int rhinoBoneRequired = 3;
													int rhinoSkinRequired = 3;
													if(    rhinoSkin < rhinoBoneRequired 
														|| rhinoBone < rhinoSkinRequired 
														|| player.getGold() < 50)
													{
														printNotEnoughMaterial();
														acknowledgement();
														break;
													}
													else
													{
														removeItemsForGetRhinoArmor(rhinoBoneRequired, rhinoSkinRequired);
														RhinoArmor rhinoArmor = new RhinoArmor();
														player.getItems().add(rhinoArmor);
														System.out.println("\n####################################");
														System.out.println("# You have Obtained an rhino armor #");
														System.out.println("####################################\n");
														acknowledgement();
														break;
													}
												}
												else if(getArmor.equals("3"))/*GET ARMOR loop. Option 3. Cancel*/
												{
													break;
												}
												else/*GET ARMOR loop. Invalid input*/
												{
													printInvalidInput();
													continue;
												}
											}/*End of GET ARMOR loop*/
										}
										else if(armory.equals("4"))/*ARMORY loop. Option 4. Get potion*/
										{
											boolean doneWithGetPotion = false;
											/*GET POTION loop*/
											while(!doneWithGetPotion)
											{
												System.out.println("---------------------------------------------");
												System.out.println("Potion:");
												System.out.println("                        Required materials:");
												System.out.println("Health Recovery: 30     Wolf blood  x1");
												System.out.println("                        Rhino Blood x1");
												System.out.println("                        Gold        x10");
												System.out.println("---------------------------------------------");
												System.out.println("Do you want to make a potion?");
												System.out.println("1. Yes");
												System.out.println("2. No");
												System.out.print("Please enter the number corresponding to your choice: ");
												String getPotion = in.nextLine();
												System.out.println("============================================================================================");
												System.out.println("========================       New messages start from here      ===========================");
												
												int wolfBlood = 0;
												int rhinoBlood = 0;
												for(Item item : player.getItems())
												{
													
													if(item instanceof WolfBlood)
													{
														wolfBlood++;
													}
													else if(item instanceof RhinoBlood)
													{
														rhinoBlood++;
													}
												}
												
												if(getPotion.equals("1"))/*GET POTION loop. Option 1. Yes*/
												{
													int wolfBloodRequired = 1;
													int rhinoBloodRequired = 1;
													if(    wolfBlood < wolfBloodRequired 
														|| rhinoBlood < rhinoBloodRequired 
														|| player.getGold() < 10)
													{
														printNotEnoughMaterial();
														acknowledgement();
														break;
														
													}
													else
													{
														removeItemsForGetPotion(wolfBloodRequired, rhinoBloodRequired);
														Potion potion = new Potion();
														player.getItems().add(potion);
														System.out.println("\n##############################");
														System.out.println("# You have Obtained a potion #");
														System.out.println("##############################\n");
														acknowledgement();
														break;
													}
												}
												else if(getPotion.equals("2"))/*GET POTION loop. Option 1. No*/
												{
													break;
												}
												else/*GET POTION loop. Invalid input*/
												{
													printInvalidInput();
													continue;
												}
											}/*End of GET POTION loop*/
										}
										else if(armory.equals("5"))/*ARMORY loop. Option 5. Check materials possessing*/
										{
											System.out.println("\n\t Gold: " + player.getGold());
											player.printAllItems();
											acknowledgement();
											continue;
										}
										else if(armory.equals("6"))/*ARMORY loop. Option 6. Exit the armory*/
										{
											player.reverseMove(move);
											allocateCoordinate(player);
											break;
										}
										else/*ARMORY loop. Invalid input*/
										{
											printInvalidInput();
											continue;
										}
									}/*End of ARMORY loop*/
									
								}
							}
							else if(gameBoard.getAreas()[y][x].getType().equals("Town"))
							{
								if(!player.isPaidToEnterTown())
								{
									int goldRequired = 100;
									System.out.println("\n##################################################");
									System.out.println("# Please pay " + goldRequired + " gold to gain the permission to  #");
									System.out.println("# enter the town. You only need to pay once.     #");
									System.out.println("##################################################\n");
									acknowledgement();
									
									boolean doneWithTown = false;
									/*TOWN loop*/
									while(!doneWithTown)
									{
										System.out.println("What would you like to do?");
										System.out.println("1. Pay " + goldRequired + " gold");
										System.out.println("2. Check amount of gold possessed");
										System.out.println("3. Turn away");
										System.out.print("Please enter the number corresponding to your action: ");
										String pay = in.nextLine();
										System.out.println("============================================================================================");
										System.out.println("========================       New messages start from here      ===========================");
										
										if(pay.equals("1"))/*TOWN loop. Option 1. Pay "goldRequired" gold*/
										{
											if(player.getGold() < goldRequired)
											{
												System.out.println("\n##################################################");
												System.out.println("# Sorry! You don't have enought gold.");
												System.out.println("# You are required to pay " + goldRequired + " gold to enter the town.");
												System.out.println("# You have " + (goldRequired - player.getGold()) + " gold short.");
												System.out.println("##################################################\n");
												acknowledgement();
												player.reverseMove(move);
												allocateCoordinate(player);
												doneWithTown = true;
												break;
											}
											else
											{
												player.setGold(player.getGold() - goldRequired);
												player.setPaidToEnterTown(true);
												System.out.println("\n##################################################");
												System.out.println("# You paid " + goldRequired + " gold.");
												System.out.println("##################################################\n");
												acknowledgement();
												doneWithTown = true;
												break;
											}
										}
										else if(pay.equals("2"))/*TOWN loop. Option 2. Check amount of gold possessed*/
										{
											player.printGold();
											acknowledgement();
											continue;
										}
										else if(pay.equals("3"))/*TOWN loop. Option 3. Turn away*/
										{
											player.reverseMove(move);
											allocateCoordinate(player);
											doneWithTown = true;
											break;
										}
										else/*TOWN loop. Invalid input*/
										{
											printInvalidInput();
											continue;
										}
									}/*End of TOWN loop*/
								}
							}
							else if(gameBoard.getAreas()[y][x].getType().equals("Castle"))
							{
								boolean possessedKey = false;
								for(Item item : player.getItems())
								{
									if(item instanceof Key)
									{
										possessedKey = true;
									}
								}
								
								if(!possessedKey)
								{
									System.out.println("\n#######################################################");
									System.out.println("# Sorry, you don't have the key to enter the castle.  #");
									System.out.println("#                                                     #");
									System.out.println("# The wizard is having the key, beat him to get it.   #");
									System.out.println("#######################################################\n");
									acknowledgement();
									player.reverseMove(move);
									allocateCoordinate(player);
									break;
								}
							}
							
							
							if( gameBoard.getAreas()[y][x].getLivingCreature() != null )
							{
								LivingCreatures livingCreature = gameBoard.getAreas()[y][x].getLivingCreature();
								
								System.out.println("\n########################################");
								System.out.println("You are encountering " + livingCreature.getName());
								System.out.println("########################################\n");
								
								if(livingCreature instanceof Fightable)
								{
									Fightable enemy = (Fightable)livingCreature;
									
									printShowLoot(enemy);
									
									/*FIGHT loop*/
									while(enemy.getHealth() > 0)
									{
										System.out.println("Your specs:");
										player.printCharacterDetails();
										System.out.println();
										System.out.println(enemy.getName() + "'s specs:");
										enemy.printCharacterDetails();
										System.out.println();
										
										System.out.println("What would you like to do?");
										System.out.println("1. Fight");
										System.out.println("2. Take a potion");
										System.out.println("3. Run");
										System.out.print("Please enter the number corresponding to your action: ");
										String fight = in.nextLine();
										System.out.println("============================================================================================");
										System.out.println("========================       New messages start from here      ===========================");
										
										if(fight.equals("1")) /*FIGHT loop. Option 1. Fight*/
										{
											int playerHealth = player.getHealth();
											int playerAttack = player.getTotalAttack();
											int playerDefence = player.getTotalDefence();
											int enemyHealth = enemy.getHealth();
											int enemyAttack = enemy.getTotalAttack();
											int enemyDefence = enemy.getTotalDefence();
											
											int damageTakenByPlayer = (enemyAttack - playerDefence);
											if(damageTakenByPlayer < 0)
											{
												damageTakenByPlayer = 0;
											}
											
											int damageTakenByEnermy = (playerAttack - enemyDefence);
											if(damageTakenByEnermy < 0)
											{
												damageTakenByEnermy = 0;
											}
											
											if(player.getShield() != null)
											{
												boolean doneWithShield = false;
												/*SHIELD loop*/
												while(!doneWithShield)
												{
													System.out.println("When you use your shield, you won't take any damage.");
													System.out.println("You can use your sheild for " + player.getShield().getLife() + " more times before it breaks.\n");
													System.out.println("Do you want to use your shield?");
													System.out.println("1. Yes");
													System.out.println("2. No");
													System.out.print("Please enter the number corresponding to your action: ");
													String useShield = in.nextLine();
													System.out.println("============================================================================================");
													System.out.println("========================       New messages start from here      ===========================");
													
													if(useShield.equals("1"))/*SHIELD loop. Option 1. Yes*/
													{
														damageTakenByPlayer = 0;
														player.getShield().setLife(player.getShield().getLife() - 1);
														doneWithShield = true;
														if(player.getShield().getLife() == 0)
														{
															System.out.println("\n#########################");
															System.out.println("# Your shield is broken #");
															System.out.println("#########################\n");
															acknowledgement();
															player.getItems().remove(player.getShield());
															player.setShield(null);
														}
														break;
													}
													else if(useShield.equals("2"))/*SHIELD loop. Option 2. No*/
													{
														doneWithShield = true;
														break;
													}
													else/*SHIELD loop. Invalid input.*/
													{
														printInvalidInput();
														continue;
													}
												}
											}
											
											playerHealth -= damageTakenByPlayer;
											enemyHealth -= damageTakenByEnermy;
											player.setHealth(playerHealth);
											enemy.setHealth(enemyHealth);
											
											System.out.println("\n########################################");
											System.out.println("You have taken " + damageTakenByPlayer + " points of damage.");
											System.out.println(enemy.getName() + " has taken " + damageTakenByEnermy + " points of damage.");
											System.out.println("########################################\n");
											acknowledgement();
											
											if(playerHealth < 1)
											{
												System.out.println("\n#####################################");
												System.out.println("# Your health has went down to zero #");
												System.out.println("#          You are dead!            #");
												System.out.println("#####################################\n");
												acknowledgement();
												break;
											}
										}
										else if(fight.equals("2"))/*FIGHT loop. Option 2. Take a potion*/
										{
											takeAPotion();
										}
										else if(fight.equals("3"))/*FIGHT loop. Option 3. Run*/
										{
											player.reverseMove(move);
											allocateCoordinate(player);
											printYouRanAway();
											acknowledgement();
											continue GAME;
										}
										else/*FIGHT loop. Invalid input*/
										{
											printInvalidInput();
											continue;
										}
									}/*End of FIGHT loop*/
									
									if(player.getHealth() < 1)
									{
										System.out.println("\n###############");
										System.out.println("#!!!!!!!!!!!!!#");
										System.out.println("#! GAME OVER !#");
										System.out.println("#!!!!!!!!!!!!!#");
										System.out.println("###############\n");
										acknowledgement();
										break;
									}
									else
									{
										System.out.println("\n####################################");
										System.out.println("You killed " + livingCreature.getName());
										System.out.println("####################################\n");
										deallocateCoordinate(livingCreature);
										
										if(enemy instanceof Wolf)
										{
											WolfBone wolfBone = new WolfBone();
											WolfSkin wolfSkin = new WolfSkin();
											WolfBlood wolfBlood = new WolfBlood();
											player.getItems().add(wolfBone);
											player.getItems().add(wolfSkin);
											player.getItems().add(wolfBlood);
											player.setGold(player.getGold() + 10);
											player.setKilledAnimal(true);
											
											printObtainLoot(enemy);
											acknowledgement();
										}
										else if(enemy instanceof Rhino)
										{
											RhinoBone rhinoBone = new RhinoBone();
											RhinoSkin rhinoSkin = new RhinoSkin();
											RhinoSkull rhinoSkull = new RhinoSkull();
											RhinoBlood rhinoBlood = new RhinoBlood();
											player.getItems().add(rhinoBone);
											player.getItems().add(rhinoSkin);
											player.getItems().add(rhinoSkull);
											player.getItems().add(rhinoBlood);
											player.setGold(player.getGold() + 20);
											player.setKilledAnimal(true);
											
											printObtainLoot(enemy);
											acknowledgement();
										}
										else if(enemy instanceof Gordon)
										{
											player.getItems().add(gordonHead);
											printObtainLoot(enemy);
											acknowledgement();
											System.out.println("\n###############################");
											System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
											System.out.println("#| Congradulations! YOU WON! |#");
											System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
											System.out.println("###############################\n");
											acknowledgement();
											break;
										}
									}
								}/*End of encountering Fightable*/
								else if(livingCreature instanceof Father)
								{
									if(player.isFatherPermitted())
									{
										father.printPermitted();
										acknowledgement();
										player.reverseMove(move);
										allocateCoordinate(player);
										break;
									}
									else
									{
										father.printbriefing();
										acknowledgement();
										
										int correctAnswers = 0;
										boolean doneWithQuestion1 = false;
										/*QUESTION 1 loop*/
										while(!doneWithQuestion1)
										{
											father.printQuestion1();
											System.out.print("Please enter the letter corresponding to your answer: ");
											String question1 = in.nextLine();
											System.out.println("============================================================================================");
											System.out.println("========================       New messages start from here      ===========================");
											if(question1.equals("1"))
											{
												father.printCorrectAnswer();
												acknowledgement();
												doneWithQuestion1 = true;
												correctAnswers++;
												break;
											}
											else if( question1.equals("2") || question1.equals("3") )
											{
												father.printWrongAnswer();
												acknowledgement();
												doneWithQuestion1 = true;
												break;
											}
											else
											{
												printInvalidInput();
												continue;
											}
										}/*End of QUESTION 1 loop*/
										
										if(correctAnswers == 1)
										{
											boolean doneWithQuestion2 = false;
											/*QUESTION 2 loop*/
											while(!doneWithQuestion2)
											{
												father.printQuestion2();
												System.out.print("Please enter the letter corresponding to your answer: ");
												String question2 = in.nextLine();
												System.out.println("============================================================================================");
												System.out.println("========================       New messages start from here      ===========================");
												if(question2.equals("2"))
												{
													father.printCorrectAnswer();
													acknowledgement();
													doneWithQuestion2 = true;
													correctAnswers++;
													break;
												}
												else if( question2.equals("1") || question2.equals("3") )
												{
													father.printWrongAnswer();
													acknowledgement();
													doneWithQuestion2 = true;
													break;
												}
												else
												{
													printInvalidInput();
													continue;
												}
											}/*End of QUESTION 2 loop*/
										}
										
										if(correctAnswers == 2)
										{
											boolean doneWithQuestion3 = false;
											/*QUESTION 3 loop*/
											while(!doneWithQuestion3)
											{
												father.printQuestion3();
												System.out.print("Please enter the letter corresponding to your answer: ");
												String question3 = in.nextLine();
												System.out.println("============================================================================================");
												System.out.println("========================       New messages start from here      ===========================");
												if(question3.equals("2"))
												{
													father.printCorrectAnswer();
													acknowledgement();
													doneWithQuestion3 = true;
													correctAnswers++;
													break;
												}
												else if( question3.equals("1") || question3.equals("3") )
												{
													father.printWrongAnswer();
													acknowledgement();
													doneWithQuestion3 = true;
													break;
												}
												else
												{
													printInvalidInput();
													continue;
												}
											}/*End of QUESTION 3 loop*/
										}
										
										if(correctAnswers == 3)
										{
											boolean doneWithQuestion4 = false;
											/*QUESTION 4 loop*/
											while(!doneWithQuestion4)
											{
												father.printQuestion4();
												System.out.print("Please enter the letter corresponding to your answer: ");
												String question4 = in.nextLine();
												System.out.println("============================================================================================");
												System.out.println("========================       New messages start from here      ===========================");
												if(question4.equals("3"))
												{
													father.printCorrectAnswer();
													acknowledgement();
													doneWithQuestion4 = true;
													correctAnswers++;
													break;
												}
												else if( question4.equals("1") || question4.equals("2") )
												{
													father.printWrongAnswer();
													acknowledgement();
													doneWithQuestion4 = true;
													break;
												}
												else
												{
													printInvalidInput();
													continue;
												}
											}/*End of QUESTION 4 loop*/
										}
										
										if(correctAnswers == 4)
										{
											player.reverseMove(move);
											allocateCoordinate(player);
											player.setFatherPermitted(true);
											father.printPuzzleCompletion();
											acknowledgement();
											
											Dagger dagger = new Dagger();
											Potion fatherPotion1 = new Potion();
											Potion fatherPotion2 = new Potion();
											Potion fatherPotion3 = new Potion();
											player.getItems().add(dagger);
											player.getItems().add(fatherPotion1);
											player.getItems().add(fatherPotion2);
											player.getItems().add(fatherPotion3);
											player.setGold(player.getGold() + 10);
											father.printGift();
											acknowledgement();
											
											break;
										}
										else
										{
											player.reverseMove(move);
											allocateCoordinate(player);
											father.printFailed();
											acknowledgement();
											break;
										}
										
									}
								}/*End of encountering Father*/
								
								else if(livingCreature instanceof Wizard)
								{
									wizard.printBriefing();
									
									System.out.println("What would you like to do?");
									System.out.println("1. Challenge the wizard");
									System.out.println("2. Run");
									System.out.print("Please enter the number corresponding to your action: ");
									String wizardChallenge = in.nextLine();
									System.out.println("============================================================================================");
									System.out.println("========================       New messages start from here      ===========================");
									
									int won = 0;
									
									boolean doneWithWizardChallenge = false;
									/*WIZARD loop*/
									while(!doneWithWizardChallenge)
									{
										if(wizardChallenge.equals("1"))/*WIZARD loop. Option 2. Run*/
										{
											wizard.printChallenge1();
											
											boolean doneWithDiceRolling = false;
											/*DICE ROLLING loop*/
											while(!doneWithDiceRolling)
											{
												int wizardRoll = random.nextInt(6) + 1;
												wizard.printRoll(wizardRoll);
												
												System.out.println("What would you like to do?");
												System.out.println("1. Roll a dice");
												System.out.println("2. Run");
												System.out.print("Please enter the number corresponding to your action: ");
												String diceRolling = in.nextLine();
												System.out.println("============================================================================================");
												System.out.println("========================       New messages start from here      ===========================");
												
												if(diceRolling.equals("1"))/*DICE ROLLING loop. Option 1. Roll a dice*/
												{
													int playerRoll = random.nextInt(6) + 1;
													wizard.printDiceRollingResult(wizardRoll, playerRoll);
													if(playerRoll > wizardRoll)
													{
														wizard.printWinChallenge();
														acknowledgement();
														won++;
														doneWithDiceRolling = true;
														break;
													}
													else if(playerRoll == wizardRoll)
													{
														wizard.printDrawChallenge();
														acknowledgement();
														continue;
													}
													else
													{
														wizard.printLossChallenge();
														acknowledgement();
														doneWithDiceRolling = true;
														doneWithWizardChallenge = true;
														break;
													}
												}
												else if(diceRolling.equals("2"))/*DICE ROLLING loop. Option 2. Run*/
												{
													player.reverseMove(move);
													allocateCoordinate(player);
													doneWithWizardChallenge = true;
													printYouRanAway();
													acknowledgement();
													break;
												}
												else/*DICE ROLLING loop. invalid input*/
												{
													printInvalidInput();
													continue;
												}
											}/*End of DICE ROLLING loop*/
											
											if(won == 1)
											{
												wizard.printChallenge2();
												
												boolean doneWithrockPaperScissors = false;
												/*ROCK PAPER SCISSORS loop*/
												while(!doneWithrockPaperScissors)
												{
													System.out.println("What would you like to go for?");
													System.out.println("1. Rock");
													System.out.println("2. Paper");
													System.out.println("3. Scissors");
													System.out.println("4. Give up and run away");
													System.out.print("Please enter the number corresponding to your action: ");
													String rockPaperScissors = in.nextLine();
													System.out.println("============================================================================================");
													System.out.println("========================       New messages start from here      ===========================");
													
													String playerRockPaperScissors = "";
													if(rockPaperScissors.equals("1"))/*ROCK PAPER SCISSORS loop. Option 1. Rock*/
													{
														playerRockPaperScissors = "Rock";
													}
													else if(rockPaperScissors.equals("2"))/*ROCK PAPER SCISSORS loop. Option 2. Paper*/
													{
														playerRockPaperScissors = "Paper";
													}
													else if(rockPaperScissors.equals("3"))/*ROCK PAPER SCISSORS loop. Option 3. Scissors*/
													{
														playerRockPaperScissors = "Scissors";
													}
													else if(rockPaperScissors.equals("4"))/*ROCK PAPER SCISSORS loop. Option 4. Give up and run away*/
													{
														player.reverseMove(move);
														allocateCoordinate(player);
														printYouRanAway();
														continue GAME;
													}
													else/*ROCK PAPER SCISSORS loop. invalid input*/
													{
														printInvalidInput();
														continue;
													}
													
													String wizardRockPaperScissors = "";
													int wizardRockPaperScissorsNum = random.nextInt(3);
													if(wizardRockPaperScissorsNum == 0)
													{
														wizardRockPaperScissors = "Rock";
													}
													else if (wizardRockPaperScissorsNum == 1)
													{
														wizardRockPaperScissors = "Paper";
													}
													else
													{
														wizardRockPaperScissors = "Scissors";
													}
													
													wizard.printRockPaperScissorsResult(playerRockPaperScissors, wizardRockPaperScissors);
													
													if(	   (playerRockPaperScissors.equals("Rock") && wizardRockPaperScissors.equals("Scissors"))
														|| (playerRockPaperScissors.equals("Paper") && wizardRockPaperScissors.equals("Rock")) 
														|| (playerRockPaperScissors.equals("Scissors") && wizardRockPaperScissors.equals("Paper")) )
													{
														wizard.printWinChallenge();
														acknowledgement();
														won++;
														doneWithrockPaperScissors = true;
														doneWithWizardChallenge = true;
														break;
													}
													else if(playerRockPaperScissors == wizardRockPaperScissors)
													{
														wizard.printDrawChallenge();
														acknowledgement();
														continue;
													}
													else
													{
														wizard.printLossChallenge();
														acknowledgement();
														doneWithrockPaperScissors = true;
														doneWithWizardChallenge = true;
														break;
													}
												}/*End of ROCK PAPER SCISSORS loop*/
											}
											else
											{
												break;
											}
											
										}
										else if(wizardChallenge.equals("2"))/*WIZARD loop. Option 2. Run*/
										{
											player.reverseMove(move);
											allocateCoordinate(player);
											printYouRanAway();
											acknowledgement();
											continue GAME;
										}
										else/*WIZARD loop. invalid input*/
										{
											printInvalidInput();
											continue;
										}
									}/*End of WIZARD loop*/
									
									if(won == 2)
									{
										wizard.printBeatTheWizardEntirely();
										
										player.getItems().add(key);
										System.out.println("\n#############################");
										System.out.println("# You have obtained the key #");
										System.out.println("#############################\n");
										acknowledgement();
										
										player.reverseMove(move);
										allocateCoordinate(player);
										doneWithWizardChallenge = true;
										break;
									}
									else
									{
										wizard.printSorryTryAgainLater();
										acknowledgement();
										
										player.reverseMove(move);
										allocateCoordinate(player);
										doneWithWizardChallenge = true;
										break;
									}
								}
							}
						}
					}
					else if(move.equals("5"))/*MOVE loop. Option 5. Cancel*/
					{
						break;
					}
					else/*MOVE loop invalid input*/
					{
						printInvalidInput();
						continue;
					}
					allocateCoordinate(player);
				}/*End of MOVE loop*/
			}
			else if(game.equals("2"))/*GAME loop. Option 2. Check materials possessing*/
			{
				System.out.println("\n\t Gold: " + player.getGold());
				player.printAllItems();
				acknowledgement();
				continue;
			}
			else if (game.equals("3"))/*GAME loop. Option 4. Gear up*/
			{
				boolean gearedUp = false;
				/*GEAR loop*/
				while(!gearedUp)
				{
					System.out.println("What would you like to do?");
					System.out.println("1. Equip a weapon");
					System.out.println("2. Unequip a weapon");
					System.out.println("3. Equip a shield");
					System.out.println("4. Unequip a shield");
					System.out.println("5. Equip a armor");
					System.out.println("6. Unequip a armor");
					System.out.println("7. Cancel");
					System.out.print("Please enter the number corresponding to choice of action: ");
					String gear = in.nextLine();
					System.out.println("============================================================================================");
					System.out.println("========================       New messages start from here      ===========================");
					
					if(gear.equals("1"))/*GEAR loop. Option 1. Equip a weapon*/
					{
						int numberOfWeapons = 0;
						for(Item item : player.getItems())
						{
							if(item instanceof Weapon)
							{
								numberOfWeapons++;
							}
						}
						if(numberOfWeapons < 1)
						{
							System.out.println("######################################");
							System.out.println("# Sorry, you have no weapon to equip #");
							System.out.println("######################################");
							acknowledgement();
							continue;
						}
						else
						{
							boolean equipped = false;
							/*WEAPON EQUIP loop*/
							while(!equipped)
							{
								System.out.println("Which weapon would you like to equip?");
								System.out.println("You have the folowing weapons:");
								player.printWeaponPossessed();
								System.out.print("Please enter the number corresponding to the weapon you want to equip: ");
								String weaponChoice = in.nextLine();
								System.out.println("============================================================================================");
								System.out.println("========================       New messages start from here      ===========================");
								
								ArrayList<Item> weapons = new ArrayList<Item>();
								ArrayList<String> indexes = new ArrayList<String>();
								int index = 0;
								for(Item item : player.getItems())
								{
									if(item instanceof Weapon)
									{
										String str = (Integer.toString(index + 1));
										weapons.add(index, item);
										indexes.add(str);
										index++;
									}
								}
								boolean valid = false;
								for(String string : indexes)
								{
									if(weaponChoice.equals(string))
									{
										int num = (Integer.parseInt(string) - 1);
										Weapon weap = (Weapon)(weapons.get(num));
										player.setWeapon(weap);
										System.out.println("\n###################");
										System.out.println("# " + weap.getName() + " Equipped");
										System.out.println("###################\n");
										acknowledgement();
										player.setTotalAttack(player.CalculateTotalAttack());
										gearedUp = true;
										equipped = true;
										valid = true;
									}
								}
								if(!valid)
								{
									printInvalidInput();
									continue;
								}
							}/*End of WEAPON EQUIP loop*/
						}
					}
					else if(gear.equals("2"))/*GEAR loop. Option 2. Unequip a weapon*/
					{
						if(player.getWeapon() == null)
						{
							System.out.println("\n#############################################");
							System.out.println("# You have no weapon equipped at the moment #");
							System.out.println("#############################################\n");
							acknowledgement();
							continue;
						}
						else
						{
							player.setWeapon(null);
							player.setTotalAttack(player.CalculateTotalAttack());
							System.out.println("\n#####################");
							System.out.println("# Weapon unequipped #");
							System.out.println("#####################\n");
							acknowledgement();
							gearedUp = true;
						}
					}
					else if(gear.equals("3"))/*GEAR loop. Option 3. Equip a shield*/
					{
						int numberOfShields = 0;
						for(Item item : player.getItems())
						{
							if(item instanceof Shield)
							{
								numberOfShields++;
							}
						}
						if(numberOfShields < 1)
						{
							System.out.println("######################################");
							System.out.println("# Sorry, you have no shield to equip #");
							System.out.println("######################################");
							acknowledgement();
							continue;
						}
						else
						{
							boolean equipped = false;
							/*WEAPON EQUIP loop*/
							while(!equipped)
							{
								System.out.println("Which shield would you like to equip?");
								System.out.println("You have the folowing shields:");
								player.printShieldPossessed();
								System.out.print("Please enter the number corresponding to the shield you want to equip: ");
								String shieldChoice = in.nextLine();
								System.out.println("============================================================================================");
								System.out.println("========================       New messages start from here      ===========================");
								
								ArrayList<Item> shields = new ArrayList<Item>();
								ArrayList<String> indexes = new ArrayList<String>();
								int index = 0;
								for(Item item : player.getItems())
								{
									if(item instanceof Shield)
									{
										String str = (Integer.toString(index + 1));
										shields.add(index, item);
										indexes.add(str);
										index++;
									}
								}
								boolean valid = false;
								for(String string : indexes)
								{
									if(shieldChoice.equals(string))
									{
										int num = (Integer.parseInt(string) - 1);
										Shield shie = (Shield)(shields.get(num));
										player.setShield(shie);
										System.out.println("\n###################");
										System.out.println("# " + shie.getName() + " Equipped");
										System.out.println("###################\n");
										acknowledgement();
										gearedUp = true;
										equipped = true;
										valid = true;
									}
								}
								if(!valid)
								{
									printInvalidInput();
									continue;
								}
							}/*End of WEAPON EQUIP loop*/
						}
					}
					else if(gear.equals("4"))/*GEAR loop. Option 4. Unequip a shield*/
					{
						if(player.getShield() == null)
						{
							System.out.println("\n#############################################");
							System.out.println("# You have no shield equipped at the moment #");
							System.out.println("#############################################\n");
							acknowledgement();
							continue;
						}
						else
						{
							player.setShield(null);
							System.out.println("\n#####################");
							System.out.println("# Shield unequipped #");
							System.out.println("#####################\n");
							acknowledgement();
							gearedUp = true;
						}
					}
					else if(gear.equals("5"))/*GEAR loop. Option 5. Equip a armor*/
					{
						int numberOfArmors = 0;
						for(Item item : player.getItems())
						{
							if(item instanceof Armor)
							{
								numberOfArmors++;
							}
						}
						if(numberOfArmors < 1)
						{
							System.out.println("######################################");
							System.out.println("# Sorry, you have no armor to equip  #");
							System.out.println("######################################");
							acknowledgement();
							continue;
						}
						else
						{
							boolean equipped = false;
							/*ARMOR EQUIP loop*/
							while(!equipped)
							{
								System.out.println("Which armor would you like to equip?");
								System.out.println("You have the folowing armors:");
								player.printArmorPossessed();
								System.out.print("Please enter the number corresponding to the armor you want to equip: ");
								String armorChoice = in.nextLine();
								System.out.println("============================================================================================");
								System.out.println("========================       New messages start from here      ===========================");
								
								ArrayList<Item> armors = new ArrayList<Item>();
								ArrayList<String> indexes = new ArrayList<String>();
								int index = 0;
								for(Item item : player.getItems())
								{
									if(item instanceof Armor)
									{
										String str = (Integer.toString(index + 1));
										armors.add(index, item);
										indexes.add(str);
										index++;
									}
								}
								boolean valid = false;
								for(String string : indexes)
								{
									if(armorChoice.equals(string))
									{
										int num = (Integer.parseInt(string) - 1);
										Armor arm = (Armor)(armors.get(num));
										player.setArmor(arm);
										System.out.println("\n###################");
										System.out.println("# " + arm.getName() + " Equipped");
										System.out.println("###################\n");
										acknowledgement();
										player.setTotalDefence(player.CalculateTotalDefence());
										gearedUp = true;
										equipped = true;
										valid = true;
									}
								}
								if(!valid)
								{
									printInvalidInput();
									continue;
								}
							}/*End of ARMOR EQUIP loop*/
						}
					}
					else if(gear.equals("6"))/*GEAR loop. Option 6. Unequip a armor*/
					{
						if(player.getArmor() == null)
						{
							System.out.println("\n#############################################");
							System.out.println("# You have no armor equipped at the moment  #");
							System.out.println("#############################################\n");
							acknowledgement();
							continue;
						}
						else
						{
							player.setArmor(null);
							player.setTotalDefence(player.CalculateTotalDefence());
							System.out.println("\n#####################");
							System.out.println("# Armor unequipped  #");
							System.out.println("#####################\n");
							acknowledgement();
							gearedUp = true;
						}
					}
					else if(gear.equals("7"))/*GEAR loop. Option 7. Cancel*/
					{
						break;
					}
					else/*GEAR loop. Invalid input*/
					{
						printInvalidInput();
						continue;
					}
				}/*End of GEAR loop.*/
			}
			else if(game.equals("4"))/*GAME loop. Option 4. Take a potion*/
			{
				takeAPotion();
			}
			else/*GAME loop. Invalid input*/
			{
				printInvalidInput();
				continue;
			}
		} /*End of GAME loop*/
		System.out.println("\n####################################");
		System.out.println("# Thank you very much for playing! #");
		System.out.println("####################################\n");
	}/*End of runTheGame()*/
	
	/**
	 * Deallocate the LivingCreature object from the areas array.
	 * @param player the player character to deallocate
	 */
	public void deallocateCoordinate(LivingCreatures livingCreatures)
	{
		int y = livingCreatures.getyCoordinate();
		int x = livingCreatures.getxCoordinate();
		
		gameBoard.getAreas()[y][x].setLivingCreature(null);
	}
	
	/**
	 * Allocate the LivingCreature object to the areas array.
	 * @param player the player character to allocate
	 */
	public void allocateCoordinate(LivingCreatures livingCreatures)
	{
		int y = livingCreatures.getyCoordinate();
		int x = livingCreatures.getxCoordinate();
		
		gameBoard.getAreas()[y][x].setLivingCreature(livingCreatures);
	}
	
	/**
	 * To check acknowledgement of the user from the text print on the console
	 */
	public void acknowledgement()
	{
		boolean acknowledged = false;
		while(acknowledged == false)
		{
			System.out.println("Press Enter to acknowledge.");
			String acknowledgement = in.nextLine();
			System.out.println("============================================================================================");
			System.out.println("========================       New messages start from here      ===========================");
			
			if(acknowledgement.equals(""))
			{
				acknowledged = true;
				break;
			}
			
			else
			{
				printInvalidInput();
				continue;
			}
			
		}
	}
	
	/**
	 * Print the texts on the console to inform the player for invalid input.
	 */
	public void printInvalidInput()
	{
		System.out.println("\n#################");
		System.out.println("# Invalid input #");
		System.out.println("#################\n");
	}
	
	/**
	 * Print the texts on the console to inform the player that you walked into a wall.
	 */
	public void printWalkedIntoAWall()
	{
		System.out.println("\n#############################################################################");
		System.out.println("# Sorry, you can't move in this direction, there is a wall in front of you. #");
		System.out.println("#############################################################################\n");
	}
	
	/**
	 * Print the texts on the console to inform the player that you ran away.
	 */
	public void printYouRanAway()
	{
		System.out.println();
		System.out.println("#################");
		System.out.println("# You ran away. #");
		System.out.println("#################");
		System.out.println();
	}
	
	/**
	 * Print the text that the player don't have enough material to do something.
	 */
	public void printNotEnoughMaterial()
	{
		System.out.println("\n##################################################");
		System.out.println("# Sorry you don't have enough material.          #");
		System.out.println("##################################################\n");
	}
	
	public void printShowLoot(Fightable enemy)
	{
		System.out.println("\n################################################");
		System.out.println("The loot after killing " + enemy.getName() + "\n");
		enemy.printLoot();
		System.out.println("################################################\n");
	}
	
	public void printObtainLoot(Fightable enemy)
	{
		System.out.println("\n################################################");
		System.out.println("# You have obtained:\n");
		enemy.printLoot();
		System.out.println("################################################\n");
	}
	
	/**
	 * Remove the required items from the player's items ArrayList for getting a weapon.
	 */
	public void removeItemsForGetWeapon(int wolfBoneRequired, int rhinoBoneRequired)
	{
		int wolfBoneRemoved = 0;
		int rhinoBoneRemoved = 0;
		Iterator<Item> iterator = player.getItems().iterator();
		while(iterator.hasNext())
		{
			Item item = iterator.next();
			if(    wolfBoneRemoved < wolfBoneRequired 
				&& item instanceof WolfBone)
			{
				iterator.remove();
				wolfBoneRemoved++;
			}
			
			if(    rhinoBoneRemoved < rhinoBoneRequired
				&& item instanceof RhinoBone)
			{
				iterator.remove();
				rhinoBoneRemoved++;
			}
		}
	}
	
	/**
	 * Remove the required items from the player's items ArrayList for getting a wolf armor.
	 */
	public void removeItemsForGetWolfArmor(int wolfBoneRequired, int wolfSkinRequired)
	{
		int wolfBoneRemoved = 0;
		int wolfSkinRemoved = 0;
		Iterator<Item> iterator = player.getItems().iterator();
		while(iterator.hasNext())
		{
			Item item = iterator.next();
			if(    wolfBoneRemoved < wolfBoneRequired 
				&& item instanceof WolfBone)
			{
				iterator.remove();
				wolfBoneRemoved++;
			}
			
			if(    wolfSkinRemoved < wolfSkinRequired
				&& item instanceof WolfSkin)
			{
				iterator.remove();
				wolfSkinRemoved++;
			}
		}
	}
	/**
	 * Remove the required items from the player's items ArrayList for getting a wolf armor.
	 */
	public void removeItemsForGetRhinoArmor(int rhinoBoneRequired, int rhinoSkinRequired)
	{
		int rhinoBoneRemoved = 0;
		int rhinoSkinRemoved = 0;
		Iterator<Item> iterator = player.getItems().iterator();
		while(iterator.hasNext())
		{
			Item item = iterator.next();
			if(    rhinoBoneRemoved < rhinoBoneRequired 
				&& item instanceof WolfBone)
			{
				iterator.remove();
				rhinoBoneRemoved++;
			}
			
			if(    rhinoSkinRemoved < rhinoSkinRequired
				&& item instanceof RhinoSkin)
			{
				iterator.remove();
				rhinoSkinRemoved++;
			}
		}
	}
	
	/**
	 * Remove the required items from the player's items ArrayList for getting a potion.
	 */
	public void removeItemsForGetPotion(int wolfBloodRequired, int rhinoBloodRequired)
	{
		int wolfBloodRemoved = 0;
		int rhinoBloodRemoved = 0;
		Iterator<Item> iterator = player.getItems().iterator();
		while(iterator.hasNext())
		{
			Item item = iterator.next();
			if(    wolfBloodRemoved < wolfBloodRequired 
				&& item instanceof WolfBlood)
			{
				iterator.remove();
				wolfBloodRemoved++;
			}
			
			if(    rhinoBloodRemoved < rhinoBloodRequired
				&& item instanceof RhinoBlood)
			{
				iterator.remove();
				rhinoBloodRemoved++;
			}
		}
	}
	
	/**
	 * Remove the required items from the player's items ArrayList for getting a shield.
	 */
	public void removeItemsForGetShield(int wolfBoneRequired, int rhinoBoneRequired, int rhinoSkullRequired)
	{
		int wolfBoneRemoved = 0;
		int rhinoBoneRemoved = 0;
		int rhinoSkullRemoved = 0;
		Iterator<Item> iterator = player.getItems().iterator();
		while(iterator.hasNext())
		{
			Item item = iterator.next();
			if(    wolfBoneRemoved < wolfBoneRequired 
				&& item instanceof WolfBone)
			{
				iterator.remove();
				wolfBoneRemoved++;
			}
			
			if(    rhinoBoneRemoved < rhinoBoneRequired
				&& item instanceof RhinoBone)
			{
				iterator.remove();
				rhinoBoneRemoved++;
			}
			
			if(    rhinoSkullRemoved < rhinoSkullRequired
				&& item instanceof RhinoSkull)
			{
				iterator.remove();
				rhinoSkullRemoved++;
			}
		}
	}
	
	public void randomAnimalGeneration()
	{
		ArrayList<Area> emptyAreas = new ArrayList<Area>();
		int numberOfWolf = 0;
		int numberOfRhino = 0;
		for(int row = 0; row < 5; row++)
		{
			for(int column = 3; column <= 4; column++)
			{
				LivingCreatures livingCreature = gameBoard.getAreas()[row][column].getLivingCreature();
				Area area = gameBoard.getAreas()[row][column];
				if(livingCreature == null)
				{
					emptyAreas.add(area);
				}
				
				if(livingCreature instanceof Wolf)
				{
					numberOfWolf++;
				}
				else if(livingCreature instanceof Rhino)
				{
					numberOfRhino++;
				}
			}
		}
		
		Collections.shuffle(emptyAreas);
		int totalNumberOfAnimal = numberOfWolf + numberOfRhino;
		if(totalNumberOfAnimal < 4)
		{
			for(int i = 0; i <= (4 - totalNumberOfAnimal); i++)
			{
				int y = emptyAreas.get(i).getyCoordinate();
				int x = emptyAreas.get(i).getxCoordinate();
				Area emptyArea = emptyAreas.get(i);
				if(numberOfWolf < 2)
				{
					LivingCreatures wolf = new Wolf(y, x);
					emptyArea.setLivingCreature(wolf);
					numberOfWolf++;
				}
				else if(numberOfRhino < 2)
				{
					LivingCreatures rhino = new Rhino(y, x);
					emptyArea.setLivingCreature(rhino);
					numberOfRhino++;
				}
			}
		}
	}
	
	public void takeAPotion()
	{
		Potion potion = null;
		boolean containsPotion = false;
		for(Item item : player.getItems())
		{
			if(item instanceof Potion)
			{
				containsPotion = true;
				Potion potion1 = (Potion)item;
				potion = potion1;
			}
		}
		
		if(containsPotion)
		{
			int originalHealth = player.getHealth();
			int potionRecovery = potion.getHealthRecovery();
			int newHealth = originalHealth + potionRecovery;
			if(newHealth > player.getMaxHealth())
			{
				newHealth = player.getMaxHealth();
				player.setHealth(newHealth);
			}
			else
			{
				player.setHealth(newHealth);
			}
			
			System.out.println("\n#########################################");
			System.out.println("You have recovered " + (newHealth - originalHealth) + " point of health");
			System.out.println("#########################################\n");
			
			player.getItems().remove(potion);
			
			int numberOfPotions = 0;
			for(Item item : player.getItems())
			{
				if(item instanceof Potion)
				{
					numberOfPotions++;
				}
			}
			
			System.out.println("\n#########################################");
			System.out.println("You have " + numberOfPotions + " potions left");
			System.out.println("#########################################\n");
			acknowledgement();
		}
		else
		{
			System.out.println("\n##############################");
			System.out.println("# You don't have any potions #");
			System.out.println("##############################\n");
			acknowledgement();
		}
	}
}
