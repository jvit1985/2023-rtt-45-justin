package com.tek.java.day6.assignment1;

public class StoneMonster extends Monster {
	public StoneMonster() {

	}

	public StoneMonster(String aName) {
		aName = name;
	}

	public String attack() {
		return ("Attack with stones!");
	}
}
