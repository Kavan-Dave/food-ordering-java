package serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.FoodItem;
import entities.Restaurant;
import repository.*;
import service.*;

@Service
public class FoodItemServiceImpl implements FoodItemService {
	
	private final FoodItemRepository FoodItemRepository;
	private final RestaurantRepository RestaurantRepository;
	@Autowired
	public FoodItemServiceImpl(FoodItemRepository FoodItemRepository,RestaurantRepository RestaurantRepository) {
		super();
		this.FoodItemRepository = FoodItemRepository;
		this.RestaurantRepository=RestaurantRepository;
	}
	
	@Override
	public Optional<FoodItem> findById(int id)
	{
		return FoodItemRepository.findById(id);
	}
	
	@Override
	public List<FoodItem> findAll()
	{
		return FoodItemRepository.findAll();
	}
	
	@Override
	public FoodItem updateFoodItem(FoodItem u,int id)
	{
		FoodItem s = FoodItemRepository.findById(id).orElse(null);
		if(s!=null)
		{
			s.setName(u.getName());
		}
		FoodItemRepository.save(s);
		return s;
	}
	
	@Override
	public FoodItem createFoodItem(FoodItem u)
	{
		Restaurant r=RestaurantRepository.findById(u.getRestaurant().getId()).orElse(null);
		u.setRestaurant(r);
		r.getMenu().add(u);
		FoodItemRepository.save(u);
		RestaurantRepository.save(r);
		return u;
	}
	
	@Override
	public String deleteFoodItem(int id)
	{
		FoodItem s = FoodItemRepository.findById(id).orElse(null);
		FoodItemRepository.delete(s);
		return "Deletion of the "+id+" performed Successfully";
	}

}
