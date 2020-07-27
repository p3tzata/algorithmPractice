package algorithmPractice.greedy;

import java.util.ArrayList;
import java.util.List;

import util.Util;

import java.util.Collections;
import java.util.Comparator;

import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparing;

public class Lecture {

	public static void main(String[] args) {

		List<schedule> schedulesList=new ArrayList<>();
		List<schedule> schedulesListResult=new ArrayList<>();
		
		
		schedulesList.add(new schedule(1, 7));
		schedulesList.add(new schedule(3, 13));
		schedulesList.add(new schedule(5, 9));
		schedulesList.add(new schedule(10, 14));
		
		
		schedulesList.sort(Comparator.comparing(schedule::getFinish_ ));
		
		
		int lastFinish=schedulesList.get(0).getFinish_();
		schedulesListResult.add(schedulesList.get(0));
		
		for(int i=1;i<schedulesList.size();i++) {
			
			if(schedulesList.get(i).getStart()>=lastFinish) {
				lastFinish=schedulesList.get(i).getFinish_();
				schedulesListResult.add(schedulesList.get(i));
			}
			
		}
		
		
		Util.printlnLine(schedulesListResult);
		String debug="debug";
		
		
		
	}
	
	
	
	
	
	
	static class schedule{
		
		int start;
		int finish_;
		public schedule(int start, int finish_) {
			super();
			this.start = start;
			this.finish_ = finish_;
		}
		public int getStart() {
			return start;
		}
		public void setStart(int start) {
			this.start = start;
		}
		public int getFinish_() {
			return finish_;
		}
		public void setFinish_(int finish_) {
			this.finish_ = finish_;
		}
		@Override
		public String toString() {
			return "schedule [start=" + start + ", finish_=" + finish_ + "]";
		}
		
		
		
	}

}
