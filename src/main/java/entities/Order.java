package entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="orders")
@PrimaryKeyJoinColumn(name="id")
public class Order extends Item {
    
   @ManyToOne(cascade=CascadeType.ALL)
   @JsonIgnoreProperties({"orders","name","location","menu","manager"})
   private Restaurant restaurant;
   
   @ManyToOne(cascade=CascadeType.ALL)
   @JoinColumn(name="customer_id")
   @JsonIgnoreProperties({"order","name","role","email"})
   private Customers customer;
   
   @Column(nullable=false)
   private int quantity;
   
   @Column(name="date")
   private LocalDateTime date = LocalDateTime.now();
   
   @ManyToOne
   @JoinColumn(name="food_id",nullable=false)
   @JsonIgnoreProperties({"name","price","restaurant"})
   private FoodItem foodItem;

public Order() {
	super();
	// TODO Auto-generated constructor stub
}

public Order(int id, String name, double price) {
	super(id, name, price);
	// TODO Auto-generated constructor stub
}

public Order(Restaurant restaurant, Customers customer, int quantity, LocalDateTime date, FoodItem foodItem) {
	super();
	this.restaurant = restaurant;
	this.customer = customer;
	this.quantity = quantity;
	this.date = LocalDateTime.now();
	this.foodItem = foodItem;
}

public Restaurant getRestaurant() {
	return restaurant;
}

public void setRestaurant(Restaurant restaurant) {
	this.restaurant = restaurant;
}

public Customers getCustomer() {
	return customer;
}

public void setCustomer(Customers customer) {
	this.customer = customer;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public LocalDateTime getDate() {
	return date;
}

public void setDate(LocalDateTime date) {
	this.date = date;
}

public FoodItem getFoodItem() {
	return foodItem;
}

public void setFoodItem(FoodItem foodItem) {
	this.foodItem = foodItem;
}

@Override
public String toString() {
	return "Order [restaurant=" + restaurant + ", customer=" + customer + ", quantity=" + quantity + ", date=" + date
			+ ", foodItem=" + foodItem + "]";
}
   
   
}
