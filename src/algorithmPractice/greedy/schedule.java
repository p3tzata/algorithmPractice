package algorithmPractice.greedy;

import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparing;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;



import algorithmPractice.greedy.schedule.item;
import util.Util;

public class schedule {

	static private double capacity;
	static private List<item> items;
	static private List<item> resultList;
	static int temp;
	
	public static void main(String[] args) {
		
		items= new ArrayList<>();
		resultList =  new ArrayList<>();
		items.add(new item(1,40,1));
		items.add(new item(2,30,2));
		items.add(new item(3,15,1));
		items.add(new item(4,20,1));
		items.add(new item(5,50,2));
		
		//items.add(new item(16d, 8));
		
		item maxStemItem = items.stream().max(Comparator.comparing(item::getStep)).get();
		items.sort(Comparator.comparing(item::getStep ).thenComparing(reverseOrder(comparing(item::getValue))));
			
		
		int n=maxStemItem.getStep();
		 temp=1;
		
		while (temp<=n) {
		
		Optional<item> findFirst = items.stream().filter(el1 ->  el1.getStep() >=temp ).findFirst();
		if (findFirst.isPresent()) {
			
			resultList.add(findFirst.get());
			temp++;
		} else {
			break;
		}
		
		
		
		}	
			
			
		
		
		
		
		
		Util.printlnLine("total price:");


	
	}
	
	
	
	
	
	static class item  {
		
		private int value;
		private int step;
		private int id;
		
		public item(int id, int value, int step) {
			this.id=id;
			this.value=value;
			this.step=step;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public int getStep() {
			return step;
		}

		public void setStep(int step) {
			this.step = step;
		}

		@Override
		public String toString() {
			return "item [value=" + value + ", step=" + step + ", id=" + id + "]";
		}

		
		
		
		
		
	}
	

	
	

}
