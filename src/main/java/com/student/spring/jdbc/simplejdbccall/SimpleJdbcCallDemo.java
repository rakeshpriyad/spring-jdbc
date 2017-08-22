package com.student.spring.jdbc.simplejdbccall;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.student.spring.jdbc.dto.Customer;
import com.student.spring.jdbc.simplejdbccall.dao.CustomerDAO;


public class SimpleJdbcCallDemo {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config-template-simplejdbccall.xml");
		CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
        Customer customer = customerDAO.getCustomer(1L);
        System.out.println(customer.getName());
        System.out.println(customer.getAge());
        
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
