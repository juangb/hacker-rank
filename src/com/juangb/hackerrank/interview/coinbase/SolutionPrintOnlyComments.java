package com.juangb.hackerrank.interview.coinbase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SolutionPrintOnlyComments {

	 public static void main(String args[] ) throws Exception {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    
		    
			try{
				int currentInt;
				
				
				boolean toBufferOneLine=false;
				boolean toBufferMultipleLines=false;
				char lastChar=(char)-1;
				while(( currentInt = br.read())!=-1){
					char currentChar = (char)currentInt;
					
					if(!toBufferOneLine && !toBufferMultipleLines){
						if(currentChar=='/' && lastChar=='/'){
							toBufferOneLine=true;
							System.out.print(lastChar);
							System.out.print(currentChar);							
							
						}else if(currentChar=='*' && lastChar=='/'){
							toBufferMultipleLines=true;
							System.out.print(lastChar);
							System.out.print(currentChar);		
						}
					}else if(toBufferOneLine){
						if(currentChar=='\n' || currentChar=='\r'){							
							toBufferOneLine=false;							
						}
						System.out.print(currentChar);
					}else if(toBufferMultipleLines){
						if(currentChar=='/' && lastChar=='*'){							
							toBufferMultipleLines=false;							
						}
						System.out.print(currentChar);
					}
					
					lastChar=currentChar;
				}
				
				
					
		    }catch(IOException e){
		    	System.out.println("Error reading line"+e);
		    	return;
		    }
	    }
	
}
