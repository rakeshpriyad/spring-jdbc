package com.student.spring.jdbc.template.daosupport.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.student.spring.jdbc.dto.Customer;
import com.student.spring.jdbc.template.daosupport.CustomerDAO;
import com.student.spring.jdbc.template.query.CustomerRowMapper;

public class TemplateDaoSupportCustomerDAOImpl extends JdbcDaoSupport implements CustomerDAO {

	public void insert(Customer customer) {

		String sql = "INSERT INTO CUSTOMER  (NAME, AGE) VALUES ( ?, ?)";
		getJdbcTemplate().update(sql, new Object[] { customer.getName(), customer.getAge() });
	}

	public Customer findByCustomerId(int custId) {
		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
		Customer customer = (Customer) getJdbcTemplate().queryForObject(sql, new Object[] { custId },
				new CustomerRowMapper());

		return customer;
	}

	public List<Customer> findAllMapManual() {

		String sql = "SELECT * FROM CUSTOMER";

		List<Customer> customers = new ArrayList<Customer>();

		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map<String, Object> row : rows) {
			Customer customer = new Customer();
			customer.setCustId((Long) (row.get("CUST_ID")));
			customer.setName((String) row.get("NAME"));
			customer.setAge((Long) row.get("AGE"));
			customers.add(customer);
		}

		return customers;
	}

	public List<Customer> findAll() {

		String sql = "SELECT * FROM CUSTOMER";

		List<Customer> customers = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Customer>(Customer.class));

		return customers;
	}

	public String findCustomerNameById(int custId) {

		String sql = "SELECT NAME FROM CUSTOMER WHERE CUST_ID = ?";

		String name = (String) getJdbcTemplate().queryForObject(sql, new Object[] { custId }, String.class);

		return name;

	}

	public int findTotalCustomer() {

		String sql = "SELECT COUNT(*) FROM CUSTOMER";

		// int total = getJdbcTemplate().queryForInt(sql);

		// return total;
		return 0;
	}

	public void insertBatch(final List<Customer> customers) {

		String sql = "INSERT INTO CUSTOMER " + "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";

		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public int getBatchSize() {
				return customers.size();
			}

			public void setValues(java.sql.PreparedStatement ps, int i) throws SQLException {
				Customer customer = customers.get(i);
				ps.setLong(1, customer.getCustId());
				ps.setString(2, customer.getName());
				ps.setLong(3, customer.getAge());
			}

		});
	}
	
	public void insertBatchSQL(final String sql){

		getJdbcTemplate().batchUpdate(new String[]{sql});

	}
}