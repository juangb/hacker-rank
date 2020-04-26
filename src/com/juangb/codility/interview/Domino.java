package com.juangb.codility.interview;

public class Domino {
	/*
	 * "Domino": We are given a S string, representing domino tiles chain. Each tile has L-R format, where L and R are numbers from 1..6 range. Tiles are separated by comma. Some examples of valid S chain are:

1. 1-4,4-2,3-1
2. 6-3
3. 4-3,5-1,2-2,1-3,4-4

Devise a function that, given S string, returns the number of tiles in the longest matching group within S. Domino tiles match, if the right side of a tile is the same as the left side of the following tile. 2-4,4-1 are matching tiles, but 5-2,1-6 are not.

domino("1-1,3-5,5-2,2-3,2-4") should return 3.
	 */
	public static void main(String[] args){
		Domino d = new Domino();
		System.out.println(d.longestChain("5-5,5-5,4-4,5-5,5-5,5-5,5-5,5-5,5-5,5-5"));
		
	}
	private int longestChain(String s){
		String[] tiles = s.split(",");
		int maxLength=0;
		int currentLength=0;
		String lastNumber="-1";
		for(int i=0; i<tiles.length; i++){
			String[] numbers = tiles[i].split("-");
			if(numbers[0].equals(lastNumber)){
				currentLength++;				
			}else{
				if(currentLength>maxLength)
					maxLength=currentLength;
				currentLength=1;
			}
			lastNumber=numbers[1];
		}
		if(currentLength>maxLength)
			maxLength=currentLength;
		return maxLength;
	}

}
