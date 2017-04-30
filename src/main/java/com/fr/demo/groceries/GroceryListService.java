package com.fr.demo.groceries;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableList;

@Service
public class GroceryListService {
	public static final GroceryList GROCERY_LIST = new GroceryList("Provigo", ImmutableList.of(new Product("Milk")));

	public List<GroceryList> getAll() {
		return ImmutableList.of(GROCERY_LIST);
	}

	public GroceryList get(int id) {
		return GROCERY_LIST;
	}
}
