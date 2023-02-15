package com.tek.java.day8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortingExamples {

	public static void main(String[] args) {

		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(13);
		numbers.add(7);
		numbers.add(18);
		numbers.add(5);
		numbers.add(2);

		System.out.println("Before : " + numbers);

		Collections.sort(numbers);
		System.out.println("After : " + numbers);

		numbers.sort(Comparator.reverseOrder());
		System.out.println("Reverse : " + numbers);
	}

	class NumberComparitor<Integer> implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return 0;
		}
	}
}
