package com.perscholas.java_basics;

public class JavaBasicsClass {
	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		int c = a + b;
		System.out.println(c);
		
		double d = 1.5;
		double e = 2.3;
		double f = d + e;
		System.out.println(f);
		
		int g = 2;
		double h = 3.3;
		double i = g + h;
		System.out.println(i);
		
		int j = 10;
		int k = 5;
		int l = j/k;
		System.out.println(l);
		
		double m = 4.8;
		double n = 3.4;
		double o = m/n;
		System.out.println(o);
		int p = (int)o;
		System.out.println(p);
		
		int x = 5;
		int y = 6;
		int q = y/x;
		System.out.println(q);
		double w = (double)y;
		double r = w/x;
		System.out.println(r);
		
		final double PI = 3.14;
		int radius = 4;
		double area = radius * radius * PI;
		System.out.println(area);
		
		double coffee = 4.79;
		double tea = 2.99;
		double muffin = 3.49;
		double subtotal;
		double totalSale;
		
		subtotal = coffee * 3 + tea * 4 + muffin * 2;
		final double SALES_TAX = 0.0825;
		totalSale = subtotal + (subtotal * SALES_TAX);
		System.out.println(String.format("%.2f", totalSale));
		
	}
}
