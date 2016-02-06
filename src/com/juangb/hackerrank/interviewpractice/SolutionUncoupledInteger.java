package com.juangb.hackerrank.interviewpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SolutionUncoupledInteger {

	 public static void main(String[] args) {
	    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	     
		/*Read input*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String numbers=null;
		try{
	    	numbers= br.readLine();
	    }catch(IOException e){
	    	System.out.println("Error reading line"+e);
	    	return;
	    }
		
		try{
    		 StringTokenizer st = new StringTokenizer(numbers, ", ");
    		 int uncoupledInteger =0;
    	     while (st.hasMoreTokens()) {    	         
    	    	 uncoupledInteger= uncoupledInteger^Integer.parseInt(st.nextToken());
    	     }
    	     System.out.println(uncoupledInteger);
    	    
    	}catch(NumberFormatException e){
    		System.out.println("Error parsing line"+e);
    		return;
    	}
	 }
}
