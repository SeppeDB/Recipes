package be.recepten.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "findAll", query = "select r from Recipe as r")
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String description;
	private String time;

	@OneToMany(mappedBy = "recipe", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Ingredient> ingredients = new ArrayList<>();

	@Lob
	private String image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient);
		ingredient.setRecipe(this);
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", description="
				+ description + ", time=" + time + ", ingredients="
				+ ingredients + ", image=" + image + "]";
	}

}
