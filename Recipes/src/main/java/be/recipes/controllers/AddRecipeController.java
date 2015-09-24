package be.recipes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import be.recepten.services.RecipeService;

@Controller
@RequestMapping("/new_recipe")
public class AddRecipeController {

	@Autowired
	RecipeService service;

	@RequestMapping(method = RequestMethod.GET)
	public String handleGet() {
		return "new_recipe";
	}

	@RequestMapping(method = RequestMethod.POST)
	public RedirectView handlePost(@RequestParam("name") String name,
			@RequestParam(value = "ingredients[]") String[] ingredients,
			@RequestParam("description") String description,
			@RequestParam("time") String time,
			@RequestParam("image") MultipartFile image) {

		service.addRecipe(name, ingredients, description, time, image);

		return new RedirectView("recipes.htm");
	}
}
