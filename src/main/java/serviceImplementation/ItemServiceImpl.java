package serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Item;
import repository.*;
import service.*;

@Service
public class ItemServiceImpl implements ItemService {
	
	private final ItemRepository userRepository;

	@Autowired
	public ItemServiceImpl(ItemRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@Override
	public Optional<Item> findById(int id)
	{
		return userRepository.findById(id);
	}
	
	@Override
	public List<Item> findAll()
	{
		return userRepository.findAll();
	}
	
	@Override
	public Item updateItem(Item u,int id)
	{
		Item s = userRepository.findById(id).orElse(null);
		if(s!=null)
		{
			s.setName(u.getName());
		}
		userRepository.save(s);
		return s;
	}
	
	@Override
	public Item createItem(Item u)
	{
		u.setId(0);
		return userRepository.save(u);
	}
	
	@Override
	public String deleteItem(int id)
	{
		Item s = userRepository.findById(id).orElse(null);
		userRepository.delete(s);
		return "Deletion of the "+id+" performed Successfully";
	}

}
