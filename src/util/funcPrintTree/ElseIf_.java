package util.funcPrintTree;

public class ElseIf_ implements IStrBuilder {
	
	
	private ThenIf_ parentStrBuilder;
	private StrBuilder mainParentStrBuild;
	private StringBuilder stringBuilder_Then=new StringBuilder();
	
	public ElseIf_(StrBuilder mainParentStrBuilder,ThenIf_ parentStrBuilder) {
		super();
		this.mainParentStrBuild = mainParentStrBuilder;
		this.parentStrBuilder = parentStrBuilder;
	}
	
	public Exp<ElseIf_> exp(String resultVarName,Object resultVarValue) {
		
		Exp<ElseIf_> exp = new Exp<>(this,resultVarName,resultVarValue);
		return exp;
	
	}
	
	public Exp<ElseIf_> exp(String resultVarName,int indx,Object resultVarValue) {
		
		Exp<ElseIf_> exp = new Exp<>(this,resultVarName,indx,resultVarValue);
		return exp;
		
	}
	
	public StrBuilder _if() {
		mainParentStrBuild.appendToBuffer(" else {"+stringBuilder_Then+"}".toString());
		stringBuilder_Then=new StringBuilder(); 
		return mainParentStrBuild;
	}
	
		

	@Override
	public void appendToBuffer(String str) {
		
		stringBuilder_Then.append(str);	
		
	}
	
	
	
	
	

}
