package controller;

import java.util.List;
import entities.*;
import serviceImplementation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/item")
public class ItemController {

	private final ItemServiceImpl ItemServiceImpl;
	@Autowired
	public ItemController(ItemServiceImpl ItemServiceImpl) {
		super();
		this.ItemServiceImpl = ItemServiceImpl;
	}

	@GetMapping
	public List<Item> getAll()
	{
		return ItemServiceImpl.findAll();
	}
	
	@GetMapping("/{id}")
	public Item GetById(@PathVariable int id)
	{
		return ItemServiceImpl.findById(id).orElse(null);
	}
	
	@PostMapping
	public Item ItemCreation(@RequestBody Item u)
	{
		return ItemServiceImpl.createItem(u);
	}
	
	@PutMapping("/{id}")
	public Item updateItem(@PathVariable int id,@RequestBody Item u)
	{
		return ItemServiceImpl.updateItem(u, id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteItem(@PathVariable int id)
	{
		ItemServiceImpl.deleteItem(id);
		return "Item with Id "+id+" Deleted Successfully!";
	}
}
