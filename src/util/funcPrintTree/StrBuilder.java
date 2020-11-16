package util.funcPrintTree;



public class StrBuilder implements IStrBuilder {
	
	private StringBuilder stringBuilder;
	//private exp exp; 
	private Var var;
	
	public StrBuilder() {
		stringBuilder=new StringBuilder();
		var=new Var();	
	}
	
	public Exp<StrBuilder> exp(String resultVarName,Object resultVarValue) {
		Exp<StrBuilder> exp = new Exp<>(this,resultVarName,resultVarValue);
		return exp;
	}
	
			
	public Exp<StrBuilder> exp(String resultVarName,Object resultVarValue,String indxName,int indxVal) {
		Exp<StrBuilder> exp = new Exp<>(this,resultVarName,resultVarValue,indxName ,indxVal);
		return exp;
	}
	
	public StrBuilder var_(String varName,Object varValue) {
		String tmpString =var.varStr_(varName, varValue);
		stringBuilder.append(tmpString);
		
	
		return this;
	}
	
	public StrBuilder var_(String resultVarName,Object resultVarValue,String indxName,int indxVal) {
		String tmpString =var.varStr_(resultVarName,resultVarValue,indxName ,indxVal);
		stringBuilder.append(tmpString);
		
	
		return this;
	}
	
	
	
	
	public StrBuilder comment_(String comment_) {
		stringBuilder.append(String.format("// %s",comment_));
		return this;
	}
	
	
	public If_ if_() {
		If_ if_ = new If_(this);
		return if_;
	}
	
	public For_ for_() {
		For_ for_=new For_(this);
		return for_;
	}
	
	public While_ while_() {
		While_ while_=new While_(this);
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
		
		return new Variable(varName, varValue);
	}
	
	
	@Override
	public String toString() {
		return build();
	}

	


	
	
	
	
	
	
	
	
	
}


