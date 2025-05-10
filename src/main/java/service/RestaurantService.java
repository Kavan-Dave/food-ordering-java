package service;

import java.util.List;
import java.util.Optional;

import entities.*;

public interface RestaurantService {
	   public Optional<Restaurant> findById(int id);
	   public List<Restaurant> findAll();
	   public Restaurant updateRestaurant(Restaurant u,int id);
	   public Restaurant createRestaurant(Restaurant u);
	   public String deleteRestaurant(int id);
	   public Restaurant assignManager(int rid,int mid);
	   public List<FoodItem> addMenu(int rid);
}
