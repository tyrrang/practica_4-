package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Fruit;
import boot.service.FruitService;

@Controller
public class FruitController {

	@Autowired
	private FruitService fruitService;
	
	@GetMapping("fruit")
	public String homeFruit(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "fruit";
	}
	
	@GetMapping("/all-fruits")
	public String allFruits(HttpServletRequest request){
		request.setAttribute("fruits", fruitService.findAll());
		request.setAttribute("mode", "MODE_FRUITS");
		return "fruit";
	}
	
	@GetMapping("/new-fruit")
	public String newFruit(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW_FRUIT");
		return "fruit";
	}
	
	@PostMapping("/save-fruit")
	public String saveFruit(@ModelAttribute Fruit fruit, BindingResult bindingResult, HttpServletRequest request){
		fruitService.save(fruit);
		request.setAttribute("fruits", fruitService.findAll());
		request.setAttribute("mode", "MODE_FRUITS");
		return "fruit";
	}
	
	@GetMapping("/update-fruit")
	public String updateTask(@RequestParam int id_fruit, HttpServletRequest request){
		request.setAttribute("fruit", fruitService.findFruit(id_fruit));
		request.setAttribute("mode", "MODE_UPDATE_FRUIT");
		return "fruit";
	}
	
	@GetMapping("/delete-fruit")
	public String deleteFruit(@RequestParam int id_fruit, HttpServletRequest request){
		fruitService.delete(id_fruit);
		request.setAttribute("fruits", fruitService.findAll());
		request.setAttribute("mode", "MODE_FRUITS");
		return "fruit";
	}
	
}
