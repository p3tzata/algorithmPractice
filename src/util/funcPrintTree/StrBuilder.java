package util.funcPrintTree;



public class StrBuilder implements IStrBuilder {
	
	private StringBuilder stringBuilder;
	//private exp exp; 

	public StrBuilder() {
		stringBuilder=new StringBuilder();
		
	}
	
	public Exp<StrBuilder> exp(String resultVarName,Object resultVarValue) {
		Exp<StrBuilder> exp = new Exp<>(this,resultVarName,resultVarValue);
		return exp;
	}
	
			
	public Exp<StrBuilder> exp(String resultArrayVarName,int indx,Object resultArrayVarValue) {
		Exp<StrBuilder> exp = new Exp<>(this,resultArrayVarName,indx,resultArrayVarValue);
		return exp;
	}
	
	public StrBuilder var_(String varName,Object varValue) {
		stringBuilder.append(String.format("%s<%s>",varName, varValue));
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
		
	
	public void appendToBuffer(String str) {
		stringBuilder.append(str);
	}
	
	public String build() {
		String result = stringBuilder.toString();
		stringBuilder=new StringBuilder();
		return result;
		
	}
	
	@Override
	public String toString() {
		return build();
	}

	


	
	
	
	
	
	
	
	
	
}


