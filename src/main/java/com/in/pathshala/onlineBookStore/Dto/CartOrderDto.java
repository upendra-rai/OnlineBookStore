package com.in.pathshala.onlineBookStore.Dto;

public class CartOrderDto {

	private long customerId;
	private int cartId;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	@Override
	public String toString() {
		return "CartOrderDto [customerId=" + customerId + ", cartId=" + cartId + "]";
	}

	public CartOrderDto(long customerId, int cartId) {
		super();
		this.customerId = customerId;
		this.cartId = cartId;
	}

	public CartOrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
