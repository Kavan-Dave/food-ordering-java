package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class FoodItem extends Item {
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"menu"})
    private Restaurant restaurant;

	public FoodItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FoodItem(int id, String name, double price) {
		super(id, name, price);
		// TODO Auto-generated constructor stub
	}

	public FoodItem(Restaurant restaurant) {
		super();
		this.restaurant = restaurant;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "FoodItem [ restaurantId="+ (restaurant != null ? restaurant.getId() : "null")+ "]";
	}
    
    
}
