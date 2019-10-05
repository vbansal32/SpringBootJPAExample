package com.tcs.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	private int customerId;
	private String name;
	private int departmentId;
	private String departmentName;
	private String address;
	
	public Customer() {
		super();
	}
	
	public Customer(int customerId, String name, int department, String departmentName, String address) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.departmentId = department;
		this.departmentName = departmentName;
		this.address = address;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return customerId + " " + name + " " + departmentId + " " + departmentName + " " + address;
	}
}
