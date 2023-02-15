package com.tek.java.day6.assignment1;

public class FireMonster extends Monster {
	public FireMonster() {

	}

	public FireMonster(String aName) {
		aName = name;
	}

	public String attack() {
		return ("Attack with fire!");
	}
}
