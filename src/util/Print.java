package util;



public class Print {

	public static <T> void printArray(T[] arr,String delimeter){
		
		printArraySlice(arr, 0, arr.length-1, delimeter);
		
	}
	
	
	public static <T> void printArraySlice(T[] arr,int fromIndx, int toIndx,String delimeter){
	    for(int i=fromIndx;i<=toIndx;i++){
	       if (i!=toIndx) {
	       System.out.print(arr[i]+delimeter);
	       } else {
	    	   System.out.print(arr[i]);
	       }
	       
	    }
	    System.out.println("");
	}
	
	
	
	
	
	public static void printlnLine(Object obj ) {
		System.out.println(obj);
	}
	
	
	public static void printNtime(Object obj,int cnt) {
		for(int i=0; i<cnt; i++) {
			
			System.out.print(obj);
			
		}
		System.out.println("");
		
	}
	
	
	
}
