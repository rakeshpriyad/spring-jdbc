package com.student.spring.jdbc.template;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.student.spring.jdbc.dto.Customer;


public class SpringJDBCTemplateDemo {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config-template.xml");
		CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
        Customer customer = new Customer("Rakesh",28L);
        customerDAO.insert(customer);

     /*   Customer customer1 = customerDAO.findByCustomerId(1);
        System.out.println(customer1);
        
        List<Customer> customerList = customerDAO.findAllCustomer();
        display(customerList);*/
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
