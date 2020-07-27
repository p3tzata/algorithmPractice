package algorithmPractice.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;



import util.Util;

public class FractionalKnapsack {

	static private double capacity;
	static private List<item> items;
	
	
	public static void main(String[] args) {
		
		capacity=13;
		int tmpFreight=0;
		double totalPrice=0;
		items=new ArrayList<>();
		
		items.add(new item(13d,7));
		items.add(new item(15d, 7));
		//items.add(new item(16d, 8));
		
		
		
		Collections.sort(items);
		
		while(tmpFreight<capacity) {
			
			
			for (int i=0;i<items.size();i++) {
				
				double remain = capacity - tmpFreight;
				
				if (remain==0) {
					break;
				} 
				
				if (items.get(i).getWeight() > remain) {
					double fraction = remain * 1.0d / items.get(i).getWeight();
					
					Util.printlnLine(String.format("take %.2f of item with price %.2f",fraction*100,items.get(i).getPrice()));
					tmpFreight+=fraction*items.get(i).getWeight();
					totalPrice+=fraction*items.get(i).getPrice();
					
					
					
				} else {
					tmpFreight+=items.get(i).getWeight();
					Util.printlnLine(String.format("take 100 of item with price %.2f",items.get(i).getPrice()));
					totalPrice+=items.get(i).getPrice();
				}
				
				
				
				
				
			}
			
			
			
			
			
		}
		
		
		
		
		Util.printlnLine("total price:"+ totalPrice);

	}
	
	
	
	
	
	
	
	static class item implements Comparable<item> {
		
		private Double price;
		private double weight;
		
		public item(Double price, double weight) {
			this.price=price;
			this.weight=weight;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public double getWeight() {
			return weight;
		}

		public void setWeight(Integer weight) {
			this.weight = weight;
		}

		@Override
		public int compareTo(item o) {
			
			
			
			if (this.getPrice()/this.getWeight() ==  o.getPrice()/o.getWeight()) {
				
				return 0;
			} if (this.getPrice()/this.getWeight() >  o.getPrice()/o.getWeight()) {
				return -1;
			} else {
				return 1;
			}
				
			
		}
		
		
		
		
	}
	
	
	

}
