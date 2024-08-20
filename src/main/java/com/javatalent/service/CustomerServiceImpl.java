package com.javatalent.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatalent.exception.CustomerAlreadyExistsException;
import com.javatalent.exception.NoSuchCustomerExistsException;
import com.javatalent.model.Customer;
import com.javatalent.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer getCustomer(Long id) {
		return customerRepository.findById(id).orElseThrow(()
				-> new NoSuchElementException("NO CUSTOMER PRESENT WITH ID= " + id));
	}

	@Override
	public String addCustomer(Customer customer) {
		Customer existingCustomer = customerRepository.findById(customer.getId())
				.orElse(null);
		if (existingCustomer == null) {
			customerRepository.save(customer);
			return "Customer added Successfully!";
		}
		else 
			throw new CustomerAlreadyExistsException("Customer already Exists!!");
	}

	@Override
	public String updateCustomer(Customer customer) {
		Customer existingCustomer = customerRepository.findById(customer.getId())
				.orElse(null);
		if (existingCustomer == null) {
			throw new NoSuchCustomerExistsException("No Such Customer Exists!!");
		}else {
			existingCustomer.setName(customer.getName());
			existingCustomer.setAddress(customer.getAddress());
			customerRepository.save(existingCustomer);
			return "Record Updated Successfully!";
		}
	}

}
