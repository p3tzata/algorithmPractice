package util.funcPrintTree;

public class VariableImpl implements Variable {
	
	private String varName;
	private Object varValue;
	
	public VariableImpl(String varName, Object varValue) {
		super();
		this.varName = varName;
		this.varValue = varValue;
	}

	@Override
	public String getVarName() {
		return varName;
	}

	@Override
	public Object getVarValue() {
		return varValue;
	}
	
	
	
	
	

}
