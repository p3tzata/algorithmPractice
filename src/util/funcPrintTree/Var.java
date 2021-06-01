package util.funcPrintTree;



public class Var {
	
	private String varNameColor=RecursionPrintTree.varNameColor;
	private String varValColor=RecursionPrintTree.varValColor;
	private String resetColor=RecursionPrintTree.ANSI_RESET;
	
	
	
	
	public String varStr_(String varName,Object varValue) {
		//return (String.format(varNameColor + "%s"+resetColor +"<%s>",varName, varValue));
		return (String.format(this.varNameColor + "%s"+resetColor +varValColor +":%s"+resetColor,varName, varValue));
		
	}
	
	public String varStr_(String varName,Object varValue,String varNameColor) {
		//return (String.format(varNameColor + "%s"+resetColor +"<%s>",varName, varValue));
		return (String.format(varNameColor + "%s"+resetColor +varValColor +":%s"+resetColor,varName, varValue));
		
	}
	
//	public String varStr_(String varName,Object varValue,String indxName, int indxVal) {
//		return (String.format(varNameColor + "%s[%s"+varValColor +":%d"+resetColor+varNameColor+"]"+resetColor +varValColor+":%s"+resetColor,varName,indxName, indxVal,varValue));
//		
//	}
//	
//	public String varStr_(String varName,Object varValue,String indxName, int indxVal,String varNameColor) {
//		return (String.format(varNameColor + "%s[%s"+varValColor +":%d"+resetColor+varNameColor+"]"+resetColor +varValColor+":%s"+resetColor,varName,indxName, indxVal,varValue));
//		
//	}
	
	public String varStr_(Variable var,Variable indx) {
		return (String.format(varNameColor + "%s[%s"+varValColor +":%d"+resetColor+varNameColor+"]"+resetColor +varValColor+":%s"+resetColor,var.getVarName(),indx.getVarName(), indx.getVarValue(),var.getVarValue()));
		
	}
	
	
	public String varStr_(Variable var,Variable indx,String varNameColor) {
		return (String.format(varNameColor + "%s[%s"+varValColor +":%d"+resetColor+varNameColor+"]"+resetColor +varValColor+":%s"+resetColor,var.getVarName(),indx.getVarName(), indx.getVarValue(),var.getVarValue()));
		
	}
	
	
	
}
