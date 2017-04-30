package com.fr.demo.groceries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	private final GroceryListService service;

	@Autowired
	MainController(GroceryListService service) {
		this.service = service;
	}

	@RequestMapping(value = "/lists", method = RequestMethod.GET)
	public String getListsForm(Model model) {
		List<GroceryList> lists = service.getAll();
		model.addAttribute("lists", lists);
		return "grocery-lists";
	}
}
