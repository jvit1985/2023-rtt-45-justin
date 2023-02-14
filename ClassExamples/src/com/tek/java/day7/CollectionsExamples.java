package com.tek.java.day7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CollectionsExamples {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("element1");
		set.add("element2");
		set.add("element3");
		set.add("element1");
		
		for (String e : set) {
			System.out.println(e);
		}
		
		if (set.isEmpty()) {
			// the set has no elements
		}
		
		if (set.size() == 0) {
			// same as is empty
		}
		
		System.out.println("========================");
		
		List<String> list = new ArrayList<>();
		
		list.add("element1");
		list.add("element2");
		list.add("element3");
		list.add("element1");
		
		for (String l : list) {
			System.out.println(l);
		}
		
		if (list.contains("element1")) {
				System.out.println("The list contains element1");
		}	
		
		if (list.isEmpty()) {
			//generally if a list is empty it means there was no results
		}
		
		if (list.size() == 0) {
			// this is the same as isEmpty()
		}
		
		System.out.println(list.get(0));
		
		System.out.println("========================");
		
		list.remove(0);
		
		for (int i = 0 ; i < list.size(); i++) {
			if (list.get(i).equals("element2")) {
				list.remove(i);
			}
		}
		
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String element = iterator.next();
			if (element.equals("element2")) {
				iterator.remove();
			}
			System.out.println(element);
		}
	}
}
