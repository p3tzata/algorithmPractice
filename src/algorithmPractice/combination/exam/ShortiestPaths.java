package algorithmPractice.combination.exam;

import util.Util;

public class ShortiestPaths {

	static Character[] path;
	static Character[] vector;
	
	public static void main(String[] args) {

		path = new Character[] {'R','*','L','*'};
		vector = new Character[path.length];
	
		gen(0,path[0]);
	
	
	}

	private static void gen(int indx,Character char_) {
		
		if(indx==path.length) {
			
			Util.printArray(vector, "");
			return;
		}
		int nextIndex=Math.min(path.length-1, indx+1);
		
		if(char_=='*') {
			
			vector[indx]='L';
			gen(indx+1, path[nextIndex]);
			vector[indx]='R';
			gen(indx+1, path[nextIndex]);
			vector[indx]='S';
			gen(indx+1, path[nextIndex]);
			
		} else {
			vector[indx]=char_;
			gen(indx+1,path[nextIndex]);
		}
		
		
		
	}

}
