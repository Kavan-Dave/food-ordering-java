package controller;

import java.util.List;
import entities.*;
import serviceImplementation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserServiceImpl userServiceImpl;
	@Autowired
	public UserController(UserServiceImpl userServiceImpl) {
		super();
		this.userServiceImpl = userServiceImpl;
	}

	@GetMapping
	public List<Users> getAll()
	{
		return userServiceImpl.findAll();
	}
	
	@GetMapping("/{id}")
	public Users GetById(@PathVariable int id)
	{
		return userServiceImpl.findById(id).orElse(null);
	}
	
	@PostMapping
	public Users userCreation(@RequestBody Users u)
	{
		return userServiceImpl.createUser(u);
	}
	
	@PutMapping("/{id}")
	public Users updateUser(@PathVariable int id,@RequestBody Users u)
	{
		return userServiceImpl.updateUser(u, id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable int id)
	{
		userServiceImpl.deleteUser(id);
		return "User with Id "+id+" Deleted Successfully!";
	}
		
	@PostMapping("/encode-passwords")
	public String encodePassword()
	{
		userServiceImpl.encodeExistingPasswords();
		return "All Registered User Password Encoded Successfully";
	}
}
