package be.recepten.services;

import org.springframework.web.multipart.MultipartFile;

import be.recepten.entities.Recipe;


public interface RecipeService {

	public void addRecipe(String name, String[] ingredients, String description, String time, MultipartFile image);
	
	public Recipe findRecipe(int id);
}
