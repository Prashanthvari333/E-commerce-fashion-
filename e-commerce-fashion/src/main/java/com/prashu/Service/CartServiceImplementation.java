package com.prashu.Service;

import com.prashu.Repository.CartRepo;
import com.prashu.exceptions.ProductException;
import com.prashu.model.Cart;
import com.prashu.model.CartItem;
import com.prashu.model.Product;
import com.prashu.model.User;
import com.prashu.requests.AddItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImplementation implements CartService {

    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private ProductService productService;

    public CartServiceImplementation(){

    }

    public CartServiceImplementation(CartRepo cartRepo, CartItemService cartItemService, ProductService productService) {
        this.cartRepo = cartRepo;
        this.cartItemService = cartItemService;
        this.productService = productService;
    }

    @Override
    public Cart createCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepo.save(cart) ;
    }

    @Override
    public String addCartItem(Long userId, AddItemRequest req) throws ProductException {
        Cart cart = cartRepo.findByUserId(userId);
        Product product = productService.findProductById(req.getProductId());
        CartItem isPresent = cartItemService.isCartItemExist(cart,product,req.getSize(),userId);
        if(isPresent == null){
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setCart(cart);
            cartItem.setQuantity(req.getQuantity());
            cartItem.setUserId(userId);

            int price = req.getQuantity()* product.getDiscountedPrice();
            cartItem.setPrice(price);
            cartItem.setSize(req.getSize());
            CartItem createdCartItem = cartItemService.createCartItem(cartItem);

            cart.getCartItems().add(createdCartItem);


        }
        return "Item added to Cart";
    }

    @Override
    public Cart findUserCart(Long userId) {
        Cart cart = cartRepo.findByUserId(userId);
        int totalPrice =0;
        int totalDicountedPrice = 0;
        int totalItems = 0;
        for ( CartItem cartItem : cart.getCartItems()){
            totalPrice+=cartItem.getPrice();
            totalDicountedPrice += cart.getTotalDiscountPrice();
            totalItems += cart.getTotalItems();
        }
        cart.setTotalDiscountPrice(totalDicountedPrice);
        cart.setTotalItems(totalItems);
        cart.setDiscount(totalPrice-totalDicountedPrice);

        return cartRepo.save(cart);
    }
}
