package com.juangb.hackerrank.algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *
 * Quicksort In-Place
 * 
 * The previous version of Quicksort was easy to understand, but it was not optimal. It required copying the numbers into other arrays, which takes up space and time. To make things faster, one can create an "in-place" version of Quicksort, where the numbers are all sorted within the array itself.
 * 
 * Challenge 
 * Create an in-place version of Quicksort. You need to follow Lomuto Partitioning method.
 * 
 * Guideline 
 * Instead of copying the array into multiple sub-arrays, use indices to keep track of the different sub-arrays. You can pass the indices to a modified partition method. The partition method should partition the sub-array and then return the index location where the pivot gets placed, so you can then call partition on each side of the pivot.
 * 
 * Always select the last element in the 'sub-array' as a pivot.
 * Partition the left side and then the right side of the sub-array.
 * Print out the whole array at the end of every partitioning method.
 * An array of length 11 or less will be considered sorted, and there is no need to sort or to print them.
 * Since you cannot just create new sub-arrays for the elements, partition method will need to use another trick to keep track of which elements are greater and which are lower than the pivot.
 * 
 * The In-place Trick
 * 
 * If an element is lower than the pivot, you should swap it with a larger element on the left-side of the sub-array.
 * Greater elements should remain where they are.
 * At the end of the partitioning method, the pivot should be swapped with the first element of the right partition, consisting of all larger elements, of the sub-array.
 * To ensure that you don't swap a small element with another small element, use an index to keep track of the small elements that have already been swapped into their "place".
 * Lomuto-partitioning
 * 
 * Input Format 
 * There will be two lines of input:
 * 
 * nn - the size of the array
 * arar - the nn numbers of the array
 * Output Format 
 * Print the entire array on a new line at the end of every partitioning method.
 * 
 * Constraints 
 * 1≤n≤50001≤n≤5000 
 * −10000≤x≤10000,x∈ar−10000≤x≤10000,x∈ar 
 * There are no duplicate numbers.
 * 
 * Sample Input
 * 
 * 7
 * 1 3 9 8 2 7 5
 * Sample Output
 * 
 * 1 3 2 5 9 7 8
 * 1 2 3 5 9 7 8
 * 1 2 3 5 7 8 9
 * Explanation 
 * 5 is initally selected as the pivot, and the array is partitioned as shown in the diagram. The left side is partitioned next with 2 as the pivot. Finally, the right side is partitioned with 8 as the pivot. The entire array is now sorted.
 * 
 */
public class QuickSortInPlace {

	public static void main(String[] args){
		
		
		QuickSortInPlace qs = new QuickSortInPlace();
		Integer arrayToSort[] = qs.readInput();
		if(arrayToSort==null)
			return;
		if(arrayToSort.length==1){
			System.out.println(arrayToSort[0]);
			return;
		}
		qs.sort2(arrayToSort,0,arrayToSort.length-1);
		
    	
	}
	
	//More efficient. Each pointer starts in one side and they move towards the middle	
	public void sort(Integer[] arrayToSort, int startIndex, int endIndex){
		if(endIndex-startIndex<=0)
			return;
		//Choose a pivot and sort the rest
		int pivot = arrayToSort[endIndex];
		int j=endIndex-1;
		
		int icopy=startIndex;
		for(int i=startIndex;i<=j;i++){
			icopy=i;
			if(arrayToSort[i]>pivot){
				while(j>i){
					if(arrayToSort[j]<pivot){
						int temp = arrayToSort[j];
						arrayToSort[j]=arrayToSort[i];
						arrayToSort[i]=temp;						
						break;
					}
					j--;
				}
			}			
		}
		//Quick fix to handle the case in which all numbers are less than the pivot
		if(arrayToSort[icopy]<pivot){
			icopy++;
		}else{
			arrayToSort[endIndex]= arrayToSort[icopy];
			arrayToSort[icopy]=pivot;
		}
		
		//Print result as specified
		for(int i2=0; i2<arrayToSort.length -1;i2++){
			System.out.print(arrayToSort[i2]+" ");
		}
		System.out.println(arrayToSort[arrayToSort.length -1]);
		
		//Recursively call this method to sort the first and last parts of the array
		this.sort(arrayToSort,startIndex,icopy-1);
		this.sort(arrayToSort,icopy+1,endIndex);
		
		
	}
	
	
	public void sort2(Integer[] arrayToSort, int startIndex, int endIndex){
		if(endIndex-startIndex<=0)
			return;
		//Choose a pivot and sort the rest
		int pivot = arrayToSort[endIndex];
		int lastIndex=startIndex;
		int j=startIndex;
		int i=startIndex;
		
		while(i<endIndex && j<endIndex){			
			if(arrayToSort[i]>pivot){
				
				while(j<endIndex){
					if(arrayToSort[j]<pivot){
						int temp = arrayToSort[j];
						arrayToSort[j]=arrayToSort[i];
						arrayToSort[i]=temp;
						lastIndex=i+1;			
						break;
					}
					j++;
				}
			}else{
				lastIndex=i+1;
			}
			i++;
			j++;
		}
					
		arrayToSort[endIndex]= arrayToSort[lastIndex];
		arrayToSort[lastIndex]=pivot;
		
		
		
		//Print result as specified
		for(int i2=0; i2<arrayToSort.length -1;i2++){
			System.out.print(arrayToSort[i2]+" ");
		}
		System.out.println(arrayToSort[arrayToSort.length -1]);
		
		//Recursively call this method to sort the first and last parts of the array
		this.sort2(arrayToSort,startIndex,lastIndex-1);
		this.sort2(arrayToSort,lastIndex+1,endIndex);
		
		
	}
	
	public Integer[] readInput(){
		/*Read input*/
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));      
        
    	try{    		
        	//No need to store the first line
        	br.readLine();
        	String arrayNumbers= br.readLine();
        	String numbers[] = arrayNumbers.split(" ");
        	Integer numbersInt[] = new Integer[numbers.length];
        	for(int i=0; i<numbers.length;i++){
        		numbersInt[i]=Integer.parseInt(numbers[i].trim());
        	}
        	return numbersInt;
        	
        }catch(IOException e){
        	System.out.println("Error reading line"+e);
        	return null;
        }catch(NumberFormatException e2){
        	System.out.println("Error parsing line"+e2);
        	return null;
        }
	}
}
