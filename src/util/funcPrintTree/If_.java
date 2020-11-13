package util.funcPrintTree;



public class If_ implements IStrBuilder{
	
	private String javaOprColor=RecursionPrintTree.javaOprColor;
	private String resetColor=RecursionPrintTree.ANSI_RESET;
	
	StringBuilder stringBuilder_If=new StringBuilder(); 
	private StrBuilder parentStrBuilder;
							
	public If_(StrBuilder parentStrBuilder) {
		super();
		this.parentStrBuilder = parentStrBuilder;
	}

	public Exp<If_> exp(String resultVarName,Object resultVarValue) {
		Exp<If_> exp = new Exp<>(this,resultVarName,resultVarValue);
		return exp;
	}

	@Override
	public void appendToBuffer(String str) {
		stringBuilder_If.append(str);
	}
	
	public ThenIf_ then_() {
		
		parentStrBuilder.appendToBuffer(javaOprColor+"if"+resetColor+"("+stringBuilder_If.toString()+")");
		stringBuilder_If=new StringBuilder(); 
		
		return new ThenIf_(this.parentStrBuilder,this);
		//return strBuilder;
	}
	
	
	
	

				
	
}


