package com.utility.io.protocol.handler;

import java.util.HashSet;

public class MultiplesOf35 {
	public static void main(String[] args){
		//
		int[] multiples={3,5};
		int maxSize=1000;
		MultiplesOf35 multiple=new MultiplesOf35(maxSize,multiples);
		multiple.fillArr();
		int sum=0;
		for(Object i:multiple._arr.toArray()){
			sum=sum+(Integer)i;
		}
		System.out.println("sum is:"+sum);
		System.out.println("_arr is:"+multiple._arr.toString());
		
	}
	
	private int maxSize;
	private HashSet<Integer> _arr;
	private int[] multiples;
	
	public MultiplesOf35 (Integer maxSize,int[] multiples){
		_arr=new HashSet<Integer>();
		this.maxSize=maxSize;
		this.multiples=multiples;
	}
	
	public void fillArr(){
		for(int i:this.multiples){
			findMultiples(i);
		}
	}
	
	public void findMultiples(int i){
		for (int k=0;k<maxSize;k=k+i){
			this._arr.add(k);
		}
	}
	
	
	
}
