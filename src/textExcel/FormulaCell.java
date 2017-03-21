package textExcel;

public class FormulaCell extends RealCell implements Cell {
	
	private String words;
	
	public FormulaCell (String words){ //not functional yet
		super (words);
		this.words = words;
	}
	
	@Override
	public String abbreviatedCellText() {
		String abrv = (words);
		abrv += "          ";
		return abrv.substring(0,10); //pads, then substrings to 10 char
	}

	@Override
	public String fullCellText() {
		return (words);
	}
	
	public double GetValue (String words){
		return Double.parseDouble(words);
	}
}
