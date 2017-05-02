package com.fr.demo.groceries;

import java.util.List;

import com.google.common.collect.ImmutableList;

public class DemoData {
	public static class Products {
		public static final Product MILK = new Product(0, "Milk");
		public static final Product YOGURT = new Product(1, "Yogurt");
		public static final Product BREAD = new Product(2, "Bread");
	}

	public static class Recipes {
		public static final Recipe BROWNIES = new Recipe("Brownies");

		public static final List<Recipe> ALL = ImmutableList.of(BROWNIES);
	}

	public static class GroceryLists {
		public static final GroceryList PROVIGO_1 = new GroceryList(0, "Provigo", ImmutableList.of(Recipes.BROWNIES),
				ImmutableList.of(Products.MILK, Products.YOGURT, Products.BREAD));

		public static final GroceryList PROVIGO_2 = new GroceryList(1, "Provigo 2", ImmutableList.of(),
				ImmutableList.of(Products.MILK));

		public static final List<GroceryList> ALL = ImmutableList.of(PROVIGO_1, PROVIGO_2);
	}

	private DemoData() {
		// To prevent instantiation
	}
}
