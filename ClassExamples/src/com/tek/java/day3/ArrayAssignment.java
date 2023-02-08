package com.tek.java.day3;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Program that creates an array with length of 3 and assigns values and prints each element
		int[] elem = new int[3];
		elem[0]=1;
		elem[1]=2;
		elem[2]=3;
		
		for (int number: elem) {
			System.out.println(number);
		}
		
		System.out.println("========================");
		
		//Program that returns the middle element in an array
		int [] middleArray = {13, 5, 7, 68, 2};
		int middle = middleArray.length/2;
		System.out.println(middleArray[middle]);
		
		System.out.println("========================");
		
		//Program that creates an array of String type and initializes it with strings "red", "green", 
		//"blue" and "yellow". Print out array length. Make a copy using clone method. Use Arrays.toString() method on the new array to verify it was copied
		String[] s = {"red", "green", "blue", "yellow"};
		System.out.println(s.length);
		String[] clonedArray = s.clone();
		System.out.println(clonedArray.toString());
		
		System.out.println("========================");
		
		//Program that creates an integer array with 5 element. Numbers can be any integers. Print the value at the first index and the last index.
		//Try to print value at array[length] and notice exception
		int[] numbers = {1, 3, 5, 7, 9};
		int length = numbers.length;
		System.out.println(numbers[0]);
		System.out.println(numbers[length-1]);
		
		System.out.println("========================");
		
		//Program to create an integer array with a length of 5. Loop through the array and assign the value of the loop variable to the index in the array
		int[] loopArray = new int[5];
		for (int i = 0; i < loopArray.length; i++) {
			loopArray[i] = i;
			System.out.println(loopArray[i]);
		}

		System.out.println("========================");
		
		//Program that creates an integer array of 5 numbers. Loop through the array and assign the value of the loop variable multiplied by 2 to the index in the array
		int[] multiplyArray = new int[5];
		for (int i = 0; i < multiplyArray.length; i++) {
			multiplyArray[i] = i * 2;
			System.out.println(multiplyArray[i]);
		}
		
		System.out.println("========================");
		
		//Program that creates an array of 5 elements. Loop through the array and print the value of each element except the middle element.
		int [] skipValues = {0,1,2,3,4};
		for (int i = 0; i < skipValues.length; i++) {
			if (i == 2) { continue; }
			else {
				System.out.println(skipValues[i]);
			}
		}
		
		System.out.println("========================");
		
		//Program that creates a string array of 5 elements that swaps the 1st element with the middle element without creating a new array
		String[] swap = {"first", "second", "third", "fourth", "fifth"};
		int middleElement = swap.length/2;
		swap[middleElement] = swap[0];
		System.out.println(swap[middleElement]);
		
		System.out.println("========================");
		
		//Program to sort the array in ascending order. Print the array in ascending order and print the smallest and largest element of the array.
		int sortedArray[] = {4, 2, 9, 13, 1, 0};
		Arrays.sort(sortedArray);
		System.out.println("Array in ascending order: ");
		for ( int i = 0; i < sortedArray.length; i++) {
			System.out.println(sortedArray[i]);
		}
		System.out.println("The smalles number is " + sortedArray[0]);
		System.out.println("The biggest number is " + sortedArray[5]);
		
		System.out.println("========================");
		
		//Create an array that includes an integer, 3 strings, and 1 double. Print the array
		Object[] obj = new Object[5];
		obj[0] = 1;
		obj[1] = "string1";
		obj[2] = "string2";
		obj[3] = "string3";
		obj[4] = 5.50;
		
		for (int i = 0; i < obj.length; i++) {
			System.out.println(obj[i]);
		}
		
		System.out.println("========================");
		
		//Program that asks the user how many favorite things they have. Based on their answer create a String array of the correct size.
		//Then ask the user to enter the things and store them in the array you created. Print the countents of the array.
		Scanner scan = new Scanner(System.in);
		System.out.println("How many favorite things do you have? ");
		int things = scan.nextInt();
		String[] stuff = new String[things];
		for (int i = 0; i < things; i++) {
			System.out.println("Enter your thing: ");
			stuff[i]=scan.next();
		}
		System.out.println("Your favorite things are: ");
		for (String element: stuff) {
			System.out.println(element);
		}
	}

}
