package com.rx.collidermd5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Collider {
	private char[] mySet = { '!' , '"' , '#' , '$' , '%' , '&' , '(' , ')' , '*' , '+' , ',' , '-' , '/' , '0' , '1' , '2' , '3' , '4' , '5' , '6' , '7' , '8' , '9' , ':' , ';' , '<' , '=' , '>' , '?' , '@' , 'A' , 'B' , 'C' , 'D' , 'E' , 'F' , 'G' , 'H' , 'I' , 'J' , 'K' , 'L' , 'M' , 'N' , 'O' , 'P' , 'Q' , 'R' , 'S' , 'T' , 'U' , 'V' , 'W' , 'X' , 'Y' , 'Z' , '['  , ']' , '^' , '_' , '`' , 'a' , 'b' , 'c' , 'd' , 'e' , 'f' , 'g' , 'h' , 'i' , 'j' , 'k' , 'l' , 'm' , 'n' , 'o' , 'p' , 'q' , 'r' , 's' , 't' , 'u' , 'v' , 'w' , 'x' , 'y' , 'z' , '{' , '|' , '}' , '~' }; 
	private ArrayList<BfProgram> prog1Set;
	private ArrayList<BfProgram> prog2Set;

	StringBuilder sb1;
	StringBuilder sb2;

	private static String base1 = "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>++++++++++++++++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>++++++++++++++++++++++++++++++++>++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++><<<<<<<<<<<<<<<<<<<.>.>.>.>.>.>.>.>>.>>.>>.>>.>>.";
	private static String base2 = "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>++++++++++++++++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>++++++++++++++++++++++++++++++++>++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++><<<<<<<<<<<<<<<<<<<.>.>.>.>.>.>.>>.>>.>>.>>.>>.>>.";

	private int minChar = 33;
	private int maxChar = 126;
	
	BfDatabase dbSet1;
	BfDatabase dbSet2;

	public Collider(){
		prog1Set = new ArrayList<BfProgram>();
		prog2Set = new ArrayList<BfProgram>();
		
		dbSet1 = new BfDatabase("hashSet1");
		dbSet2 = new BfDatabase("hashSet2");

		BfProgram b = new BfProgram();
		b.setProgram("");
		b.setHash(getMD5(base1));

		
		prog1Set.add(b);


		BfProgram b2 = new BfProgram();
		b2.setProgram("");
		b2.setHash(getMD5(base2));


		prog2Set.add(b2);
		//sb1 = new StringBuilder();
	}

	public static String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);
			// Now we need to zero pad it if you actually want the full 32 chars.
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		}
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public BfProgram getFromHash1(String hash){
		for(BfProgram p : prog1Set){
			if(p.getHash().equals(hash)){
				return p;
			}
		}
		return null;
	}

	public BfProgram getFromHash2(String hash){
		for(BfProgram p : prog2Set){
			if(p.getHash().equals(hash)){
				return p;
			}
		}
		return null;
	}

	public boolean searchCollisions1(){
		
		long maxi=prog1Set.size();
		System.out.println("C1  max="+maxi);
		
		for(int i=0; i<maxi ; i++){
			if(i%10 == 0){
				printProgress(i, maxi);
			}
			sb1 = new StringBuilder();//gets base string from existing set
			BfProgram btmp = prog1Set.get(i); 
			sb1.append(btmp.getProgram());

			for(int j=0; j<mySet.length;j++){
				//printProgress(j, mySet.length);
				
				sb2 = new StringBuilder(); //creates new string
				sb2.append(sb1.toString());
				sb2.append(mySet[j]);

				BfProgram b = new BfProgram(); //adds to set
				b.setProgram(sb2.toString());
				b.setHash(getMD5(base1+sb2.toString()));

				prog1Set.add(b);
				dbSet1.saveProgram(b);

				//System.out.println("Search collision for "+b.getHash());
				BfProgram btest = getFromHash2(b.getHash()); //try to find a match
				if(btest != null){
					System.out.println("Collision found !");
					System.out.println("P1 = "+b.getProgram());
					System.out.println("P2 = "+btest.getProgram());

					return true;
				}
			}

		}

		return false;
	}

	public boolean searchCollisions2(){

		long maxi=prog2Set.size();
		System.out.println("C2  max="+maxi);

		for(int i=0; i<maxi ; i++){
			if(i%10 == 0){
				printProgress(i, maxi);
			}
			sb1 = new StringBuilder();
			BfProgram btmp = prog2Set.get(i); 
			sb1.append(btmp.getProgram());

			for(int j=0; j<mySet.length;j++){
				//printProgress(j, mySet.length);
				
				sb2 = new StringBuilder();
				sb2.append(sb1.toString());
				sb2.append(mySet[j]);

				BfProgram b = new BfProgram();
				b.setProgram(sb2.toString());
				b.setHash(getMD5(base2+sb2.toString()));

				prog2Set.add(b);
				dbSet2.saveProgram(b);

				//System.out.println("Search collision for "+b.getHash());
				BfProgram btest = getFromHash1(b.getHash());
				if(btest != null){
					System.out.println("Collision found !");
					System.out.println("P1 = "+btest.getProgram());
					System.out.println("P2 = "+b.getProgram());

					return true;
				}
			}
		}

		return false;
	}
	
	public void printProgs(){
		System.out.println("P1");
		for( BfProgram p : prog1Set){
			System.out.println(p.getProgram());
		}
		
		System.out.println("P2");
		for( BfProgram p : prog2Set){
			System.out.println(p.getProgram());
		}
	}
	
	public void printProgress(long current, long max){
		System.out.println(((100*current)/max)+"%");
	}
	

}
