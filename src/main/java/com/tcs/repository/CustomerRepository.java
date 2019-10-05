package com.tcs.repository;

import org.springframework.data.repository.CrudRepository;

import com.tcs.bean.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
