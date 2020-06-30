package algorithmPractice.recursion.room1;

import util.Print;

public class DrawFigure {

	
	public static void main(String[] args) {
		
		
		draw(5);
		
				

	}
	
	
	static private void draw(int cnt) {
		
		
		if (cnt == 0) {
			return;
		}
		
		Print.printNtime("#", cnt);
		
		draw(cnt-1);
		
		Print.printNtime("#", cnt);
		
		
		
		
	}
	
}
