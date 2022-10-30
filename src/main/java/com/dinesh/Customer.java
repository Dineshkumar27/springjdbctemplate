package com.dinesh;

public class Customer {
	int custId;
	String name;
	String address;

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", address=" + address + "]";
	}

	public Customer() {
		super();
	}

	public Customer(int custId, String name, String address) {
		super();
		this.custId = custId;
		this.name = name;
		this.address = address;
	}

	public int getCustId() {
		return custId;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

}