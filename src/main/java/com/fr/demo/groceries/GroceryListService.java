package com.fr.demo.groceries;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GroceryListService {
	public List<GroceryListService> getAll() {
		return new ArrayList<>();
	}
}
