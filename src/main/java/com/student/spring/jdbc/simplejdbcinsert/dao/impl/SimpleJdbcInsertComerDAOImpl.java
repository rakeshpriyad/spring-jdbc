package com.student.spring.jdbc.simplejdbcinsert.dao.impl;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.student.spring.jdbc.dto.Customer;
import com.student.spring.jdbc.simplejdbcinsert.dao.CustomerDAO;

public class SimpleJdbcInsertComerDAOImpl implements CustomerDAO {
	private DataSource dataSource;
	private SimpleJdbcInsert insertCustomer;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.insertCustomer = new SimpleJdbcInsert(dataSource).withTableName("customer");
	}

	public void insert(Customer customer) {

		// String sql = "INSERT INTO CUSTOMER (CUST_ID, NAME, AGE) VALUES (?, ?,
		// ?)";
		// Connection conn = null;

		Map<String, Object> params = new HashMap<String, Object>(3);
		params.put("NAME", customer.getName());
		params.put("AGE", customer.getAge());
		insertCustomer.execute(params);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

}