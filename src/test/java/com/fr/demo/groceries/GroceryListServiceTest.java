package com.fr.demo.groceries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

public class GroceryListServiceTest {
	private GroceryListService service;
	
	@Before
	public void setup() {
		service = new GroceryListService();
	}
	
	@Test
	public void canGetExistingGroceryList() {
		assertEquals(Optional.of(DemoData.GroceryLists.PROVIGO_1), service.get(0));
	}
	
	@Test
	public void tryingToGetUnexistingGroceryListReturnsEmptyOptional() {
		int id = service.getAll().size() + 1;
		assertEquals(Optional.empty(), service.get(id));
	}
	
	@Test
	public void canGetAllExistingGroceryLists() {
		assertEquals(DemoData.GroceryLists.ALL, service.getAll());
	}

	@Test
	public void deletingGroceryListCannotBeAccessedAfterwards() {
		service.delete(DemoData.GroceryLists.PROVIGO_1.getId());
		assertEquals(Optional.empty(), service.get(DemoData.GroceryLists.PROVIGO_1.getId()));
		assertFalse(service.getAll().contains(DemoData.GroceryLists.PROVIGO_1));
	}
}
