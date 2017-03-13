package textExcel;

public class TextCell implements Cell {
	
	private String words;
	
	public TextCell (String words){
		this.words = words;
	}
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		String abrv = words;
		abrv += "          ";
		return abrv.substring(0,10);
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return "\"" + words + "\"";
	}

}
