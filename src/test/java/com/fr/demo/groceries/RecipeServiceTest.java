package com.fr.demo.groceries;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RecipeServiceTest {
	private RecipeService service;
	
	@Before
	public void setup() {
		service = new RecipeService();
	}
	
	@Test
	public void canGetAllExistingRecipes() {
		assertEquals(DemoData.Recipes.ALL, service.getAll());
	}
}
