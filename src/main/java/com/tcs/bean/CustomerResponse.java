package com.tcs.bean;

import java.util.List;

import org.springframework.context.annotation.Configuration;

public class CustomerResponse {
	
	private String status;
	private String message;
	private List<Customer> customers;

	public CustomerResponse() {
		super();
	}
	
	public CustomerResponse(String status, String message, List<Customer> customers) {
		super();
		this.status = status;
		this.message = message;
		this.customers = customers;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
}
