package be.recipes.controllers;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.recepten.entities.Recipe;
import be.recepten.services.RecipeService;

@Controller
@RequestMapping("/recipes")
public class ListController {

	@Autowired
	RecipeService service;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleGet(HttpServletResponse response) {
		Recipe recipe = service.findRecipe(1);
		
		Base64.Encoder enc = Base64.getEncoder();
		
		
		System.out.println("ENCODE" + enc.encode(recipe.getImage()));
		
		return new ModelAndView("recipes", "recipe", recipe);

//		response.setContentType("image/gif");
//		OutputStream o;
//		try {
//			o = response.getOutputStream();
//
//			o.write(recipe.getImage());
//			o.flush();
//			o.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	
	}

}
