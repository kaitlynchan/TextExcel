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
		String abrv = (words);
		abrv += "          ";
		return abrv.substring(0,10);
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return (words);
	}
	
	public double GetValue (String words){
		return Double.parseDouble(words);
	}


}
