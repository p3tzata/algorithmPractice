package algorithmPractice.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ReadOnlyBufferException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import algorithmPractice.combination.exam.Words;


public class MusalaSoft {

	public static void main(String[] args) {
		//System.out.println((1+3)/2);
		
	
		
		
		
		List<Integer> result = new ArrayList<>();
		
		List<String> wordList = new ArrayList<>();
		wordList.add("bbooo");
		wordList.add("boook");
		wordList.add("break");
		wordList.add("abbaaasssss");
		
		//procced_word("abbaaasssss");
		
	
		for(int i=0;i<wordList.size();i++) {
			String word = wordList.get(i);
			
			
			int procced_word = procced_word(word);
			result.add(procced_word);
			
			
		}
		
		System.out.println(result);
		
		
	   }







	private static int procced_word(String word ) {
		
		int marker;
		int operNum=0;
		int count=0;
		
		
		for (int j=0;j<word.length()-1;j=marker) {
			 count=0;
			 marker=j+1;
			 char curChar=word.charAt(j);
			 
			 while (word.charAt(marker)==word.charAt(j) ) {
				 
				 marker++;
				 count++;
				 
				 if (marker==word.length()) {
					 break;
				 }
				 
			 }
			 
			 operNum=operNum+((count+1)/2);
			 //System.out.println( (count+1)/2 );	 
		}
		// System.out.println( operNum);	
		 return operNum;
		 
	}

	
	
	
	
	
	
	private static List<Integer> fibunachi() {
	
		int number=1;
		
		List<Integer> fib = new ArrayList<>();
		fib.add(0);
		fib.add(1);
				
		
		for(int i=2;i<=number-1;i++) {
			int f=fib.get(i-1);
			int s=fib.get(i-2);
			fib.add( f + s );
		}
				
		return fib;
		
	}







	private static void readBuffer() {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int t = 0; t < n; t++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a+b);
        }
		
	}
		
		
	}


