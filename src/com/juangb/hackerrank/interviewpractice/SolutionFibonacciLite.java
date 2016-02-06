package com.juangb.hackerrank.interviewpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * FIBONACCI LITE
 * 
 * For this question, you will write a program that generates values from the Fibonacci sequence. The Fibonnaci sequence is recursively defined by:
 * 
 * Fn = Fn - 1 + Fn - 2
 * 
 * Using the following seed values: * 
 * F0 = 0, F1 = 1
 * 
 * Given a number n, print the nth value of the Fibonacci sequence.
 * 
 * Examples
 * Input: 
 * 12
 * Output: 
 * 144
 * 
 * Input: 
 * 30
 * Output: 
 * 832040
 * 
 * General Approach
 * Find the base case(s),
 * Have your function recognize the base case(s) and provide a solution,
 * Recursively define a solution to the sub-problem for other inputs,
 * Call your function on the input and print the result to STDOUT.
 * 
 * Things to think about
 * Although we are doing this mainly to learn recursion, think about whether this is effecient in your language of choice. Does your language support tail call elimination?
 * 
 * Input Format and Restrictions
 * Each test case will consist of a single positive integer n. * 
 * The inputs will always satisfy the following restrictions: * 
 * Fn < 2^32 - 1,
 * 0 <= n < 50
 * 
 * 
 */
public class SolutionFibonacciLite {

	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		
		/*Read input*/
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
        String number=null;
        int numberInt=0;
    	try{    		
        	number= br.readLine();
        }catch(IOException e){
        	System.out.println("Error reading line"+e);
        	return;
        }
    	try{
    		numberInt = Integer.parseInt(number);
    	}catch(NumberFormatException e){
    		System.out.println("Error parsing line"+e);
        	return;
    	}
    	SolutionFibonacciLite sol = new SolutionFibonacciLite();
    	System.out.println(sol.fibbonacciRecursive(numberInt));
    	
    }
	
	public int fibbonacciRecursive(int number){
		if(number==0)
			return 0;
		if(number==1)
			return 1;
		
		return fibbonacciRecursive(number-1)+fibbonacciRecursive(number-2);
	}
	
	public int fibbonacciIterative(int number){
		if(number==0)
			return 0;
		if(number==1)
			return 1;
		int fibprev2 =0;
		int fibprev=1;
		int temp =0;
		for(int i=2;i<number; i++){
			temp=fibprev;
			fibprev=fibprev+fibprev2;
			fibprev2=temp;
		}
		return fibprev2+fibprev;
	}
}
