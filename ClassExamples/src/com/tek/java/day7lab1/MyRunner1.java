package com.tek.java.day7lab1;

public class MyRunner1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GMultipleDatatype<String, Integer> mobj = new GMultipleDatatype("Per Scholas", 11025);

	       System.out.println(mobj.getValueOne());
	       System.out.println(mobj.getValueTwo());
	       
	         // initialize generic class
	       // with String and String data
	       GMultipleDatatype<String, String> mobj2 = new GMultipleDatatype("Per Scholas", "Non profit");
	       System.out.println(mobj2.getValueOne());
	       System.out.println(mobj2.getValueTwo());

	}

}
