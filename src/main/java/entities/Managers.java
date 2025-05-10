package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Managers extends Users
{
	
	@OneToOne( cascade = CascadeType.ALL)
	@JsonIgnoreProperties("manager")
	private Restaurant restaurent ;

	public Managers(Restaurant restaurent) {
		super();
		this.restaurent = restaurent;
	}

	public Managers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurant getRestaurent() {
		return restaurent;
	}

	public void setRestaurent(Restaurant restaurent) {
		this.restaurent = restaurent;
	}

	@Override
	public String toString() {
		return "Managers [restaurent=" + restaurent + "]";
	}

	
}
