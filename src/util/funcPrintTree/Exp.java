package util.funcPrintTree;

import static util.funcPrintTree.Var.*;


public class Exp<T extends IStrBuilder> {
	
	private StringBuilder ownStringBuilder;
	private T parentStrBuilder;
	private String varNameColorFunc=RecursionPrintTree.varNameColorFunc;
	private String varValColor=RecursionPrintTree.varValColor;
	private String resetColor=RecursionPrintTree.ANSI_RESET;
	private Var var;
	private RecursionPrintTree recursionPrintTree;

	public Exp(T parentStrBuilder,RecursionPrintTree recursionPrintTree) {
		this.ownStringBuilder=new StringBuilder();
		this.parentStrBuilder=parentStrBuilder;
		this.recursionPrintTree=recursionPrintTree;
		var=new Var();
		
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
	
	public Exp<T> Cc () {
		ownStringBuilder.append(String.format("%s%s%s",varNameColorFunc,"{",resetColor ));
		return this;
	}
	
	public Exp<T> Dc () {
		ownStringBuilder.append(String.format("%s%s%s",varNameColorFunc,"} ",resetColor ));
		return this;
	}
	
	
	public Exp<T> return_ () {
		ownStringBuilder.append(String.format("%s","return;" ));
		return this;
	}
	
	public Exp<T> throwEx_ () {
		ownStringBuilder.append(String.format("%s","throw Ex();" ));
		return this;
	}
	
	
	public T endExp() {
		parentStrBuilder.appendToBuffer(ownStringBuilder.toString());
		ownStringBuilder=new StringBuilder();
		return parentStrBuilder;
		
	}
	
	public Exp<T> newLine() {
		ownStringBuilder.append(System.lineSeparator());
		ownStringBuilder.append(String.format("%s",recursionPrintTree.getOffsetAsEmptyString(2)));
		return this;
	}
	
	
	
	
	/*
	public Exp<T> expResult(String resultVarName,Object resultVarValue,String indxName,int indxVal) {
		//ownStringBuilder.append("; ");
		ownStringBuilder.append(String.format(var.varStr_(resultVarName,resultVarValue,indxName ,indxVal)+ " = "));
		return this;
		
	}
	
	public Exp<T> expResult(String resultVarName,Object resultVarValue) {
		//ownStringBuilder.append("; ");
		//ownStringBuilder.append(String.format(varColor + "%s<"+resetColorString +"%s>=",resultVarName, resultVarValue));
		ownStringBuilder.append(String.format(var.varStr_(resultVarName,resultVarValue)+" = "));
		return this;
		
	}
	*/
	public Exp<T> eq() {
		ownStringBuilder.append(" = ");
		//ownStringBuilder.append(String.format(varColor + "%s<"+resetColorString +"%s>=",resultVarName, resultVarValue));
		
		return this;
		
	}
	
	
	public Exp<T> and() {
		ownStringBuilder.append("; ");
		//ownStringBuilder.append(String.format(varColor + "%s<"+resetColorString +"%s>=",resultVarName, resultVarValue));
		
		return this;
		
	}
	
	
	
}

