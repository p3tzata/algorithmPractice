package algorithmPractice.dynamicProgramming.exam;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;



import util.Util;

public class Towns_ex {

	public static void main(String[] args) {
		List<Town> towns = new ArrayList<>();
		
		/*
		towns.add(new Town(108214, "Pleven"));
		towns.add(new Town(339077, "Plovdiv"));
		towns.add(new Town(200612, "Burgas"));
		towns.add(new Town(334688, "Varna"));
		towns.add(new Town(1241396, "Sofia"));
		towns.add(new Town(92162, "Sliven"));
		towns.add(new Town(151951, "Ruse"));
		towns.add(new Town(137907, "StaraZagora"));
		*/
		towns.add(new Town(19906, "NikiTown"));
		towns.add(new Town(19832, "EvlogiTown"));
		towns.add(new Town(19894, "IvoTown"));
		towns.add(new Town(19896, "Ceco"));
		
		
		int[] resultPathInc= new int[towns.size()];
		int[] resultPathDcr= new int[towns.size()];
		
		int[] resultInc= new int[towns.size()];
		int[] resultDcr= new int[towns.size()];
		
		Deque<Town> result=new ArrayDeque<Town>(); 
		
		resultPathInc[0]=-1;
		resultPathDcr[towns.size()-1]=-1;
		
		
		resultInc[0]=1;
		resultDcr[towns.size()-1]=1;

		
		for(int i=1;i<towns.size();i++) {
			
			long currentMaxVal=0;
			resultInc[i]=1;
			resultPathInc[i]=-1;
			for(int j=0;j<i;j++) {
				if ((towns.get(i).getPeople()) > towns.get(j).getPeople()   ) {
					if(resultInc[j] + 1>resultInc[i]) {
						resultInc[i]=resultInc[j]+1;
						resultPathInc[i]=j;
					}
				}
				
				
			}
			
			
		}
		
		
		for(int i=towns.size()-2;i>=0;i--) {
			
			long currentMaxVal=0;
			resultDcr[i]=1;
			resultPathDcr[i]=-1;
			for(int j=i+1;j<towns.size();j++) {
				if ((towns.get(i).getPeople()) > towns.get(j).getPeople()   ) {
				
					if(resultDcr[j] + 1>resultDcr[i]) {
						
						resultDcr[i]=resultDcr[j]+1;
						resultPathDcr[i]=j;
					}
				
				}
				
				
			}
			
			
		}
		
		int curVal=-1;
		int curIndx=-1;
		for(int i=0;i<towns.size();i++) {
			
			if( (resultDcr[i]+resultInc[i]) > curVal ) {
				
				curVal=resultDcr[i]+resultInc[i];
				curIndx=i;
				
			}
			
			
		}
		result.add(towns.get(curIndx));
		
		int prev=resultPathInc[curIndx];
		while(prev!=-1) {
			//Util.printlnLine(towns.get(prev).getName());
			result.addFirst(towns.get(prev));
			prev=resultPathInc[prev];
			
			
		}
		
		 prev=resultPathDcr[curIndx];
		while(prev!=-1) {
			//Util.printlnLine(towns.get(prev).getName());
			result.addLast(towns.get(prev));
			
			prev=resultPathDcr[prev];
			
			
		}
		
		
		Iterator<Town> iterator = result.iterator();
		
		while (iterator.hasNext()) {
			Town town = (Town) iterator.next();
			Util.printlnLine(town.toString());
		}
		
		
		
		String debugString = "debug";
		System.out.print(debugString);
		
		
		
		
	}

}


class Town{
	
	private long people;
	private String name;
	
	public Town(long people, String name) {
		super();
		this.people = people;
		this.name = name;
	}

	public long getPeople() {
		return people;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Town [people=" + people + ", name=" + name + "]";
	}

	
	
	
	
	
	
}


