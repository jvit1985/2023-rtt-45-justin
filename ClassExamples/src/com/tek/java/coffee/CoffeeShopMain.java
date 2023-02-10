package com.tek.java.coffee;

public class CoffeeShopMain {

	public static void main(String[] args) {
		CoffeeShop cs = new CoffeeShop();
		cs.initialize();

		while (true) {
			int selection = cs.menuPrompt();

			if (selection == CoffeeShop.PRINT_MENU) {
				cs.printMenuItems();
			}
			if (selection == CoffeeShop.ORDER_ITEM) {
				cs.orderItem();
			}
			if (selection == CoffeeShop.VIEW_CART) {
				cs.viewCart();
			}
			if (selection == CoffeeShop.EXIT) {
				System.out.println("Thank you, please come again.");
				System.exit(0);
			}
		}
	}
}
