package com.capgemini.customerapp.tests;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.customerapp.controller.CustomerController;
import com.capgemini.customerapp.entity.Customer;
import com.capgemini.customerapp.service.CustomerService;
import com.capgemini.customerapp.service.impl.CustomerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CustomerControllerTest {
	@InjectMocks
	private CustomerController customerController;

	@Mock
	private CustomerService customerService;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}

	/*@Test
	public void testaddCustomer() throws Exception {
		when(customerService.addCustomer(Mockito.isA(Customer.class))).thenReturn(new Customer(566,"abc","hyd","xyz@gmail.com","123"));
		String content = "{\r\n" + 
				"    \"customerId\": 566,\r\n" + 
				"    \"customerName\": \"abc\",\r\n" + 
				"    \"customerAddress\": \"hyd\",\r\n" + 
				"    \"customerEmail\": \"xyz@gmail.com\",\r\n" + 
				"    \"customerPassword\": \"123\"\r\n" + 
				"}";
		mockMvc.perform(post("/customer").contentType(MediaType.APPLICATION_JSON).content(content)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.customerId").exists())
				.andExpect(jsonPath("$.customerName").exists())
				.andExpect(jsonPath("$.customerAddress").exists())
				.andExpect(jsonPath("$.customerEmail").exists())
				.andExpect(jsonPath("$.customerPassword").exists())
				.andExpect(jsonPath("$.customerId").value(566))
				.andExpect(jsonPath("$.customerName").value("abc"))
				.andExpect(jsonPath("$.customerAddress").value("hyd"))
				.andExpect(jsonPath("$.customerEmail").value("xyz@gmail.com"))
				.andExpect(jsonPath("$.customerPassword").value("123"))
				.andDo(print());
		
	}*/
/*	@Test
	public void testAuthenticate() throws Exception {
		Customer customer=new Customer(566, "abc", "mum","xyz@gmail.com","789");
		when(customerService.authenticate(Mockito.isA(Integer.class), (Mockito.isA(String.class)))).thenReturn(customer);
		String content="{\r\n" + 
				"  \r\n" + 
				"  \"customerId\": \"566\",\r\n" + 
				"  \"customerPassword\":\"789\"\r\n" + 
				"}";
		mockMvc.perform(post("/customer/auth").contentType(MediaType.APPLICATION_JSON).content(content)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.customerId").exists())
				.andExpect(jsonPath("$.customerName").exists())
				.andExpect(jsonPath("$.customerAddress").exists())
				.andExpect(jsonPath("$.customerEmail").exists())
				.andExpect(jsonPath("$.customerPassword").exists())
				.andExpect(jsonPath("$.customerId").value(566))
				.andExpect(jsonPath("$.customerName").value("abc"))
				.andExpect(jsonPath("$.customerAddress").value("mum"))
				.andExpect(jsonPath("$.customerEmail").value("xyz@gmail.com"))
				.andExpect(jsonPath("$.customerPassword").value("789"))
				.andDo(print());
		
	}*/
	
	/*@Test
	public void testFindCustomerById()throws Exception {
		when(customerService.findCustomerById(566)).thenReturn(new Customer(566, "abc", "hyd","xyz@gmail.com","123"));
		mockMvc.perform(get("/customer/566").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.customerId").exists())
				.andExpect(jsonPath("$.customerName").exists())
				.andExpect(jsonPath("$.customerAddress").exists())
				.andExpect(jsonPath("$.customerEmail").exists())
				.andExpect(jsonPath("$.customerPassword").exists())
				.andExpect(jsonPath("$.customerId").value(566))
				.andExpect(jsonPath("$.customerName").value("abc"))
				.andExpect(jsonPath("$.customerAddress").value("hyd"))
				.andExpect(jsonPath("$.customerEmail").value("xyz@gmail.com"))
				.andExpect(jsonPath("$.customerPassword").value("123"))
				.andDo(print());
		
}*/
	/*@Test
	public void testUpdateProduct() throws Exception{
		when(customerService.updateProfile(Mockito.isA(Customer.class))).thenReturn(new Customer(566, "abc", "mum","xyz@gmail.com","789"));
//		when(customerService.findCustomerById(566)).thenReturn(new Customer(566, "abc", "hyd","xyz@gmail.com","123"));

		String content = "{\r\n" + 
				"  \"customerName\": \"abc\",\r\n" + 
				"  \"customerId\": \"566\",\r\n" + 
				"  \"customerEmail\": \"xyz@gmail.com\",\r\n" + 
				"  \"customerAddress\": \"mum\",\r\n" + 
				"  \"customerPassword\":\"789\"\r\n" + 
				"}";
			
				
				
				mockMvc.perform(put("/customer").contentType(MediaType.APPLICATION_JSON).content(content)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.customerId").exists())
				.andExpect(jsonPath("$.customerName").exists())
				.andExpect(jsonPath("$.customerAddress").exists())
				.andExpect(jsonPath("$.customerEmail").exists())
				.andExpect(jsonPath("$.customerPassword").exists())
				.andExpect(jsonPath("$.customerId").value(566))
				.andExpect(jsonPath("$.customerName").value("abc"))
				.andExpect(jsonPath("$.customerAddress").value("mum"))
				.andExpect(jsonPath("$.customerEmail").value("xyz@gmail.com"))
				.andExpect(jsonPath("$.customerPassword").value("789"))
				.andDo(print());

}
	*/
/*	@Test
	public void testDelete() throws Exception {
		Customer customer=new Customer(566, "abc", "mum","xyz@gmail.com","789");
		when(customerService.findCustomerById(566)).thenReturn(customer);
		mockMvc.perform(delete("/customer/566").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print());
	}
*/
	
	
	
	
	
	
	
	
	
}

