package entities;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Restaurant {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable=true)
    private String name;
    
    @Column(nullable=true)
    private String location;
    
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"restaurant"})
    private List<FoodItem> menu;  // A restaurant can have multiple food items
    
    @OneToOne( cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"restaurent","password"})
    private Managers manager;
    
    @OneToMany(mappedBy="restaurant", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("restaurant")
    private List<Order> orders;

    public Restaurant() {
        super();
    }

	public Restaurant(int id, String name, String location, List<FoodItem> menu, Managers manager, List<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.menu = menu;
		this.manager = manager;
		this.orders = orders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<FoodItem> getMenu() {
		return menu;
	}

	public void setMenu(List<FoodItem> menu) {
		this.menu = menu;
	}

	public Managers getManager() {
		return manager;
	}

	public void setManager(Managers manager) {
		this.manager = manager;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", location=" + location + ", foodItemsCount=" + (menu.isEmpty() ? 0: menu.size())+ ", manager="
				+ manager + ", orders=" + orders + "]";
	}

   
}
