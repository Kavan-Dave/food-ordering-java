package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.*;

public interface CustomerRepository extends JpaRepository<Customers,Integer>{

}
