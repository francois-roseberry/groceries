package com.fr.demo.groceries;

public class GroceryList {
	private final String name;
	
	public static GroceryList named(String name) {
		return new GroceryList(name);
	}
	
	private GroceryList(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
