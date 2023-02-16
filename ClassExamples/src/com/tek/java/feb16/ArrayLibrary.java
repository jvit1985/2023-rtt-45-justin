package com.tek.java.feb16;

import java.util.Arrays;

public class ArrayLibrary {

	public int[] insertElement(int[] arr, int position, int value) throws Exception {

		if (position < 0) {
			throw new NegativePositionException("Position must be greater than 0");
		}

		if (position >= arr.length) {
			throw new PositionTooLargeException("Position must be less than " + arr.length);
		}

		int[] copy = append(arr, 0);

		for (int i = position; i < arr.length; i++) {
			copy[i + 1] = arr[i];
		}
		copy[position] = value;
		// printArray(copy, "New value set on copy");
		// 1 create a new array that is 1 larger than the size of arr
		// 2 copy all elements from arr into the new copy
		// 3 move all elements in the array starting at position to the end 1 space to
		// the right
		// arr[i+1] = arr[i]
		// 4 set arr[position] = number

		return copy;
	}

	public void printArray(int[] array, String message) {
		System.out.println(message + "\t= " + Arrays.toString(array));
	}

	public int[] append(int[] arr, int value) {

		int[] copy = new int[arr.length + 1];

		for (int i = 0; i < arr.length; i++) {
			copy[i] = arr[i];
		}
		copy[arr.length] = value;

		return copy;
	}

	public int[] deleteElement(int[] arr, int position) {

		int[] copy = new int[arr.length - 1];

		for (int i = 0; i < position; i++) {
			copy[i] = arr[i];
		}

		for (int i = position; i < arr.length; i++) {
			copy[i - 1] = arr[i];
		}

		return copy;
	}

	public int[] bubbleSort(int[] arr) {
		// outer loop that will move across the entire array
		// inner loop that moves across the entire array
		// compare elements at arr[inner] with arr[inner +1]
		// if arr[inner] < arr{inner+1} then swap the elements
		// use a temp variable to store one value
		// move the other value
		// put the temp value into the one you just moved
		// return the array
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}

	public int findPositionOfValue(int[] arr, int value) {
		// find position of the incoming value
		for (int i = 0; i < arr.length; i++) {
			if (value == arr[i]) {
				return i;
			}
		}
		return -1;
		// if the value is not found then return -1;
		// return the first element found
	}
}
