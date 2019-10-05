package com.tcs.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.tcs.exception.CustomerServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.bean.Customer;
import com.tcs.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	private List<Customer> customers = new ArrayList<>(Arrays.asList(
			new Customer(123, "John", 1, "Warranty", "Sample Address 1"),
			new Customer(1234, "Brown", 2, "MVP", "Sample Address 2"),
			new Customer(12345, "White", 2, "CC", "Sample Address 3"),
			new Customer(123456, "Brad", 1, "TSO", "Sample Address 4")
			));
	
	public List<Customer> findAllCustomers() throws CustomerServiceException{
		List<Customer> allCustomers= new ArrayList<>();
		customerRepository.findAll().forEach(allCustomers::add);
		return allCustomers;
	}
	
	public Customer findCustomerById(int customerId) throws CustomerServiceException{
		return customerRepository.findById(customerId).orElse(null);
	}
	
	public void addCustomer(Customer customer) throws CustomerServiceException {
		customerRepository.save(customer);
	}
	
	public void updateCustomer(Customer customer) throws CustomerServiceException {
		customerRepository.save(customer);
	}
	public void deleteCustomer(int customerId) throws CustomerServiceException {
		customerRepository.deleteById(customerId);
	}
	
	public List<Customer> getAllCustomers() {
		return customers;		
	}
	
	public Customer getCustomer(int customerId) {
		return customers.stream().filter(customer -> customer.getCustomerId()==customerId).findFirst().orElse(null);	
	}
	
	public List<Customer> getCustomerForDept(int deptId) {
		List<Customer> deptCustomers = new ArrayList<>();
		customers.stream().filter(customer -> customer.getDepartmentId()==deptId).forEach(customers::add);
		return deptCustomers;
	}
}
