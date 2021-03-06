package textExcel;
import java.util.*;
import java.io.*;

// Update this file with your own code.


public class Spreadsheet implements Grid
{	
	//create array of Cell objects called textexcell
	private Cell [] [] textexcell;

	//Spreadsheet Constructor
	public Spreadsheet () {
		textexcell = new Cell [12] [20];
		for (int i = 0; i < 12; i++){
			for (int j = 0; j< 20; j++){
				textexcell [i][j] = new EmptyCell(); //initializes with all empty cells
			}
		}
	}
	@Override
	public String processCommand(String command)
	{	
		if (command.length()==0){ //if no command, catches 
			return "";
		}

		String [] input = command.split(" ",3); //divide up command input into an array
		String cell = input[0];
		
		if (!(command.indexOf("save")<0)){ //save the spreadsheet
			System.out.println("saved to: " + input[1]);
			return saveSpreadsheet(input[1]);
		}
		if (!(command.indexOf("open")<0)){ //open up the spreadsheet
			System.out.println("opened from: " + input[1]);
			return openSpreadsheet(input[1]); 
		}
		if (input[0].toLowerCase().equals("clear")){ //run the clearCell method
			clearCell(input);
			return getGridText();
		}
		else if (input.length > 2){ //run the setCell method to assign value
		
			setCell(input);
			return getGridText();
		}
		else { //run the getCell method to inspect cell
			SpreadsheetLocation placeholder = new SpreadsheetLocation(input[0].toUpperCase());
			return getCell(placeholder).fullCellText();
		}
	}

	@Override
	public int getRows() //number of rows in array
	{
		return 20;
	}

	@Override
	public int getCols() //number of columns in array
	{
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{	
		return textexcell [loc.getCol()] [loc.getRow()]; //uses location interface to get the coordinates of the cell
	}

	@Override
	public String getGridText() //formats the spreadsheet and prints
	{		
		String toptext = "   "; //prints the header
		for (char c = 'A'; c <= 'L';c++){
			toptext += "|" + c + "         ";	
		}
		toptext += "|";
		
		String fulltext = "\n";	//prints the cells	
		for (int j = 0; j < 20; j++ ){
			fulltext += ((j+1) + "   ").substring(0, 3);
			fulltext += "|";
			for (int k = 0; k < 12; k++){
				fulltext += textexcell[k][j].abbreviatedCellText() + "|"; //puts the 10 char cell text into each grid box
			}			
			fulltext += "\n";
		}
		return toptext+fulltext; //returns full spreadsheet
	}
	
	public void clearCell (String [] input){
		if (input.length > 1){ //if "clear" all
			SpreadsheetLocation placeholder = new SpreadsheetLocation(input[1].toUpperCase());
			textexcell [placeholder.getCol()] [placeholder.getRow()] = new EmptyCell (); //make everything an empty cell
		}
		else {
			for (int j = 0; j < 20; j++ ){
				for (int k = 0; k < 12; k++){
					textexcell[k][j] = new EmptyCell(); //target the specific cell to empty
				}			
			}
		}
	}
	
	public void setCell (String [] input){ //assign the cell a value
		
		String testInput = input[2]; 
		SpreadsheetLocation placeholder = new SpreadsheetLocation(input[0].toUpperCase());
		if (testInput.charAt(0) == 34){ //if a text cell, take the string between the quotes and fill the array element with a text cell
			String words = input[2].substring(1, (input[2].length()-1));
			textexcell [placeholder.getCol()] [placeholder.getRow()] = new TextCell (words);
		}
		else if (testInput.substring(testInput.length()-1).equals("%")){ //if a percent cell
			textexcell [placeholder.getCol()] [placeholder.getRow()] = new PercentCell (testInput);	
		}
		else if (testInput.substring(testInput.length()-1).equals(")")){ //if a formula cell
			textexcell [placeholder.getCol()] [placeholder.getRow()] = new FormulaCell (testInput, textexcell);	
		}
		else { // if a value cell
			textexcell [placeholder.getCol()] [placeholder.getRow()] = new ValueCell (testInput);	
		}
	}
	

	public String saveSpreadsheet (String fileName){ //takes the grid and saves it to a file in the text excel directory
		
	     PrintStream outputFile;
	     try {
	            outputFile = new PrintStream(new File(fileName));  //write the new file            
	     }
	     catch (FileNotFoundException e) {   	 
	            return "File not found: " + fileName;   //throws error if file does not exist
	     }
	     for (int j = 0; j < 20; j++){  	 
	    	 for (int k = 0; k < 12; k++){
	    		 if (!(textexcell[k][j] instanceof EmptyCell)){ //checks to make sure only cells with data are saved.		 
	    			 outputFile.println((char)(k+65) + "" + (j+1) + "," + textexcell[k][j].getClass().getSimpleName() + ","+ textexcell[k][j].fullCellText());
	    			 //prints the cell to the output file in the format Location,Type,Full Value
	    		 }
			 }	 
	     }
	     outputFile.close(); //closes the file
		 return "";
	}
	
	private String openSpreadsheet(String fileName) {
		
	     Scanner inputFile;
	     try {
	            inputFile = new Scanner(new File(fileName)); //open up the file from the directory
	     }
	     catch (FileNotFoundException e) {
	            return "File not found: " + fileName; //throws error if file does not exist
	     }
	     while (inputFile.hasNextLine()) { //reads the file line by line
             String [] fileContent = inputFile.nextLine().split(",", 3); //splits each line of the file into location, type, and full text value
             if (fileContent[1].equals("PercentCell")){ //changes the formatting if it is a percent cell for proper use of setCell()
            	 String percentVal = "" + (Double.parseDouble(fileContent[2])*100);
            	fileContent[2] = (percentVal)+"%";
             }
             setCell(fileContent); //uses previous setCell method to push each cell into the spreadsheet   
         }
	     
	     inputFile.close();
	     return getGridText(); //returns the opened spreadsheet
	}
}