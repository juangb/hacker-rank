package com.juangb.hackerrank.algorithms.graphtheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
 * 
 * Breadth First Search: Shortest Reach
 * 
 * Given an undirected graph consisting of N nodes (labelled 1 to N) where a specific given node S represents the start position and an edge between any two nodes is of length 6 units in the graph.
 * 
 * It is required to calculate the shortest distance from start position (Node S) to all of the other nodes in the graph.
 * 
 * Note 1: If a node is unreachable , the distance is assumed as −1. 
 * Note 2: The length of each edge in the graph is 6 units.
 * 
 * Input Format
 * 
 * The first line contains T, denoting the number of test cases. 
 * First line of each test case has two integers N, denoting the number of nodes in the graph and M, denoting the number of edges in the graph. 
 * The next M lines each consist of two space separated integers x y, where x and y denote the two nodes between which the edge exists. 
 * The last line of a testcase has an integer S, denoting the starting position.
 * 
 * Constraints 
 * 1≤T≤10 
 * 2≤N≤1000 
 * 1≤M≤N×(N−1)2 
 * 1≤x,y,S≤N
 * 
 * Output Format
 * 
 * For each of T test cases, print a single line consisting of N−1 space-separated integers, denoting the shortest distances of the N-1 nodes from starting position S. This will be done for all nodes same as in the order of input 1 to N.
 * 
 * For unreachable nodes, print −1.
 * 
 * Sample Input
 * 
 * 2
 * 4 2
 * 1 2
 * 1 3
 * 1
 * 3 1
 * 2 3
 * 2
 * Sample Output
 * 
 * 6 6 -1
 * -1 6
 * Explanation
 * 
 * For test cases 1:
 * 
 * The graph given in the test case is shown as :
 * 
 * Graph
 * 
 * S denotes the node 1 in the test case and B,C and D denote 2,3 and 4. Since S is the starting node and the shortest distances from it are (1 edge, 1 edge, Infinity) to the nodes B,C and D (2,3 and 4) respectively.
 * 
 * Node D is unreachable, hence -1 is printed (not Infinity).
 * 
 * For test cases 2: There are only one edge (2, 3) in a graph with 3 nodes, so node 1 is unreachable from node 2, and node 3 has one edge from node 2, each edge has the length of 6 units. So we output -1 6.

 */

public class BreadthSearchFirst {

	/* 
	 * Models a vertex in our graph implementation
	 */
	public class Vertex{
		private int value;
		private boolean marked;
		private ArrayList<Edge> edges;
		private int accumulatedDistance;
		
		public Vertex(int value){
			super();
			this.accumulatedDistance=0;
			this.value=value;
			this.edges=new ArrayList<Edge>();
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public ArrayList<Edge> getEdges() {
			return edges;
		}
		public void setEdges(ArrayList<Edge> edges) {
			this.edges = edges;
		}
		public boolean isMarked() {
			return marked;
		}
		public void setMarked(boolean marked) {
			this.marked = marked;
		}
		public int getAccumulatedDistance() {
			return accumulatedDistance;
		}
		public void setAccumulatedDistance(int accumulatedDistance) {
			this.accumulatedDistance = accumulatedDistance;
		}
	}
	
	/*
	 * Models an Edge in our graph implementation
	 */
	public class Edge{
		private int weight;
		private Vertex vertex1, vertex2;
		
		public Edge(int weight, Vertex vertex1, Vertex vertex2){
			super();
			this.weight=weight;
			this.vertex1=vertex1;
			this.vertex2=vertex2;			
		}
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
		public Vertex getVertex1() {
			return vertex1;
		}
		public void setVertex1(Vertex vertex1) {
			this.vertex1 = vertex1;
		}
		public Vertex getVertex2() {
			return vertex2;
		}
		public void setVertex2(Vertex vertex2) {
			this.vertex2 = vertex2;
		}		
	}
	/*
	 * Models a graph.
	 */
	public class Graph{
		private int numberOfNodes;
		private int numberOfEdges;
		private Hashtable<Integer,Vertex> vertexHash;
		private int startingPosition;
		
		public Graph(int numberOfNodes, int numberOfEdges){
			this.numberOfNodes=numberOfNodes;
			this.numberOfEdges=numberOfEdges;
			vertexHash = new Hashtable<Integer,Vertex>();
			
		}
		public void addEdge(int originVertex, int destinationVertex, int weight){
			Vertex origin = vertexHash.get(originVertex);
			if(origin==null){
				origin= new Vertex(originVertex);
				vertexHash.put(originVertex, origin);
			}
			Vertex destination = vertexHash.get(destinationVertex);
			if(destination==null){
				destination= new Vertex(destinationVertex);
				vertexHash.put(destinationVertex, destination);
			}
			Edge edge = new Edge(weight,origin,destination);
			origin.getEdges().add(edge);
			destination.getEdges().add(edge);
		}

