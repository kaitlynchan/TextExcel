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
		String toptext = "   ";
		for (char c = 'A'; c <= 'L';c++){
			toptext += "|" + c + "         ";	
		}
		toptext += "|";
		
		String fulltext = "\n";
		
		for (int j = 0; j < 20; j++ ){
			fulltext += ((j+1) + "   ").substring(0, 3);
			fulltext += "|";
			for (int k = 0; k < 12; k++){
				fulltext += textexcell[k][j].abbreviatedCellText() + "|";
			}			
			fulltext += "\n";
		}
		return toptext+fulltext;
	}

}
