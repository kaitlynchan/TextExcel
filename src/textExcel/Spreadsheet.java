package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{	
	int rows;
	int columns;
	
	//Spreadsheet Constructor
	public Spreadsheet () {
		rows = 20;
		columns = 12;
		//EmptyCell [] [] textexcell = new EmptyCell [rows] [columns];
	}
	
	@Override
	public String processCommand(String command)
	{
		// TODO Auto-generated method stub
		return command;
	}

	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return this.rows;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return this.columns;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
