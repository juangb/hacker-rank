package com.juangb.hackerrank.datastructures.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwapNodes {
	static class Node {
	    int data;
	    Node left;
	    Node right;
	    public Node(){
	    	super();
	    }
	}
	
	public static void main(String[] args){
		//ReadInput
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			Integer numberOfNodes= Integer.parseInt(br.readLine().trim());
			Node[] nodes = new Node[numberOfNodes];
			for(int i=0; i<numberOfNodes; i++){
				nodes[i]=new Node();
				nodes[i].data=i+1;
			}
			for(int i=0; i<numberOfNodes; i++){
				String[] children = br.readLine().split(" ");
				int leftChild = Integer.parseInt(children[0]);
				int rightChild = Integer.parseInt(children[1]);
				if(leftChild!=-1){
					nodes[i].left=nodes[leftChild-1];
				}
				if(rightChild!=-1){
					nodes[i].right=nodes[rightChild-1];
				}
			}
			Integer numberOfK = Integer.parseInt(br.readLine().trim());
			Integer[] ks= new Integer[numberOfK];
			for(int i=0; i<numberOfK; i++){
				ks[i]=Integer.parseInt(br.readLine().trim());
			}
			SwapNodes sn = new SwapNodes();
			for(int i=0; i<numberOfK; i++){
				sn.swap(nodes[0],ks[i],1);
				sn.inOrder(nodes[0]);
				System.out.println("");
			}
			
			
			
		}catch(IOException e){
			System.out.println("Error reading line");
		}catch(NumberFormatException e2){
			System.out.println("Error parsing line");
		}
	}
	
	void swap(Node node, int k, int height){
		if(node==null)
			return;
		if(height%k==0){
			Node temp=node.left;
			node.left=node.right;
			node.right=temp;
		}
		swap(node.left,k,height+1);
		swap(node.right,k,height+1);		
	}
	void inOrder(Node node){
		if(node==null)
			return;
		inOrder(node.left);
		System.out.print(node.data+" ");
		inOrder(node.right);
	}
	
	
	
}
