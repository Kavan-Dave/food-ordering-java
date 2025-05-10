package entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Customers extends Users {

	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
	@JsonIgnoreProperties({"customer"})
	private List<Order> order ;

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customers(String name, Role role, String password, String email) {
		super(name, role, password, email);
		// TODO Auto-generated constructor stub
	}

	public Customers(String name, Role role, String password, String email, List<Order> order) {
		super(name, role, password, email);
		this.order = order;
	}

	@Override
	public String toString() {
		return "Customer [order=" + order + "]";
	}
	
	
}
