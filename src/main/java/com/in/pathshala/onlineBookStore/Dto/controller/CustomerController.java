package com.in.pathshala.onlineBookStore.Dto.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.pathshala.onlineBookStore.Dto.BaseResponseDTO;
import com.in.pathshala.onlineBookStore.Dto.model.Book;
import com.in.pathshala.onlineBookStore.Dto.model.Customer;
import com.in.pathshala.onlineBookStore.Dto.service.BookService;
import com.in.pathshala.onlineBookStore.Dto.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	Logger logger=LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	public CustomerService customerService;
	
	@GetMapping(value="/getAllBook")
	public List<Customer> getCustomers(){
		logger.info("Requesting getAllBook from BookController");
		return customerService.getCustomers();
		
	}
	@GetMapping("/{id}")
	public Customer findCustomerById(@PathVariable("id") long id){
		logger.info("Requesting getbookByID from book controller");
		return  customerService.findCustomerById( id);
		
	}
	@PostMapping(value="/createBook")
	public Customer saveCustomer(@RequestBody Customer customer){
		return customerService.saveCustomer(customer);
	}
	@PutMapping(value="/updateBook")
	public Customer updateCustomer (@PathVariable long id,@RequestBody Customer customer){
//		logger.info("User Id coming from Request::" + bookRequest.getBook_id());
		return customerService.updateCustomers(id,customer);
	}
	@DeleteMapping("/deleteBook/{id}")
	public void deleteCustomer(@PathVariable long id) {
	 logger.info("Deleting by id is executed");
	 customerService.deleteCustomer(id);
}
}
