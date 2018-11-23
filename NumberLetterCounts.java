package com.utility.io.protocol.handler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class NumberLetterCounts {
	public static void main(String[] args){
		NumberLetterCounts letters= new NumberLetterCounts();
		
		long start=System.nanoTime();
		for (int i=0;i<=999;i++){
			System.out.println("number "+ i + " is:"+ letters.convertToString(i));
		}
		long total=System.nanoTime()-start;
		System.out.println("total time is  "+ total);
		
		
	}
	
	public NumberLetterCounts(){
		digits=new HashMap<Integer,String>();
		tenDigits=new HashMap<Integer,String>();
		
		digits.put(0,"");
		digits.put(1,"one");
		digits.put(2,"two");
		digits.put(3,"three");
		digits.put(4,"four");
		digits.put(5,"five");
		digits.put(6,"six");
		digits.put(7,"seven");
		digits.put(8,"eight");
		digits.put(9,"nine");
		
		tenDigits.put(10, "ten");
		tenDigits.put(11, "eleven");
		tenDigits.put(12, "twelve");
		tenDigits.put(13, "thirteen");
		tenDigits.put(14, "fourteen");
		tenDigits.put(15, "fifteen");
		tenDigits.put(16, "sixteen");
		tenDigits.put(17, "seventeen");
		tenDigits.put(18, "eighteen");
		tenDigits.put(19, "nineteen");
		tenDigits.put(20, "twenty");
		tenDigits.put(30, "thirty");
		tenDigits.put(40, "fourty");
		tenDigits.put(50, "fifty");
		tenDigits.put(60, "sixty");
		tenDigits.put(70, "seventy");
		tenDigits.put(80, "eighty");
		tenDigits.put(90, "ninety");		
	}
	public String convertToString(Integer number){
		String result="";
		int hundredDividend=number/100;
		if (hundredDividend>0){
			if (number==hundredDividend*100)
				result+=digits.get(hundredDividend) + " hundred ";
			else
				result+=digits.get(hundredDividend) + " hundred and ";
		}
			

		number-=hundredDividend*100;

		if (number==0)
			return result;
		
		if (tenDigits.containsKey(number)){
			result+=tenDigits.get(number);
			number=0;
		}else{
			int tenDividend=number/10;
			if (tenDividend>0)
				result+=tenDigits.get(tenDividend*10) +" ";
				number-=tenDividend*10;
		}
		
		if (number==0)
			return result;
		
		result+= digits.get(number);
		return result;
		
	}
	
	private HashMap<Integer,String> tenDigits;
	private HashMap<Integer,String> digits;
	

	
}
