package com.fr.demo.groceries;

import java.util.List;

import com.google.common.collect.ImmutableList;

public class GroceryList {
	private final String name;
	private final List<Product> products;

	public GroceryList(String name, List<Product> products) {
		this.name = name;
		this.products = ImmutableList.copyOf(products);
	}

	public String getName() {
		return name;
	}
	
	public List<Product> getProducts() {
		return products;
	}
}
