package com.juangb.codility.interview;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 * Mistakes I had:
 *    - forgot to multiply by a[i]
 *    - loop for arrayToBigInt incorrect
 *    - wrong bigIntToArray because of negative remainders
 *    
 *    Note that in most programming languages, the result (in integer arithmetic) of dividing a negative number 
 *    by a negative number is rounded towards 0, usually leaving a negative remainder. In such a case we have 
 *    a = (-r)c + d = (-r)c + d - r + r = (-r)(c + 1) + (d + r). Because  |d| < r,  (d + r) is the positive remainder. 
 *    Therefore, to get the correct result in such case, computer implementations of the above algorithm should add 1 
 *    and r to the quotient and remainder respectively
 */
public class Exercise2Negabinary {
	
	 public static void main(String[] args){
		 Exercise2Negabinary sol = new Exercise2Negabinary();
		 int[] array = {1,1,0,1};
		 int[] array2 = sol.solution(array);
		 System.out.println(Arrays.toString(array2));
		
		 
	 }
	 public int[] solution(int[] A) {
		 BigInteger number = arrayToBigInt(A,-2); //1. Build a bigInt from the negabinary representation
		 System.out.println(number);
		 number=number.negate(); //2. Negate the number	
		 System.out.println(number);
		 return bigIntToArray(number,-2); // 3. Represent it in negabinary
	 }
	 
	 // array[0] is the most significant byte
	 private BigInteger arrayToBigInt(int[] array, int base){
		 BigInteger myBigInt = BigInteger.ZERO;
		  for(int i=0; i<array.length; i++){
			  if(array[i]!=0){
				  myBigInt=myBigInt.add(new BigInteger(array[i]+"").multiply(new BigInteger(base+"").pow(array.length-1-i))); // A[i]*(-2)^i--> This would be if A[0] is the less significant byte
			  }
		  }
		  return myBigInt;		  
	 }
	
	 
	 private int[] bigIntToArray(BigInteger value, int base){ 
		 Stack<Integer> numberStack = new Stack<Integer>();
		 BigInteger baseBI = new BigInteger(base+"");

		 	while (!value.equals(BigInteger.ZERO)){
		 		BigInteger[] valueAndRemainder = value.divideAndRemainder(baseBI);
		 		BigInteger remainder = valueAndRemainder[1];
		 		value = valueAndRemainder[0];

		 		if (remainder.compareTo(BigInteger.ZERO) ==-1){ // remainder < 0
		 			remainder=remainder.add(new BigInteger(Math.abs(base)+""));
		 			value = value.add(BigInteger.ONE);		 			
		 		}
		 		numberStack.push(remainder.intValue());		 		
		 	}
		 	int[] numberArray = new int[numberStack.size()];
		 	int i=0;
		 	while(!numberStack.empty()){
		 		numberArray[i]=numberStack.pop();
		 		i++;
		 	}
		 	return numberArray;
		
	 }
	 
	 
	 
	 
	 
	 
/* ***********************************************************************************
 * Submitted solutions
 */
		  public int[] solution3(int[] A) {
		        // write your code in Java SE 8
			  StringBuffer sb = new StringBuffer();
			  BigInteger myBigInt = BigInteger.ZERO;
			  for(int i=A.length-1; i>=0; i--){
				  if(A[i]!=0){
					  myBigInt=myBigInt.add(new BigInteger("-2").pow(i));
				  }
			  }
			  
			  myBigInt= myBigInt.negate();
			  List<Integer> list = new ArrayList<>();
			  //TODO Implement with bitwise operations
			  BigInteger minusTwo = new BigInteger("-2");
			  while(!myBigInt.equals(BigInteger.ZERO)){
				  list.add(Integer.parseInt((myBigInt.remainder(minusTwo)).toString()));
				  myBigInt=myBigInt.divide(minusTwo);
			  }
			  int[] numbers = new int[list.size()];
			  for(int i=0; i<numbers.length; i++){
				  numbers[numbers.length-1-i]=list.get(i);
			  }
			  return numbers;
		    }
		  
		  public int[] solution2(int[] A) {
		        // write your code in Java SE 8
			  StringBuffer sb = new StringBuffer();
			  long myBigInt =0;
			  for(int i=A.length-1; i>=0; i--){
				  if(A[i]!=0){
					  myBigInt=myBigInt+ -2^i;
				  }
			  }
			  
			  myBigInt= -1*myBigInt;
			  List<Long> list = new ArrayList<>();
			  //TODO Implement with bitwise operations
			  BigInteger minusTwo = new BigInteger("-2");
			  while(!(myBigInt==0)){
				  list.add(myBigInt%-2);
				  myBigInt=myBigInt/-2;
			  }
			  int[] numbers = new int[list.size()];
			  for(int i=0; i<numbers.length; i++){
				  long a=list.get(i);
				  numbers[numbers.length-1-i]=(int)a;
			  }
			  return numbers;
		    }
	  
		  
		  
	  /*
	  public int[] solution(int[] A) {
	        // write your code in Java SE 8
		  int number = 0;
	      for (int i=0; i<A.length; i++) {
	          double pow = Math.pow(-2, i*1.0);
	          int x = (int) (A[i]*pow);
	          number= number + x;
	      }
	      number=number*-1;
	      
	      
	      List<Integer> list = new ArrayList<>();
	      while(number!=0) {
	            int division = (int) Math.ceil(number / -2);
	            int remainder = number % -2;
	            number = division;
	            list.add(Math.abs(remainder));
	      }
	      
	      int[] solution = new int[list.size()];
	      for (int i=0; i<list.size(); i++) {
	    	  solution[i] = list.get(i);
	      }
	      return solution;
	        
	    }*/
	  
	  
	 
}
