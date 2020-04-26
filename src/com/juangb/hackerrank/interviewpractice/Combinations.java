package com.juangb.hackerrank.interviewpractice;


/*
 * 
* For each letter from input start position to end of input string
*     Select the letter into the current position in output string
*     Print letters in output string
*     If the current letter isn't the last in the input string
* Generate remaining combinations starting at next position with iteration starting
* at next letter beyond the letter just selected
 * 
 * 
 */
public class Combinations {
	public static void main(String[] args){
		Combinations comb = new Combinations();
		comb.combine("abcd");
	}
	void combine( String str ){
	    int           length = str.length();
	    char[]        instr = str.toCharArray();
	    StringBuilder outstr = new StringBuilder();
	    doCombine( instr, outstr, length, 0, 0 );
	}

	void doCombine( char[] instr, StringBuilder outstr, int length,
	                int level, int start ){
	    for( int i = start; i < length; i++ ){
	        outstr.append( instr[i] );
	       System.out.println( outstr );

	        if( i < length - 1 ){
	            doCombine( instr, outstr, length, level + 1, i + 1 );
	        }

	        outstr.setLength( outstr.length() - 1);
	    }
	}

}
