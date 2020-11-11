package util.funcPrintTree;

import static util.funcPrintTree.RecursionPrintTree.frmStr_buildExp;
import static util.funcPrintTree.RecursionPrintTree.frmStr_const;
import static util.funcPrintTree.RecursionPrintTree.frmStr_operator;
import static util.funcPrintTree.RecursionPrintTree.frmStr_operatorIfElse;
import static util.funcPrintTree.RecursionPrintTree.frmStr_operatorIfThen;
import static util.funcPrintTree.RecursionPrintTree.frmStr_var;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





public class RecursionPrintTree {
	
	  private static int multiple=3;
	  private static String fncName="fnc";
	  public static final String ANSI_RESET = "\u001B[0m";
	  public static final String ANSI_BLACK = "\u001B[30m";
	  public static final String ANSI_RED = "\u001B[31m";
	  public static final String ANSI_GREEN = "\u001B[32m";
	  public static final String ANSI_YELLOW = "\u001B[33m";
	  public static final String ANSI_BLUE = "\u001B[34m";
	  public static final String ANSI_PURPLE = "\u001B[35m";
	  public static final String ANSI_CYAN = "\u001B[36m";
	  public static final String ANSI_WHITE = "\u001B[37m";
	
	  
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
	  
	  public StrBuilder strBuilder;
	
	public RecursionPrintTree(int level) {
		super();
		this.level=level;
		strBuilder=new StrBuilder();
		listOfBackgroundColor.add(ANSI_GREEN_BACKGROUND);
		listOfBackgroundColor.add(ANSI_YELLOW_BACKGROUND);
		listOfBackgroundColor.add(ANSI_CYAN_BACKGROUND);
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

	public StrBuilder getStrBuilder() {
		return strBuilder;
	}


	public static void setMultiple(int multiple) {
		RecursionPrintTree.multiple = multiple;
	}




	public static void setFncName(String fncName) {
		RecursionPrintTree.fncName = fncName;
	}




	public void printHeaderCall(Object... obj) { 
		StringBuilder str = new StringBuilder();
		
		for (int i = 0; i < obj.length; i++) {
			Object object = obj[i];
			if (i==obj.length-1) {
			str.append(object);
			} else {
				str.append(object);
				str.append(", ");
			}
			
			
			
		}
		
	
		
		String string = str.toString();
		//System.out.println("\u001B[30m" + "example" + "\u001B[0m");
		System.out.println(String.format("%s" + getBackgroundColor(level) +  getFontColor() +">"  + ANSI_RESET+ "%s(%s)", pad(getLevelMultiple(level)),fncName, string));
		
	}
	
	
	
	
	public  void printPostRecursion(Object... obj) {
		
		
		
		if (obj.length>1) {
			
			
			System.out.println(String.format("%s" + getBackgroundColor(level) + getFontColor()+ "{{"+ ANSI_RESET, pad(getLevelMultiple(level)+1)));
			
			for (int i = 0; i < obj.length; i++) {
				System.out.print(String.format("%s%s " , pad(getLevelMultiple(level)+1), obj[i]));
				
				if(i!=obj.length-1) {
					System.out.println();
				} 
			}
			System.out.println(String.format(getBackgroundColor(level) + getFontColor()+ "}}"  + ANSI_RESET + ANSI_RESET));
			
			} else {
			
			System.out.println(String.format("%s" + getBackgroundColor(level) + getFontColor()+ "{{"  + ANSI_RESET + " %s " + getBackgroundColor(level) + getFontColor()+ "}}"  + ANSI_RESET + ANSI_RESET, pad(getLevelMultiple(level)+1), obj[0]));
			}
		
		
		//System.out.println(String.format("%s" + getBackgroundColor(level) + getFontColor() + "{{"  + ANSI_RESET + " %s " + getBackgroundColor(level) + getFontColor()+ "}}"  + ANSI_RESET + ANSI_RESET, pad(getLevelMultiple(level)+1), print));
		
	}
	
	
	public   void printPreRecursion(Object... obj) {
		
		if (obj.length>1) {
		
		
		System.out.println(String.format("%s" + getBackgroundColor(level) + getFontColor()+ "{"+ ANSI_RESET, pad(getLevelMultiple(level)+1)));
		
		for (int i = 0; i < obj.length; i++) {
			System.out.print(String.format("%s%s " , pad(getLevelMultiple(level)+1), obj[i]));
			
			if(i!=obj.length-1) {
				System.out.println();
			} 
		}
		System.out.println(String.format(getBackgroundColor(level) + getFontColor()+ "}"  + ANSI_RESET + ANSI_RESET));
		
		} else {
		
		System.out.println(String.format("%s" + getBackgroundColor(level) + getFontColor()+ "{"  + ANSI_RESET + " %s " + getBackgroundColor(level) + getFontColor()+ "}"  + ANSI_RESET + ANSI_RESET, pad(getLevelMultiple(level)+1), obj[0]));
		}
	}

	
	
	
	
	public   void printResult(Object result) {
		
		System.out.println(String.format( "%s" + getBackgroundColor(level) + getFontColor() + "<"  + ANSI_RESET +"==( %s )"+System.lineSeparator(), pad(getLevelMultiple(level)), result));
		
	}
	
	public void printResultBase(Object result) {
		
		System.out.println(String.format( "%s" + getBackgroundColor(level) + getFontColor() + "<"  + ANSI_RESET +"===( %s )"+System.lineSeparator(), pad(getLevelMultiple(level)), result));
		
	}
	
	
	
	
	public static  String frmStr_buildExp(String resultName,Object resultVal , Object exp ) {
		return String.format("%s[[%s]]=%s", resultName, resultVal,exp);
	}
	
	public static String frmStr_var(String varStr,Object varVal ) {
		return String.format("%s[%s]",varStr, varVal);
	}
	
	public static String frmStr_operator(Object operStr ) {
		return String.format("%s",operStr);
	}
	
	public static String frmStr_operatorIfThen(String condition ) {
		return String.format("if( %s )",condition );
	}
	
	public static String frmStr_operatorIfThen(String condition , String then_) {
		return String.format("if( %s ) { %s } ",condition , then_);
	}
	
	public static String frmStr_operatorIfElse(String condition , String then_,String else_) {
		return String.format("if( %s ) { %s } else { %s }",condition , then_,else_);
	}
	
	
	public static String frmStr_const(Object constStr ) {
		return String.format("%s",constStr);
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
		
		return listOfBackgroundColor.get(level%3);
		
	}
	
	private String getFontColor() {
		
		return listOfFontColor.get(curRotateFontColor);
		
	}
	
	
	
	
	
/*
 * 	
		frmStr_operatorIfElse(frmStr_buildExp("", (num % 10 == dupNum % 10) ,  frmStr_var("num", num) + frmStr_operator("%") + frmStr_const(10)  
        																		 + frmStr_operator("==") 
        																		 + frmStr_var("dupNum", dupNum) + frmStr_operator("%") + frmStr_const(10) )
        						     ,frmStr_buildExp("dupNum", (dupNum / 10 ) ,  frmStr_var("dupNum", dupNum) + frmStr_operator("/") + frmStr_const(10))
        						     ,"throw Exaption"
        					 )
        
        
        
        
*/
	
	
	
	
	

}









