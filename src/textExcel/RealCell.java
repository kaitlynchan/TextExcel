package textExcel;

public class RealCell implements Cell {
	
	private String words;
	 
	public RealCell (String words){
		this.words = words;
	}
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		return "          ";
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return words;
	}
	
	public double getDoubleValue(){
		return Double.parseDouble(words);
	}

}
