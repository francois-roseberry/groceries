package com.fr.demo.groceries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/lists")
public class GroceryListController {
	private static final String VIEW_NAME = "grocery-list";
	
	private final GroceryListService service;

	@Autowired
	GroceryListController(GroceryListService service) {
		this.service = service;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getListForm(@PathVariable("id") int id, Model model) {
		return service.get(id).map((groceryList) -> {
			model.addAttribute("list", groceryList);
			return VIEW_NAME;
		}).orElseThrow(() -> new ResourceNotFoundException());
	}
	
	@RequestMapping(value = "/create")
	public String create(Model model) {
		GroceryList list = service.create();
		model.addAttribute("list", list);
		return VIEW_NAME;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable("id") int id) {
		if (!service.delete(id)) {
			throw new ResourceNotFoundException();
		}
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	class ResourceNotFoundException extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}
}
