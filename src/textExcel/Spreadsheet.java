package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{	
	
	private Cell [] [] textexcell;
	//Spreadsheet Constructor
	public Spreadsheet () {
		textexcell = new Cell [12] [20];
		for (int i = 0; i < 12; i++){
			for (int j = 0; j< 20; j++){
				textexcell [i][j] = new EmptyCell();
			}
		}
			//fill with empthycells
	}
	
	@Override
	public String processCommand(String command)
	{
		// TODO Auto-generated method stub split
		String [] arr = command.split(" ");
		
		if (arr.length > 2){
			
			
		}
		if (arr[0].equals("clear")){
			
		}
		return command;
	}

	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return 12;
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
		String fulltext;
		String toptext = "   ";
		for (char c = 'A'; c <= 'L';c++){
			toptext += "|" + c;
			for (int i = 0; i < 9; i++){
				toptext += " ";
			}
		}
		toptext += "|";
		
		fulltext = "\n";
		for (int j = 0; j < 9; j++ ){
			fulltext += (j+1) + "  |";
			for (int k = 0; k < 12; k++){
				fulltext += textexcell[k][j].abbreviatedCellText() + "|";
			}
			
			fulltext += "\n";
		}
		for (int k = 9; k < 20; k++){
			fulltext += (k+1) + " |";
			for (int l = 0; l < 12; l++){
				fulltext += textexcell[l] [k].abbreviatedCellText() + "|";
			}
			fulltext += "\n";
		}
		// TODO Auto-generated method stub string containing the entire sheet grid in the form described in the spec.
		
		return toptext+fulltext;
	}

}
