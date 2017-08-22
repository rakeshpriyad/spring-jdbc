package com.student.spring.jdbc.template.sqlquery.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.student.spring.jdbc.dto.Customer;

public class CustomerMapper implements RowMapper<Customer> {
	public Customer mapRow(ResultSet result, int i) throws SQLException {
		Customer student = new Customer(result.getString("name"), result.getLong("age"));
		return student;
	}
}
