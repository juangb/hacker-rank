package com.juangb.hackerrank.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeUtils {

	/* you only have to complete the function given below.  
	Node is defined as  
	*/

	static class Node {
	    int data;
	    Node left;
	    Node right;
	    public Node(){
	    	super();
	    }
	}

	
	/*
	 * Recursion. Stack overflow might occur. To avoid that I should implement an iterative solution
	 * 
     * https://www.hackerrank.com/challenges/tree-preorder-traversal
     * 
     * 
     * You are given a pointer to the root of a binary tree; print the values in preorder traversal.
     * 
     * You only have to complete the function.
     * 
     * Input Format 
     * You are given a function,
     * 
     * void Preorder(node *root) {
     * 
     * }
     * Output Format 
     * Print the values on a single line separated by space.
     * 
     * Sample Input
     * 
     *      3
     *    /   \
     *   5     2
     *  / \    /
     * 1   4  6
     * Sample Output
     * 
     * 3 5 1 4 2 6
     * 
     */
	void Preorder(Node node) {
		if(node==null)
			return;
		System.out.print(node.data+" ");
		Preorder(node.left);
		Preorder(node.right);
	}
	
	
	/*
	 * https://www.hackerrank.com/challenges/tree-postorder-traversal
	 * 
	 * You are given a pointer to the root of a binary tree; print the values in post-order traversal.
     * 
     * You only have to complete the function.
     * 
     * Input Format 
     * You are given a function,
     * 
     * void Postorder(node *root) {
     * 
     * }
     * Output Format 
     * Print the values on a single line separated by space.
     * 
     * Sample Input
     * 
     *      3
     *    /   \
     *   5     2
     *  / \    /
     * 1   4  6
     * Sample Output
     * 
     * 1 4 5 6 2 3
     * 	 
     */
	
	void Postorder(Node node) {
		if(node==null)
			return;
		
		Postorder(node.left);
		Postorder(node.right);
		System.out.print(node.data+" ");
	}
	
	
	/*
	 * https://www.hackerrank.com/challenges/tree-inorder-traversal
	 * 
	 * You are given a pointer to the root of a binary tree; print the values in in-order traversal.
     * 
     * You only have to complete the function.
     * 
     * Input Format 
     * You are given a function,
     * 
     * void Inorder(node *root) {
     * 
     * }
     * Output Format 
     * Print the values on a single line separated by space.
     * 
     * Sample Input
     * 
     *      3
     *    /   \
     *   5     2
     *  / \    /
     * 1   4  6
     * Sample Output
     * 
     * 1 5 4 3 6 2
	 */


	void Inorder(Node node) {
		if(node==null)
			return;
		
		Inorder(node.left);
		System.out.print(node.data+" ");
		Inorder(node.right);
		
	}
	
	/*
	 * https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree
	 * 
	 * The height of a binary tree is the number of nodes on the largest path from root to any leaf. You are given a pointer to the root of a binary tree. Return the height of the tree. 
     * You only have to complete the function.
     * 
     * Input Format
     * 
     * You are given a function,
     * 
     * int height_of_bt(node * root)
     * {
     * 
     * }
     * Output Format
     * 
     * Return a single value equal to the height of the binary tree.
     * 
     * Sample Input
     * 
     *      3
     *    /   \
     *   5     2
     *  / \    /
     * 1   4  6
     *       /
     *      7
     * Sample Output
     * 
     * 4
     * Explanation
     * 
     * The maximum length root to leaf path is 3->2->6->7. There are 4 nodes in this path. Therefore the height of the binary tree = 4.
     * 
	 */

	int height(Node root){
         return recursiveHeight(root,1);
    }
	
	int recursiveHeight(Node node, int currentHeight){
		if(node==null)
			return currentHeight -1;
		return Math.max(recursiveHeight(node.left,currentHeight+1), recursiveHeight(node.right,currentHeight+1));
	}
	
	
	/*
	 * https://www.hackerrank.com/challenges/tree-top-view
	 * 
	 * You are given a pointer to the root of a binary tree. Print the top view of the binary tree. 
     * You only have to complete the function. 
     * For example :
     * 
     *      3
     *    /   \
     *   5     2
     *  / \   / \
     * 1   4 6   7
     *  \       /
     *   9     8
     * Top View : 1 -> 5 -> 3 -> 2 -> 7
     * Input Format
     * 
     * You are given a function,
     * 
     * void top_view(node * root)
     * {
     * 
     * }
     * Output Format
     * 
     * Print the values on a single line separated by space.
     * 
     * Sample Input
     * 
     *      3
     *    /   \
     *   5     2
     *  / \   / \
     * 1   4 6   7
     *  \       /
     *   9     8
     * Sample Output
     * 
     * 1 5 3 2 7
     * Explanation
     * 
     *      3
     *    /   \
     *   5     2
     *  / \   / \
     * 1   4 6   7
     *  \       /
     *   9     8
     * From the top only nodes 1,5,3,2 and 7 will be visible.
     * 
	 */
	
	void top_view(Node node){
		if(node==null)
			return;
		Node root = node;
		Stack<Node> leftStack = new Stack<Node>();		
		while(node.left!=null){
			node=node.left;
			leftStack.push(node);
		}
		while(!leftStack.isEmpty()){
			System.out.print(leftStack.pop().data+" ");
		}
		while(root!=null){
			System.out.print(root.data+" ");
			root=root.right;
		}
	  
	}
	
	
	/*
	 * https://www.hackerrank.com/challenges/tree-level-order-traversal
	 * 
	 * You are given a pointer to the root of a binary tree. You need to print the level order traversal of this tree. In level order traversal, we visit the nodes level by level from left to right. 
     * You only have to complete the function. 
     * For example:
     * 
     *          3
     *        /   \
     *       5     2
     *      / \    /
     *     1   4  6
     * For the above tree, the level order traversal is 3 -> 5 -> 2 -> 1 -> 4 -> 6.
     * 
     * Input Format
     * 
     * You are given a function,
     * 
     * void level_order(node * root)
     * {
     * 
     * }
     * Output Format
     * 
     * Print the values in a single line seperated by a space.
     * 
     * Sample Input
     * 
     *          3
     *        /   \
     *       5     2
     *      / \    /
     *     1   4  6
     * Sample Output
     * 
     * 3 5 2 1 4 6
     * Explanation
     * 
     * Level 1:        3
     *               /   \
     * Level 2:     5     2
     *             / \    /
     * Level 3:   1   4  6
     * We need to print the nodes level by level. We process each level from left to right. 
     * Level Order Traversal: 3 -> 5 -> 2 -> 1 -> 4 -> 6
     * 
	 */

	   void LevelOrder(Node root){
		   Queue<Node> queue = new LinkedList<Node>();
	       queue.add(root);
	       while(!queue.isEmpty()){
	    	   Node node = queue.poll();
	    	   System.out.print(node.data+ " ");
	    	   if(node.left!=null)
	    		   queue.add(node.left);
	    	   if(node.right!=null)
	    		   queue.add(node.right);
	       }
	    }
	   
	   
	   /*
	    * https://www.hackerrank.com/challenges/binary-search-tree-insertion
	    * 
	    * You are given a pointer to the root of a binary search tree and a value to be inserted into the tree. Insert this value into its appropriate position in the binary search tree and return the root of the updated binary tree. You just have to complete the function.
        * 
        * Input Format
        * 
        * You are given a function,
        * 
        * node * insert (node * root ,int value)
        * {
        * 
        * }
        * node is defined as :
        * 
        * struct node
        * {
        * int data;
        * node * left;
        * node * right;
        * }node;
        * Output Format
        * 
        * Return the root of the binary search tree after inserting the value into the tree.
        * 
        * Sample Input
        * 
        *         4
        *        / \
        *       2   7
        *      / \
        *     1   3
        * The value to be inserted is 6.
        * 
        * Sample Output
        * 
        *          4
        *        /   \
        *       2     7
        *      / \   /
        *     1   3 6
        *     
	    */
	  
	   static Node Insert(Node root,int value){	
		   if(root==null){
			   Node newNode= new Node();
			   newNode.data=value;
			   return newNode;
		   }		   
		   insertRecursive(root,value);
		   return root;
	    }
	   
	   static void insertRecursive(Node node, int value){
		   if(node==null)
			   return;
		   if(value<node.data){
			   if(node.left==null){
				   Node newNode= new Node();
				   newNode.data=value;
				   node.left=newNode;
			   }else{
				   insertRecursive(node.left,value);
			   }
		   }else if(value>node.data){
			   if(node.right==null){
				   Node newNode= new Node();
				   newNode.data=value;
				   node.right=newNode;
			   }else{
				   insertRecursive(node.right,value);
			   }
		   }		 
	   }
	   
	   /*
	    * Binary Search Tree : Lowest Common Ancestor
	    * https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor
	    * 
	    * You are given pointer to the root of the binary search tree and two values v1 and v2. You need to return the lowest common ancestor (LCA) of v1 and v2 in the binary search tree. You only need to complete the function.
        * 
        * Input Format
        * 
        * You are given a function,
        * 
        * node * LCA (node * root ,int v1,int v2)
        * {
        * 
        * }
        * It is guaranteed that v1 and v2 are present in the tree.
        * 
        * Node is defined as :
        * 
        * struct node
        * {
        * int data;
        * node * left;
        * node * right;
        * }node;
        * Output Format
        * 
        * Return the LCA of v1 and v2.
        * 
        * Sample Input
        * 
        *          4
        *        /   \
        *       2     7
        *      / \   /
        *     1   3 6
        * v1=1 and v2=7.
        * 
        * Sample Output
        * 
        * LCA of 1 and 7 is 4 (which is the root). 
        * Return a pointer to the root in this case.
        * 
	    */
	   static Node lca(Node root,int v1,int v2){
		   if(root==null)
			   return null;
		   if(v1<root.data && v2<root.data)
			   return lca(root.left,v1,v2);
		   else if(v1>root.data && v2>root.data)
			   return lca(root.right,v1,v2);
		   else
			   return root;
	       
	    }


}
