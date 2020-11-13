package util.funcPrintTree;

import static util.funcPrintTree.Var.*;


public class Exp<T extends IStrBuilder> {
	
	private StringBuilder ownStringBuilder;
	private T parentStrBuilder;
	private String varNameColor=RecursionPrintTree.varNameColor;
	private String varValColor=RecursionPrintTree.varValColor;
	private String resetColor=RecursionPrintTree.ANSI_RESET;
	private Var var;
	

	public Exp(T parentStrBuilder,String resultVarName,Object resultVarValue) {
		this.ownStringBuilder=new StringBuilder();
		this.parentStrBuilder=parentStrBuilder;
		var=new Var();
		ownStringBuilder.append(String.format(var.varStr_(resultVarName,resultVarValue)+" = "));
	}
	
	public Exp(T strBuilder,String resultVarName,Object resultVarValue,String indxName,int indxVal) {
		this.ownStringBuilder=new StringBuilder();
		this.parentStrBuilder=strBuilder;
		var=new Var();
		ownStringBuilder.append(String.format(var.varStr_(resultVarName,resultVarValue,indxName ,indxVal)+" = "));
	}

	
	
	public Exp<T> var_(String varName,Object varValue) {
		String tmpString =var.varStr_(varName, varValue);
		ownStringBuilder.append(tmpString);
		
		return this;
		
		
	}
	
	public Exp<T> var_(String resultVarName,Object resultVarValue,String indxName,int indxVal) {
		String tmpString =var.varStr_(resultVarName,resultVarValue,indxName ,indxVal);
		ownStringBuilder.append(tmpString);
		return this;
	}
	
	
	
	
	
	
	public Exp<T> const_(Object constValue) {
		ownStringBuilder.append(String.format(varValColor+"%s"+resetColor,constValue));
		return this;
	}
	
	public Exp<T> opr(String operatorString) {
		ownStringBuilder.append(String.format(" %s ",operatorString));
		return this;
	}
	
	public Exp<T> C () {
		ownStringBuilder.append(String.format("%s","("));
		return this;
	}
	
	public Exp<T> D () {
		ownStringBuilder.append(String.format("%s",")"));
		return this;
	}
	
	public T endExp() {
		parentStrBuilder.appendToBuffer(ownStringBuilder.toString());
		ownStringBuilder=new StringBuilder();
		return parentStrBuilder;
		
	}
	
	public Exp<T> andExp(String resultVarName,Object resultVarValue,String indxName,int indxVal) {
		ownStringBuilder.append("; ");
		ownStringBuilder.append(String.format(var.varStr_(resultVarName,resultVarValue,indxName ,indxVal)+ " = "));
		return this;
		
	}
	
	public Exp<T> andExp(String resultVarName,Object resultVarValue) {
		ownStringBuilder.append("; ");
		//ownStringBuilder.append(String.format(varColor + "%s<"+resetColorString +"%s>=",resultVarName, resultVarValue));
		ownStringBuilder.append(String.format(var.varStr_(resultVarName,resultVarValue)+" = "));
		return this;
		
	}

	
	public Exp<T> andExp() {
		ownStringBuilder.append("; ");
		//ownStringBuilder.append(String.format(varColor + "%s<"+resetColorString +"%s>=",resultVarName, resultVarValue));
		
		return this;
		
	}
	
	
	
}

