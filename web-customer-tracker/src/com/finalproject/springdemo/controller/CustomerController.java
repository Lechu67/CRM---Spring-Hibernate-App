package com.finalproject.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finalproject.springdemo.entity.Customer;
import com.finalproject.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject customerservice
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers (Model model){
		
		//get customer from the service
		List<Customer> customers = customerService.getCustomers();
		//add the customers to the model
		model.addAttribute("customers",customers);
		
		return "list-customers";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model){
		
		//create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		model.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
		
		//save the customer using our service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model model){
		
		//get the customer from sservice
		Customer theCustomer = customerService.getCustomer(theId);
		//set the customer as a model attribute to pre=populate the form
		model.addAttribute("customer", theCustomer);
		//send over to the form
		return "customer-form";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId){
		
		//delete the customer from service
		customerService.deleteCustomer(theId);
		//return form list
		return "redirect:/customer/list";
	}

}