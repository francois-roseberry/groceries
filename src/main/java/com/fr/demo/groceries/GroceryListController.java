package com.fr.demo.groceries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Model model) {
		GroceryList list = service.create();
		return "redirect:/lists/" + list.getId();
	}
	
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
		if (!service.delete(id)) {
			throw new ResourceNotFoundException();
		}
		
		redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE", String.format("Grocery list (%s) was deleted", id));
		return "redirect:/";
	}
	
	@RequestMapping(value = "/{listId}/products/{productId}/delete")
	public String deleteProduct(@PathVariable("listId") int listId, @PathVariable("productId") int productId) {
		if (!service.deleteProduct(listId, productId)) {
			throw new ResourceNotFoundException();
		}
		
		return String.format("redirect:/lists/%s", listId);
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	class ResourceNotFoundException extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}
}
