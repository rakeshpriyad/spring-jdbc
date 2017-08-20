package com.student.spring.jdbc.template.query;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.student.spring.jdbc.dto.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setCustId(rs.getLong("CUST_ID"));
		customer.setName(rs.getString("NAME"));
		customer.setAge(rs.getLong("AGE"));
		return customer;
	}
}