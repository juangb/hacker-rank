package com.juangb.hackerrank.interviewpractice;

import java.util.Arrays;

public class FacebookZerosRight {
	
	public static void main(String[] args){
		Integer[] myArray = {7,0,1,0,0,0,2,3,0,5,0,0,0,1};
		FacebookZerosRight fb = new FacebookZerosRight();
		System.out.println(fb.parseArray(myArray));
		System.out.println(Arrays.toString(myArray));
	}
	
	/*
	 * This solution will run in O(n) time. It only visits every node once.
	 */
	public int parseArray(Integer[] data){
		  int i=0;
		  int j=data.length-1;
		  while(i<data.length){
			//int j=i+1;
		    if(data[i]==0){		     
		      while(j>0 && data[j]==0){
		    	j--;
		      }	
		      if(j<=i)
		    	  return data.length-i;
			  else{
				  swap(data, i, j);					  
			  }	 
		    }
		    i++;
		  }  
		  return 0;
		  
		}
	
	void swap(Integer[] data, int i, int j){
		int temp=data[j];
	    data[j]=data[i];
	    data[i]=temp;
	}
}
