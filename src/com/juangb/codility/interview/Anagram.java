package com.juangb.codility.interview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/*
 * "Anagram": An anagram is a type of word play, the result of rearranging the letters of a
 *  word or phrase to produce a new word or phrase using all the original letters exactly once; 
 *  for example, the letters from 'icon' can be rearranged into 'coin'. The word is NOT an anagram of itself.

Devise a function that takes one parameter W and returns all the anagrams of W from the file wl.txt.

anagrams("beat") should return ["beta", "bate"]
 */
public class Anagram {

	public static void main(String[] args){
		Anagram a = new Anagram();
		Set<String> words = a.allWords();
		//System.out.println(words.contains("yell"));
	}
	private Set<String> allWords(){
		try{
			Set<String> words = new HashSet<String>();
			BufferedReader br = new BufferedReader(new FileReader("c:/wl.txt"));
			String line = br.readLine();
			while (line != null) {			       
			        line = br.readLine();
			        if(line!=null){
			        	line=line.trim();
			        	words.add(line);
			        }
			}
			return words;
		}catch (Exception e){
			System.out.println(e);
		}	   
		return null;
	}
	private List<String> anagrams(String word, List<String> words, Set<String> existingWords, List<String> letters){
		if(letters.size()==0 && existingWords.contains(word)){
			System.out.println(word);
			words.add(word);
		}		
		
		for(int i=0; i<letters.size(); i++){
			word=word+letters.get(i);
			//Inefficient way. Improve it later
			List<String> newLetters = new ArrayList<String>();
			for(int j=0; j<letters.size();j++)
				if(j!=i) newLetters.add(letters.get(i));
			return anagrams(word,words,existingWords,newLetters);
		}
	}
	
}
