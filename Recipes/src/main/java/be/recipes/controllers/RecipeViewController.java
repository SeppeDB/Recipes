package be.recipes.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import be.recipes.entities.Recipe;
import be.recipes.services.RecipeService;

@Controller
@RequestMapping("/recipes")
public class RecipeViewController {

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

	@RequestMapping(method = RequestMethod.GET, params = "filter")
	public ModelAndView handleSearch(@RequestParam Map<String, String> params) {
		String name = params.get("name");
		String desc = params.get("desc");
		String time = params.get("time");

		List<Recipe> recipes = new ArrayList<Recipe>(service.findAllRecipesBy(name, desc, time));

		return new ModelAndView("recipes", "recipes", recipes);
	}

	@RequestMapping(method = RequestMethod.GET, params = "id")
	public ModelAndView handleGet(@RequestParam Map<String, String> params) {

		int id = Integer.parseInt(params.get("id"));

		Recipe recipe = service.findRecipe(id);

		return new ModelAndView("recipe", "recipe", recipe);
	}

}
