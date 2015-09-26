package be.recipes.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import be.recipes.entities.Ingredient;
import be.recipes.entities.Recipe;

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
	public void addRecipe(String name, String[] ingredients, String description, String time, MultipartFile file) {

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

	@Override
	public List<Recipe> findAllRecipesBy(String name, String description, String time) {

		name = service.emptyStringToWildcard(name);
		description = service.emptyStringToWildcard(description);
		time = service.emptyStringToWildcard(time);

		TypedQuery<Recipe> query = em.createQuery(
				"SELECT r FROM Recipe as r WHERE r.name LIKE :name AND r.description LIKE :description AND r.time LIKE :time",
				Recipe.class);

		query.setParameter("name", name);
		query.setParameter("description", description);
		query.setParameter("time", time);

		List<Recipe> recipes = (List<Recipe>) query.getResultList();

		return recipes;
	}

	// Niet gebruikte methode. Vanwege tijdsgebrek is het zoeken op ingredienten
	// (nog) niet geimplementeerd
	@Override
	public List<Recipe> findAllRecipesByIngredient(String ingredient) {

		TypedQuery<Recipe> query = em
				.createQuery("SELECT r FROM Recipe r join r.ingredients i where i.name LIKE :ingredient", Recipe.class);
		query.setParameter("ingredient", "%" + ingredient + "%");

		List<Recipe> recipes = (List<Recipe>) query.getResultList();

		return recipes;
	}

}
