package com.dinesh;

import java.util.List;

public interface CustomerDAO {
	public void insert(Customer customer);

	public Customer findByCustomerId(int custId);

	public List<Customer> listCustomers();

	public void update(int id, String address);
}