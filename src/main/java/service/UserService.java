package service;

import java.util.List;
import java.util.Optional;

import entities.*;

public interface UserService {
	   public Optional<Users> findById(int id);
	   public List<Users> findAll();
	   public Users updateUser(Users u,int id);
	   public Users createUser(Users u);
	   public String deleteUser(int id);
	   void encodeExistingPasswords();
}
