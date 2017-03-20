package textExcel;

public class FormulaCell extends RealCell implements Cell {
	
	private String words;
	
	public FormulaCell (String words){
		super (words);
		this.words = words;
	}
	
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return null;
	}

}
