package com.juangb.hackerrank.interview.coinbase;
import java.io.*;
public class SolutionDaysToReachOther {
public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
	/*Read input*/
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
    try{    		
    	String line= br.readLine();
    	String numbers[] = line.split(" ");
    	double x = Integer.parseInt(numbers[0].trim());
    	double y = Integer.parseInt(numbers[1].trim());
    	double d = Integer.parseInt(numbers[2].trim());
    	
    	if(x==y){
    		System.out.println("-1");
    		return;
    	}
    	double days= d/(y-x);
    	int daysInt = (int) (Math.ceil(days));
    	/*if(days<0){
    		System.out.println("-1");
    		return;
    	}*/
    	System.out.println(daysInt);
    	return;
    }catch(IOException e){
    	System.out.println("Error reading line"+e);
    	return;
    }catch(NumberFormatException e2){
    	System.out.println("Error parsing line"+e2);
    	return;
    }
}
}