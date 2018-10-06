package com.capgemini.customerapp.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.customerapp.Exceptions.AuthenticationFailedException;
import com.capgemini.customerapp.Exceptions.CustomerAlreadyRegisteredException;
import com.capgemini.customerapp.Exceptions.CustomerNotFoundException;
import com.capgemini.customerapp.entity.Customer;
import com.capgemini.customerapp.repository.CustomerRepository;
import com.capgemini.customerapp.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerAlreadyRegisteredException {
		Optional<Customer> optionalCustomer = customerRepository.findById(customer.getCustomerId());
		if (!optionalCustomer.isPresent()) {
		return customerRepository.save(customer);
	}
		throw new CustomerAlreadyRegisteredException("Customer Already present  with Id" +customer.getCustomerId());
	}
	@Override
	public Customer authenticate(int customerId, String customerPassword) throws CustomerNotFoundException {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if (optionalCustomer.isPresent()) {

			if (optionalCustomer.get().getCustomerPassword().equals(customerPassword)) {
				return optionalCustomer.get();
			}
			throw new AuthenticationFailedException("Username password not match");
		}
		throw new CustomerNotFoundException("Customer does not found Please Register!!!");
	}

	@Override
	public Customer updateProfile(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer findCustomerById(int customerId) throws CustomerNotFoundException {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if (optionalCustomer.isPresent())
			return optionalCustomer.get();
		throw new CustomerNotFoundException("Customer does not exists");
	}

	@Override
	public void deleteCustomer(int customerId) {
		customerRepository.deleteById(customerId);
	}

}
