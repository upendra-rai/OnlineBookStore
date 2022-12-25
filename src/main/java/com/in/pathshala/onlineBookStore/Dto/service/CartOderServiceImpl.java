package com.in.pathshala.onlineBookStore.Dto.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.in.pathshala.onlineBookStore.Dto.CartOrderDto;
import com.in.pathshala.onlineBookStore.Dto.model.Book;
import com.in.pathshala.onlineBookStore.Dto.model.Cart;
import com.in.pathshala.onlineBookStore.Dto.model.CartOrder;
import com.in.pathshala.onlineBookStore.Dto.model.Customer;
import com.in.pathshala.onlineBookStore.Dto.repository.BookRepository;
import com.in.pathshala.onlineBookStore.Dto.repository.CartOderRepository;
import com.in.pathshala.onlineBookStore.Dto.repository.CartRepository1;
import com.in.pathshala.onlineBookStore.Dto.repository.CustomerRepository;

@Service
public class CartOderServiceImpl implements CartOrderService{
//	Logger logger=LoggerFactory.getLogger(ProductServiceImpl.class);
	
	Logger logger=LoggerFactory.getLogger(CartOderServiceImpl.class);
	@Autowired
	private CartOderRepository cartOderRepository;
	
	@Autowired
	private CartRepository1 cartRepository1;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<CartOrder>getCartOrders() {
	return	cartOderRepository.findAll();
	}

	@Override
	public CartOrder findCartOrderById( long id) {
		CartOrder cartOrder=cartOderRepository.findById(id).get();
		return cartOrder;
	}

	@Override
	public CartOrder saveCartOrder( CartOrderDto cartOrderDto) {
		CartOrder cartOrder= new  CartOrder();
		Customer customer =customerRepository.findById(cartOrderDto.getCustomerId()).get();
		Cart cart= cartRepository1.findById(cartOrderDto.getCartId()).get();
		cartOrder.setCart(cart);
		cartOrder.setCustomer(customer);
		cartOrder.setTotalPrice(cart.getCartAmount());
		return cartOrder;
	}

	public void deleteCartOrder(long id) {
		CartOrder cartOrder=cartOderRepository.findById(id).get();
		cartOderRepository.delete(cartOrder);
	}

}
