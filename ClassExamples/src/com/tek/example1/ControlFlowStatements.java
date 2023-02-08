package com.tek.example1;

import java.util.Scanner;

public class ControlFlowStatements {

	public static void main(String[] args) {
		//1.
		int x = 15;
		if(x < 10) {
			System.out.println("Less than 10");
		}
		//2.
		int x1 = 15;
		if (x1 < 10) {
			System.out.println("Less than 10");
		} else {
			System.out.println("Greater than 10");
		}
		//3.
		int x2 = 50;
		if (x2 < 10) {
			System.out.println("Less than 10");
		} else if (x2 > 10 && x2 < 20) {
			System.out.println("Between 10 and 20");
		} else {
			System.out.println("Greater than or equal to 20");
		}
		//4.
		int x3 = 5;
		if (x3 < 10 || x3 > 20) {
			System.out.println("Out of range");
		} else {
			System.out.println("In range");
		}
		//5.
		int grade;
		System.out.println("Enter your numeric grade (0-100): ");
		Scanner scan = new Scanner(System.in);
		grade = scan.nextInt();
		if(grade < 0 || grade > 100) {
			System.out.println("Score out of range");
		} else if (grade >= 90) {
			System.out.println("A");
		} else if (grade >= 80) {
			System.out.println("B");
		} else if (grade >= 70) {
			System.out.println("C");
		} else if (grade >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
		//6.
		int day;
		System.out.println("Enter a number between 1 and 7: ");
		Scanner sc = new Scanner(System.in);
		day = sc.nextInt();
		switch(day) {
		case 1:
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("Tuesday");
			break;
		case 3:
			System.out.println("Wednesday");
			break;
		case 4:
			System.out.println("Thursday");
			break;
		case 5:
			System.out.println("Friday");
			break;
		case 6:
			System.out.println("Saturday");
			break;
		case 7:
			System.out.println("Sunday");
			break;
		default:
			System.out.println("Out of Range");
			break;
		}
		//7.
		int filingStatus;
		double income;
		System.out.println("Please enter your filing status, 1-Single, 2-Married Filing Jointly, 3-Married Filing Separately, 4-Head of Household: ");
		Scanner scanA = new Scanner(System.in);
		filingStatus = scanA.nextInt();
		System.out.println("Please enter your taxable income: ");
		income = scanA.nextDouble();
		double taxOwed = 0;
		switch(filingStatus) {
		case 1:
			if (income > 372950) {
				taxOwed = ((income -372950) *.35) + ((372950-171550) * .33) + ((171550 - 82250) * .28) + ((82550-33950) * .25) + ((33950 -8350) * .15) + (8350 * .1);
			} else if (income > 171550) {
				taxOwed = ((income-171550) * .33) + ((171550 - 82250) * .28) + ((82550-33950) * .25) + ((33950 -8350) * .15) + (8350 * .1);
			} else if (income > 82250) {
				taxOwed = ((income - 82250) * .28) + ((82550-33950) * .25) + ((33950 -8350) * .15) + (8350 * .1);
			} else if (income > 33950) {
				taxOwed = ((income-33950) * .25) + ((33950 -8350) * .15) + (8350 * .1);
			} else if (income > 8350) {
				taxOwed = ((income-8350) * .15) + (8350 * .1);
			} else if (income > 0) {
				taxOwed = ((income - 8350) * .1);
			} else {
				System.out.println("Invalid amount entered");
			}
			System.out.println(taxOwed);
			break;
			
		case 2:
			if (income > 372950) {
				taxOwed = ((income -372950) *.35) + ((372950-208850) * .33) + ((208850 - 137050) * .28) + ((137050-67900) * .25) + ((67900 -16700) * .15) + (16700 * .1);
			} else if (income > 208850) {
				taxOwed = ((income-208850) * .33) + ((208850 - 137050) * .28) + ((137050-67900) * .25) + ((67900 -16700) * .15) + (16700 * .1);
			} else if (income > 137050) {
				taxOwed = ((income - 137050) * .28) + ((137050-67900) * .25) + ((67900 -16700) * .15) + (16700 * .1);
			} else if (income > 67900) {
				taxOwed = ((income-33950) * .25) + ((33950 -8350) * .15) + (8350 * .1);
			} else if (income > 16700) {
				taxOwed = ((income-16700) * .15) + (16700 * .1);
			} else if (income > 0) {
				taxOwed = ((income - 16700) * .1);
			} else {
				System.out.println("Invalid amount entered");
			}
			System.out.println(taxOwed);
			break;
			
		case 3:
			if (income > 186475) {
				taxOwed = ((income -186475) *.35) + ((186475-104425) * .33) + ((104425 - 68525) * .28) + ((68525-33950) * .25) + ((33950 -8350) * .15) + (8350 * .1);
			} else if (income > 104425) {
				taxOwed = ((income-104425) * .33) + ((104425 - 68525) * .28) + ((68525-33950) * .25) + ((33950 -8350) * .15) + (8350 * .1);
			} else if (income > 68525) {
				taxOwed = ((income - 68525) * .28) + ((68525-33950) * .25) + ((33950 -8350) * .15) + (8350 * .1);
			} else if (income > 33950) {
				taxOwed = ((income-33950) * .25) + ((33950 -8350) * .15) + (8350 * .1);
			} else if (income > 8350) {
				taxOwed = ((income-8350) * .15) + (8350 * .1);
			} else if (income > 0) {
				taxOwed = ((income - 8350) * .1);
			} else {
				System.out.println("Invalid amount entered");
			}
			System.out.println(taxOwed);
			break;
			
		case 4:
			if (income > 372950) {
				taxOwed = ((income -372950) *.35) + ((372950-190200) * .33) + ((190200 - 117450) * .28) + ((117450-45500) * .25) + ((45500 -11950) * .15) + (11950 * .1);
			} else if (income > 190200) {
				taxOwed = ((income-190200) * .33) + ((190200 - 117450) * .28) + ((117450-45500) * .25) + ((45500 -11950) * .15) + (11950 * .1);
			} else if (income > 117450) {
				taxOwed = ((income - 117450) * .28) + ((117450-45500) * .25) + ((45500 -11950) * .15) + (11950 * .1);
			} else if (income > 45500) {
				taxOwed = ((income-45500) * .25) + ((45500 -11950) * .15) + (11950 * .1);
			} else if (income > 11950) {
				taxOwed = ((income-11950) * .15) + (11950 * .1);
			} else if (income > 0) {
				taxOwed = ((income - 11950) * .1);
			} else {
				System.out.println("Invalid amount entered");
			}
			System.out.println(taxOwed);
			break;
			
		default:
			System.out.println("Invalid filing status");
			break;
		}

	}

}