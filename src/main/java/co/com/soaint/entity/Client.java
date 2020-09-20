package co.com.soaint.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "CLIENT_TABLE")
public class Client {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String lastName;
	private String dni;
	private String telephone;
	private String email;
	
	public Client() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Client(String name, String lastName, String dni, String telephone, String email) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.dni = dni;
		this.telephone = telephone;
		this.email = email;
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		
	
	
}
