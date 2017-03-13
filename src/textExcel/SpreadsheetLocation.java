package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{	
	char column;
	int row;
	
    @Override
    public int getRow()
    {
        return row-1;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return column - 65;
    }
    
    public SpreadsheetLocation(String cellName)
    {
    	column = cellName.charAt(0);
    	row = Integer.parseInt(cellName.substring(1));
    }

}
