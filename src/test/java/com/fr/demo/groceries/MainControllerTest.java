package com.fr.demo.groceries;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {

    private MockMvc mvc;
    
    @Before
    public void setup() {
    	MainController controller = new MainController(new GroceryListService(), new RecipeService());
    	mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getListsPage() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("lists", equalTo(DemoData.GroceryLists.ALL)))
                .andExpect(model().attribute("recipeCount", DemoData.Recipes.ALL.size()))
                .andExpect(view().name("grocery-list-list"));
    }
}