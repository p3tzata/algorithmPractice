package algorithmPractice.greedy;

import java.util.ArrayList;
import java.util.List;

import algorithmPractice.greedy.KnightTour.position;

import util.Util;

public class KnightTour {
	
	static Integer[][] matrix;
	static int dimension;
	static int trackerStep;
	
	public static void main(String[] args) {
		
		dimension=8;
		matrix = new Integer[dimension][dimension];
		
		
		//Util.printMatrix(matrix, 2);
		
		
		trackerStep=0;
		position pos = new position(0, 0);
		if (isValidStep(pos)) {
			matrix[pos.getX()][pos.getY()]=trackerStep;
		}
		
		trackerStep++;
		Util.printMatrix(matrix, 2);
		while ( listAll(pos).size()>0) {
			int tmpDegree=Integer.MAX_VALUE;
			int tmpIndex=-1;
			
			if (trackerStep==33) {
				String deg="debug";
			}
			
			List<position> listAll = listAll(pos);
			
			
			for (int i=0;i<listAll.size();i++) {
			    int size = listAll(listAll.get(i)).size();
			    
				if (size<tmpDegree) {
					tmpDegree=size;
					tmpIndex=i;
				}
				
				
			}
			
			pos = listAll(pos).get(tmpIndex);
			
			
			
			
			
			
			matrix[pos.getX()][pos.getY()]=trackerStep;
			
			trackerStep++;
			Util.printMatrix(matrix, 2);
			
		}
		
		
		List<position> listAll = listAll(pos);
		
		
		
		
		
		Util.printMatrix(matrix, 2);
	
	}
	
	
	
	
	 static List<position> listAll(position pos) {
		
		 List<position> result= new ArrayList<>();
		 position position1 = new position(pos.getX()+2, pos.getY()+1);
		 if(isValidStep(position1)) {
			 result.add(position1);
		 }
		 
		 

		 position position2 = new position(pos.getX()+1, pos.getY()+2);
		 if(isValidStep(position2)) {
			 result.add(position2);
		 }
		 
		 
		 position position3 = new position(pos.getX()-1, pos.getY()+2);
		 if(isValidStep(position3)) {
			 result.add(position3);
		 }
		 
		 position position11 = new position(pos.getX()-2, pos.getY()+1);
		 if(isValidStep(position11)) {
			 result.add(position11);
		 }
		 
		 
		 
		 
		 position position4 = new position(pos.getX()-2, pos.getY()-1);
		 if(isValidStep(position4)) {
			 result.add(position4);
		 }
		 
		 
		 
		 position position5 = new position(pos.getX()-1, pos.getY()-2);
		 if(isValidStep(position5)) {
			 result.add(position5);
		 }
		 
		 
		 
		 position position6 = new position(pos.getX()+1, pos.getY()-2);
		 if(isValidStep(position6)) {
			 result.add(position6);
		 }
		 
		 
		
		 
		 
		 
		 
		 
		 position position7 = new position(pos.getX()+2, pos.getY()-1);
		 if(isValidStep(position7)) {
			 result.add(position7);
		 }
		 
		 
		
		
		 
		 
		 
		 
		
		 
		
		
		 
		 
		 
		 
		 
		 
		 
		
		return result;
	}




	private static boolean isValidStep(position pos) {
		
		if(pos.getX()>dimension-1 || pos.getY()>dimension-1  
	   ||	pos.getX()<0 || pos.getY()<0  || matrix[pos.getX()][pos.getY()]!=null 
				) {
			return false;
		} else {
			return true;
		}
	}
	 
	 
	 
	static class position{
		
		int x;
		int y;
		public position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		@Override
		public String toString() {
			return "position [x=" + x + ", y=" + y + "]";
		}
		
		
		
		
	}
	 
	
	

}
