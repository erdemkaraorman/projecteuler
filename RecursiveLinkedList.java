package com.utility.io.protocol.handler;

import java.util.LinkedList;

public class RecursiveLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecursiveLinkedList r=new RecursiveLinkedList();
		LinkedList<String> list=r.prepareData(100);
		String result=r.printListMember(list);
		System.out.println("result is:"+ result);
		
		 
	}
	
	public LinkedList prepareData(int numberOfElements){
		LinkedList<String> list=new LinkedList<String>();
		
		for (int i=0;i<numberOfElements;i++){
			list.add(new Integer(i).toString());			
		}	
		return list;		
	}
	
	public String printListMember(LinkedList list){
		if (list==null){
			return "";
		}else if (list.isEmpty())
			return "";
		else if (list.size()==1){
			return (String) list.peek();
		}
		
		else{
			String pop=(String) list.poll();
			return printListMember(list)+pop;
		}
	}

}
