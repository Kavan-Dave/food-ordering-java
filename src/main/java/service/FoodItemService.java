package service;

import java.util.List;
import java.util.Optional;

import entities.*;

public interface FoodItemService {
	   public Optional<FoodItem> findById(int id);
	   public List<FoodItem> findAll();
	   public FoodItem updateFoodItem(FoodItem u,int id);
	   public FoodItem createFoodItem(FoodItem u);
	   public String deleteFoodItem(int id);
}
