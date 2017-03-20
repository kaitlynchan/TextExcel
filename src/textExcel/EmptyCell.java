package textExcel;

public class EmptyCell implements Cell {
	
	public EmptyCell(){ //nothing in here :)
	}
	
	@Override
	public String abbreviatedCellText() {
		return "          ";
	}
	@Override
	public String fullCellText() {
		return "";
	}
}
