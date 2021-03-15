package util.funcPrintTree;

public class ElseIf_ implements IStrBuilder {
	private String javaOprColor=RecursionPrintTree.javaOprColor;
	private String resetColor=RecursionPrintTree.ANSI_RESET;
	private RecursionPrintTree recursionPrintTree;
	
	private StrBuilder mainParentStrBuild;
	private StringBuilder stringBuilder_Then=new StringBuilder();
	
	public ElseIf_(StrBuilder mainParentStrBuilder,ThenIf_ parentStrBuilder,RecursionPrintTree recursionPrintTree) {
		super();
		this.mainParentStrBuild = mainParentStrBuilder;
	    this.recursionPrintTree=recursionPrintTree;
	}
	
	
	public Exp<ElseIf_> exp() {
		
		Exp<ElseIf_> exp = new Exp<>(this,recursionPrintTree);
		return exp;
	
	}
	
	
	public StrBuilder _if() {
		mainParentStrBuild.appendToBuffer(javaOprColor + " else "+resetColor+"{"+stringBuilder_Then+"}".toString());
		stringBuilder_Then=new StringBuilder(); 
		return mainParentStrBuild;
	}
	
		

	@Override
	public void appendToBuffer(String str) {
		
		stringBuilder_Then.append(str);	
		
	}
	
	
	
	
	

}
