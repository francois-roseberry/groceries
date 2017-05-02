package com.fr.demo.groceries;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableList;

@Service
public class GroceryListService {
	private final LinkedHashMap<Integer, GroceryList> lists = DemoData.GroceryLists.ALL.stream()
			.collect(Collectors.toMap(GroceryList::getId, (groceryList) -> groceryList, (v1,v2) -> v1, LinkedHashMap::new));
	
	public List<GroceryList> getAll() {
		return ImmutableList.copyOf(lists.values());
	}

	public Optional<GroceryList> get(int id) {
		return Optional.ofNullable(lists.get(id));
	}
	
	public GroceryList create() {
		int newId = lists.size();
		GroceryList newList = GroceryList.empty(newId);
		lists.put(newId, newList);
		return newList;
	}

	public boolean delete(int id) {
		return lists.remove(id) != null;
	}

	public boolean deleteProduct(int listId, int productId) {
		return true;
	}
}
