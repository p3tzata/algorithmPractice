package algorithmPractice.combination.exam;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import util.Util;

public class Snake {

	private static String[][] matrix;
	private static int xDemension;
	private static String stepSymbol="o";
	private static String startSymbol="S";
	private static List<Character> tracker;
	private static List<List<Character>> store;
	private static Character R = new Character('R');
	private static Character D = new Character('D');
	private static Character L = new Character('L');
	private static Character U = new Character('U');
	private static Character S = new Character('S');
	private static HashSet<String> trackerSet;
	
	
	public static void main(String[] args) throws Exception {
		tracker=new LinkedList<>();
		trackerSet = new HashSet<>();
		store=new LinkedList<>();
		xDemension=4;
		matrix = new String[xDemension][xDemension];
		snakeRec(0, 0, 1, S);
		Util.printlnLine("===");
		
		ArrayList<Character> arrayList1 = new ArrayList<Character>() {/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{add('S');add('R');add('R');add('D');}};
		
		ArrayList<Character> arrayList2 = new ArrayList<Character>() {/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{add('S');add('R');add('D');add('D');}}; 
		
		//Util.printlnLine(isFlipped(arrayList1, arrayList2 ));
		
		
		
		for (int i = 0; i < store.size(); i++) {
			if (store.get(i)!=null) {
			for (int j=i+1;j<store.size();j++) {
				
				if(store.get(j)!=null) {
					//This not catch all...
					if(isRotated(store.get(i), store.get(j)) || isFlipped(store.get(i), store.get(j)) ) {
						store.set(j, null);
					}
					
				}
				
				
			}
			
			}
		
		
		}
		
		for (int i = 0; i < store.size(); i++) {
			if (store.get(i)!=null) {
				Util.printlnLine(store.get(i));
			}
		}
		
		
		//Util.printlnLine(D-R);
		
	}
	
	
	
	static boolean isRotated(List<Character> patter, List<Character> candidate ) {
		int baseRotated=Math.abs(patter.get(1)-candidate.get(1));
		
		for (int i=2;i<patter.size();i++) {
			if (baseRotated!= Math.abs(patter.get(i)-candidate.get(i)) ) {
				return false;
			}
		}
		return true;
		
	}
	
	static boolean isFlipped(List<Character> patter, List<Character> candidate ) {
		int baseRotated=Math.abs(patter.get(1)-candidate.get(candidate.size()-1));
		
		for (int i=2;i<patter.size();i++) {
			Character characterParrent = patter.get(i);
			Character characterCandidate = candidate.get(candidate.size()-i);
			int abs = Math.abs(characterParrent-characterCandidate);
			if (baseRotated!= abs ) {
				return false;
			}
		}
		return true;
		
	}
	
	
	
	
	static void snakeRec(int x,int y,int lenght,Character chr) throws Exception {
		
		String coordinateString = String.format("%d-%d", x,y);
		
		//if (!coordinateString.contains(coordinateString))
		if (checkIfFreeForStep(x,y)) {
			
			stepOn(x,y);
			
			trackerSet.add(coordinateString);
			tracker.add(chr);
			if (lenght==xDemension) {
				Util.printlnLine("");
				Util.printlnLine("");
				
				Util.printlnLine("win");
				Util.printMatrix(matrix, 1);
				Util.printlnLine(tracker.toString());
				store.add(new LinkedList<Character>(tracker));
				stepOf(x, y);
				tracker.remove(tracker.size()-1);
				return;
			}
			
			snakeRec(x,y+1,lenght+1,R);
			snakeRec(x+1,y,lenght+1,D);
			snakeRec(x,y-1,lenght+1,L);
			snakeRec(x-1,y,lenght+1,U);
			stepOf(x, y);
			tracker.remove(tracker.size()-1);
			
		}
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	private static void stepOn(int x, int y) {
		matrix[x][y]=stepSymbol;
	}
	
	private static void stepOf(int x, int y) throws Exception {
		if (matrix[x][y]==stepSymbol) {
			matrix[x][y]=null;	
			
		} else {
			throw new Exception("Somting wrong");
		}
		
		
		
	}
	
	
	
	private static boolean checkIfFreeForStep(int x,int y) {
		
		if (x<0 || x>=xDemension || y<0|| y>=xDemension  || matrix[x][y]!=null) {
			return false;
			
			
		}
		
		return true;
	}
	
	
	
	
	
	

}