		public int getNumberOfNodes() {
			return numberOfNodes;
		}

		public void setNumberOfNodes(int numberOfNodes) {
			this.numberOfNodes = numberOfNodes;
		}

		public int getNumberOfEdges() {
			return numberOfEdges;
		}

		public void setNumberOfEdges(int numberOfEdges) {
			this.numberOfEdges = numberOfEdges;
		}
		public Hashtable<Integer, Vertex> getVertexHash() {
			return vertexHash;
		}
		public void setVertexHash(Hashtable<Integer, Vertex> vertexHash) {
			this.vertexHash = vertexHash;
		}
		public int getStartingPosition() {
			return startingPosition;
		}
		public void setStartingPosition(int startingPosition) {
			this.startingPosition = startingPosition;
		}

		
		
	}
	
	 public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        
		 BreadthSearchFirst bsf = new BreadthSearchFirst();
		 List<Graph> graphs= bsf.readInput();
		 if(graphs==null || graphs.size()==0)
			 return;
		 for(Graph graph: graphs){
			 bsf.breadthSearch(graph);
		 }    
	    	   	
	    	
	    	
	        
	  }
	 
	 public void breadthSearch(Graph graph){
		 int distances[] = new int[graph.numberOfNodes-1];
		 for(int i=0; i<distances.length;i++){
			 distances[i]=-1;
		 }
		 Queue<Vertex> queue = new LinkedList<Vertex>();
		 Vertex startingVertex=graph.getVertexHash().get(graph.getStartingPosition());
		 if(startingVertex!=null){
			 startingVertex.setMarked(true);
			 queue.add(startingVertex);
			
			 while(!queue.isEmpty()){
				 Vertex vertex = queue.poll();
				 if(vertex.getValue()<startingVertex.getValue()){
					 if(distances[vertex.getValue()-1]==-1){
						 distances[vertex.getValue()-1]=vertex.getAccumulatedDistance();
					 }else if(distances[vertex.getValue()-1]>vertex.getAccumulatedDistance()){
						 distances[vertex.getValue()-1]=vertex.getAccumulatedDistance();
					 }
				 }else if(vertex.getValue()>startingVertex.getValue()){
					 if(distances[vertex.getValue()-2]==-1){
						 distances[vertex.getValue()-2]=vertex.getAccumulatedDistance();
					 }else if(distances[vertex.getValue()-2]>vertex.getAccumulatedDistance()){
						 distances[vertex.getValue()-2]=vertex.getAccumulatedDistance();
					 }
				 }
				 for(Edge edge: vertex.getEdges()){
					 
					 if(edge.getVertex1()==vertex){
						 if(!edge.getVertex2().isMarked()){
							 edge.getVertex2().setMarked(true);
							 edge.getVertex2().setAccumulatedDistance(vertex.getAccumulatedDistance()+edge.getWeight());
							 queue.add(edge.getVertex2());
						 }
					 }else if(edge.getVertex2()==vertex){
						 if(!edge.getVertex1().isMarked()){
							 edge.getVertex1().setMarked(true);
							 edge.getVertex1().setAccumulatedDistance(vertex.getAccumulatedDistance()+edge.getWeight());
							 queue.add(edge.getVertex1());
						 }
					 } 
				}
			 }
		 }
		 // Print distances
		 for(int i=0; i<distances.length;i++){
			 System.out.print(distances[i]+ " ");
		 }
		 System.out.println("");
	 }
	 
	 public List<Graph> readInput(){
		 /*Read input*/
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      
	    	List<Graph> graphs = new ArrayList<Graph>();
	    	try{
	    		String numTestCasesString = br.readLine();
	    		int numTestCases= Integer.parseInt(numTestCasesString.trim());
	    		for(int i=0; i<numTestCases; i++){
	    			String firstLine = br.readLine();
	    			String dimensions[] = firstLine.split(" ");
	    			int numberOfEdges =Integer.parseInt(dimensions[1].trim());
	    			Graph graph1 = new Graph(Integer.parseInt(dimensions[0].trim()),numberOfEdges);
	    			graphs.add(graph1);
	    			for(int j=0; j<numberOfEdges; j++){
	    				String edgeLine = br.readLine();
	    				String nodes[] = edgeLine.split(" ");
	    				graph1.addEdge(Integer.parseInt(nodes[0].trim()),Integer.parseInt(nodes[1].trim()), 6);
	    			}	    	
	    			String startingPosition = br.readLine();
	    			graph1.setStartingPosition(Integer.parseInt(startingPosition.trim()));
	    		}
	        	
	        }catch(IOException e){
	        	System.out.println("Error reading input"+e);
	        	return null;
	        }catch(NumberFormatException e2){
	        	System.out.println("Error parsing input"+e2);
	        	return null;
	        }
	    	return graphs;
	 }
	
}
