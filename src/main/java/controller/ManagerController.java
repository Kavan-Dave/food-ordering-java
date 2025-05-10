package controller;

import java.util.List;
import entities.*;
import serviceImplementation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {

	private final ManagerServiceImpl ManagerServiceImpl;
	@Autowired
	public ManagerController(ManagerServiceImpl ManagerServiceImpl) {
		super();
		this.ManagerServiceImpl = ManagerServiceImpl;
	}

	@GetMapping
	public List<Managers> getAll()
	{
		return ManagerServiceImpl.findAll();
	}
	
	@GetMapping("/{id}")
	public Managers GetById(@PathVariable int id)
	{
		return ManagerServiceImpl.findById(id).orElse(null);
	}
	
	@PostMapping
	public Managers ManagersCreation(@RequestBody Managers u)
	{
		return ManagerServiceImpl.createManager(u);
	}
	
	@PutMapping("/{id}")
	public Managers updateManagers(@PathVariable int id,@RequestBody Managers u)
	{
		return ManagerServiceImpl.updateManager(u, id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteManagers(@PathVariable int id)
	{
		ManagerServiceImpl.deleteManager(id);
		return "Managers with Id "+id+" Deleted Successfully!";
	}
}
