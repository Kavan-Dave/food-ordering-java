package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.*;

public interface FoodItemRepository extends JpaRepository<FoodItem,Integer>{

	public List<FoodItem> findByRestaurant(Restaurant r);
}
