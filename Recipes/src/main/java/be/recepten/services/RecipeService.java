package be.recepten.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import be.recepten.entities.Recipe;

public interface RecipeService {

	// Niew recept wegschrijven naar database
	public void addRecipe(String name, String[] ingredients,
			String description, String time, MultipartFile image);

	// Specifiek recept uit database halen
	public Recipe findRecipe(int id);

	// Al de recepten uit de database halen
	List<Recipe> findAllRecipes();
}
