package be.recipes.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import be.recepten.entities.Recipe;
import be.recepten.services.RecipeService;

@Controller
@RequestMapping("/recipes")
public class RecipeListController {

	@Autowired
	RecipeService service;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleGet() {

		List<Recipe> recipes = new ArrayList<Recipe>(service.findAllRecipes());

		return new ModelAndView("recipes", "recipes", recipes);
	}

	@RequestMapping(method = RequestMethod.POST)
	public RedirectView handlePost() {
		return new RedirectView("new_recipe.htm");
	}

}
