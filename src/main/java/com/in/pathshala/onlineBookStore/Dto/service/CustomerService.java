package com.in.pathshala.onlineBookStore.Dto.service;

import java.util.List;
import com.in.pathshala.onlineBookStore.Dto.model.Customer;

public interface CustomerService {

	public List<Customer>getCustomers();
	public Customer findCustomerById(long id);
	public Customer saveCustomer( Customer customer);
	public Customer updateCustomers(long id, Customer customer);
	public void deleteCustomer(long id);
	
}
