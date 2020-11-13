package util.funcPrintTree;



public class ThenIf_ implements IStrBuilder {

	private String javaOprColor=RecursionPrintTree.javaOprColor;
	private String resetColor=RecursionPrintTree.ANSI_RESET;
	private If_ parentIfStrBuilder;
	private StrBuilder mainParentStrBuild;
	private StringBuilder stringBuilder_Then=new StringBuilder();
	
	public ThenIf_(StrBuilder mainParentStrBuilder, If_ parentIfStrBuilder) {
		super();
		this.parentIfStrBuilder = parentIfStrBuilder;
		this.mainParentStrBuild = mainParentStrBuilder;
	}
	
	public Exp<ThenIf_> exp(String resultVarName,Object resultVarValue,String indxName,int indxVal) {
		
			Exp<ThenIf_> exp = new Exp<>(this,resultVarName,resultVarValue,indxName ,indxVal);
			return exp;
		
	}
	
	
	public Exp<ThenIf_> exp(String resultVarName,Object resultVarValue) {
		
		Exp<ThenIf_> exp = new Exp<>(this,resultVarName,resultVarValue);
		return exp;
		
	}
	
	public ElseIf_ else_() {
		mainParentStrBuild.appendToBuffer(javaOprColor+" then"+resetColor+" {"+stringBuilder_Then.toString() +"}");
		stringBuilder_Then=new StringBuilder(); 
		return new ElseIf_(this.mainParentStrBuild,this);
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
