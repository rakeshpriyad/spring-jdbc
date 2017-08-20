package com.student.spring.jdbc.template.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.student.spring.jdbc.dto.Customer;
import com.student.spring.jdbc.template.CustomerDAO;

public class TemplateCustomerDAOImpl implements CustomerDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Customer customer) {

		String sql = "INSERT INTO CUSTOMER  (NAME, AGE) VALUES ( ?, ?)";

		jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(sql, new Object[] { customer.getName(), customer.getAge() });

	}

	public Customer findByCustomerId(int custId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Customer> findAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

}