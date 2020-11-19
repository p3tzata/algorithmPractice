package util.funcPrintTree;



public class If_ implements IStrBuilder{
	
	private String javaOprColor=RecursionPrintTree.javaOprColor;
	private String resetColor=RecursionPrintTree.ANSI_RESET;
	private RecursionPrintTree recursionPrintTree;
	StringBuilder stringBuilder_If=new StringBuilder(); 
	private StrBuilder parentStrBuilder;
							
	public If_(StrBuilder parentStrBuilder,RecursionPrintTree recursionPrintTree) {
		super();
		this.parentStrBuilder = parentStrBuilder;
		this.recursionPrintTree= recursionPrintTree;
	}

	//public Exp<If_> exp(String resultVarName,Object resultVarValue) {
	public Exp<If_> exp() {
		//Exp<If_> exp = new Exp<>(this,resultVarName,resultVarValue);
		Exp<If_> exp = new Exp<>(this,recursionPrintTree);
		return exp;
	}

	@Override
	public void appendToBuffer(String str) {
		stringBuilder_If.append(str);
	}
	
	public ThenIf_ then_() {
		
		parentStrBuilder.appendToBuffer(javaOprColor+"if"+resetColor+"("+stringBuilder_If.toString()+")");
		stringBuilder_If=new StringBuilder(); 
		
		return new ThenIf_(this.parentStrBuilder,this,recursionPrintTree);
		//return strBuilder;
	}
	
	
	
	

				
	
}


