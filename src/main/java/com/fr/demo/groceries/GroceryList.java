package com.fr.demo.groceries;

import java.util.List;

import com.google.common.collect.ImmutableList;

public class GroceryList {
	private final int id;
	private final String name;
	private final List<Recipe> recipes;
	private final List<Product> products;

	public GroceryList(int id, String name, List<Recipe> recipes, List<Product> products) {
		this.id = id;
		this.name = name;
		this.recipes = ImmutableList.copyOf(recipes);
		this.products = ImmutableList.copyOf(products);
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public List<Recipe> getRecipes() {
		return recipes;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public int getProductCount() {
		return products.size();
	}
}
