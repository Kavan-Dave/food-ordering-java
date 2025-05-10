package service;

import java.util.List;
import java.util.Optional;

import entities.*;

public interface CustomerService {
	   public Optional<Customers> findById(int id);
	   public List<Customers> findAll();
	   public Customers updateCustomer(Customers u,int id);
	   public Customers createCustomer(Customers u);
	   public String deleteCustomer(int id);
	   
	   public List<Order> findOrderById(int id);
	   public Customers placeOrder(int cid,int fid,Order u);
}
