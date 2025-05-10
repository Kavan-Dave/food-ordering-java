package service;

import java.util.List;
import java.util.Optional;

import entities.*;

public interface ItemService {
	   public Optional<Item> findById(int id);
	   public List<Item> findAll();
	   public Item updateItem(Item u,int id);
	   public Item createItem(Item u);
	   public String deleteItem(int id);
}
