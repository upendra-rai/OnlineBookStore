package com.in.pathshala.onlineBookStore.Dto.service;

import java.util.List;

import com.in.pathshala.onlineBookStore.Dto.CartOrderDto;
import com.in.pathshala.onlineBookStore.Dto.model.CartOrder;
import com.in.pathshala.onlineBookStore.Dto.model.Customer;

public interface CartOrderService {

	public List<CartOrder>getCartOrders();
	public CartOrder findCartOrderById( long id);
	public  CartOrder saveCartOrder( CartOrderDto cartOrderDto);
	public void deleteCartOrder(long id);
	
}
