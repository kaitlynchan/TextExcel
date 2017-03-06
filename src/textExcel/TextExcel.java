package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code. github

public class TextExcel
{

	public static void main(String[] args)
	{
	    Scanner scanner = new Scanner (System.in);
	    String input = scanner.nextLine();
	    Spreadsheet sheet = new Spreadsheet();
	    while (input != "quit") {
	    	sheet.processCommand(input);
	    }
//	    TextExcel.java: A class with a main method that constructs a
//
//	    Spreadsheet, and has the command loop (reading commands, calling 
//
//	    the spreadsheetâ€™s processCommand method to process each line of 
//
//	    input, printing the String returned from processCommand, repeating until 
//
//	    â€œquitâ€� is read).  You do not need to actually correctly implement any 
//
//	    commands other than quit, as long as the program compiles and does 
//
//	    not crash.
//
		// Add your command loop here
	}
}
