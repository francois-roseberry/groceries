package com.fr.demo.groceries;

import java.util.List;

import com.google.common.collect.ImmutableList;

public class FakeData {
	public static class Products {
		public static final Product MILK = new Product("Milk");
		public static final Product YOGURT = new Product("Yogurt");
		public static final Product BREAD = new Product("Bread");
	}

	public static class Recipes {
		public static final Recipe BROWNIES = new Recipe("Brownies");

		public static final List<Recipe> ALL = ImmutableList.of(BROWNIES);
	}

	public static class GroceryLists {
		public static final GroceryList GROCERY_LIST = new GroceryList(0, "Provigo", ImmutableList.of(Recipes.BROWNIES),
				ImmutableList.of(Products.MILK, Products.YOGURT, Products.BREAD));
		
		public static final List<GroceryList> ALL = ImmutableList.of(GROCERY_LIST);
	}
	
	private FakeData() {
		// To prevent instantiation
	}
}
