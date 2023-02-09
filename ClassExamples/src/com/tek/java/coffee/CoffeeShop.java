package com.tek.java.coffee;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CoffeeShop {

	private List<MenuItem> menuItems = new ArrayList<>();

	public void initialize() {
		MenuItem item1 = new MenuItem();
		item1.setName("Small Coffee");
		item1.setPrice(4.30);
		item1.setQuantityInStock(50);

		menuItems.add(item1);

		MenuItem item2 = new MenuItem();
		item2.setName("Large Coffee");
		item2.setPrice(5.99);
		item2.setQuantityInStock(50);

		menuItems.add(item2);

		MenuItem item3 = new MenuItem("Small Cookie", 9.99, 5);
		menuItems.add(item3);

		menuItems.add(new MenuItem("Egg Sandwich", 14.30, 4));
	}

	public void printMenuItems() {

		System.out.println("Item Name\tPrice\tQuantity In Stock");
		System.out.println("---------\t-----\t-----------------");

		for (MenuItem item : menuItems) {
			DecimalFormat df = new DecimalFormat("$##.00");
			System.out.println(item.getName() + "\t" + df.format(item.getPrice()) + "\t" + item.getQuantityInStock());
		}

	}

}
