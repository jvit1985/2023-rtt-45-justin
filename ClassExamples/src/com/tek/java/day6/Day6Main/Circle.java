package com.tek.java.day6.Day6Main;

public class Circle extends Shape {
	private int radius;
	private static final double PI = 3.14159;

	public void setRadius(int radius) {
		this.radius = radius;
	}

	// this is the implmenetation of the AreaCalculation interface
	@Override
	public double calculateArea() {
		double area = (radius * radius * PI);
		return area;
	}

//		@Override
//		public String toString() {
//			return "The area of " + getShapeName() + " (radius= " + radius + ", Pi=" + PI + ") is " + calculateArea();
//		}
}
