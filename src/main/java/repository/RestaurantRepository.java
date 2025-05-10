package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.*;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {

}
