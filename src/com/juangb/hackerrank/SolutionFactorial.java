package com.juangb.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


/*
 * FACTORIAL
 * 
 * n factorial (written as n!) is the number we get when we multiply every positive number from 1 up to n together. In this problem, your code will do the grunt work of computing the factorial.
 * 
 * Problem Statement
 * Write a program that, given a number n from STDIN, prints out the factorial of n to STDOUT:
 * 
 * If n is 0, n factorial is 1
 * n! is not defined for negative numbers.
 * Example 1:
 * 
 * 3! = 3 × 2 × 1 = 6
 * So given the input 3, your program should output:
 * 
 * 6
 * Example 2:
 * 
 * 7! = 7 × 6 × 5 × 4 × 3 × 2 × 1 = 5040
 * So given the input 7, your program should output:
 * 
 * 5040
 * What are factorials good for?
 * Factorials can be used to calculate the number of permutations of a given set. Think—if there are 3 letters—A, B, and C, they can be arranged as: ABC, ACB, BAC, BCA, CAB, or CBA. That's 6 options because A can be put in 3 different slots, B has 2 choices left after A is placed, and C has only one option left after A and B have been placed. That is 3×2×1 = 6 choices.
 * 
 * More generally, if there are three objects, and we want to find out how many different ways there are to arrange (or select them), for the first object, there are 3 choices, for the second object, there are only two choices left as the first object has already been chosen, and finally, for the third object, there is only one position left.
 * 
 * So using what we know about factorials, we know that there are 6 options for arranging 3 items. 3! is equivalent to 3×2×1, or 6.
 * 
 * To dig a bit deeper in to factorials and their role in permutations and combinations (which occasionally come up in interviews), check out this article and its practice problems.
 * 
 * Hints
 * The factorial function grows very fast. There are 3,628,800 ways to arrange 10 items.
 * 
 * This problem can be solved in an imperative style using loops—or in a functional style, using recursion. If you write a recursive solution, its worth reading up on tail-call optimization or watching the Coding for Interviews course lecture on recursion before if your solution's stack level goes too deep
 * 
 * For help on reading from STDIN, see the HackerRank environment help page under the "Sample Problem Statement" section.
 */
public class SolutionFactorial {

	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		
		/*Read input*/
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
        String number=null;
        BigInteger numberBigInteger=null;
    	try{    		
        	number= br.readLine();
        }catch(IOException e){
        	System.out.println("Error reading line"+e);
        	return;
        }
    	try{
    		numberBigInteger = new BigInteger(number);
    	}catch(NumberFormatException e){
    		System.out.println("Error parsing line"+e);
        	return;
    	}
    	SolutionFactorial sol = new SolutionFactorial();
    	System.out.println(sol.factorial(numberBigInteger));
    	
    }
	
	public BigInteger factorial(BigInteger number){
		if(number.equals(BigInteger.ZERO) || number.equals(BigInteger.ONE))
			return BigInteger.ONE;
		return number.multiply(factorial(number.subtract(BigInteger.ONE)));
	}
}
