package com.tek.jav.day6.assignment1;

public class Monster {
		String name;
	 
	   public Monster() {

	   }
	   public Monster(String aName) {
	       name = aName;
	   }
	   public String getName() { return name; }
	   public void setName(String aName) { name = aName; }
	   
	   public String attack() {
	       return("!^_&^$@+%$* I don't know how to attack!");
	   }
}
