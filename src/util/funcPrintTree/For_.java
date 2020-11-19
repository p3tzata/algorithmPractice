package util.funcPrintTree;

public class For_ implements IStrBuilder {
	
	private String javaOprColor=RecursionPrintTree.javaOprColor;
	private String resetColor=RecursionPrintTree.ANSI_RESET;
	private RecursionPrintTree recursionPrintTree;
	private StrBuilder parentStrBuilder;
	
	public For_(StrBuilder parentStrBuilder, RecursionPrintTree recursionPrintTree) {
		super();
		this.parentStrBuilder = parentStrBuilder;
		this.recursionPrintTree = recursionPrintTree;
	}
	
	
	public Exp<For_> exp() {
		Exp<For_> exp = new Exp<>(this,recursionPrintTree);
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
