package com.tek.java.feb16;

public class ArrayLibraryMain {

	public static void main(String[] args) {

		ArrayLibrary al = new ArrayLibrary();
		int[] numbers = new int[10];

		// 1 - initialize the array with numbers from 1 to 10
		// 2 - create a function that will insert a number into the array at a position

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}

		al.printArray(numbers, "Default initialization");

		try {
			numbers = al.insertElement(numbers, 40, 11);
			al.printArray(numbers, "After element insert");
		} catch (NegativePositionException npe) {
			System.out.println("NEGATIVE POSITION EXCEPTION " + npe.getMessage());
		} catch (PositionTooLargeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("This code will be executed in either case no matter what");
		}

		numbers = al.append(numbers, 12);
		al.printArray(numbers, "After append element");

		numbers = al.deleteElement(numbers, 4);
		al.printArray(numbers, "After deleting element");

		int position = al.findPositionOfValue(numbers, 11);
		System.out.println("The position of value 11 is " + position);

		numbers = al.bubbleSort(numbers);
		al.printArray(numbers, "After bubble sort");

	}
}
