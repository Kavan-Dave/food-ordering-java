package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.*;

public interface ItemRepository extends JpaRepository<Item,Integer>{

}
