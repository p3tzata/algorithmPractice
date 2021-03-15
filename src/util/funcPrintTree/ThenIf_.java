package util.funcPrintTree;



public class ThenIf_ implements IStrBuilder {

	private String javaOprColor=RecursionPrintTree.javaOprColor;
	private String resetColor=RecursionPrintTree.ANSI_RESET;
	
	private StrBuilder mainParentStrBuild;
	private RecursionPrintTree recursionPrintTree;
	private StringBuilder stringBuilder_Then=new StringBuilder();
	
	public ThenIf_(StrBuilder mainParentStrBuilder, If_ parentIfStrBuilder,RecursionPrintTree recursionPrintTree) {
		super();
	
		this.mainParentStrBuild = mainParentStrBuilder;
		this.recursionPrintTree = recursionPrintTree;
	}
	
	//public Exp<ThenIf_> exp(String resultVarName,Object resultVarValue,String indxName,int indxVal) {
	public Exp<ThenIf_> exp() {
			//Exp<ThenIf_> exp = new Exp<>(this,resultVarName,resultVarValue,indxName ,indxVal);
		Exp<ThenIf_> exp = new Exp<>(this,recursionPrintTree);
			return exp;
		
	}
	
	/*
	public Exp<ThenIf_> exp(String resultVarName,Object resultVarValue) {
		
		//Exp<ThenIf_> exp = new Exp<>(this,resultVarName,resultVarValue);
		Exp<ThenIf_> exp = new Exp<>(this);
		return exp;
		
	}
	*/
	
	public ElseIf_ else_() {
		mainParentStrBuild.appendToBuffer(javaOprColor+" then"+resetColor+" {"+stringBuilder_Then.toString() +"}");
		stringBuilder_Then=new StringBuilder(); 
		return new ElseIf_(this.mainParentStrBuild,this,recursionPrintTree);
	}
	
	public StrBuilder _if() {
		mainParentStrBuild.appendToBuffer(javaOprColor+" then"+resetColor+" {"+stringBuilder_Then.toString() +"}");
		stringBuilder_Then=new StringBuilder(); 
		return mainParentStrBuild;
	}
	
	

	@Override
	public void appendToBuffer(String str) {
		
		stringBuilder_Then.append(str);				
		
	}
	
	
	
	
	
	
	
}
