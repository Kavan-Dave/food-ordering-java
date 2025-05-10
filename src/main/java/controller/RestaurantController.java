package controller;

import java.util.List;
import entities.*;
import serviceImplementation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

	private final RestaurantServiceImpl restaurantServiceImpl;
	@Autowired
	public RestaurantController(RestaurantServiceImpl RestaurantServiceImpl) {
		super();
		this.restaurantServiceImpl = RestaurantServiceImpl;
	}

	@GetMapping
	public List<Restaurant> getAll()
	{
		return restaurantServiceImpl.findAll();
	}
	
	@GetMapping("/{id}")
	public Restaurant GetById(@PathVariable int id)
	{
		return restaurantServiceImpl.findById(id).orElse(null);
	}
	
	@PostMapping
	public Restaurant RestaurantCreation(@RequestBody Restaurant u)
	{
		return restaurantServiceImpl.createRestaurant(u);
	}
	
	@PutMapping("/{id}")
	public Restaurant updateRestaurant(@PathVariable int id,@RequestBody Restaurant u)
	{
		return restaurantServiceImpl.updateRestaurant(u, id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteRestaurant(@PathVariable int id)
	{
		restaurantServiceImpl.deleteRestaurant(id);
		return "Restaurant with Id "+id+" Deleted Successfully!";
	}
	@PostMapping("/{rid}/manager-assign/{mid}")
	public Restaurant assignMnager(@PathVariable int rid,@PathVariable int mid)
	{
		return restaurantServiceImpl.assignManager(rid,mid);
	}
	
	@GetMapping("/{rid}/menu")
	public List<FoodItem> getMenu(@PathVariable int rid)
	{
		return restaurantServiceImpl.addMenu(rid);
	}
	
	
}
