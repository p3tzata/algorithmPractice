package algorithmPractice.recursion.gfg.myselfTry;

import java.util.Stack;

import util.Util;

public class ReverseStack {

	private static Stack<Integer> stack;
	private static Stack<Integer> vector;
	
	public static void main(String[] args) {
		stack = new Stack<>();
		vector= new Stack<>();
		stack.add(1);
		stack.add(2);
		stack.add(3);
		stack.add(4);
		
		fun(stack.pop());
		
		Util.printlnLine(vector);
		
	}

	private static void fun(Integer pop) {
		
		vector.add(pop);
		
		if (stack.isEmpty()){
			return;
		}
		
		fun(stack.pop());
		
		
		
	}

}
