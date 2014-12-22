package com.rx.collidermd5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BfDatabase {
	static private BfDatabase mySelf;
	private PrintWriter outwriter;
	private String dbFileName;
	
	public BfDatabase(String fileName){
		mySelf = this;
		dbFileName  = fileName;
	}
	
	static public BfDatabase getInstance(){
		return mySelf;
	}
	
	
	public void saveProgram(BfProgram p){
		try {
			outwriter = new PrintWriter(new BufferedWriter(new FileWriter(dbFileName, true)));
			outwriter.println(p.getProgram());
			outwriter.println(p.getHash());
			outwriter.close();
		} catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
	}
	
	public void savePrograms(List<BfProgram> lp, int beginIndex, int count){
		try {
			outwriter = new PrintWriter(new BufferedWriter(new FileWriter(dbFileName, true)));
			BfProgram p = null;
			for(int i = beginIndex ; i < beginIndex+count && i < lp.size() ; i++){
				p = lp.get(i);
				outwriter.println(p.getProgram());
				outwriter.println(p.getHash());
			}
			outwriter.close();
		} catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
	}

}
