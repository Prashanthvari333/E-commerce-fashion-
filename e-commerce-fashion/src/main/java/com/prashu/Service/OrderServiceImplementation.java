package com.prashu.Service;

import com.prashu.Repository.CartRepo;
import com.prashu.exceptions.OrderException;
import com.prashu.model.Address;
import com.prashu.model.Order;
import com.prashu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImplementation implements  OrderService{

    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private CartService cartItemService;
    @Autowired
    private ProductService productService;

    public OrderServiceImplementation(CartRepo cartRepo, CartService cartItemService, ProductService productService) {
        this.cartRepo = cartRepo;
        this.cartItemService = cartItemService;
        this.productService = productService;
    }



    @Override
    public Order createOrder(User user, Address shippingAddress) {
        return null;
    }

    @Override
    public Order findOrderById(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public List<Order> userOrderHistory(Long userId) {
        return List.of();
    }

    @Override
    public Order placeOrder(Long orderid) throws OrderException {
        return null;
    }

    @Override
    public Order confirmedOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order shippingOrder(Long orderid) throws OrderException {
        return null;
    }

    @Override
    public Order deliveredOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order canceledOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order deleteOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public List<Order> getAllOrders() throws OrderException {
        return List.of();
    }
}
