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
//		Implement enough of the processCommand method on your
//
//		Spreadsheet class to handle the following four commands:
//
//		o cell inspection (e.g., A1). This should return the value at that cell; 
//
//		see above for examples.
//
//		o assignment to string values (e.g., A1 = “Hello”). This should 
//
//		return the String of the entire sheet (reflecting the new cell 
//
//		assignment), as returned by getGridText().
//
//		o clearing the entire sheet (e.g., clear). This should return the 
//
//		String of the entire sheet (reflecting the clear command), as 
//
//		returned by getGridText().
//
//		o clearing a particular cell (e.g., clear A1). This should return the 
//
//		String of the  entire sheet (reflecting the clear cell command), as 
//
//		returned by GetGridText().
//
//		Please break functionality up into different methods as appropriate.
		
		String [] input = command.split(" ",3);
		
		if (input[0].equals("clear")){
			// clear cell
			
		}
		
		else if (input.length > 2){
			//assign value
		}
		
		else {
			//inspect cell
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
		int row = loc.getRow();
		int column = loc.getCol();
		return textexcell [row] [column];
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
