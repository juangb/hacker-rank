package com.juangb.hackerrank.algorithms.graphtheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.PriorityQueue;

/*
 * DIJKSTRA SHORTEST REACH
 * 
 * Given a graph consisting N nodes (labelled 1 to N) where a specific given node S represents the starting position S and an edge between two nodes is of a given length, which may or may not be equal to other lengths in the graph.
 * 
 * It is required to calculate the shortest distance from the start position (Node S) to all of the other nodes in the graph.
 * 
 * Note 1: If a node is unreachable , the distance is assumed as −1.
 * 
 * Input Format
 * 
 * The first line contains T, denoting the number of test cases. 
 * First line of each test case has two integers N, denoting the number of nodes in the graph and M, denoting the number of edges in the graph.
 * 
 * The next M lines each consist of three space-separated integers x y r, where x and y denote the two nodes between which the undirected edge exists, r denotes the length of edge between these corresponding nodes.
 * 
 * The last line has an integer S, denoting the starting position.
 * 
 * Constraints 
 * 1≤T≤10 
 * 2≤N≤3000 
 * 1≤M≤N×(N−1))2 
 * 1≤x,y,S≤N 
 * 1≤r≤350
 * 
 * If there are edges between the same pair of nodes with different weights, they are to be considered as is, like multiple edges.
 * 
 * Output Format
 * 
 * For each of the T test cases, print a single line consisting N−1 space separated integers denoting the shortest distance of N−1 nodes from starting position S.
 * 
 * For unreachable nodes, print −1.
 * 
 * Sample Input
 * 
 * 1
 * 4 4
 * 1 2 24
 * 1 4 20
 * 3 1 3
 * 4 3 12
 * 1
 * Sample Output
 * 
 * 24 3 15
 * Explanation
 * 
 * The graph given in the test case is shown as :
 * 
 * Graph
 * 
 * The straight line is a weighted edge, denoting length of edge between the corresponding nodes.
 * The nodes S,B,C and D denote the obvious node 1,2,3 and 4 in the test case.
 * The shortest paths followed for the three nodes B,C and D are as follows :
 * 
 * S->B - Shortest Path Value : 24
 * 
 * S->C - Shortest Path Value : 3
 * 
 * S->C->D - Shortest Path Value : 15
 * 
 */
public class DijkstraShortestReach {

	/* 
	 * Models a vertex in our graph implementation
	 */
	public class Vertex implements Comparable<Vertex>{
		private int value;
		private boolean marked;
		private ArrayList<Edge> edges;
		private int accumulatedDistance;
		
		public Vertex(int value) {
			super();
			this.accumulatedDistance=-1;
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
		
		@Override
		public int compareTo(Vertex o) {
			if(this.getAccumulatedDistance()<o.getAccumulatedDistance())
				return -1;
			else if(this.getAccumulatedDistance()==o.getAccumulatedDistance())
				return 0;
			else
				return 1;
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
	        
		 DijkstraShortestReach dsr = new DijkstraShortestReach();
		 List<Graph> graphs= dsr.readInput();
		 if(graphs==null || graphs.size()==0)
			 return;
		 for(Graph graph: graphs){
			 dsr.breadthSearch(graph);
		 }    
	    	   	
	    	
	    	
	        
	  }
	 
	 public void breadthSearch(Graph graph){
		 int distances[] = new int[graph.numberOfNodes-1];
		 for(int i=0; i<distances.length;i++){
			 distances[i]=-1;
		 }
		 PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
		 Vertex startingVertex=graph.getVertexHash().get(graph.getStartingPosition());
		 if(startingVertex!=null){
			
			 startingVertex.setAccumulatedDistance(0);
			 queue.add(startingVertex);
			
			 while(!queue.isEmpty()){
				 Vertex vertex = queue.poll();
				 if(!vertex.isMarked()){
					 for(Edge edge: vertex.getEdges()){					 
						 if(edge.getVertex1()==vertex && !edge.getVertex2().isMarked()){	
							 if(edge.getVertex2().getAccumulatedDistance()==-1 || edge.getVertex2().getAccumulatedDistance()>vertex.getAccumulatedDistance()+edge.getWeight())
								 edge.getVertex2().setAccumulatedDistance(vertex.getAccumulatedDistance()+edge.getWeight());
							 queue.add(edge.getVertex2());
							 
						 }else if(edge.getVertex2()==vertex && !edge.getVertex1().isMarked()){		
							 if(edge.getVertex1().getAccumulatedDistance()==-1 || edge.getVertex1().getAccumulatedDistance()>vertex.getAccumulatedDistance()+edge.getWeight())
								 edge.getVertex1().setAccumulatedDistance(vertex.getAccumulatedDistance()+edge.getWeight());
							 queue.add(edge.getVertex1());							 
						 }					 
					}
					 
					vertex.setMarked(true);
					if(vertex.getValue()<graph.getStartingPosition())
						distances[vertex.getValue()-1]=vertex.getAccumulatedDistance();
					else if(vertex.getValue()>graph.getStartingPosition())
						distances[vertex.getValue()-2]=vertex.getAccumulatedDistance();
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
	    				graph1.addEdge(Integer.parseInt(nodes[0].trim()),Integer.parseInt(nodes[1].trim()),Integer.parseInt(nodes[2].trim()));
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
