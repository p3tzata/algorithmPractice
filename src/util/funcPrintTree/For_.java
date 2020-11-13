package util.funcPrintTree;

public class For_ implements IStrBuilder {
	
	private String javaOprColor=RecursionPrintTree.javaOprColor;
	private String resetColor=RecursionPrintTree.ANSI_RESET;
	
	private StrBuilder parentStrBuilder;
	
	public For_(StrBuilder parentStrBuilder) {
		super();
		this.parentStrBuilder = parentStrBuilder;
	}
	
	
	public Exp<For_> exp(String resultVarName,Object resultVarValue) {
		Exp<For_> exp = new Exp<>(this,resultVarName,resultVarValue);
		return exp;
	}


	@Override
	public void appendToBuffer(String str) {
		
		this.parentStrBuilder.appendToBuffer(javaOprColor + "for"+ resetColor+"(" + str+ ")");
		
	}
	
	
	public StrBuilder _for () {
		return this.parentStrBuilder;
	}
	
	
	
	

}
