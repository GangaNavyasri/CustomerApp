package com.capgemini.customerapp.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.customerapp.entity.Customer;
import com.capgemini.customerapp.repository.CustomerRepository;
import com.capgemini.customerapp.service.impl.CustomerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CustomerServiceTest {

	
	@Mock
	private CustomerRepository customerRepository;

	@InjectMocks
	private CustomerServiceImpl customerServiceImpl;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(customerRepository).build();
	}

	/*@Test
	public void testAddCustomer() {
		Customer customer = new Customer(123, "abc", "hyd", "xyz@gmail.com", "987");
		when(customerRepository.save(customer)).thenReturn(customer);
		assertEquals(customerServiceImpl.addCustomer(customer), customer);
		System.out.println(customer);
	}*/
	/*@Test
	public void testAuthenticate() {
		Customer customer=new Customer(123, "abc", "hyd", "xyz@gmail.com", "987");
		Optional<Customer> cust=Optional.of(customer);
		when(customerRepository.findById(123)).thenReturn(cust);
		assertEquals(customerServiceImpl.authenticate(123, "987"), customer);
		System.out.println(customer);

	}*/
/*	@Test
	public void testUpdateProfile() {
		Customer customer=new Customer(123, "abc", "hyd", "xyz@gmail.com", "987");
		Customer customer1=new Customer(123, "xyz", "hyd", "abc@gmail.com", "456");
		when(customerRepository.save(customer)).thenReturn(customer1);
		assertEquals(customerServiceImpl.updateProfile(customer),customer1);

	}
*/
	@Test
	public void testCustomerById() {
		Customer customer=new Customer(123, "abc", "hyd", "xyz@gmail.com", "987");
		Optional<Customer> cust=Optional.of(customer);
		when(customerRepository.findById(123)).thenReturn(cust);
		assertEquals(customerServiceImpl.findCustomerById(123), customer);
		System.out.println(customer);
		
	}
	@Test
	public void testDeleteCustomer() {
		customerServiceImpl.deleteCustomer(12345);
		verify(customerRepository, times(1)).deleteById(123);
	}
}
