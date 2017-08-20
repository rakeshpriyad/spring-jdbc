package com.student.spring.jdbc.template.daosupport;

import java.util.List;

import com.student.spring.jdbc.dto.Customer;

public interface CustomerDAO {
	public void insert(Customer customer);

	public Customer findByCustomerId(int custId);

	public List<Customer> findAllMapManual();

	public List<Customer> findAll();

	public String findCustomerNameById(int custId);
	public int findTotalCustomer();
	public void insertBatch(final List<Customer> customers);
	public void insertBatchSQL(final String sql);
}