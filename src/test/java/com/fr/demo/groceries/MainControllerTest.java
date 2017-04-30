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

import com.google.common.collect.ImmutableList;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getListsPage() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/lists"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("lists", equalTo(ImmutableList.of(GroceryListService.GROCERY_LIST))))
                .andExpect(view().name("grocery-lists"));
    }
}