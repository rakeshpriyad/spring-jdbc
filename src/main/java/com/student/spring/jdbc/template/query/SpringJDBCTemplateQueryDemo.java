package com.student.spring.jdbc.template.query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.student.spring.jdbc.dto.Customer;
import com.student.spring.jdbc.template.daosupport.CustomerDAO;

public class SpringJDBCTemplateQueryDemo {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config-template-jdbc-daosupport.xml");
		CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
		Customer customer = new Customer("Rakesh", 28L);
		customerDAO.insert(customer);
		List<Customer> customerList = customerDAO.findAllMapManual();
		display(customerList);
		
		customerList = customerDAO.findAll();
		display(customerList);
		
		
		Customer customer1 = new Customer("Customer1",21l);
        Customer customer3 = new Customer("Customer2",22L);
        Customer customer2 = new Customer("Customer3",23L);

        List<Customer>customers = new ArrayList<Customer>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        customerDAO.insertBatch(customers);

        String sql = "UPDATE CUSTOMER SET NAME ='BATCHUPDATE'";
        customerDAO.insertBatchSQL(sql);
        
		System.out.println(customerDAO.findCustomerNameById(2));
		context.close();
	}

	public static void display(List<Customer> customerList) {
		Iterator<Customer> custIterator = customerList.iterator();
		while (custIterator.hasNext()) {
			Customer customer = custIterator.next();
			System.out.println(" Customer id : " + customer.getCustId() + " Name " + customer.getName() + " Age "
					+ customer.getAge());
		}
	}
}
