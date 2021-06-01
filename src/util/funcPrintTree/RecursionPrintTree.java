package util.funcPrintTree;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





public class RecursionPrintTree {
	
	  private static int multiple=3;
	  private static String fncName="FUNCTION";
	  private Var var;
	  public static final String ANSI_RESET = "\u001B[0m";
	  public static final String ANSI_MAGENTA = "\u001B[95m";
	  public static final String ANSI_ITALIC = "\u001B[3m";
	  public static final String ANSI_UNDERLINE = "\u001B[4m";
	  public static final String ANSI_BLACK = "\u001B[30m";
	  public static final String ANSI_RED = "\u001B[31m";
	  public static final String ANSI_GREEN = "\u001B[32m";
	  public static final String ANSI_YELLOW = "\u001B[33m";
	  public static final String ANSI_BLUE = "\u001B[34m";
	  public static final String ANSI_BLUE_LIGHT = "\u001B[96m";
	  public static final String ANSI_PURPLE = "\u001B[35m";
	  public static final String ANSI_CYAN = "\u001B[36m";
	  public static final String ANSI_GRAY = "\u001B[90m";
	  public static final String ANSI_WHITE = "\u001B[37m";
	  private boolean isEmptyLine=false;
	  
	  //public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	  public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	  public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	  public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	  public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	  public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	  public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	  public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	  
	  
	
	  public static String currentBackgroundColor=ANSI_YELLOW_BACKGROUND;
	  public static String currentFontColor=ANSI_RED;
	  
	  private static List<String> listOfBackgroundColor=new ArrayList<>();
	  private static List<String> listOfFontColor=new ArrayList<>();
	  
	  private static Map<Integer, Integer> stateFontColorMap=new HashMap<>();
	  private int curRotateFontColor;
	  private int level;
	  
	  public static String varNameColor=ANSI_WHITE;
	  //public static String varNameColor=ANSI_CYAN;
	  
	  public static String varNameColorFunc=ANSI_CYAN;
	  
	  
	  
	  public static String varValColor=ANSI_GRAY + ANSI_ITALIC;
	  //public static String varValColor=ANSI_GRAY + ANSI_UNDERLINE + ANSI_ITALIC;
	  
	  public static String javaOprColor=ANSI_MAGENTA + ANSI_ITALIC;
	  public static String functionNameColor=ANSI_MAGENTA;
	  
	  public StrBuilder strBuilder;
	
	public RecursionPrintTree(int level) {
		super();
		this.level=level;
		strBuilder=new StrBuilder(this);
		var=new Var();
		listOfBackgroundColor.add(ANSI_GREEN_BACKGROUND);
		listOfBackgroundColor.add(ANSI_YELLOW_BACKGROUND);
		listOfFontColor.add(ANSI_RED);
		listOfFontColor.add(ANSI_BLUE);
		
		if (!stateFontColorMap.containsKey(level)) {
			stateFontColorMap.put(level, 0);
		} else {
			int curStateFontColor=stateFontColorMap.get(level);
			int newStateFontColor=1-curStateFontColor;
			stateFontColorMap.put(level, newStateFontColor);
		}
		
		curRotateFontColor=stateFontColorMap.get(level);
		
	}
	
	
	

	public int getLevel() {
		return level;
	}




	public StrBuilder getStrBuilder() {
		return strBuilder;
	}


	public static void setMultiple(int multiple) {
		RecursionPrintTree.multiple = multiple;
	}




	public static void setFncName(String fncName) {
		RecursionPrintTree.fncName = fncName;
	}

	public void setIsEmptyLine(boolean set) {
		this.isEmptyLine=set;
	}
	
	

