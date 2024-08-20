package com.javatalent.service;

import com.javatalent.model.Customer;

public interface CustomerService {
	// Method to get customer by id
	Customer getCustomer(Long id);
	
	// Add new Customer into the DB
	String addCustomer(Customer customer);
	
	// Method to update details of a Customer
	String updateCustomer(Customer customer);
}
