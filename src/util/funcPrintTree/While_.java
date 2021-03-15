package util.funcPrintTree;

public class While_ implements IStrBuilder {
	
	private RecursionPrintTree recursionPrintTree;
	private String javaOprColor=RecursionPrintTree.javaOprColor;
	private String resetColor=RecursionPrintTree.ANSI_RESET;
	
	private StrBuilder parentStrBuilder;
	
	public While_(StrBuilder parentStrBuilder, RecursionPrintTree recursionPrintTree) {
		super();
		this.parentStrBuilder = parentStrBuilder;
		this.recursionPrintTree=recursionPrintTree;
	}
	
	
	public Exp<While_> exp() {
		
		Exp<While_> exp = new Exp<>(this,recursionPrintTree);
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