	public void printFuncCall(Variable... variables) {
		if (isEmptyLine) {
		System.out.println();
		}
		
		StringBuilder str = new StringBuilder();
		
		for (int i = 0; i < variables.length; i++) {
			Variable variable = variables[i];
			if (i==variables.length-1) {
			str.append(var.varStr_(variable.getVarName(), variable.getVarValue(),varNameColorFunc)   );
			} else {
				str.append(var.varStr_(variable.getVarName(), variable.getVarValue(),varNameColorFunc));
				str.append(", ");
			}
			
			
			
		}
		
		String string = str.toString();
		//System.out.println("\u001B[30m" + "example" + "\u001B[0m");
		System.out.println(String.format("%s"+ getBackgroundColor(level) +  getFontColor() +">"  + ANSI_RESET+ functionNameColor + "%s"+ANSI_RESET+"(%s)", getOffsetAsEmptyString(),fncName, string));
		
	
	}
	
	
	public  void printPostRecursion(Object... obj) {
		
		if (isEmptyLine) {
			System.out.println();
			}
		
		if (obj.length>1) {
			
			
			System.out.println(String.format("%s" + getBackgroundColor(level) + getFontColor()+ "{{"+ ANSI_RESET, getOffsetAsEmptyString(1)));
			
			for (int i = 0; i < obj.length; i++) {
				System.out.print(String.format("%s%s " , pad(getLevelMultiple(level)+1), obj[i]));
				
				if(i!=obj.length-1) {
					if (isEmptyLine) {
						System.out.println();
					}
				} 
			}
			System.out.println(String.format(getBackgroundColor(level) + getFontColor()+ "}}"  + ANSI_RESET + ANSI_RESET));
			
			} else {
			
			System.out.println(String.format("%s" + getBackgroundColor(level) + getFontColor()+ "{{"  + ANSI_RESET + " %s " + getBackgroundColor(level) + getFontColor()+ "}}"  + ANSI_RESET + ANSI_RESET, getOffsetAsEmptyString(1), obj[0]));
			}
		
		
		//System.out.println(String.format("%s" + getBackgroundColor(level) + getFontColor() + "{{"  + ANSI_RESET + " %s " + getBackgroundColor(level) + getFontColor()+ "}}"  + ANSI_RESET + ANSI_RESET, pad(getLevelMultiple(level)+1), print));
		
	}
	
	
	public   void printPreRecursion(Object... obj) {
		if (isEmptyLine) {
			System.out.println();
		}
		if (obj.length>1) {
		
		
		System.out.println(String.format("%s" + getBackgroundColor(level) + getFontColor()+ "{"+ ANSI_RESET, getOffsetAsEmptyString(1)));
		
		for (int i = 0; i < obj.length; i++) {
			System.out.print(String.format("%s%s " , pad(getLevelMultiple(level)+1), obj[i]));
			
			if(i!=obj.length-1) {
				if (isEmptyLine) {
					System.out.println();
				}
			} 
		}
		System.out.println(String.format(getBackgroundColor(level) + getFontColor()+ "}"  + ANSI_RESET + ANSI_RESET));
		
		} else {
		
		System.out.println(String.format("%s" + getBackgroundColor(level) + getFontColor()+ "{"  + ANSI_RESET + " %s " + getBackgroundColor(level) + getFontColor()+ "}"  + ANSI_RESET + ANSI_RESET, getOffsetAsEmptyString(1), obj[0]));
		}
	}

	
	public   void printResult(Object result) {
		if (isEmptyLine) {
			System.out.println();
		}
		System.out.println(String.format( "%s" + getBackgroundColor(level) + getFontColor() + "<"  + ANSI_RESET +"==( %s )", getOffsetAsEmptyString(), result));
		
	}
	
	public void printResultBase(Object result) {
		if (isEmptyLine) {
			System.out.println();
		}
		System.out.println(String.format( "%s" + getBackgroundColor(level) + getFontColor() + "<"  + ANSI_RESET +"===( %s )", getOffsetAsEmptyString(), result));
		
	}
	
	
	
	public String getOffsetAsEmptyString(int additionSpace) {
		return pad(getLevelMultiple(level) + additionSpace );
	}
	
	public String getOffsetAsEmptyString() {
		return getOffsetAsEmptyString(0);
	}
	
	
	
	
	
	
	
	

	
	private static String pad(int level) {
	
		String pad = "";
	    for (int i = 0; i < level; i++) {
	        pad += "  ";
	    }
	    return pad;
	}
	
	private static int getLevelMultiple(int level) {
		
		return level*multiple;
		
	}
	
	private static String getBackgroundColor(int level) {
		
		return listOfBackgroundColor.get(level%2);
		
	}
	
	private String getFontColor() {
		
		return listOfFontColor.get(curRotateFontColor);
		
	}
	
	public static Variable gVar(String varName,Object varValue) {
		
		return new Variable(varName, varValue);
	}

}









