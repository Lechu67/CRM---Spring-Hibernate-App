package com.finalproject.springdemo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finalproject.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	
	//need to inject the session factory
	@Autowired
	private  SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		//create query to get the customers
		List<Customer> results = session.createQuery("from Customer order by lastName", Customer.class).getResultList();
		
		//return the results
		return results;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		
		//get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		//save the customer
		session.saveOrUpdate(theCustomer);;
	}


	@Override
	public Customer getCustomer(int theId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Customer theCustomer = session.get(Customer.class, theId);
		return theCustomer;
	}


	@Override
	public void deleteCustomer(int theId) {
		
		Session session = sessionFactory.getCurrentSession();
	
		session.delete(session.get(Customer.class, theId));
		
	}
	/*
	 * Another approach of Chad, using only one DB operation.
	 * 
	@Override
	public void deleteCustomer2(int theId) {
		
		Session session = sessionFactory.getCurrentSession();
	
		Query theQuery = session.createQuery("delete from Customer where id=customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
		
	}
	*/
}
