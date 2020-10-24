package coursework;

/**
 * A class represent the game board.
 * @author Gordon Lai
 */
public class GameBoard 
{
	private int numberOfRows;
	private int numberOfColumns;
	private Area[][] areas;
	
	/**
	 * A constructor for a game board.
	 */
	public GameBoard() 
	{
		numberOfRows = 5;
		numberOfColumns = 5;
		areas = new Area[numberOfRows][numberOfColumns];
	}

	/**
	 * Return the number of rows of the areas array.
	 * @return the number of rows of the areas array
	 */
	public int getNumberOfRows() 
	{
		return numberOfRows;
	}

	/**
	 * Set the number of rows of the areas array.
	 * @param numberOfRows the number of rows of the areas array to set.
	 */
	public void setNumberOfRows(int numberOfRows) 
	{
		this.numberOfRows = numberOfRows;
	}
	
	/**
	 * Return the number of columns of the areas array.
	 * @return the number of columns of the areas array
	 */
	public int getNumberOfColumns() 
	{
		return numberOfColumns;
	}

	/**
	 * Set the number of columns of the areas array.
	 * @param numberOfColumns the number of columns of the areas array to set.
	 */
	public void setNumberOfColumns(int numberOfColumns) 
	{
		this.numberOfColumns = numberOfColumns;
	}

	/**
	 * Return the areas array.
	 * @return the areas array
	 */
	public Area[][] getAreas() 
	{
		return areas;
	}

	/**
	 * Set the areas array.
	 * @param areas the areas array to set.
	 */
	public void setAreas(Area[][] areas) 
	{
		this.areas = areas;
	}
	
	/**
	 * Fill the areas array up with Area objects.
	 */
	public void gameBoardSetup()
	{
		for(int row = 0; row < numberOfRows; row++)
		{
			for(int column = 0; column < numberOfColumns; column++)
			{
				if(	   (row <= 1 && column <= 1)
					|| (row == 0 && column == 2) )
				{
					areas[row][column] = new Area(row, column);
					areas[row][column].setType("Village");
				}
				else if(row == 1 && column == 2)
				{
					areas[row][column] = new Area(row, column);
					areas[row][column].setType("Armory");
				}
				else if(column >= 3)
				{
					areas[row][column] = new Area(row, column);
					areas[row][column].setType("Forest");
				}
				else if(row >= 2 && column == 0)
				{
					areas[row][column] = new Area(row, column);
					areas[row][column].setType("Castle");
				}
				else
				{
					areas[row][column] = new Area(row, column);
					areas[row][column].setType("Town");
				}
			}
		}
	}
	
	/**
	 * Print all the details of the game board.
	 */
	public void printGameBoardDetails()
	{
		String[][] l = new String[numberOfRows][numberOfColumns];
		for(int row = 0; row < numberOfRows; row++)
		{
			for(int column = 0; column < numberOfColumns; column++)
			{
				LivingCreatures livingCreatures = areas[row][column].getLivingCreature();
				if(livingCreatures == null)
				{
					l[row][column] = "    ";
				}
				else if(livingCreatures instanceof Player)
				{
					l[row][column] = "(PL)";
				}
				else if(livingCreatures instanceof Gordon)
				{
					l[row][column] = "(GD)";
				}
				else if(livingCreatures instanceof Wizard)
				{
					l[row][column] = "(WZ)";
				}
				else if(livingCreatures instanceof Father)
				{
					l[row][column] = "(FA)";
				}
				else if(livingCreatures instanceof Wolf)
				{
					l[row][column] = "(WF)";
				}
				else if(livingCreatures instanceof Rhino)
				{
					l[row][column] = "(RN)";
				}
			}
		}
		System.out.println("####################################");
		System.out.println("# " + l[0][0] + " | " + l[0][1] + " | " + l[0][2] + " / " + l[0][3] + " | " + l[0][4] + " #\t(PL) = Player");
		System.out.println("#      |      |      /      |      #\t(GD) = Gordon");
		System.out.println("#---Village---+//////#------+------#\t(WZ) = Wizard");
		System.out.println("# " + l[1][0] + " | " + l[1][1] + " / " + l[1][2] + " # " + l[1][3] + " | " + l[1][4] + " #\t(FA) = Father");
		System.out.println("#      |      /Armory#      |      #\t(WF) = Wolf");
		System.out.println("######################----Forest---#\t(RN) = Rhino");
		System.out.println("# " + l[2][0] + " / " + l[2][1] + " | " + l[2][2] + " # " + l[2][3] + " | " + l[2][4] + " #");
		System.out.println("#      /      |      #      |      #");
		System.out.println("#------#------+------#----Forest---#");
		System.out.println("# " + l[3][0] + " # " + l[3][1] + " | " + l[3][2] + " # " + l[3][3] + " | " + l[3][4] + " #");
		System.out.println("#      #      |      #      |      #");
		System.out.println("#Castle#-----Town----#------+------#\t------ = Cell boundary");
		System.out.println("# " + l[4][0] + " # " + l[4][1] + " | " + l[4][2] + " / " + l[4][3] + " | " + l[4][4] + " #\t###### = Wall");
		System.out.println("#      #      |      /      |      #\t////// = Door");
		System.out.println("####################################");
	}
}
