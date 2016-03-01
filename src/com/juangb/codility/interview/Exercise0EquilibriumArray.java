package com.juangb.codility.interview;

import java.math.BigInteger;

/*
 * INTERVIEW TEST QUESTION
 * This is a demo task. You can read about this task and its solutions in this blog post.
 * 
 * A zero-indexed array A consisting of N integers is given. An equilibrium index of this array is any integer P such that 0 ≤ P < N and the sum of elements of lower indices is equal to the sum of elements of higher indices, i.e. 
 * A[0] + A[1] + ... + A[P−1] = A[P+1] + ... + A[N−2] + A[N−1].
 * Sum of zero elements is assumed to be equal to 0. This can happen if P = 0 or if P = N−1.
 * 
 * For example, consider the following array A consisting of N = 8 elements:
 * 
 *   A[0] = -1
 *   A[1] =  3
 *   A[2] = -4
 *   A[3] =  5
 *   A[4] =  1
 *   A[5] = -6
 *   A[6] =  2
 *   A[7] =  1
 * P = 1 is an equilibrium index of this array, because:
 * 
 * A[0] = −1 = A[2] + A[3] + A[4] + A[5] + A[6] + A[7]
 * P = 3 is an equilibrium index of this array, because:
 * 
 * A[0] + A[1] + A[2] = −2 = A[4] + A[5] + A[6] + A[7]
 * P = 7 is also an equilibrium index, because:
 * 
 * A[0] + A[1] + A[2] + A[3] + A[4] + A[5] + A[6] = 0
 * and there are no elements with indices greater than 7.
 * 
 * P = 8 is not an equilibrium index, because it does not fulfill the condition 0 ≤ P < N.
 * 
 * Write a function:
 * 
 * int solution(int A[], int N);
 * 
 * that, given a zero-indexed array A consisting of N integers, returns any of its equilibrium indices. The function should return −1 if no equilibrium index exists.
 * 
 * For example, given array A shown above, the function may return 1, 3 or 7, as explained above.
 * 
 * Assume that:
 * 
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 * Complexity:
 * 
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 * 
 */
public class Exercise0EquilibriumArray {

	
	
	// Solution using BigInt to avoid overflow the sum of numbers
	// Correctness 100% Performance 81%
	public int solution(int[] A) {
		if(A==null || A.length==0)
			return -1;
		if(A.length==1)
			return 0;
	   
		BigInteger prefix= BigInteger.ZERO;
		BigInteger sufix= BigInteger.ZERO;
		for(int i=1; i<A.length; i++){ //First element is not added
			sufix=sufix.add(new BigInteger(A[i]+""));
		}
		if(prefix.equals(sufix))
			return 0;
		for(int i=1; i<A.length; i++){
			prefix = prefix.add(new BigInteger(Integer.toString(A[i-1])));
			sufix=sufix.subtract(new BigInteger(Integer.toString(A[i])));
			if(prefix.equals(sufix))
				return i;
		}
		return -1;
	}
	
	// Solution using Long to increase speed. It gets a better score because it doesn't overflow with their tests and its faster than with BigIntegers
	// Correctness 100% Performance 100%
		public int solution2(int[] A) {
			if(A==null || A.length==0)
				return -1;
			if(A.length==1)
				return 0;
		   
			long prefix= 0L;
			long sufix= 0L;
			for(int i=1; i<A.length; i++){ //First element is not added
				sufix=sufix+A[i];
			}
			if(prefix==sufix)
				return 0;
			for(int i=1; i<A.length; i++){
				prefix = prefix+(A[i-1]);
				sufix=sufix-A[i];
				if(prefix==sufix)
					return i;
			}
			return -1;
		}
}
