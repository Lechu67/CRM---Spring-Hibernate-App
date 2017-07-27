package com.finalproject.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.Transient;



@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="importance")
	private String importance;
	
	/*one way to implement the Dropdown list(not fancy):
	 * in the entity class create a field with a Map, then mark it Transcient(ignored by hibernate)
	 * create the setter method
	 * populate the map in both contructors
	 * update the html form
	
	@Transient //ALL FIELDS IN HIBERNATE ENTITY CLASS ARE TAKEN BY DEFAULT AS COLUMNS, "TRANSCIENT" IGNORE THIS FIELD
	private LinkedHashMap<String,String> importanceOptions;
	*/
	
	public Customer () {
		
		
	}
	public Customer (int theId, String theFirstName, String theLastName, String theEmail, String importance){
		
		super();
		this.id = theId;
		this.firstName= theFirstName;
		this.lastName=theLastName;
		this.email=theEmail;
		this.importance=importance;
		
	}
	
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", importance=" + importance + "]";
	}
	
	
	public int getId(){
		return id;
	}
	public void setId(int theId){
		this.id = theId;
	}
	public String getImportance() {
		return importance;
	}
	public void setImportance(String importance) {
		this.importance = importance;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
