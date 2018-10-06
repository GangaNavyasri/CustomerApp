package com.capgemini.customerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.customerapp.entity.Customer;
import com.capgemini.customerapp.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(customerService.addCustomer(customer),
				HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping("/customer/auth")
	public ResponseEntity<Customer> authentication(@RequestBody Customer customer){
		ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(
				customerService.authenticate(customer.getCustomerId(), customer.getCustomerPassword()), HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId)  {
		Customer c = customerService.findCustomerById(customerId);
		return new ResponseEntity<Customer>(c, HttpStatus.OK);

	}

	@PutMapping("/customer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.updateProfile(customer), HttpStatus.OK);
	}

	@DeleteMapping("/customer/{customerId}")
	public ResponseEntity<Customer> deleteProduct(@PathVariable int customerId) {

		Customer c = customerService.findCustomerById(customerId);

		customerService.deleteCustomer(customerId);
		return new ResponseEntity<Customer>(HttpStatus.OK);

	}
}
