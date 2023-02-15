package com.tek.java.day8;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		
		//Map<Key, Value>
		Map<String, String> dictionary = new HashMap<>();
		dictionary.put("key", "value");
		dictionary.put("concat", "To add 2 strings together");
		dictionary.put("instantiate", "To create a new object");
		dictionary.put("new", "allocate new memory location");
		
		Set<String> keySet = dictionary.keySet();
		for ( String key : keySet) {
			System.out.println(key + " = " + dictionary.get(key));
		}
		
		System.out.println("=====================");
		
		Map<String, Integer> intMap = new HashMap<>();
		intMap.put("key", 1);
		
		Map<Integer, String> sintMap = new HashMap<>();
		sintMap.put(1, "one");
		sintMap.put(2, "two");
		sintMap.put(3, "three");
		sintMap.put(4, "four");
		sintMap.put(5, "five");
		sintMap.put(6, "six");
		
		System.out.println(sintMap.get(3));
		
		sintMap.put(3, "THREE");
		System.out.println(sintMap.get(3));
		
		for ( Integer key : sintMap.keySet() ) {
			System.out.println(key);
		}
		
	}
}
