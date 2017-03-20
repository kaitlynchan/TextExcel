package textExcel;

public class PercentCell extends RealCell implements Cell {
	
private String words;
	
	public PercentCell (String words){
		super (words);
		this.words = words;
	}
	
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		String abrv = words.substring(0, words.indexOf("."));
		abrv += "%         ";
		return abrv.substring(0,10);
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return GetValue(words)+"";
	}
	
	public double GetValue (String words){
		return Double.parseDouble(words.substring(0, words.length()-1))/100;
		
	}


}
