package com.fr.demo.groceries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/lists")
public class GroceryListController {
	private final GroceryListService service;
	
	@Autowired
	GroceryListController(GroceryListService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getListForm(@PathVariable("id") int id, Model model) {
		System.out.println("getListForm()");
		GroceryList groceryList = service.get(id);
		model.addAttribute("list", groceryList);
		return "grocery-list";
	}
}
