package com.finalproject.springdemo.dao;

import java.util.List;
import java.util.Map;

import com.finalproject.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public Map<String, String> getImportantOptions();
}
