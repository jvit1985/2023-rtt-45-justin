package com.tek.java.day8lab;

import java.util.Comparator;

public class cities_Comparator implements Comparator<String> {

	@Override
	public int compare(String cities_one, String cities_two) {
	       int value =  cities_one.compareTo(cities_two);
	       // sort elements in reverse order
	       if (value > 0) {
	         return -1;
	       }
	       else if (value < 0) {
	         return 1;
	       }
	       else {
	          return 0;
	       }
	       }

}
