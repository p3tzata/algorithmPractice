package algorithmPractice.recursion.gfg.myselfTry;

import java.util.Stack;

import util.Util;

public class SortStack {

	private static Stack<Integer> stack;

	
	public static void main(String[] args) {
		stack = new Stack<>();
		stack.add(100);
		stack.add(2);
		stack.add(400);
		stack.add(50);
		stack.add(4);
		
		Util.printlnLine(stack);
		
		fun();
		
		Util.printlnLine(stack);
		
	}

	private static void fun() {
	
		if(stack.isEmpty()) {
			return;
		}
		
		int el = stack.pop();
		
		
		fun();
		
		putAsSorted(el);
		
		
	}

	private static void putAsSorted(int el) {
		
		if(stack.isEmpty()) {
			stack.add(el);
			return;
		}
		
		
		if(stack.peek()>el) {
			
			Integer x = stack.pop();
			putAsSorted(el);
			stack.add(x);
		}
		
		else {
			stack.add(el);
		}
		
		
	}

}
