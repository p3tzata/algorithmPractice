package algorithmPractice.recursion.gfg;

import static util.funcPrintTree.StrBuilder.gVar;

import util.Util;
import util.funcPrintTree.RecursionPrintTree;

//Java program to find all combinations
//of numbers from a given string of digits
class CombinationStringDigit
{
  
//function to print combinations of numbers 
//in given input string
static void printCombinations(char[] input,
                           int index, 
                           char[] output, 
                           int outLength, int level)
{
	RecursionPrintTree recursionPrintTree=new RecursionPrintTree(level);
	recursionPrintTree.printHeaderCall(gVar("index", index),gVar("outLength", outLength) );
	
	// no more digits left in input string
 if (input.length == index)
 {
     // print output string & return
    // System.out.println(String.valueOf(output));
	 recursionPrintTree.printResult(String.valueOf(output));
     return;
 }
  
 // place current digit in input string
 output[outLength] = input[index];
  
 // separate next digit with a space
 output[outLength + 1] = ' ';
  
 printCombinations(input, index + 1, output, 
                             outLength + 2,level+1);
  
 // if next digit exists make a 
 // call without including space
 if(input.length!=index + 1)
 printCombinations(input, index + 1, output, 
                             outLength + 1,level+1);
}

//Driver Code
public static void main(String[] args) 
{
 char input[] = "123".toCharArray();
 char []output = new char[20];
  
 printCombinations(input, 0, output, 0,0);
}
}

//This code is contributed by Rajput-Ji