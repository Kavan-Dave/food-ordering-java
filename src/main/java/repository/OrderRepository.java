package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.*;

public interface OrderRepository extends JpaRepository<Order,Integer>{

}
