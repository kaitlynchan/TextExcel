package textExcel;

public class TextCell implements Cell {
	
	String s;
	
	public TextCell (String s){
		this.s = s;
	}
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		return "          ";
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return null;
	}

}
