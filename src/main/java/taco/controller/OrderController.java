package taco.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import taco.Order;
import taco.Taco;

@Slf4j
@RequestMapping("/tacoOrders")
@Controller
public class OrderController {

	@GetMapping(value="/current")
	public String currentOrder(Model model) {
		model.addAttribute("order",new Order());
		return "order";
	}
	
	@PostMapping
	public String processOrder(@Valid Order order,Errors errors,Model model) {
		//System.out.println("ENtered 25");
		if(errors.hasErrors())
			return "order";
		log.info("Order submitted: " + order);
		//model.addAttribute("design",new Taco());
		return "redirect:/";
	}
}
