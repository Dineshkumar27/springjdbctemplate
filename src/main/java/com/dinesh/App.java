package com.dinesh;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
		Customer customer = new Customer(200, "Hashan", "Pune");
//		customerDAO.insert(customer);

//		Customer customer1 = customerDAO.findByCustomerId(200);
//		System.out.println(customer1);
//
//		List<Customer> customers = customerDAO.listCustomers();
//		for (Customer record : customers) {
//			System.out.print("ID : " + record.getCustId());
//			System.out.print(", Name : " + record.getName());
//			System.out.println(", Address : " + record.getAddress());
//		}
		System.out.println("----Updating Record with ID = 2 -----");
		customerDAO.update(200, "Mumbai");
	}
}
