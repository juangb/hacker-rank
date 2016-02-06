package com.juangb.hackerrank.interviewpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;


/*
 * COIN CHANGE PROBLEM
 * 
 * How many different ways can you make change for an amount, given a list of coins? In this problem, your code will need to efficiently compute the answer.
 * 
 * Task
 * 
 * Write a program that, given
 * 
 * The amount N to make change for and the number of types M of infinitely available coins
 * A list of M coins - C={C1,C2,C3,..,CM}
 * Prints out how many different ways you can make change from the coins to STDOUT.
 * 
 * The problem can be formally stated:
 * 
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of C={C1,C2,…,CM} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
 * 
 * Constraints
 * 
 * 1≤Ci≤50
 * 1≤N≤250
 * 1≤M≤50
 * The list of coins will contain distinct integers.
 * Solving the overlapping subproblems using dynamic programming
 * 
 * You can solve this problem recursively, but not all the tests will pass unless you optimise your solution to eliminate the overlapping subproblems using a dynamic programming solution
 * 
 * Or more specifically;
 * 
 * If you can think of a way to store the checked solutions, then this store can be used to avoid checking the same solution again and again.
 * Input Format
 * 
 * First line will contain 2 integer N and M respectively. 
 * Second line contain M integer that represent list of distinct coins that are available in infinite amount.
 * 
 * Output Format
 * 
 * One integer which is the number of ways in which we can get a sum of N from the given infinite supply of M types of coins.
 * 
 * Sample Input
 * 
 * 4 3
 * 1 2 3 
 * Sample Output
 * 
 * 4
 * Sample Input #02
 * 
 * 10 4
 * 2 5 3 6
 * Sample Output #02
 * 
 * 5
 * Explanation
 * 
 * Example 1: For N=4 and C={1,2,3} there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}
 * 
 * Example 2: For N=10 and C={2,5,3,6} there are five solutions: {2,2,2,2,2},{2,2,3,3},{2,2,6},{2,3,5},{5,5}.
 * 
 * Hints
 * 
 * Think about the degenerate cases:
 * 
 * How many ways can you give change for 0 cents?
 * How many ways can you give change for >0 cents, if you have no coins?
 * If you are having trouble defining your solutions store, then think about it in terms of the base case (n=0)
 * For help on reading from STDIN, see the HackerRank environment help page under the "Sample Problem Statement" section.
 */
public class SolutionCoinChange {

	public ArrayList<Hashtable<Integer,Long>> results;
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		
		/*Read input*/
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
        String line1=null;
        String line2=null;
        
        int changeAmount;
        int numberOfCoins;
        int[] coinValues;
    	try{    		
    		line1= br.readLine();
    		line2= br.readLine();
        }catch(IOException e){
        	System.out.println("Error reading line"+e);
        	return;
        }
    	try{
    		String[] line1Numbers= line1.split(" ");
    		changeAmount=Integer.parseInt(line1Numbers[0]);
    		numberOfCoins=Integer.parseInt(line1Numbers[1]);
    		
    		String[] line2Numbers= line2.split(" ");
    		coinValues= new int[line2Numbers.length];
    		for(int i=0; i<line2Numbers.length;i++){
    			coinValues[i]=Integer.parseInt(line2Numbers[i]);
    		}
    		
    	}catch(NumberFormatException e){
    		System.out.println("Error parsing line"+e);
        	return;
    	}
    	SolutionCoinChange sol = new SolutionCoinChange();
    	sol.results=new ArrayList<Hashtable<Integer,Long>>(coinValues.length);  
    	for(int i=0; i<coinValues.length; i++){
    		sol.results.add(new Hashtable<Integer,Long>());
    	}
    	System.out.println(sol.calculateChange(changeAmount, coinValues, coinValues.length));
    	
    }
	
	/*
	 * Solution with dynamic programming
	 * To count total number solutions, we can divide all set solutions in two sets.
     * 1) Solutions that do not contain mth coin (or Sm).
     * 2) Solutions that contain at least one Sm.
	 */
	public Long calculateChange(int changeAmount, int[] coinValues, int lastPos){
		if(changeAmount==0)
			return 1L;
		else if(changeAmount<0)
			return 0L;
		else if(lastPos==0)
			return 0L;
		
		if(results.get(lastPos-1).get(changeAmount)!=null)
			return results.get(lastPos-1).get(changeAmount);
		
		long result = calculateChange(changeAmount, coinValues, lastPos-1) + calculateChange(changeAmount-coinValues[lastPos-1], coinValues, lastPos);
		results.get(lastPos-1).put(changeAmount,result);
		return result;
		
	
		
	}
	
	
	/*
	 * Solution using tail recursion
	 * To count total number solutions, we can divide all set solutions in two sets.
     * 1) Solutions that do not contain mth coin (or Sm).
     * 2) Solutions that contain at least one Sm.
	 */
	public Long calculateChangeTailRecursion(int changeAmount, int[] coinValues, int lastPos){
		if(changeAmount==0)
			return 1L;
		else if(changeAmount<0)
			return 0L;
		else if(lastPos==0)
			return 0L;
		
			
		return calculateChange(changeAmount, coinValues, lastPos-1) + calculateChange(changeAmount-coinValues[lastPos-1], coinValues, lastPos);
		
	
		
	}
}




