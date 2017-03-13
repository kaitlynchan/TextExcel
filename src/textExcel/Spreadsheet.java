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
		String [] input = command.split(" ",3);
		
		if (input[0].toLowerCase().equals("clear")){
			// clear cell
			clearCell(input);
			return getGridText();
		}
		
		else if (input.length > 2){
			//assign value
			setCell(input);
			return getGridText();
		}
		
		else {
			//inspect cell
			SpreadsheetLocation placeholder = new SpreadsheetLocation(input[0].toUpperCase());
			return getCell(placeholder).fullCellText();
		}
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
		return textexcell [loc.getCol()] [loc.getRow()];
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
	
	public void clearCell (String [] input){
		if (input.length > 1){
			SpreadsheetLocation placeholder = new SpreadsheetLocation(input[1].toUpperCase());
			textexcell [placeholder.getCol()] [placeholder.getRow()] = new EmptyCell ();
			
		}
		else {
			for (int j = 0; j < 20; j++ ){
				for (int k = 0; k < 12; k++){
					textexcell[k][j] = new EmptyCell();
				}			
			}
		}
	}
	
	public void setCell (String [] input){
		SpreadsheetLocation placeholder = new SpreadsheetLocation(input[0].toUpperCase());
		String words = input[2].substring(1, (input[2].length()-1));
		textexcell [placeholder.getCol()] [placeholder.getRow()] = new TextCell (words);
	}
	
	
}
