package util.funcPrintTree;



public class StrBuilder implements IStrBuilder {
	
	private StringBuilder stringBuilder;
	private RecursionPrintTree recursionPrintTree;
	
	private Var var;
	
	public StrBuilder(RecursionPrintTree recursionPrintTree) {
		this.stringBuilder=new StringBuilder();
		this.recursionPrintTree=recursionPrintTree;
		this.var=new Var();	
	}
	
	public Exp<StrBuilder> exp() {
		Exp<StrBuilder> exp = new Exp<>(this,recursionPrintTree);
		return exp;
	}
	
	
	
	
	public StrBuilder var_(String varName,Object varValue) {
		String tmpString =var.varStr_(varName, varValue);
		stringBuilder.append(tmpString);
		
	
		return this;
	}
	
//	public StrBuilder var_(String resultVarName,Object resultVarValue,String indxName,int indxVal) {
//		String tmpString =var.varStr_(resultVarName,resultVarValue,indxName ,indxVal);
//		stringBuilder.append(tmpString);
//		
//	
//		return this;
//	}
	
	
	
	
	public StrBuilder comment_(String comment_) {
		stringBuilder.append(String.format("// %s",comment_));
		return this;
	}
	
	
	public If_ if_() {
		If_ if_ = new If_(this,recursionPrintTree);
		return if_;
	}
	
	public For_ for_() {
		For_ for_=new For_(this,recursionPrintTree);
		return for_;
	}
	
	public While_ while_() {
		While_ while_=new While_(this,recursionPrintTree);
		return while_;
	}
	
	
	
	public void appendToBuffer(String str) {
		stringBuilder.append(str);
	}
	
	public String build() {
		String result = stringBuilder.toString();
		stringBuilder=new StringBuilder();
		return result;
		
	}
	
	
	

	public static Variable gVar(String varName,Object varValue) {
		
		return new VariableImpl(varName, varValue);
	}
	
	public static <T> Variable gArrayVar(String varName,T[] arr,int fromIndx, int toIndx) {
		
		return new ArrayVariableImpl<T>(varName,arr, fromIndx, toIndx);
		
	
		
	}

	
	
	@Override
	public String toString() {
		return build();
	}

	


	
	
	
	
	
	
	
	
	
}


