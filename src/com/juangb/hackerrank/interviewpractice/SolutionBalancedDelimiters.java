package com.juangb.hackerrank.interviewpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * BALANCED DELIMITERS PROBLEM
 * 
 * For this question, you will parse a string to determine if it contains only "balanced delimiters."

 * A balanced delimiter starts with an opening character ((, [, {), ends with a matching closing character (), ], } respectively), and has only other matching delimiters in between. A balanced delimiter may contain any number of balanced delimiters.
 * 
 * Examples
 * The following are examples of balanced delimiter strings: 
 * ()[]{}
 * ([{}])
 * ([]{})
 * 
 * The following are examples of invalid strings: 
 * ([)]
 * ([]
 * [])
 * ([})
 * 
 * Input is provided as a single string. Your output should be True or False according to whether the string is balanced. For example:
 * 
 * Input: 
 * ([{}])
 * Output: 
 * True
 * 
 * Input Format and Restrictions
 * Each test case will consist of a string only containing the characters ()[]{}. The length of the string will not exceed 2KB.
 * 
 * Things to think about
 * How will you keep track of previous delimiters?
 * How will you determine if the next character is valid?
 * When you reach the end of the string, how do you know if it is balanced?
 * 
 */
public class SolutionBalancedDelimiters {

	 public static void main(String[] args) {
	    /* Enter your code here. Read input from STDIN. Print output to STDOUT.*/
	     
		/*Read input*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String line=null;
		try{
			line= br.readLine();
			if(line.length()==0){
				System.out.println("True");
				return;
			}
				
	    }catch(IOException e){
	    	System.out.println("Error reading line"+e);
	    	return;
	    }
		Stack<Character> characterStack= new Stack<Character>();
		for(int i=0; i<line.length();i++){
			char character = line.charAt(i);
			switch(character){
			case '{':
			case '(':
			case '[':
				characterStack.push(character);
				break;
			case '}':
			case ')':
			case ']': // It would be a closing character	
				if(characterStack.isEmpty()){
					System.out.println("False");
					return;
				}
				char openChar=characterStack.pop();
				if((character=='}' && openChar!='{') ||(character==')' && openChar!='(') ||(character==']' && openChar!='[') ){
						System.out.println("False");
						return;
				}
				
			}
		}
		if(characterStack.isEmpty())
			System.out.println("True");
		else
			System.out.println("False");
		
	 }
}
