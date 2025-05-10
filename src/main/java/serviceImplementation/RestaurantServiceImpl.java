package serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.FoodItem;
import entities.Managers;
import entities.Restaurant;
import repository.*;
import service.*;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	private final RestaurantRepository RestaurantRepository;
	private final ManagerRepository managerRepository;
	private final FoodItemRepository foodItemRepository;

	@Autowired
	public RestaurantServiceImpl(RestaurantRepository RestaurantRepository,ManagerRepository managerRepository,FoodItemRepository foodItemRepository) {
		super();
		this.RestaurantRepository = RestaurantRepository;
		this.managerRepository=managerRepository;
		this.foodItemRepository=foodItemRepository;
	}
	
	@Override
	public Optional<Restaurant> findById(int id)
	{
		return RestaurantRepository.findById(id);
	}
	
	@Override
	public List<Restaurant> findAll()
	{
		return RestaurantRepository.findAll();
	}
	
	@Override
	public Restaurant updateRestaurant(Restaurant u,int id)
	{
		Restaurant s = RestaurantRepository.findById(id).orElse(null);
		if(s!=null)
		{
			s.setName(u.getName());
			s.setLocation(u.getLocation());
		}
		RestaurantRepository.save(s);
		return s;
	}
	
	@Override
	public Restaurant createRestaurant(Restaurant u)
	{
		u.setId(0);
		return RestaurantRepository.save(u);
	}
	
	@Override
	public String deleteRestaurant(int id)
	{
		Restaurant s = RestaurantRepository.findById(id).orElse(null);
		RestaurantRepository.delete(s);
		return "Deletion of the "+id+" performed Successfully";
	}
	
	@Override
	public Restaurant assignManager(int rid,int mid)
	{
		Restaurant r =RestaurantRepository.findById(rid).orElse(null);
		Managers m = managerRepository.findById(mid).orElse(null);
		r.setManager(m);
		m.setRestaurent(r);
		RestaurantRepository.save(r);
		managerRepository.save(m);
		return r;
	}
	
	@Override 
	public List<FoodItem> addMenu(int rid)
	{
		Restaurant r = RestaurantRepository.findById(rid).orElse(null);
		return foodItemRepository.findByRestaurant(r); 
		
	}

}
