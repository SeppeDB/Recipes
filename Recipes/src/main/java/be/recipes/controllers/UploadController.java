package be.recipes.controllers;

import java.io.IOException;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import be.recepten.services.RecipeService;

import com.mysql.jdbc.Blob;

@Controller
@RequestMapping("/new_recipe")
public class UploadController {

	@Autowired
	RecipeService service;

	@RequestMapping(method = RequestMethod.GET)
	public String handleget() {
		return "new_recipe";
	}

	@RequestMapping(method = RequestMethod.POST)
	public void handlePost(@RequestParam("name") String name,
			@RequestParam(value = "ingredients[]") String[] ingredients,
			@RequestParam("description") String description,
			@RequestParam("time") String time,
			@RequestParam("image") MultipartFile image) {

		service.addRecipe(name, ingredients, description, time, image);
		
		
	}
}
