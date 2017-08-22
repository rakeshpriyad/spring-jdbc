package com.student.spring.jdbc.template.sqlquery.dao;

import java.util.List;

import com.student.spring.jdbc.dto.Customer;

public interface CustomerDAO {
	public List<Customer> listCustomers();
}