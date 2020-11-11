package util.funcPrintTree;




public class Exp<T extends IStrBuilder> {
	
	private StringBuilder stringBuilder;
	private T strBuilder;

	public Exp(T strBuilder,String resultVarName,Object resultVarValue) {
		this.stringBuilder=new StringBuilder();
		this.strBuilder=strBuilder;
		stringBuilder.append(String.format("%s<%s>=",resultVarName, resultVarValue));
	}
	
	public Exp(T strBuilder,String resultVarName,int indx, Object resultVarValue) {
		this.stringBuilder=new StringBuilder();
		this.strBuilder=strBuilder;
		stringBuilder.append(String.format("%s[%d]<%s>=",resultVarName,indx, resultVarValue));
	}

	
	
	public Exp<T> var_(String varName,Object varValue) {
		stringBuilder.append(String.format("%s<%s>",varName, varValue));
		return this;
	}
	
	public Exp<T> const_(Object constValue) {
		stringBuilder.append(String.format("%s",constValue));
		return this;
	}
	
	public Exp<T> opr(String operatorString) {
		stringBuilder.append(String.format("%s",operatorString));
		return this;
	}
	
	public Exp<T> C () {
		stringBuilder.append(String.format("%s","("));
		return this;
	}
	
	public Exp<T> D () {
		stringBuilder.append(String.format("%s",")"));
		return this;
	}
	
	public T endExp() {
		strBuilder.appendToBuffer(stringBuilder.toString());
		stringBuilder=new StringBuilder();
		return strBuilder;
		
	}
	
	
}

