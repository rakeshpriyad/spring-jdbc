package com.student.spring.jdbc.simplejdbccall.dao;

import com.student.spring.jdbc.dto.Customer;

public interface CustomerDAO {
	public Customer getCustomer(Long customerId);
}