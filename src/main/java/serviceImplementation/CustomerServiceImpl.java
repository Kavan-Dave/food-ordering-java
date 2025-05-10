package serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import entities.Customers;
import entities.FoodItem;
import entities.Order;
import entities.Restaurant;
import entities.Role;
import repository.*;
import service.*;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private final CustomerRepository CustomerRepository;
	private final OrderRepository orderRepository;
	private final RestaurantRepository RestaurantRepository;
	private final FoodItemRepository FoodItemRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public CustomerServiceImpl(CustomerRepository CustomerRepository,OrderRepository orderRepository,RestaurantRepository RestaurantRepository,FoodItemRepository FoodItemRepository) {
		super();
		this.CustomerRepository = CustomerRepository;
		this.orderRepository=orderRepository;
		this.RestaurantRepository=RestaurantRepository;
		this.FoodItemRepository=FoodItemRepository;
	}
	
	@Override
	public Optional<Customers> findById(int id)
	{
		return CustomerRepository.findById(id);
	}
	
	@Override
	public List<Customers> findAll()
	{
		return CustomerRepository.findAll();
	}
	
	@Override
	public Customers updateCustomer(Customers u,int id)
	{
		Customers s = CustomerRepository.findById(id).orElse(null);
		if(s!=null)
		{
			s.setName(u.getName());
			s.setEmail(u.getEmail());		
		}
		CustomerRepository.save(s);
		return s;
	}
	
	@Override
	public Customers createCustomer(Customers u)
	{
		u.setId(0);
		u.setRole(Role.CUSTOMER);
		u.setId(0);
    	String plain=u.getPassword();
    	String encodedPassword=passwordEncoder.encode(plain);
    	u.setPassword(encodedPassword);
		return CustomerRepository.save(u);
	}
	
	@Override
	public String deleteCustomer(int id)
	{
		Customers s = CustomerRepository.findById(id).orElse(null);
		CustomerRepository.delete(s);
		return "Deletion of the "+id+" performed Successfully";
	}
	
	@Override
	public List<Order> findOrderById(int id)
	{
		Customers c= CustomerRepository.findById(id).orElse(null);
		return c.getOrder();
	}
	
	@Override
	public Customers placeOrder(int cid,int fid,Order u)
	{
		Customers c=CustomerRepository.findById(cid).orElse(null);
		u.setId(0);
		FoodItem f=FoodItemRepository.findById(fid).orElse(null);
		Restaurant r=RestaurantRepository.findById(f.getRestaurant().getId()).orElseThrow(()-> new RuntimeException("Restaurant not found"));
		System.out.println(f);
		if(f.getRestaurant().getMenu().contains(f))		
		{
			u.setName(f.getName());
			u.setFoodItem(f);
			u.setCustomer(c);
			u.setRestaurant(r);
			u.setPrice(f.getPrice()*u.getQuantity());
			c.getOrder().add(u);
			r.getOrders().add(u);
			orderRepository.save(u);
			CustomerRepository.save(c);
			RestaurantRepository.save(r);
			return c;
		}
		else
			throw new RuntimeException("Food Item Not Found"); 
	}

}
