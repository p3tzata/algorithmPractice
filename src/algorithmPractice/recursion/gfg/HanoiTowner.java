package algorithmPractice.recursion.gfg;

import java.util.Stack;

import util.Util;

public class HanoiTowner {


	
	public static void main(String[] args) {
		

		tower(2, 'S', 'D', 'A'); 
		
		
		
		String debugString = "debug";
		System.out.print(debugString);
		

	}

	static void tower(int n, char sourcePole, 
            char destinationPole, char auxiliaryPole) 
{ 
// Base case (termination condition) 
if (0 == n) 
return; 

// Move first n-1 disks from source pole 
// to auxiliary pole using destination as 
// temporary pole 
tower(n - 1, sourcePole, auxiliaryPole, 
                    destinationPole); 

// Move the remaining disk from source 
// pole to destination pole 
System.out.printf("Move the disk %d from %c to %c\n", 
                   n, sourcePole, destinationPole); 

// Move the n-1 disks from auxiliary (now source) 
// pole to destination pole using source pole as 
// temporary (auxiliary) pole 
tower(n - 1, auxiliaryPole, destinationPole, sourcePole); 
} 

}
