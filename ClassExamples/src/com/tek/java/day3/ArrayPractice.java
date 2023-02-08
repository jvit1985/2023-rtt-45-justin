package com.tek.java.day3;

import java.util.Random;

public class ArrayPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayPractice ap = new ArrayPractice();
		ap.maxRandomValue(1, 10, 10);
	}
	
	public void maxRandomValue(int smallest, int largest, int length) {
		int[] values = new int[length];

		// this code adds 10 random numbers to the list
		for (int i = 0; i < length; i++) {
			Random rand = new Random();
			int randomNum = rand.nextInt((largest - smallest) + 1) + smallest;

			values[i]=randomNum;
			
			System.out.println(randomNum);
		}

		int minValue = values[0];
		// int minValue = 100;
		int maxValue = 0;
		for (Integer r : values) {
			if (r > maxValue) {
				maxValue = r;
			}
			if (r < minValue) {
				minValue = r;
			}
		}

		System.out.println("Max value = " + maxValue);
		System.out.println("Min value = " + minValue);
	}

}
