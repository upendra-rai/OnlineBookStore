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
import com.in.pathshala.onlineBookStore.Dto.CartOrderDto;
import com.in.pathshala.onlineBookStore.Dto.model.Book;
import com.in.pathshala.onlineBookStore.Dto.model.CartOrder;
import com.in.pathshala.onlineBookStore.Dto.model.Customer;
import com.in.pathshala.onlineBookStore.Dto.service.BookService;
import com.in.pathshala.onlineBookStore.Dto.service.CartOrderService;
import com.in.pathshala.onlineBookStore.Dto.service.CustomerService;

@RestController
@RequestMapping("/cartOrder")
public class CarOrderController {

	Logger logger=LoggerFactory.getLogger(CarOrderController.class);
	
	@Autowired
	public CartOrderService cartOrderService;
	
	@GetMapping
	public List<CartOrder> getCartOrders(){
		logger.info("Requesting getAllBook from BookController");
		return cartOrderService.getCartOrders();
		
	}
	@GetMapping("/{id}")
	public CartOrder findCartOrderById(@PathVariable("id") long id){
		logger.info("Requesting getbookByID from book controller");
		return  cartOrderService.findCartOrderById( id);
		
	}
	@PostMapping
	public CartOrder saveCartOrder(@RequestBody CartOrderDto cartOrderDto){
		return cartOrderService.saveCartOrder(cartOrderDto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCartOrder(@PathVariable long id) {
	 logger.info("Deleting by id is executed");
	 cartOrderService.deleteCartOrder(id);
}
}
