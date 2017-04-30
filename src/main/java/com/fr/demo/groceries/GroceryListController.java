package com.fr.demo.groceries;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javassist.NotFoundException;

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
		return service.get(id).map((groceryList) -> {
			model.addAttribute("list", groceryList);
			return "grocery-list";
		}).orElseThrow(() -> new ResourceNotFoundException());
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	class ResourceNotFoundException extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}
}
