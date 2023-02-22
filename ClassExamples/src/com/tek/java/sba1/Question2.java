package com.tek.java.sba1;

import java.text.DecimalFormat;

public class Question2 {

	// position : 0 1 2 3 4 5
	// value : a b c d e f

	private static final int ARRAY_SIZE = 5;

	private int[] array;

	public static void main(String[] args) {

		Question2 q2 = new Question2();
		
		int[] avg = { 1, 2, 3, 4, 5, 6, 7 };
		q2.calculateAverage(avg);
		
		q2.setValue(4);
		//print first message setting value
		
		q2.setValue(5);
		//print first message setting value
		
		q2.setValue(4);
		//print 2nd message because its already been changed
		q2.move(50, 3);
		//print 1st message
		q2.move(30, 3);
		//print 2nd message
		q2.move(30,  4);
		//print 2nd message
	}

	Question2() {
		// we need to make a 1 based data structure for an array of size 5
		// an array is 0 based so when we need 5 elements they from from 0 to 4
		// since we are 1 based we need 6 elements going from 0 to 5, but ignore
		// position 0

		// the key to this is to ignore the 0 element of the array
		array = new int[ARRAY_SIZE + 1];
		for(int i = 0; i < array.length; i++) {
			if(i > 0) {
				array[i] = -1;
			} else {
				array[i] = 0;
			}
		}

		// initialize this entire array to a value ... -1
	}
	
	//this will be in an interface
	//and will be the exact same implementation in both classes
	public void calculateAverage(int[] arr) {
		// calculate the average
		// print out a message using system.out.format of the average with
		// decimal format this to show 2 places right of the decimal ( %.2f )
		// include new line character at the end of the message "/n"
		//optional: use a decimal formatter and system.out.println rather than format
		int sum = 0;
		double average = 0;
		for (int num : arr) {
			sum = sum + num;
		}
		average = sum/arr.length;
		DecimalFormat df = new DecimalFormat("##.00");
		System.out.println("The average of the array is " + df.format(average));
	}
	
	//this will be in an interface
	//and will be the exact same implementation in both classes
	public void setValue(int index) {
		if (array[index] == -1) {
			System.out.println("Set the value to 1");
			array[index] = 1;
		} else {
			System.out.println("Value already changed");
		}
		// if the value at array[index] == -1 then print a message saying that you set the value to 1
		// otherwise print a message saying that it was already changed
	}
	
	//this will be an extra function in one of the classes
	public void move(int value, int id) {
		//if the value at array[id] == -1 then print a message saying "Value with id: {id} is moved to {value}" and set the value to 1
		// otherwise print a message saying "Value is already 1"
		if (array[id] != value) {
			System.out.println("Value with id: " + id + " is moved to " + value);
			value = 1;
			System.out.println("Value with id: " + id + " is moved to " + value);
		} else {
			System.out.println("Value is already 1");
		}
	}
}
