package com.juangb.hackerrank.algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class Gemstones {
	
	public static void main(String[] args){
		Gemstones gs = new Gemstones();
		String[] rocks = gs.readInput();
		System.out.println(gs.numberOfGemElements(rocks));
	}
	
	public String[] readInput(){
		/*Read input*/
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));      
        
    	try{    		
        	        	
        	int numberOfRocks = Integer.parseInt(br.readLine());
        	String[] rocks = new String[numberOfRocks];
        	
        	for(int i=0; i<numberOfRocks;i++){
        		rocks[i]=br.readLine();
        	}
        	return rocks;
        	
        }catch(IOException e){
        	System.out.println("Error reading line"+e);
        	return null;
        }catch(NumberFormatException e2){
        	System.out.println("Error parsing line"+e2);
        	return null;
        }
	}
	
	public int numberOfGemElements(String[] rocks){
		int numberOfRocks = rocks.length;
		Hashtable<Character, Integer> gemElements= new Hashtable<Character, Integer>();
		Set<Character> gemElementSet= new HashSet<Character>();
		for(String rock: rocks){			
			Set<Character> visited= new HashSet<Character>();
			for(char rockChar: rock.toCharArray()){
				if(visited.contains(rockChar))
					continue;
				visited.add(rockChar);
				if(!gemElements.containsKey(rockChar)){
					gemElements.put(rockChar, 1);
				}else{
					gemElements.put(rockChar, gemElements.get(rockChar)+1);
				}
				if(gemElements.get(rockChar)==numberOfRocks)
					gemElementSet.add(rockChar);				
			}			
		}
		return gemElementSet.size();
	}
}
