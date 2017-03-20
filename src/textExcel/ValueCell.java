package textExcel;

public class ValueCell extends RealCell implements Cell {
	
	private String words;
	
	public ValueCell (String words){
		super (words);
		this.words = words;
	}
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		String abrv = GetValue(words)+"";
		abrv += "          ";
		return abrv.substring(0,10);
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return GetValue(words)+"";
	}
	
	public double GetValue (String words){
		return Double.parseDouble(words);
	}

}
