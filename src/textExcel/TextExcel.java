package textExcel;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.Scanner;

import textExcel.TestsALL.TestLocation;

// Update this file with your own code. 
public class TextExcel
{

	public static void main(String[] args)
	{	
		System.out.println("hi");
	    Scanner scanner = new Scanner (System.in);
	    String input = scanner.nextLine();
	    Spreadsheet sheet = new Spreadsheet (); 
	    while (!input.equalsIgnoreCase("quit")) {
	    	System.out.println(sheet.processCommand(input));
	    	input = scanner.nextLine();
	    }
	}
}
