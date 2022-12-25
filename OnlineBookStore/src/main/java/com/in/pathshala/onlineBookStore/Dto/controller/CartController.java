package com.in.pathshala.onlineBookStore.Dto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.in.pathshala.onlineBookStore.Dto.cart.AddToCartDto;
import com.in.pathshala.onlineBookStore.Dto.cart.CartDto;
import com.in.pathshala.onlineBookStore.Dto.exceptions.AuthenticationFailException;
import com.in.pathshala.onlineBookStore.Dto.exceptions.BookNotExistException;
import com.in.pathshala.onlineBookStore.Dto.exceptions.CartItemNotExistException;
import com.in.pathshala.onlineBookStore.Dto.model.Book;
import com.in.pathshala.onlineBookStore.Dto.model.Seller;
import com.in.pathshala.onlineBookStore.Dto.service.AuthenticationService;
import com.in.pathshala.onlineBookStore.Dto.service.BookService;
import com.in.pathshala.onlineBookStore.Dto.service.CartService1;
import com.in.pathshala.onlineBookStore.Dto.service.SellerService1;
import com.in.pathshala.onlineBookStore.common.ApiResponse;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
    private CartService1 cartService1;
	
	@Autowired
	private SellerService1 sellerService1;

    @Autowired
    private BookService bookService;
	 @Autowired
	    private AuthenticationService authenticationService;
	 
	 @PostMapping("/addToCart")
	    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto
//                ,@RequestParam("token") String token
                ) {       
//		 	authenticationService.authenticate(token);
	        cartService1.addToCart(addToCartDto);
	        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);
	    }
	 @GetMapping("/all")
//	    public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token) throws AuthenticationFailException {
	   public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token) throws AuthenticationFailException {
//	        authenticationService.authenticate(token);
	        Seller seller = authenticationService.getSeller(token);
	        CartDto cartDto = cartService1.listCartItems(seller);
	        return new ResponseEntity<CartDto>(cartDto,HttpStatus.OK);
	    }
	    @PutMapping("/update/{cartItemId}")
	    public ResponseEntity<ApiResponse> updateCartItem(@PathVariable("cartItemId") int itemID,@RequestBody  AddToCartDto cartDto,
	                                                      @RequestParam("token") String token) throws AuthenticationFailException,BookNotExistException {
	        authenticationService.authenticate(token);
	        
	        Seller seller = authenticationService.getSeller(token);
	        
	        cartService1.updateCartItem(itemID,cartDto);
	        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Book has been updated"), HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{cartItemId}")
	    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") int itemID,@RequestParam("token") String token) throws AuthenticationFailException, CartItemNotExistException {
	        authenticationService.authenticate(token);
	        long sellerId = authenticationService.getSeller(token).getId();
	        cartService1.deleteCartItem(itemID, sellerId);
	        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
	    }
}
