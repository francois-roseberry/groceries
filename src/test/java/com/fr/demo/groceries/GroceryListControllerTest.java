package com.fr.demo.groceries;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GroceryListControllerTest {
	@Autowired
	private MockMvc mvc;

	@Test
	public void getGroceryListPage() throws Exception {
		int id = DemoData.GroceryLists.PROVIGO_1.getId();
		mvc.perform(MockMvcRequestBuilders.get("/lists/{0}", id)).andExpect(status().isOk())
				.andExpect(model().attribute("list", equalTo(DemoData.GroceryLists.PROVIGO_1)))
				.andExpect(view().name("grocery-list"));
	}

	@Test
	public void gettingUnexistingListShouldReturn404() throws Exception {
		int unusedId = DemoData.GroceryLists.ALL.size() + 1;
		mvc.perform(MockMvcRequestBuilders.get("/lists/{0}", unusedId)).andExpect(status().isNotFound());
	}
	
	@Test
	public void canDeleteGroceryList() throws Exception {
		int id = DemoData.GroceryLists.PROVIGO_2.getId();
		mvc.perform(MockMvcRequestBuilders.delete("/lists/{0}", id)).andExpect(status().isOk());
	}
	
	@Test
	public void deletingUnexistingListShouldReturn404() throws Exception {
		int unusedId = DemoData.GroceryLists.ALL.size() + 1;
		mvc.perform(MockMvcRequestBuilders.delete("/lists/{0}", unusedId)).andExpect(status().isNotFound());
	}
}
