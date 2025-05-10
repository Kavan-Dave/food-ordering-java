package controller;

import java.util.List;
import entities.*;
import serviceImplementation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	private final OrderServiceImpl OrderServiceImpl;
	@Autowired
	public OrderController(OrderServiceImpl OrderServiceImpl) {
		super();
		this.OrderServiceImpl = OrderServiceImpl;
	}

	@GetMapping
	public List<Order> getAll()
	{
		return OrderServiceImpl.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Order GetById(@PathVariable int id)
	{
		return OrderServiceImpl.findById(id).orElse(null);
	}
	
	@PostMapping
	public Order OrderCreation(@RequestBody Order u)
	{
		return OrderServiceImpl.createOrder(u);
	}
	
	@PutMapping("/{id}")
	public Order updateOrder(@PathVariable int id,@RequestBody Order u)
	{
		return OrderServiceImpl.updateOrder(u, id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteOrder(@PathVariable int id)
	{
		return OrderServiceImpl.deleteOrder(id);
		
	}
}
