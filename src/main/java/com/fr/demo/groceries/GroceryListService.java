package com.fr.demo.groceries;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableList;

@Service
public class GroceryListService {
	public List<GroceryList> getAll() {
		return ImmutableList.of(FakeData.GroceryLists.GROCERY_LIST);
	}

	public Optional<GroceryList> get(int id) {
		if (id == FakeData.GroceryLists.GROCERY_LIST.getId()) {
			return Optional.of(FakeData.GroceryLists.GROCERY_LIST);
		}

		return Optional.empty();
	}

	public boolean delete(int id) {
		return id == FakeData.GroceryLists.GROCERY_LIST.getId();
	}
}
