package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code. 
public class TextExcel
{

	public static void main(String[] args)
	{	
		
	    Scanner scanner = new Scanner (System.in);
	    String input = scanner.nextLine();
	    Spreadsheet sheet = new Spreadsheet ();
	    System.out.println(sheet.getGridText());
	    while (!input.equalsIgnoreCase("quit")) {
	    	System.out.println(sheet.processCommand(input));
	    	input = scanner.nextLine();
	    }
	}
}
