package com.student.spring.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.student.spring.jdbc.dao.CustomerDAO;
import com.student.spring.jdbc.dto.Customer;

public class JdbcCustomerDAOImpl implements CustomerDAO {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Customer customer) {

		String sql = "INSERT INTO CUSTOMER  (CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, customer.getCustId());
			ps.setString(2, customer.getName());
			ps.setLong(3, customer.getAge());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public Customer findByCustomerId(int custId) {

		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, custId);
			Customer customer = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer(rs.getLong("CUST_ID"), rs.getString("NAME"), rs.getLong("Age"));
			}
			rs.close();
			ps.close();
			return customer;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public List<Customer> findAllCustomer() {

		String sql = "SELECT * FROM CUSTOMER";
		List<Customer> customerList = new ArrayList<Customer>();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			Customer customer = null;
			rs = ps.executeQuery();
			while (rs.next()) {
				customer = new Customer(rs.getLong("CUST_ID"), rs.getString("NAME"), rs.getLong("Age"));
				customerList.add(customer);
			}
			return customerList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}