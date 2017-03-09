package textExcel;

//*******************************************************
// DO NOT MODIFY THIS FILE!!!
//*******************************************************
//implemented by (EmptyCell, TextCell, RealCell, ValueCell, PercentCell, FormulaCell)
public interface Cell
{
	public String abbreviatedCellText(); // text for spreadsheet cell display, must be exactly length 10
	public String fullCellText(); // text for individual cell inspection, not truncated or padded
}
