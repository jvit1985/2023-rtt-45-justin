package com.tek.java.day7lab1;

public class myRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// initialize the class with Integer data
	    DemoClass dObj = new DemoClass();
	    dObj.genericsMethod(25); // passing int
	    dObj.genericsMethod("Per Scholas"); // passing String
	    dObj.genericsMethod(2563.5); // passing float
	    dObj.genericsMethod('H'); // passing Char

	}

}
