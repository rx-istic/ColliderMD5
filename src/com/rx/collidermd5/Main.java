package com.rx.collidermd5;

public class Main {

	public static void main(String[] args) {
		Collider c = new Collider();
		for(long i=0; true ; i++){
			
			System.out.println("Round#"+i);
			if(c.searchCollisions1()){
				return;
			}else if(c.searchCollisions2()){
				return;
			}
		}		
		//c.printProgs();		
		//System.out.println("No collisions found =/");
	}

}
