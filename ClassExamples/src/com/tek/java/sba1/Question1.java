package com.tek.java.sba1;

import java.util.ArrayList;
import java.util.List;

public class Question1 {
	
	//String x = null; this means that no string object has been created and there is no memory allocated
	// String x = ""; this is an empty string that has been allocated to memory
	private List<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		//how to transfer an array into an array list	
		Question1 q1 = new Question1();
		String[] arr = { "zero", "one", "two", "three", "four", "five"};
		q1.convert(arr);
		
		q1.replace(2);
		//I have replaced two with the empty string
		q1.replace(4);
		// I have replaced four with the empty string
		q1.compact();
		//print compacted and should produce
		//zero, one, three, five
	}
	
	
	//Know how to convert an array of strings to a list of strings
	public void convert( String[] arr) {
		for ( String str: arr) {
			list.add(str);
		}
	}
	
	public void replace(int idx) {
		//In an ArrayList write the value at idx to be an empty string
		//print a message saying what the value of the position in the list is and the value you are overwriting it with
		for (int i = 0; i < list.size(); i++) {
			if(i == idx) {
				System.out.println("The value of idx is " + list.get(i));
				list.set(i, "");
				System.out.println("Overwrote to " + list.get(i));
			}
		}
		}
		
	
	public ArrayList<String> compact() {
		//remove all values in the array list that are empty strings
		//must use .equals and not ==
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals("")) {
				list.remove(i);
			} 
		}
		System.out.println(list);
		return null;
	}

}
