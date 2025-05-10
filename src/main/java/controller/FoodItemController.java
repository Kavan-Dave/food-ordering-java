package controller;

import java.util.List;
import entities.*;
import serviceImplementation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fooditem")
public class FoodItemController {

	private final FoodItemServiceImpl FoodItemServiceImpl;
	@Autowired
	public FoodItemController(FoodItemServiceImpl FoodItemServiceImpl) {
		super();
		this.FoodItemServiceImpl = FoodItemServiceImpl;
	}

	@GetMapping
	public List<FoodItem> getAll()
	{
		return FoodItemServiceImpl.findAll();
	}
	
	@GetMapping("/{id}")
	public FoodItem GetById(@PathVariable int id)
	{
		return FoodItemServiceImpl.findById(id).orElse(null);
	}
	
	@PostMapping
	public FoodItem FoodItemCreation(@RequestBody FoodItem u)
	{
		return FoodItemServiceImpl.createFoodItem(u);
	}
	
	@PutMapping("/{id}")
	public FoodItem updateFoodItem(@PathVariable int id,@RequestBody FoodItem u)
	{
		return FoodItemServiceImpl.updateFoodItem(u, id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteFoodItem(@PathVariable int id)
	{
		FoodItemServiceImpl.deleteFoodItem(id);
		return "FoodItem with Id "+id+" Deleted Successfully!";
	}
}
