package com.prashu.Service;

import com.prashu.exceptions.ProductException;
import com.prashu.model.Cart;
import com.prashu.requests.AddItemRequest;
import com.prashu.model.User;

public interface CartService {

    public Cart createCart(User user);

    public String addCartItem(Long userId, AddItemRequest req)  throws ProductException;

    public Cart findUserCart(Long userId);
}
