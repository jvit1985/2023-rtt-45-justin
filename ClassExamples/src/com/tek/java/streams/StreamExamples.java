package com.tek.java.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExamples {

	public static void main(String[] args) {
		
		List<String> names = new ArrayList<String>();
		
		names.add("Larry");
		names.add("Steven");
		names.add("Eric");
		names.add("Jessica");
		names.add("Ellen");
		
		//sort the original names list by length of string of name using a stream
				//after working then sort secondary alphabetically
		
		List<String> tempNames = names;
		Collections.sort(tempNames);
		List<String> lengthList = names.stream()
				.sorted(Comparator.comparingInt(String::length))
				.collect(Collectors.toList());
		
		System.out.println(String.join("\n", lengthList) +"\n");
		
		System.out.println("===============================");
		
		List<String> sortedList = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		
		System.out.print(String.join("\n", sortedList) + "\n");
		
		System.out.println("===============================");
		
		sortedList.removeIf(name -> name.contains("n"));
		System.out.print(String.join("\n", sortedList) + "\n");
		
		//sort the original names list by length of string of name using a stream
		//after working then sort secondary alphabetically
	};
}

