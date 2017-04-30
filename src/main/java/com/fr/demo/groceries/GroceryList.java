package com.fr.demo.groceries;

import java.util.List;

import com.google.common.collect.ImmutableList;

public class GroceryList {
	private final int id;
	private final String name;
	private final List<Product> products;

	public GroceryList(int id, String name, List<Product> products) {
		this.id = id;
		this.name = name;
		this.products = ImmutableList.copyOf(products);
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public int getProductCount() {
		return products.size();
	}
}
