package textExcel;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.Scanner;

import textExcel.TestsALL.TestLocation;

// Kaitlyn Chan :)
//APCS Period 1
//March 19, 2017

public class TextExcel
{

	public static void main(String[] args)
	{	
		System.out.println("Welcome to the spreadsheet! You can: enter values into cells, inspect the values, clear the cells, save the spreadsheet, and open the spreadsheet. Coming soon: performing math operations.");
	    Scanner scanner = new Scanner (System.in); //open up the scanner
	    String input = scanner.nextLine();
	    Spreadsheet sheet = new Spreadsheet (); 
	    while (!input.equalsIgnoreCase("quit")) { //quits when "quit" is entered
	    	try {
	    		System.out.println(sheet.processCommand(input)); //makes sure input is valid
	    	}
	    	catch (IndexOutOfBoundsException e) {
	    		System.err.println("IndexOutOfBoundsException: enter in a valid cell"); //catches error
	    	} 
	    	
	    	catch (NumberFormatException e) {
	    		System.err.println("NumberFormatException: enter in a valid cell or value"); //catches error
	    	} 
	    	
	    	input = scanner.nextLine();
	    }
	}
}
