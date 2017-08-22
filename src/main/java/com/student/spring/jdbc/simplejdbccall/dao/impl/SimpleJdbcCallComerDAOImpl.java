package com.student.spring.jdbc.simplejdbccall.dao.impl;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.student.spring.jdbc.dto.Customer;
import com.student.spring.jdbc.simplejdbccall.dao.CustomerDAO;

public class SimpleJdbcCallComerDAOImpl implements CustomerDAO {
	private DataSource dataSource;
	private SimpleJdbcCall jdbcCall;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("get_customer");
	}

	public Customer getCustomer(Long customerId){
		SqlParameterSource in = new MapSqlParameterSource().addValue("varCustomerId", customerId);
	      Map<String, Object> out = jdbcCall.execute(in);
	      Long age = new Long((Integer)out.get("varage"));
	      return new Customer((String)out.get("varname"), age); 
	}

	public DataSource getDataSource() {
		return dataSource;
	}

}