package algorithmPractice.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import algorithmPractice.greedy.SetCover.setComparator;
import util.Util;


public class SetCover {

	static HashSet<Integer> university1;
	static HashSet<Integer> university2;
	static HashSet<Integer> university;
	static List<HashSet<Integer>> sets;
	static List<HashSet<Integer>> sets1;
	static List<HashSet<Integer>> sets2;
	static List<HashSet<Integer>> result;
	
	
	static class setComparator implements Comparator<HashSet<Integer>>{

		@Override
		public int compare(HashSet<Integer> o1, HashSet<Integer> o2) {
			int o1ElementCount=0;
			int o2ElementCount=0;
			
			Iterator<Integer> iterator = university.iterator();	
			while(iterator.hasNext()) {
				Integer next = iterator.next();
				
				if (o1.contains(next)) {
					o1ElementCount++;
				}
				
				if (o2.contains(next)) {
					o2ElementCount++;
				}
				
				
			}
			
			return o2ElementCount-o1ElementCount;
			//return o2.size()-o1.size();
		}
		
	}

		
	
	
	public static void main(String[] args) {

		result =  new ArrayList<>();
		
		university = new HashSet<>();
		university.add(1);
		university.add(2);
		university.add(3);
		university.add(4);
		university.add(5);
		university.add(6);
		
		sets = new ArrayList<>();
		
		//sets.add(new HashSet<>() {{add(2);}});
		sets.add(new HashSet<>() {{add(1);add(3);}});
		sets.add(new HashSet<>() {{add(1);}});
		sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		
		
		
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});
		sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});
		sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});
		/**/
		
		
		
		
		
		
		
		sets.add(new HashSet<>() {{add(2);add(4);}});
		sets.add(new HashSet<>() {{add(2);add(5);}});
		sets.add(new HashSet<>() {{add(2);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(6);}});
		sets.add(new HashSet<>() {{add(2);add(3);add(6);}});
		sets.add(new HashSet<>() {{add(4);add(5);add(6);}});
		sets.add(new HashSet<>() {{add(6);}});
		Util.printlnLine(university.toString());
		
		long currentTimeMillis = System.currentTimeMillis();
		//variant1();
		//Util.printlnLine(System.currentTimeMillis()-currentTimeMillis);
		 currentTimeMillis = System.currentTimeMillis();
		variant2();
		Util.printlnLine(System.currentTimeMillis()-currentTimeMillis);
		
		
		
		
		
		
	}


	private static void variant2() {
        setComparator setComparator = new setComparator();
		sets2= new ArrayList<>(sets);
		university2=new HashSet<>(university);
        sets2.sort(setComparator);
        result =  new ArrayList<>();
        while (university2.size()>0 ) {
			int currentCountEl=0;
			int tmpCountEl=0;
			int curentIndex=-1;
		for (int i=0;i<sets2.size();i++) {
			tmpCountEl=0;
			HashSet<Integer> tmpHashSet = sets2.get(i);
			Iterator<Integer> iteratorUniverse = university2.iterator();
			
			while(iteratorUniverse.hasNext()) {
				if(tmpHashSet.contains(iteratorUniverse.next())) {
					tmpCountEl++;
				}
			}
			
			if (tmpCountEl>currentCountEl) {
				curentIndex=i;
				currentCountEl=tmpCountEl;
			}
			
			
			
		}
		
		if(curentIndex!=-1) {
			HashSet<Integer> winSet = sets2.get(curentIndex);
			sets2.remove(curentIndex);
			result.add(new HashSet<>(winSet));
			Iterator<Integer> iteratorWinSet = winSet.iterator();
		
			while(iteratorWinSet.hasNext()) {
				university2.remove(iteratorWinSet.next());
		}
			
			
		} else {
			break;
			//Util.printlnLine("break");
		}
		
	}
        
        if(university2.size()>0) {
			Util.printlnLine("No solution");
		} else {
			Util.printlnLine(result.toString());
		}
        
		Util.printlnLine("Debug");
	}


	private static void variant1() {
		university1=new HashSet<>(university);
		sets1= new ArrayList<>(sets);
		while (university1.size()>0 ) {
			int currentCountEl=0;
			int tmpCountEl=0;
			int curentIndex=-1;
		for (int i=0;i<sets1.size();i++) {
			tmpCountEl=0;
			HashSet<Integer> tmpHashSet = sets1.get(i);
			Iterator<Integer> iteratorUniverse = university1.iterator();
			
			while(iteratorUniverse.hasNext()) {
				if(tmpHashSet.contains(iteratorUniverse.next())) {
					tmpCountEl++;
				}
			}
			
			if (tmpCountEl>currentCountEl) {
				curentIndex=i;
				currentCountEl=tmpCountEl;
			}
			
			
			
		}
		
		if(curentIndex!=-1) {
			HashSet<Integer> winSet = sets1.get(curentIndex);
			sets1.remove(curentIndex);
			result.add(new HashSet<>(winSet));
			Iterator<Integer> iteratorWinSet = winSet.iterator();
		
			while(iteratorWinSet.hasNext()) {
				university1.remove(iteratorWinSet.next());
		}
			
			
		} else {
			break;
			//Util.printlnLine("break");
		}
		
	}
		
		
		if(university1.size()>0) {
			Util.printlnLine("No solution");
		} else {
			Util.printlnLine(result.toString());
		}
		
	}

}
