package com.finalproject.springdemo.entity;


import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



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
	
	@Transient
	private LinkedHashMap<String,String> importanceOptions;
	
	
	public Customer () {
		importanceOptions = new LinkedHashMap<>();
		importanceOptions.put("High","High");
		importanceOptions.put("Low","Low");
		
	}
	public Customer (int theId, String theFirstName, String theLastName, String theEmail, String importance){
		
		super();
		this.id = theId;
		this.firstName= theFirstName;
		this.lastName=theLastName;
		this.email=theEmail;
		this.importance=importance;
		importanceOptions = new LinkedHashMap<>();
		importanceOptions.put("High","High");
		importanceOptions.put("Low","Low");
	}
	
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", importance=" + importance + "]";
	}
	
	public LinkedHashMap<String, String> getImportanceOptions() {
		return importanceOptions;
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
