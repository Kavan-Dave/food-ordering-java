package service;

import java.util.List;
import java.util.Optional;

import entities.*;

public interface ManagerService {
	   public Optional<Managers> findById(int id);
	   public List<Managers> findAll();
	   public Managers updateManager(Managers u,int id);
	   public Managers createManager(Managers u);
	   public String deleteManager(int id);
}
