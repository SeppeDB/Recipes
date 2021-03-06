package be.recipes.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import be.recipes.entities.Recipe;

public interface RecipeService {

	// Niew recept wegschrijven naar database
	public void addRecipe(String name, String[] ingredients,
			String description, String time, MultipartFile image);

	// Specifiek recept uit database halen
	public Recipe findRecipe(int id);

	// Al de recepten uit de database halen
	List<Recipe> findAllRecipes();

	// Al de recepten uit de database halen op basis van bepaalde criteria
	List<Recipe> findAllRecipesBy(String name, String description, String time);

	// Al de recepten uit de database halen op basis van ingredienten
	List<Recipe> findAllRecipesByIngredient(String ingredient);
}
