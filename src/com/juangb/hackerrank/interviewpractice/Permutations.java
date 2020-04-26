package com.juangb.hackerrank.interviewpractice;


/*
 * 
 * If you're past the last position
 *     Print the string
 *     Return
 * Otherwise
 *     For each letter in the input string
 *     If it's marked as used, skip to the next letter
 *     Else place the letter in the current position
 *         Mark the letter as used
 *         Permute remaining letters starting at current position + 1
 *         Mark the letter as unused
 * 
 * 
 */
public class Permutations {
	
	public static void main(String[] args){
		Permutations comb = new Permutations();
		comb.permute("abcd");
	}
	void permute( String str ){
	    int          length = str.length();
	    boolean[]    used = new boolean[ length ];
	    StringBuffer out = new StringBuffer();
	    char[]       in = str.toCharArray();

	    doPermute( in, out, used, length, 0 );
	}

	void doPermute( char[] in, StringBuffer out,
	                boolean[] used, int length, int level ){
	    if( level == length ){
	        System.out.println( out.toString() );
	        return;
	    }

	    for( int i = 0; i < length; ++i ){
	        if( used[i] ) continue;

	        out.append( in[i] );
	        used[i] = true;
	        doPermute( in, out, used, length, level + 1 );
	        used[i] = false;
	        out.setLength( out.length() - 1 );
	    }
	}

}
