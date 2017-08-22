package com.student.spring.jdbc.template.sqlquery.dao.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.object.SqlQuery;

import com.student.spring.jdbc.dto.Customer;
import com.student.spring.jdbc.template.sqlquery.dao.CustomerDAO;

public class SqlQueryComerDAOImpl implements CustomerDAO {
	private DataSource dataSource;
	private SqlQuery<Customer> sqlQuery;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		sqlQuery = new SqlQuery<Customer>() {
	         @Override
	         protected RowMapper<Customer> newRowMapper(Object[] parameters, Map<?, ?> context){
	            return new CustomerMapper();
	         }
	      };
	}

	public List<Customer> listCustomers() {
	      String sql = "select * from customer";
	      sqlQuery.setDataSource(dataSource);
	      sqlQuery.setSql(sql);
	      List <Customer> students = sqlQuery.execute();
	      return students;
	   }

	public DataSource getDataSource() {
		return dataSource;
	}
}