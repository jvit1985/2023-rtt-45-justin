package com.tek.java.day7;

import java.util.StringJoiner;

public class StringJoinerExample {
	public static void main(String[] args) {
		//1st arg is delimiter which will be between each element and separates each element
		//2nd arg is the start character
		//3rd arg is the end character
		StringJoiner sj1 = new StringJoiner("-", "[", "]");
		
		sj1.add("element1");
		sj1.add("element2");
		sj1.add("element3");
		sj1.add("element4");
		
		System.out.println(sj1.toString());
		
StringJoiner sj2 = new StringJoiner(",", "(", ")");
		
		sj2.add("list1");
		sj2.add("list2");
		sj2.add("list3");
		sj2.add("list4");
		
		System.out.println(sj2.toString());
		
		//uses delimiter for each stringjoiners elements but the start and end characters for sj1
		System.out.println(sj1.merge(sj2).toString());
		
		//primary use of a string joiner is to create a CSV file in which the data is separated by a delimiter
	}
}
