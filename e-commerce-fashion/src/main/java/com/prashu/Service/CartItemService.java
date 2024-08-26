package com.prashu.Service;

import com.prashu.exceptions.CartItemException;
import com.prashu.exceptions.UserException;
import com.prashu.model.Cart;
import com.prashu.model.CartItem;
import com.prashu.model.Product;
import com.prashu.model.User;

public interface CartItemService {

    public CartItem createCartItem(CartItem cartItem);

    public CartItem updateCartItem(Long userId, Long id , CartItem cartItem) throws CartItemException, UserException, Exception;

    public CartItem isCartItemExist(Cart cart , Product product , String size , Long userId);

    public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException, Exception;

    public CartItem findCartItemById(Long cartItemId) throws  CartItemException;
}
