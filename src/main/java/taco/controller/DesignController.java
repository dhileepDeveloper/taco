package taco.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import taco.Ingredient;
import taco.Ingredient.Type;
import taco.Taco;

@RequestMapping(value = "/design")
@Controller
public class DesignController {
	
	private static final Logger log =	LoggerFactory.getLogger(DesignController.class);

	@ModelAttribute
	public void addIngredients(Model model) {
		List<Ingredient> ingredientList = new ArrayList<Ingredient>();
		ingredientList.add(new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP));
		ingredientList.add(new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP));
		ingredientList.add(new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN));
		ingredientList.add(new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN));
		ingredientList.add(new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES));
		ingredientList.add(new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES));
		ingredientList.add(new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE));
		ingredientList.add(new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE));
		ingredientList.add(new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE));
		ingredientList.add(new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE));

		Type[] typeArr = Ingredient.Type.values();
		for (Type type : typeArr) {
			model.addAttribute(type.toString(), filterByType(ingredientList, type));
		}
	}

	@GetMapping()
	public String getDesign(Model model) {
		model.addAttribute("design", new Taco());
		return "design";
	}

	@PostMapping
	public String processDesign(@Valid Taco taco, Errors errors)
	{
		if(errors.hasErrors())
		{
			System.out.println("Having error");
			return "design";
		}
		System.out.println("taco is " + taco);
		log.info("Processing design: "+taco);
		return "redirect:/tacoOrders/current";
	}
	
	public List<Ingredient> filterByType(List<Ingredient> ingredientList, Type type) {
		return ingredientList
				.stream()
				.filter(x -> x.getType().equals(type))
				.collect(Collectors.toList());
	}
}
