	package controller;

import java.util.List;
import entities.*;
import serviceImplementation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	private final CustomerServiceImpl CustomerServiceImpl;
	@Autowired
	public CustomerController(CustomerServiceImpl CustomerServiceImpl) {
		super();
		this.CustomerServiceImpl = CustomerServiceImpl;
	}

	@GetMapping
	public List<Customers> getAll()
	{
		return CustomerServiceImpl.findAll();
	}
	
	@GetMapping("/{id}")
	public Customers GetById(@PathVariable int id)
	{
		return CustomerServiceImpl.findById(id).orElse(null);
	}
	
	@PostMapping
	public Customers CustomerCreation(@RequestBody Customers u)
	{
		return CustomerServiceImpl.createCustomer(u);
	}
	
	@PutMapping("/{id}")
	public Customers updateCustomer(@PathVariable int id,@RequestBody Customers u)
	{
		return CustomerServiceImpl.updateCustomer(u, id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteCustomer(@PathVariable int id)
	{
		CustomerServiceImpl.deleteCustomer(id);
		return "Customer with Id "+id+" Deleted Successfully!";
	}
	
	@GetMapping("/{id}/orders")
	public List<Order> findOrderByIf(@PathVariable int id){
		return CustomerServiceImpl.findOrderById(id);
	}
	
	@PostMapping("{cid}/place-order/{fid}")
	public Customers placeOrder(@PathVariable int cid , @PathVariable int fid,@RequestBody Order o)
	{
		return CustomerServiceImpl.placeOrder(cid,fid,o);
	}
}
