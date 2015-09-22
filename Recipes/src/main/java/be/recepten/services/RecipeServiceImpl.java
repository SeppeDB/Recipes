package be.recepten.services;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.web.multipart.MultipartFile;

import be.recepten.entities.Ingredient;
import be.recepten.entities.Recipe;

public class RecipeServiceImpl implements RecipeService {

	private EntityManagerFactory emf;

	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void addRecipe(String name, String[] ingredients,
			String description, String time, MultipartFile image) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Recipe recipe = new Recipe();
		recipe.setName(name);
		recipe.setDescription(description);
		recipe.setTime(time);

		byte[] bFile;
		try {
			bFile = image.getBytes();
			recipe.setImage(bFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String s : ingredients) {
			Ingredient ing = new Ingredient();
			ing.setName(s);
			ing.setRecipe(recipe);
			recipe.addIngredient(ing);
		}

		em.persist(recipe);

		tx.commit();
		em.close();
	}

	@Override
	public Recipe findRecipe(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Recipe recipe = em.find(Recipe.class, 1);

		tx.commit();
		em.close();

		if (recipe == null) {
			return null;
		} else {
			return recipe;
		}
	}

}
