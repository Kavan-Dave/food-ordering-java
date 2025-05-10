package com.project.online_food_ordering;


//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import entities.Role;
import entities.Users;
import repository.*;


@SpringBootApplication
@EntityScan(basePackages="entities")
@EnableJpaRepositories("repository")
@ComponentScan(basePackages={"service","serviceImplementation","controller","security"})
public class OnlineFoodOrderingApplication {

//	private static SessionFactory sessionfactory;
	public static void main(String[] args) {
		SpringApplication.run(OnlineFoodOrderingApplication.class, args);
//		sessionfactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//		System.out.println("Done!");
	}
//	public static SessionFactory getSessionFactory()
//	{
//		return sessionfactory;
//	}
//	@Bean
//	CommandLineRunner testRepo(UserRepository userRepository,CustomerRepository customerRepository)
//	{
//		return args ->{
//			try 
//			{
//				Users u = new Users("kavan",Role.CUSTOMER,"1234","kd@example.com");
//				userRepository.save(u);
//			}
//			catch(Exception e)
//			{
//				System.out.println("problem");
//				e.printStackTrace();
//			}
//		};
//	}
}