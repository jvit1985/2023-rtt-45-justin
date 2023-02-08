package com.tek.java.day3;

import java.util.Scanner;

public class LoopsPracticeAssignment {

	public static void main(String[] args) {
		//1. Multiplication Table
		for (int i = 1; i <= 12; i++) {
			for (int j = 1; j<= 12; j++) {
				int sum = i * j;
				System.out.println(sum);
			}
			System.out.println();
		}
		//3. Predict Future Tuition
				double tuition = 10000;
				int count = 0;
				while(tuition < 20000) {
					tuition = tuition * 1.07;
					count++;
				}
				System.out.println("It will take " + count + " years for the tuition to double.");
				System.out.println("==================================");
		//2. Greatest Common Divisor
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a positive integer: ");
		int n1 = scan.nextInt();
		System.out.println("Enter another positive integer: ");
		int n2 = scan.nextInt();
		int gcd = findGCD(n1, n2);  
		System.out.println("GCD of " + n1 + " and " + n2 + " =  " + gcd);  
		}  
		public static int findGCD(int a, int b)  
		{  
		while(b != 0)  
		{  
		if(a > b)  
		{  
		a = a - b;  
		}  
		else  
		{  
		b = b - a;  
		}  
		}  
		return a;  
		}  

	}


