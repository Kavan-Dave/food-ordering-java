package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Users;

public interface UserRepository extends JpaRepository<Users,Integer>
{
	
}