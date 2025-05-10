package entities;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Users {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String name;
	@Enumerated(EnumType.STRING)
	private Role role;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false,unique=true)
	private String email;
	public Users(String name,Role role, String password, String email)
	{
		super();
		this.name = name;
		this.role = role;
		this.password = password;
		this.email = email;
	}
	public Users(String name, String password, String email)
	{
		super();
		this.name = name;
		this.role = Role.ADMIN;
		this.password = password;
		this.email = email;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", role=" + role + ", password=" + password + ", email=" + email
				+ "]";
	}
	
	
	
}
