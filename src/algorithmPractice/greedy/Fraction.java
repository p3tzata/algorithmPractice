package algorithmPractice.greedy;

import java.util.ArrayList;
import java.util.List;





public class Fraction {

	public static void main(String[] args) {
		double p=134;
		double q=3151;
		List<Integer> resultList=new ArrayList<>();
		int candidateFraction=1;
		while(p>0) {
		
		if (candidateFraction==231) {
			String debug="debug";
		}
			
			double result =  round(q/candidateFraction,6);
		//int mod= q%candidateFraction;
		if(result<=round(p,6)) {
			resultList.add(candidateFraction);
			p=p-result;
		}
		candidateFraction++;
		}
		
		String debug="debug";
	}
	
	
	
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	

}
