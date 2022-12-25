package com.in.pathshala.onlineBookStore.Dto.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.in.pathshala.onlineBookStore.Dto.model.Book;
import com.in.pathshala.onlineBookStore.Dto.model.Customer;
import com.in.pathshala.onlineBookStore.Dto.repository.BookRepository;
import com.in.pathshala.onlineBookStore.Dto.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
//	Logger logger=LoggerFactory.getLogger(ProductServiceImpl.class);
	
	Logger logger=LoggerFactory.getLogger(CustomerServiceImpl.class);
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getCustomers() {
	return	customerRepository.findAll();
	}

	@Override
	public Customer findCustomerById(long id) {
		Customer customer=customerRepository.findById(id).get();
		return customer;
	}

	@Override
	public Customer saveCustomer( Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	@Transactional
	public Customer updateCustomers(long id, Customer customer) {
		Customer updateCustomer=customerRepository.findById(id).get();
		updateCustomer.setFullName(customer.getFullName());
		updateCustomer.setEmail(customer.getEmail());
		updateCustomer.setAddress(customer.getAddress());
		updateCustomer.setPhone(customer.getPhone());
		updateCustomer.setPassword(customer.getPassword());
		return updateCustomer;
	}

	@Override
	public void deleteCustomer(long id) {
		Customer customer=customerRepository.findById(id).get();
		customerRepository.delete(customer);
	}

}
