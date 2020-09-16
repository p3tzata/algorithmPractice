package algorithmPractice.misc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

import util.Util;
class ComparatorInteger implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		
		return o1-o2;
	}
	
	
}


public class Shopper {
	

	private static TreeSet<Integer> stock;
	private static List<Integer> orders;
	private static int cnt=0;

	
	public static void main(String[] args) {
		
	
		
		Comparator<Integer> comparator = new ComparatorInteger();
		orders = new ArrayList<>();
		stock =  new TreeSet<>(comparator);
		boolean isOrderOnce=false;
		
		stock.add(3);
		stock.add(1);
		stock.add(2);
		stock.add(4);
		
		orders.add(1);
		orders.add(2);
		orders.add(2);
		orders.add(5);
		orders.add(1);
		orders.add(3);
		
		orders.sort(comparator);
		
		Iterator<Integer> iterator = orders.iterator();
		while (iterator.hasNext()) {
			Integer integer = (Integer) iterator.next();
			//Util.printlnLine(integer);
			
			
			if(stock.contains(integer)) {
				isOrderOnce=true;
				continue;
				
			} else {
				if(isOrderOnce) {
				Integer toRemove = stock.floor(integer);
				if (toRemove!=null) {
					
					stock.remove(toRemove);
					stock.add(integer);
					cnt++;
					
				} else {
					
					Integer toRemoveGreater = stock.ceiling(integer);
					stock.remove(toRemoveGreater);
					stock.add(integer);
					cnt++;
				}
				} else {
					Util.printlnLine("No permition");
					break;
				}
				
				
				
				
			}
			
			
			
		}
		
		
		Util.printlnLine(cnt);
		String debugString = "debug";
		System.out.print(debugString);
		
	}
	
	

}


