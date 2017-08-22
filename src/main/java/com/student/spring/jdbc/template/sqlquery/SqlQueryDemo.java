package com.student.spring.jdbc.template.sqlquery;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.student.spring.jdbc.dto.Customer;
import com.student.spring.jdbc.template.sqlquery.dao.CustomerDAO;


public class SqlQueryDemo {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config-template-sqlquery.xml");
		CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
        List<Customer> customerList = customerDAO.listCustomers();
        display(customerList);
        
		context.close();
	}
	
	public static void display(List<Customer> customerList){
		Iterator<Customer> custIterator = customerList.iterator();
		while(custIterator.hasNext()){
			Customer customer = custIterator.next();
			System.out.println(" Customer id : "+ customer.getCustId() + " Name "+ customer.getName()+ " Age " + customer.getAge());
		}
	}
}
