package com.utility.io.protocol.handler;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class EvenFibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EvenFibonacci fib=new EvenFibonacci();
		
		HashSet<Integer> result=fib.calculateEven();
		int sum=0;
		for (Integer i: result){
			sum+=i;
		}
		System.out.println("sum is:" +sum+",result is:"+ result.toString());

	}
	
	private  LRUCache<Integer,Integer> cache;

	private int cacheSize=2;
	private final int maxNumber=4000000;
	
	public EvenFibonacci(){
		cache=new LRUCache<Integer,Integer>(cacheSize);
	}
	

	public HashSet<Integer> calculateEven(){
		HashSet<Integer> result=new HashSet();
		
		cache.put(0,0);
		cache.put(1,1);
		Integer sum=0;
		int counter=2;
		while (sum<maxNumber){
			if (sum % 2==0)
				result.add(sum);
			Object[] temp= cache.values().toArray();
			sum=(Integer)temp[0]+(Integer)temp[1];	
			
			cache.put(counter++, sum);
		}
		return result;
	}
	
	 class LRUCache<K, V> extends LinkedHashMap<K, V> {
		  private final int maxEntries;
		  private static final int DEFAULT_INITIAL_CAPACITY = 16;
		  private static final float DEFAULT_LOAD_FACTOR = 0.75f;

		  public LRUCache(int initialCapacity,
		                  float loadFactor,
		                  int maxEntries) {
		    super(initialCapacity, loadFactor, true);
		    this.maxEntries = maxEntries;
		  }

		  public LRUCache(int initialCapacity,
		                  int maxEntries) {
		    this(initialCapacity, DEFAULT_LOAD_FACTOR, maxEntries);
		  }

		  public LRUCache(int maxEntries) {
		    this(DEFAULT_INITIAL_CAPACITY, maxEntries);
		  }

		  // not very useful constructor
		  public LRUCache(Map<? extends K, ? extends V> m,
		                  int maxEntries) {
		    this(m.size(), maxEntries);
		    putAll(m);
		  }

		  protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		    return size() > maxEntries;
		  }
		}
}
