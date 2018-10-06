package com.capgemini.customerapp.service;

import com.capgemini.customerapp.Exceptions.AuthenticationFailedException;
import com.capgemini.customerapp.Exceptions.CustomerAlreadyRegisteredException;
import com.capgemini.customerapp.Exceptions.CustomerNotFoundException;
import com.capgemini.customerapp.entity.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer customer) throws CustomerAlreadyRegisteredException ;

	public Customer authenticate(int customerId, String customerPassword) throws CustomerNotFoundException,AuthenticationFailedException;

	public Customer updateProfile(Customer customer);

	public Customer findCustomerById(int customerId) throws CustomerNotFoundException;

	public void deleteCustomer(int customerId);

}
