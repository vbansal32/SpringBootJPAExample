package com.tcs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tcs.exception.CustomerServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcs.bean.CustomerResponse;
import com.tcs.bean.Customer;
import com.tcs.service.CustomerService;
import com.tcs.utility.CustomerConstants;


@RestController
@RequestMapping("/customer")
public class CustomerController implements CustomerConstants{
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerResponse customerResponse;
	

	@GetMapping(value="/getAllCustomers", produces = "application/json")
	public CustomerResponse getAllCustomers(String cartId) {
		try {
			customerResponse.setCustomers(customerService.findAllCustomers());
			customerResponse.setStatus(SUCCESS_STATUS);
		}
		catch (CustomerServiceException use) {
			customerResponse.setStatus(ERROR_STATUS);
			customerResponse.setMessage(GENERAL_ERROR_MESSAGE);
		}
		return customerResponse;
	}
	
	@GetMapping(value="/getCustomer/{customerId}", produces = "application/json")
	public CustomerResponse getCustomer(@PathVariable int customerId) {
		List<Customer> customers = new ArrayList<>();
		try {
			customers.add(customerService.findCustomerById(customerId));
			customerResponse.setCustomers(customers);
			customerResponse.setStatus(SUCCESS_STATUS);
		}
		catch (CustomerServiceException use) {
			customerResponse.setStatus(ERROR_STATUS);
			customerResponse.setMessage(GENERAL_ERROR_MESSAGE);
		}
		return customerResponse;
	}
	
	@GetMapping(value="/getCustomersForDept/{deptId}", produces = "application/json")
	public CustomerResponse getCustomersForDept(@PathVariable int deptId) {
		customerResponse.setCustomers(customerService.getCustomerForDept(deptId));
		customerResponse.setStatus(SUCCESS_STATUS);
		return customerResponse;
	}

	@PostMapping(value="/addCustomer", produces = "application/json", consumes = "application/json")
	public CustomerResponse addCustomer(@RequestBody String customerString){
		//customerResponse = new CustomerResponse();
		try {
			Customer customer = new ObjectMapper().readValue(customerString, Customer.class);
			customerService.addCustomer(customer);
			customerResponse.setMessage(CUSTOMER_ADD_MESSAGE);
			customerResponse.setStatus(SUCCESS_STATUS);
		}
		catch (CustomerServiceException use) {
			customerResponse.setStatus(ERROR_STATUS);
			customerResponse.setMessage(GENERAL_ERROR_MESSAGE);
		}catch(JsonParseException jpe) {
			System.out.println("jpe" + jpe.getMessage());
			customerResponse.setStatus(ERROR_STATUS);
			customerResponse.setMessage(INVALID_REQUEST_BODY);
		}catch(JsonMappingException jme) {
			System.out.println("jme" + jme.getMessage());
			customerResponse.setStatus(ERROR_STATUS);
			customerResponse.setMessage(INVALID_REQUEST_BODY);
		}catch(IOException ie) {
			System.out.println("ie" + ie.getMessage());
			customerResponse.setStatus(ERROR_STATUS);
			customerResponse.setMessage(INVALID_REQUEST_BODY);
		}
		return customerResponse;
	}
	
	@PostMapping(value="/updateCustomer", produces = "application/json", consumes = "application/json")
	public CustomerResponse updateCustomer(@RequestBody String customerString){
		try {
			Customer customer= new ObjectMapper().readValue(customerString, Customer.class);
			customerService.updateCustomer(customer);
			customerResponse.setMessage(CUSTOMER_ADD_MESSAGE);
			customerResponse.setStatus(SUCCESS_STATUS);
		}
		catch (CustomerServiceException use) {
			customerResponse.setStatus(ERROR_STATUS);
			customerResponse.setMessage(GENERAL_ERROR_MESSAGE);
		}catch(JsonParseException jpe) {
			System.out.println("jpe" + jpe.getMessage());
			customerResponse.setStatus(ERROR_STATUS);
			customerResponse.setMessage(INVALID_REQUEST_BODY);
		}catch(JsonMappingException jme) {
			System.out.println("jme" + jme.getMessage());
			customerResponse.setStatus(ERROR_STATUS);
			customerResponse.setMessage(INVALID_REQUEST_BODY); 
		}catch(IOException ie) {
			System.out.println("ie" + ie.getMessage());
			customerResponse.setStatus(ERROR_STATUS);
			customerResponse.setMessage(INVALID_REQUEST_BODY);
		}
		return customerResponse;
	}
		
//	@PostMapping(value="/addItemToCart", produces = "application/json", consumes = "application/json")
//	public User addItemToCart(@RequestBody String itemString){
//		AddItemRequest item = new AddItemRequest();
//		try {
//			item = new ObjectMapper().readValue(itemString, AddItemRequest.class);
//		}
//		catch(JsonParseException jpe) {
//			System.out.println("jpe" + jpe.getMessage());
//		}catch(JsonMappingException jme) {
//			System.out.println("jme" + jme.getMessage()); 
//		}catch(IOException ie) {
//			System.out.println("ie" + ie.getMessage());
//		}
//		User cart = new User();
//		cart.getCartItems().add(item.getItem());
//		return cart;
//	}

}
