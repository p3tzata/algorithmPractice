package util.funcPrintTree;

public class While_ implements IStrBuilder {
	
	private String javaOprColor=RecursionPrintTree.javaOprColor;
	private String resetColor=RecursionPrintTree.ANSI_RESET;
	
	private StrBuilder parentStrBuilder;
	
	public While_(StrBuilder parentStrBuilder) {
		super();
		this.parentStrBuilder = parentStrBuilder;
	}
	
	
	public Exp<While_> exp(String resultVarName,Object resultVarValue) {
		Exp<While_> exp = new Exp<>(this,resultVarName,resultVarValue);
		return exp;
	}


	@Override
	public void appendToBuffer(String str) {
		
		this.parentStrBuilder.appendToBuffer(javaOprColor + "while"+ resetColor+"(" + str+ ")");
		
	}
	
	
	public StrBuilder _while () {
		return this.parentStrBuilder;
	}
	
	
	
	

}
