package com.fr.demo.groceries;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RecipeService {
	
	public List<Recipe> getAll() {
		return DemoData.Recipes.ALL;
	}
}
