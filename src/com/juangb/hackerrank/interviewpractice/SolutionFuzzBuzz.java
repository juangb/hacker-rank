package com.juangb.hackerrank.interviewpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 
 * Why Practice FizzBuzz?
 * FizzBuzz is a classic programming interview problem popularized by Jeff Atwood's post Why Can't Programmers... Program?.
 * 
 * While the purported simplicity of the problem can lead to many candidates being offended that they would even get asked such a simple question, often times you will come across FizzBuzz or variants as the first "weed out the non-programmers" question in phone screens.
 * 
 * Problem Statement
 * Write a program that, given a number n from STDIN, prints out all numbers from 1 to n (inclusive) to STDOUT, each on their own line. But there's a catch:
 * 
 * For numbers divisible by 3, instead of n, print Fizz
 * For numbers divisible by 5, instead of n, print Buzz
 * For numbers divisible by 3 and 5, just print FizzBuzz
 * For example, given the input 1, your program should output:
 * 
 * 1
 * Another example, given the input 15, your program should output:
 * 
 * 1
 * 2
 * Fizz
 * 4
 * Buzz
 * Fizz
 * 7
 * 8
 * Fizz
 * Buzz
 * 11
 * Fizz
 * 13
 * 14
 * FizzBuzz
 */
public class SolutionFuzzBuzz {

	
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
    	SolutionFuzzBuzz sol = new SolutionFuzzBuzz();
    	sol.countFizzBuzz(numberInt);
    	
    }
	
	public void countFizzBuzz(int number){
		for(int i=1; i<=number; i++){
			boolean fizz=false;
			boolean buzz =false;
			if(i%3==0){
				System.out.print("Fizz");
				fizz=true;
			}if(i%5==0){
				System.out.print("Buzz");
				buzz=true;
			}
			if(!buzz && !fizz){
				System.out.println(i);
			}else{
				System.out.println("");
			}
			
		}
		
		
	}
	
	
}
