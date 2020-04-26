package com.juangb.hackerrank.algorithms.heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class QHeap1 {
	
	public Node root;
	int numberOfNodes;
	public static class Node{
		Node parent;
		int data;
		Node right;
		Node left;
		public Node(int data){
			this.data=data;
		}
	}
	
	/*
	 * https://www.hackerrank.com/challenges/qheap1
	 * 
	 * This question is designed to help you get a better understanding of basic heap operations. 
     * You will be given queries of 33 types:
     * 
     * "11 vv" - Add an element vv to the heap.
     * "22 vv" - Delete the element vv from the heap.
     * "33" - Print the minimum of all the elements in the heap.
     * NOTE: It is guaranteed that the element to be deleted will be there in the heap. Also, at any instant, only distinct elements will be in the heap.
     * 
     * Input Format
     * 
     * The first line contains the number of queries, QQ. 
     * Each of the next QQ lines contains a single query of any one of the 33 above mentioned types.
     * 
     * Constraints 
     * 1≤Q≤1051≤Q≤105 
     * −109≤v≤109−109≤v≤109
     * Output Format
     * 
     * For each query of type 33, print the minimum value on a single line.
     * 
     * Sample Input
     * 
     * 5  
     * 1 4  
     * 1 9  
     * 3  
     * 2 4  
     * 3  
     * Sample Output
     * 
     * 4  
     * 9 
     * Explanation
     * 
     * After the first 22 queries, the heap contains {4,94,9}. Printing the minimum gives 44 as the output. Then, the 4th4th query deletes 44 from the heap, and the 5th5th query gives 99 as the output.
     * 
	 */
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		QHeap1 qh = new QHeap1();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			int numberOfQueries = Integer.parseInt(br.readLine().trim());
			for(int i=0; i<numberOfQueries; i++){
				String line = br.readLine();
				String numberStrings[]= line.split(" ");
				int firstOption=Integer.parseInt(numberStrings[0].trim());
				switch(firstOption){
					case 1:						
						qh.add(qh.root,Integer.parseInt(numberStrings[1].trim()));
						break;
					case 2:						
						qh.delete(qh.root,Integer.parseInt(numberStrings[1].trim()));
						break;
					case 3:
						qh.print();
				}
			}
		}catch(IOException e){
			System.out.println("Error reading line");
		}catch(NumberFormatException e2){
			System.out.println("Error parsing line");
		}
    }
	
	public void add(Node node, int value){
		if(this.root==null){
			numberOfNodes++;
			root=node;
			return;
		}
		Node newNode= new Node(value);
		//Insert it in the last position
		String position=Integer.toBinaryString(numberOfNodes)+1;
		for(int i=1; i<position.length();i++){
			if(position.charAt(i)=='0'){
				if(node.left==null){
					node.left=newNode;
					newNode.parent=node;
				}else{
					node=node.left;
				}
			}else{
				if(node.right==null){
					node.right=newNode;
					newNode.parent=node;
				}
				node=node.right;
			}
		}
		
		//Heapify
		while(newNode.parent!=null && newNode.data<newNode.parent.data){
			swap(newNode.parent,newNode);
		}
		
	}
	
	public void swap(Node parentNode, Node child){
		
		Node childLeft = child.left;
		Node childRight=child.right;
		if(parentNode.parent!=null){
			if(parentNode==parentNode.parent.left){//Parent is left child
				parentNode.parent.left=child;			
			}else if(parentNode==parentNode.parent.right){//Parent is right child
				parentNode.parent.right=child;
			}
		}else{
			this.root=child;
		}
		child.parent=parentNode.parent;	
		
		
		if(parentNode.left==child){
			child.left=parentNode;
			child.right=parentNode.right;
		}else if(parentNode.right==child){
			child.right=parentNode;
			child.left=parentNode.left;
		}
		parentNode.parent=child;
		parentNode.left=childLeft;
		parentNode.right=childRight;
		
	}
	
	public void delete(Node node, int value){
		node=find(node,value);
		if(node==null)
			return;
		//If it is the root
		if(node.parent==null){
			if(node.left!=null){
				if(node.right==null)
					node.left=root;
				else{
					if(node.left<node.right){
						node.left=root;
						
					}
				}
			}
		}
	}
	
	public Node find(Node node, int value){
		if(node==null)
			return null;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		while(!queue.isEmpty()){
			Node myNode= queue.poll();
			if(myNode.data==value)
				return myNode;
			else if(myNode.data<value){
				if(myNode.left!=null)
					queue.add(myNode);
				if(myNode.right!=null)
					queue.add(myNode);
			}
		}
		return null;
		
	}
	
	public void print(){
		if(this.root!=null)
			System.out.println(root.data);
	}
}
