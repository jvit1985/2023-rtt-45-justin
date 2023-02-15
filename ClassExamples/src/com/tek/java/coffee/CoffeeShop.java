package com.tek.java.coffee;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CoffeeShop {

	public static final int PRINT_MENU = 1;
	public static final int ORDER_ITEM = 2;
	public static final int VIEW_CART = 3;
	public static final int EXIT = 4;

	private List<MenuItem> menuItems = new ArrayList<>();

	private List<MenuItem> cart = new ArrayList<>();

	private Scanner scanner = new Scanner(System.in);

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

		MenuItem item3 = new MenuItem("Small Cookie", 4.99, 5);
		menuItems.add(item3);

		menuItems.add(new MenuItem("Egg Sandwich", 14.30, 4));
		
		menuItems.sort(new Comparator<MenuItem>() {

			@Override
			public int compare(MenuItem o1, MenuItem o2) {
				// TODO Auto-generated method stub
				Double p1 = o1.getPrice();
				Double p2 = o2.getPrice();
				
				return p1.compareTo(p2);
			}
		});
			
	}

	public void printMenuItems() {

		System.out.println("Item Name\tPrice\tQuantity In Stock");
		System.out.println("---------\t-----\t-----------------");

		for (MenuItem item : menuItems) {

			System.out.println(item.getName() + "\t" + formatPrice(item.getPrice()) + "\t" + item.getQuantityInStock());
		}

		System.out.println("-----------------------------------------");
	}

	public int menuPrompt() {

		System.out.println("Welcome to Justin's coffee shop\n");
		System.out.println(PRINT_MENU + ") Print Menu");
		System.out.println(ORDER_ITEM + ") Order Item");
		System.out.println(VIEW_CART + ") View Cart");
		System.out.println(EXIT + ") Exit Coffee Shop");
		System.out.print("\nMake slection :");

		int selection = scanner.nextInt();
		scanner.nextLine();

		System.out.println("");

		return selection;
	}

	public void orderItem() {
		printMenuItems();

		System.out.print("Enter item name:");
		String itemName = scanner.nextLine();

		MenuItem selectedItem = findMenuItemByItemName(itemName);
		if (selectedItem != null) {
			System.out.println(selectedItem.getName() + " added to your cart.\n");
			cart.add(selectedItem);
		} else {
			System.out.println(itemName + " is not a valid selection\n");
		}
	}

	private MenuItem findMenuItemByItemName(String itemName) {
		if (itemName == null) {
			return null;
		}

		itemName = itemName.trim();

		for (MenuItem menuItem : menuItems) {
			String name = menuItem.getName();
			if (name.equalsIgnoreCase(itemName)) {
				return menuItem;
			}
		}
		return null;
	}

	public void viewCart() {
		System.out.println(cart.size() + " items in your cart.\n");

		double totalPrice = 0.0;

		System.out.println("Item Name\tPrice");
		System.out.println("---------\t-----");
		for (MenuItem item : cart) {

			System.out.println(item.getName() + "\t" + formatPrice(item.getPrice()));
			totalPrice = totalPrice + item.getPrice();
		}

		System.out.println("---------\t-----");

		System.out.println("Total Price\t" + formatPrice(totalPrice));
		System.out.println("");
	}

	private String formatPrice(double price) {
		DecimalFormat df = new DecimalFormat("$##.00");
		String formattedPrice = df.format(price);

		return formattedPrice;
	}

}
