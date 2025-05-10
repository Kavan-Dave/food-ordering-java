package serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Order;
import repository.*;
import service.*;

@Service
public class OrderServiceImpl implements OrderService {
	
	private final OrderRepository OrderRepository;

	@Autowired
	public OrderServiceImpl(OrderRepository OrderRepository) {
		super();
		this.OrderRepository = OrderRepository;
	}
	
	@Override
	public Optional<Order> findById(int id)
	{
		return OrderRepository.findById(id);
	}
	
	@Override
	public List<Order> findAll()
	{
		return OrderRepository.findAll();
	}
	
	@Override
	public Order updateOrder(Order u,int id)
	{
		Order s = OrderRepository.findById(id).orElse(null);
		if(s!=null)
		{
			s.setQuantity(u.getQuantity());
		}
		OrderRepository.save(s);
		return s;
	}
	
	@Override
	public Order createOrder(Order u)
	{
		u.setId(0);
		if(u.getRestaurant().getMenu().contains(u.getFoodItem()))		
			return OrderRepository.save(u);
		else
			throw new RuntimeException("Food Item Not Found");
	}
	
	@Override
	public String deleteOrder(int id)
	{
		Order order = OrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

				// Check if the foodItem is associated properly
				if (order.getFoodItem() == null) {
				throw new RuntimeException("Order does not have a valid food item.");
				}
				
				OrderRepository.delete(order);  // Perform deletion
		return "Deletion of the "+id+" performed Successfully";
	}

}
