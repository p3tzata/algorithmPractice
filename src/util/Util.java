package util;



public class Util {

public static <T> void printMatrix(T[][] arr, int cellLength){
		
		
		for (int i=0;i<arr.length;i++) {
			
			for(int j=0;j<arr[i].length;j++) {
				
				System.out.print( "[" + padLeft( String.valueOf( arr[i][j]==null ? "" : arr[i][j] ) ,cellLength," ") + "]" );
				
				
				
			}
			System.out.println();
			
		}
	
		System.out.println();
	
		
	}
	
	
	
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
	
	
	public static  String  padLeft(String arr, int length,String append) {
	    if (arr.length() >= length) {
	        return arr;
	    }
	    StringBuilder sb = new StringBuilder();
	    while (sb.length() < length - arr.length()) {
	        sb.append(append);
	    }
	    sb.append(arr);
	 
	    return sb.toString();
	}
	
	public static void swap(Integer[] arr,Integer a, Integer b) {
		Integer tmpString;
		tmpString=arr[a];
		arr[a]=arr[b];
		arr[b]=tmpString;
		
		
	}
	
	
}
