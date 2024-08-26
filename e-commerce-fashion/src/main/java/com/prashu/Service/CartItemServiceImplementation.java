package com.prashu.Service;

import com.prashu.Repository.CartItemRepo;
import com.prashu.Repository.CartRepo;
import com.prashu.exceptions.CartItemException;
import com.prashu.exceptions.UserException;
import com.prashu.model.Cart;
import com.prashu.model.CartItem;
import com.prashu.model.Product;
import com.prashu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartItemServiceImplementation implements CartItemService{

    @Autowired
    private CartItemRepo cartItemRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private CartRepo cartRepo;

    public CartItemServiceImplementation(CartItemRepo cartItemRepo, UserService userService, CartRepo cartRepo) {
        this.cartItemRepo = cartItemRepo;
        this.userService = userService;
        this.cartRepo = cartRepo;
    }

    @Override
    public CartItem createCartItem(CartItem cartItem) {
        cartItem.setQuantity(1);
        cartItem.setPrice(cartItem.getProduct().getPrice()*cartItem.getQuantity());
        cartItem.setDiscountedPrice(cartItem.getProduct().getDiscountedPrice()*cartItem.getQuantity());
        CartItem createdCartItem = cartItemRepo.save(cartItem);
        return createdCartItem;
    }

    @Override
    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException,  UserException {
        CartItem item = findCartItemById(id);
        User user = userService.findUserById(item.getUserId());

        if( user.getId().equals(userId)){
            item.setQuantity(cartItem.getQuantity());
            item.setPrice(item.getQuantity()*item.getProduct().getPrice());
            item.setDiscountedPrice(item.getProduct().getDiscountedPrice()*item.getQuantity());

        }
        return cartItemRepo.save(item);
    }

    @Override
    public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId) {
        CartItem cartItem  = cartItemRepo.isCartItemExist(cart,product,size ,userId);

        return cartItem;
    }

    @Override
    public void removeCartItem(Long userId, Long cartItemId) throws UserException, CartItemException {
        CartItem cartItem = findCartItemById(cartItemId);
        User user = userService.findUserById(cartItem.getUserId());

        User reqUser = userService.findUserById(userId);

        if(user.getId().equals(reqUser.getId())){
            cartItemRepo.deleteById(cartItemId);
        }else{
            throw new UserException("You can't remove another users item");
        }

    }

    @Override
    public CartItem findCartItemById(Long cartItemId) throws CartItemException {
        Optional<CartItem> opt = cartItemRepo.findById(cartItemId);
        if(opt.isPresent()){
            return opt.get();
        }
        throw new CartItemException("CartItem not found with id : "+ cartItemId);
    }
}
