package service;

import java.util.List;
import java.util.Optional;

import entities.*;

public interface OrderService {
	   public Optional<Order> findById(int id);
	   public List<Order> findAll();
	   public Order updateOrder(Order u,int id);
	   public Order createOrder(Order u);
	   public String deleteOrder(int id);
}
