package textExcel;

public class FormulaCell extends RealCell implements Cell {
	
	private String words;
	
	public FormulaCell (String words){ //not functional yet
		super (words);
		this.words = words;
	}
	
	@Override
	public String abbreviatedCellText() {
		
		String abrv = GetValue(words) + "";
		abrv += "          ";
		return abrv.substring(0,10); //pads, then substrings to 10 char
	}

	@Override
	public String fullCellText() {
		return (words);
	}
	// ( 1 + 3 - 5 )
	public double GetValue (String words){
		String [] formulaParts = words.split(" ");
		String operand1 = "";
		String operator= "";
		String operand2 = "";
		int i = 0;
		String finalAnswer = formulaParts [i+1];
		while (i <= formulaParts.length - 5){
			operand1 = finalAnswer;
			operator = formulaParts [i+2];
			operand2 = formulaParts [i+3];
			finalAnswer = Calculate(operand2, operand1, operator);
			i+=2;
		}
		return Double.parseDouble(finalAnswer);
	}
    
    public static String Calculate(String operand2, String operand1, String operator){
    	//this method takes in parsed components and performs calculations
    	String calculateAnswer = " ";
    	double number2 = Double.parseDouble(operand2);
    	double number1 = Double.parseDouble(operand1);

    	//calls method depending on operator
    	if (operator.equals("+")){  		
    		
    		calculateAnswer = number1 + number2 + "";
    	}
    	else if (operator.equals("-")){
    
    		calculateAnswer = number1 - number2 + "";
    	}
    	else if (operator.equals("*")){
    		
    		calculateAnswer = number1*number2+"";
    	}
    	else {
    		
    		calculateAnswer = number1/number2+"";
    	}   
		return calculateAnswer;
    }
}
