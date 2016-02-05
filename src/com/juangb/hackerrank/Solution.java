package com.juangb.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 *  Mth TO LAST ELEMENT
 * 
 *  For this question, you will write a program that, given a positive integer M and a list of integers L, outputs the list element M links away from the end of the list. For this program, we will use 1-indexing. That means mth_to_last(1) is the "1st-to-last" element, or simply the last element in the list.
 *  If you are given an invalid index, output NIL instead.
 *  
 *  Examples
 *  Input:  
 *  4
 *  10 200 3 40000 5  
 *  Output:  
 *  200
 *  
 *  Input:  
 *  2
 *  42  
 *  Output:  
 *  NIL
 *  
 *  General Approach
 *  Construct a linked list from the inputs. While it's certainly possible to solve this using array indices, the point is to practice linked list traversals.
 *  Use that linked list to find the Mth to last element.
 *  
 *  Things to think about
 *  Is your list singly- or doubly-linked? How does this affect your algorithm? Does this change the complexity of your algorithm?
 *  What if your list was circular? Would this change how you check for edge cases?
 *  
 *  Input Format and Restrictions
 *  Each test case will consist of two lines. The first line contains the value of M. The second line contains the values of L, each separated by a space character.
 *  
 *  The inputs will always satisfy the following restrictions: *  
 *  0 < M < 2^32 - 1,
 *  Each element of the list satisfies 0 <= L[i] <= 2^32 - 1,
 *  The number of elements in the list satisfies 0 < \|L\| < 1024. The bonus test cases may be much larger!
 * 
 * 
 * 
 */

public class Solution {

	public class Node{
		private int value;
		private Node nextNode;
		private Node previousNode;
		
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public Node getNextNode() {
			return nextNode;
		}
		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}
		public Node getPreviousNode() {
			return previousNode;
		}
		public void setPreviousNode(Node previousNode) {
			this.previousNode = previousNode;
		}
	}
	
	public class DoublyLinkedList{
		private Node first;
		private Node last;
		private int size;
		
		public void add(int number){
			Node n = new Node();
			if(first==null){
				n.setValue(number);
				this.first=n;
				this.last=n;
			}else{
				n.setValue(number);
				n.setPreviousNode(this.last);
				this.last.setNextNode(n);				
				this.setLast(n);
			}
			size++;
		}
		public Node getFirst() {
			return first;
		}
		public void setFirst(Node first) {
			this.first = first;
		}
		public Node getLast() {
			return last;
		}
		public void setLast(Node last) {
			this.last = last;
		}
		public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}	
		
	}
	
	 public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        
	    	/*Read input*/
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String mPosition=null;
	        String numbers=null;
	    	try{
	    		mPosition = br.readLine();
	        	numbers= br.readLine();
	        }catch(IOException e){
	        	System.out.println("Error reading line"+e);
	        	return;
	        }
	        
	    	if(mPosition==null)
	    		return;
	    	
	    	Integer positions = null;
	    	Solution sol = new Solution();
	    	DoublyLinkedList numbersList = sol.new DoublyLinkedList();
	    	try{
	    		positions = Integer.parseInt(mPosition);
	    		 StringTokenizer st = new StringTokenizer(numbers);
	    	     while (st.hasMoreTokens()) {    	         
	    	         numbersList.add(Integer.parseInt(st.nextToken()));
	    	     }
	    	     if(numbersList.getSize()<=0){
	    	    	 System.out.println("NIL");
	    	    	 return;
	    	     }
	    	     //In case number is bigger than the list size
	    	     if(positions>numbersList.getSize()){
	    	    	 System.out.println("NIL"); 	  
	    	    	 return;
	    	     }
	    	}catch(NumberFormatException e){
	    		System.out.println("Error parsing line"+e);
	    		return;
	    	}
	    	
	    	
	    	Node currentNode = numbersList.getLast();
	    	while(positions>1){
	    		if(currentNode.getPreviousNode()!=null)
	    			currentNode=currentNode.getPreviousNode();
	    		else{
	    			System.out.println("NIL");
	    			return;
	    		}
	    		positions--;
	    	}
	    	System.out.println(currentNode.getValue());
	        
	    }
}
