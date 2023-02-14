package com.tek.java.day7;

public class StringBufferExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("abcdefghi");
		
		System.out.println(sb);
		
		//arg 1 = start index
		//arg 2 = end index
		//arg 3 = what to replace it with
		//this is doing 2 operations, 1st is to delete the characters from position 0 to 5
		//then inserts the characters in the string at position 0 (start index)
		sb.replace(0, 5, "12345890");
		
		System.out.println(sb);	
		
		sb.insert(0, "ABCD");
			
		System.out.println(sb);
		
	}

}
