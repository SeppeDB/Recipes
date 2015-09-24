package be.recepten.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import be.recepten.entities.Ingredient;
import be.recepten.entities.Recipe;

public class RecipeServiceImpl implements RecipeService {

	private EntityManager em;

	@Autowired
	private HelperService service;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Transactional
	@Override
	public void addRecipe(String name, String[] ingredients,
			String description, String time, MultipartFile file) {

		// MultipartFile omzetten naar een Base64 encoded String
		byte[] image = service.MultipartFileToByteArray(file);
		String imageString = service.Base64EncodeToString(image);

		// Recipe object aanmaken en opvullen met gegevens uit het forumulier
		// (new_recipe.jsp)
		Recipe recipe = new Recipe();
		recipe.setName(name);
		recipe.setDescription(description);
		recipe.setTime(time);
		recipe.setImage(imageString);

		for (String s : ingredients) {
			Ingredient ing = new Ingredient();
			ing.setName(s);
			ing.setRecipe(recipe);
			recipe.addIngredient(ing);
		}

		// Recipe object wegschrijven naar de database
		em.persist(recipe);
	}

	@Transactional
	@Override
	public Recipe findRecipe(int id) {

		Recipe recipe = em.find(Recipe.class, id);

		if (recipe == null) {
			return null;
		} else {
			return recipe;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Recipe> findAllRecipes() {

		// findAll query uitvoeren om al de recepten in een lijst te steken
		// (De query String wordt gedefinieerd in de Recipe entity)
		Query query = em.createNamedQuery("findAll");
		List<Recipe> recipes = (List<Recipe>) query.getResultList();

		if (recipes == null) {
			return null;
		} else {
			return recipes;
		}
	}

}
