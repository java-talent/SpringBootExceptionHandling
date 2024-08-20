package com.javatalent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javatalent.exception.CustomerAlreadyExistsException;
import com.javatalent.exception.ErrorResponse;
import com.javatalent.model.Customer;
import com.javatalent.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	// Get Customer by id
	@GetMapping("/getCustomer/{id}")
	public Customer getCustomer(@PathVariable("id") Long id) {
		return customerService.getCustomer(id);
	}
	
	// Add new Customer
	@PostMapping("/addCustomer")
	public String addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	// Update Customer
	@PutMapping("/updateCustomer")
	public String updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}
	
	@ExceptionHandler(value = CustomerAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public @ResponseBody ErrorResponse handleCustomerAlreadyExistsException(CustomerAlreadyExistsException ex) {
		return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
	}
	
	
	
}
