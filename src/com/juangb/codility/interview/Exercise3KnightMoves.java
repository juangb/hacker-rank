package com.juangb.codility.interview;

/*
 * Return minimum number of turns knight
 */
public class Exercise3KnightMoves {
	
	public static void main(String[] args){
		for(int x=0; x<10; x++){
			for(int y=0; y<10; y++){
				System.out.print(solution(x,y)+ " ");
			}
			System.out.println("");
		}
	}
	
	/*
	 * The first thing to note is that the grid is symetrical along the x, y axis and the lines y = ±x. 
	 * You can therefore convert all points (x, y) into an equivalent point such that the new 0 ≤ y ≤ x.
	 * 
	 * 
	 * d=x−y
	 * 
	 * f(x,y) = 2|(y-d)/3| + d if y>d
	 * f(x,y) = d-2|(d-y)/4| otherwise
	 */
	public static int solution(int x, int y){
		x= Math.abs(x);
		y= Math.abs(y);
		//If y>x switch variables
		if(y>x){
			int temp=y;
			y=x;
			x=temp;
		}
		//TODO Special cases
		
		int d=x-y;
		if(y>d){
			return 2*((y-d)/3)+d;
		}else{
			return d-2*((d-y)/4);
		}				
	}
}
