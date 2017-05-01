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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroceryList other = (GroceryList) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GroceryList [id=" + id + ", name=" + name + ", recipes=" + recipes + ", products=" + products + "]";
	}
}
