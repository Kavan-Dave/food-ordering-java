package serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import entities.Role;
import entities.Users;
import repository.*;
import service.*;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@Override
	public Optional<Users> findById(int id)
	{
		return userRepository.findById(id);
	}
	
	@Override
	public List<Users> findAll()
	{
		return userRepository.findAll();
	}
	
	@Override
	public Users updateUser(Users u,int id)
	{
		Users s = userRepository.findById(id).orElse(null);
		if(s!=null)
		{
			s.setName(u.getName());
		}
		userRepository.save(s);
		return s;
	}
	
	@Override
	public Users createUser(Users u)
	{
		u.setId(0);
		u.setRole(Role.ADMIN);
		u.setId(0);
    	String plain=u.getPassword();
    	String encodedPassword=passwordEncoder.encode(plain);
    	u.setPassword(encodedPassword);
		return userRepository.save(u);
	}
	
	@Override
	public String deleteUser(int id)
	{
		Users s = userRepository.findById(id).orElse(null);
		userRepository.delete(s);
		return "Deletion of the "+id+" performed Successfully";
	}
	
	@Override 	
    public void encodeExistingPasswords() {
        List<Users> users = userRepository.findAll();
        for (Users user : users) {
            if (!user.getPassword().startsWith("$2a$")) {
                String encodedPassword = passwordEncoder.encode(user.getPassword());
                user.setPassword(encodedPassword);
                userRepository.save(user);
            }
        }
    }

}
