package serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import entities.Managers;
import entities.Role;
import repository.*;
import service.*;

@Service
public class ManagerServiceImpl implements ManagerService {
	
	private final ManagerRepository ManagerRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;


	@Autowired
	public ManagerServiceImpl(ManagerRepository ManagerRepository) {
		super();
		this.ManagerRepository = ManagerRepository;
	}
	
	@Override
	public Optional<Managers> findById(int id)
	{
		return ManagerRepository.findById(id);
	}
	
	@Override
	public List<Managers> findAll()
	{
		return ManagerRepository.findAll();
	}
	
	@Override
	public Managers updateManager(Managers u,int id)
	{
		Managers s = ManagerRepository.findById(id).orElse(null);
		if(s!=null)
		{
			s.setName(u.getName());
		}
		ManagerRepository.save(s);
		return s;
	}
	
	@Override
	public Managers createManager(Managers u)
	{
		u.setId(0);
		u.setRole(Role.MANGER);
		u.setId(0);
    	String plain=u.getPassword();
    	String encodedPassword=passwordEncoder.encode(plain);
    	u.setPassword(encodedPassword);
		return ManagerRepository.save(u);
	}
	
	@Override
	public String deleteManager(int id)
	{
		Managers s = ManagerRepository.findById(id).orElse(null);
		ManagerRepository.delete(s);
		return "Deletion of the "+id+" performed Successfully";
	}

}
