package util.funcPrintTree;

import util.Util;

public class ArrayVariable<T> implements Variable{
	
	private String varName;
	private String varValue;
 
	
	public ArrayVariable(String varName, T[] arr,int fromIndx, int toIndx) {
		super();
		this.varName = varName;
		this.varValue = Util.printArraySliceAsString(arr, fromIndx, toIndx, ", ");
		this.varValue = "[" + this.varValue + "]";
	}

	public String getVarName() {
		return varName;
	}

	public Object getVarValue() {
		return varValue;
	}
	
	
	
	
	

}
