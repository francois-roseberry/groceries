package com.fr.demo.groceries;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableList;

@Service
public class GroceryListService {
	public static final GroceryList GROCERY_LIST = new GroceryList(0, "Provigo", ImmutableList.of(new Product("Milk")));

	public List<GroceryList> getAll() {
		return ImmutableList.of(GROCERY_LIST);
	}

	public Optional<GroceryList> get(int id) {
		if (id == GROCERY_LIST.getId()) {
			return Optional.of(GROCERY_LIST);
		}

		return Optional.empty();
	}
	
	public boolean delete(int id) {
		return id == GROCERY_LIST.getId();
	}
}
