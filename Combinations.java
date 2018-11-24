package com.utility.io.protocol.handler;

public class Combinations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int group=20;
		int members=5;
		Combinations c=new Combinations();
		int result=c.calculateCombinations(group,members);
		System.out.println("Combinations of "+group+","+members+"="+result);

	}
	
	
	public int calculateCombinations(int group,int members){
		if (members==group){
			return 1;
		}
		else if (members==1){
			return group;
		}
		return calculateCombinations(group-1,members-1)+ calculateCombinations(group-1,members);
	}

}
