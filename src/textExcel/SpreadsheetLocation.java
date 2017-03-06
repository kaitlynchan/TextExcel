package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	int column;
	int row;
	@Override
    public int getRow()
    {
        // TODO get rid of todos
        return row-1;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return column;
    }
    
    public SpreadsheetLocation(String cellName)
    {
        column = (cellName.charAt(0)) - 65;
        row = Integer.parseInt(cellName.substring(1));
        System.out.println(column + " " + row);
    	// TODO: Fill this out with your own code
    }

}
