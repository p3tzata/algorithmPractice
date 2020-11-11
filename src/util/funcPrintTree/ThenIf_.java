package util.funcPrintTree;



public class ThenIf_ implements IStrBuilder {

	private If_ parentIfStrBuilder;
	private StrBuilder mainParentStrBuild;
	private StringBuilder stringBuilder_Then=new StringBuilder();
	
	public ThenIf_(StrBuilder mainParentStrBuilder, If_ parentIfStrBuilder) {
		super();
		this.parentIfStrBuilder = parentIfStrBuilder;
		this.mainParentStrBuild = mainParentStrBuilder;
	}
	
	public Exp<ThenIf_> exp(String resultVarName,int indx,Object resultVarValue) {
		
			Exp<ThenIf_> exp = new Exp<>(this,resultVarName,indx,resultVarValue);
			return exp;
		
	}
	
	
	public Exp<ThenIf_> exp(String resultVarName,Object resultVarValue) {
		
		Exp<ThenIf_> exp = new Exp<>(this,resultVarName,resultVarValue);
		return exp;
		
	}
	
	public ElseIf_ else_() {
		mainParentStrBuild.appendToBuffer(" then {"+stringBuilder_Then.toString() +"}");
		stringBuilder_Then=new StringBuilder(); 
		return new ElseIf_(this.mainParentStrBuild,this);
	}
	
	public StrBuilder _if() {
		mainParentStrBuild.appendToBuffer(" then {"+stringBuilder_Then.toString() +"}");
		stringBuilder_Then=new StringBuilder(); 
		return mainParentStrBuild;
	}
	
	

	@Override
	public void appendToBuffer(String str) {
		
		stringBuilder_Then.append(str);				
		
	}
	
	
	
	
	
	
	
}
