package com.tek.java.day3;

import java.util.ArrayList;
import java.util.List;

public class LoopIterations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// EXAMPLES - Loop from 10 to 30 showing even numbers only and using continue
		for (int i = 10; i <= 30; i += 2) {
			System.out.println(i);
			continue;
		}
		System.out.println("==================================");
		// Loop from 10 to 1 showing all numbers
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
		}
		System.out.println("==================================");
		// Loop from 10 to 30 and break when you find the first number divisable by 3
		for (int i = 10; i <= 30; i++) {
			if (i % 3 == 0) {
				System.out.println(i);
				break;
			}
		}
		System.out.println("==================================");
		// Create a List of Integers and use a loop to add the numbers 1 to 10 to the
		// list. Then print the elements in the list
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}

		for (Integer element : list) {
			System.out.println(element);
		}

	}

}
