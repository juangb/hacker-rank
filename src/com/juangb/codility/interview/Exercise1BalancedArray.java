package com.juangb.codility.interview;

/*
 * EXERCISE 1
 * Find the index in an array where given a number X the number of numbers different than x before that index is equal to the number of numbers equal to x after it.
 */
public class Exercise1BalancedArray {

	public int solution(int X, int[] A) {
        // write your code in Java SE 8
		int sufix=0; //number of numbers different than x
		int prefix=0; //number of numbers equal to x
		

		if(A==null || A.length==0)
			return -1;		
		
		if(A.length==1){
			if(A[0]==X)
				return 0;
			else
				return 1;
		}
		
		for(int i=0; i<A.length; i++){
			if(A[i]!=X)
				sufix=sufix+1;
		}
		for(int i=0; i<=A.length; i++){
			if(i>0){
				if(A[i-1]==X){
					prefix=prefix+1;				
				}else{
					sufix=sufix-1;
				}
			}
			if(prefix==sufix)
				return i;
		}
		return -1;
    }
}
