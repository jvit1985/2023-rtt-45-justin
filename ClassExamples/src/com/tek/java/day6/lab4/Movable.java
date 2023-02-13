package com.tek.java.day6.lab4;

public interface Movable {// An interface defines a list of public abstract methods to be implemented by
							// the subclasses

	void moveUp(); // "public" and "abstract" by default

	void moveDown();

	void moveLeft();

	void moveRight();

	String getCoordinate();
}
