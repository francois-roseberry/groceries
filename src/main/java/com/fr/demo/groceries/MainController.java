package com.fr.demo.groceries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	private final GroceryListService groceryService;
	private final RecipeService recipeService;

	@Autowired
	MainController(GroceryListService service, RecipeService recipeService) {
		this.groceryService = service;
		this.recipeService = recipeService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getListsForm(Model model) {
		model.addAttribute("lists", groceryService.getAll());
		model.addAttribute("recipeCount", recipeService.getAll().size());
		return "grocery-list-list";
	}
}
