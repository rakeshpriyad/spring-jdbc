package com.student.spring.jdbc.template;

import java.util.List;

import com.student.spring.jdbc.dto.Customer;

public interface CustomerDAO {
	public void insert(Customer customer);

	public Customer findByCustomerId(int custId);

	public List<Customer> findAllCustomer();
}