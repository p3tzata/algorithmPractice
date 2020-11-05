package algorithmPractice.recursion.gfg;

import util.Util;

public class HanoiMyselfTry {
	
	static final int N=6;
	static int cnt=0;
	public static void main(String[] args) {
		
		func(N,'1','3','2');
		Util.printlnLine(cnt);		

	}
	
	
	
	
	private static void func(int nDiscs, char from, char to, char aux) {
		
		if(nDiscs==0) {
			return;
		}
		
		
		func(nDiscs -1 , from, aux, to);
		
		Util.printlnLine(String.format("Disk %d from %s to %s", nDiscs,from,to));
		cnt++;
		
		func(nDiscs -1 , aux, to, from);
		
		
		
		
		
	}
	
	

	
	
	
	

}
