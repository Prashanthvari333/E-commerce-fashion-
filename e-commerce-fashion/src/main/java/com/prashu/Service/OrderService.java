package com.prashu.Service;

import com.prashu.exceptions.OrderException;
import com.prashu.model.Address;
import com.prashu.model.Order;
import com.prashu.model.User;

import  java.util.*;

public interface OrderService {

    public Order createOrder(User user , Address shippingAddress);

    public  Order findOrderById(Long orderId) throws OrderException;

    public  List<Order> userOrderHistory(Long userId);

    public  Order placeOrder(Long orderid) throws OrderException;

    public  Order confirmedOrder(Long orderId) throws OrderException;

    public  Order shippingOrder(Long orderid) throws  OrderException;

    public Order deliveredOrder(Long orderId) throws OrderException;

    public Order canceledOrder(Long orderId) throws OrderException;

    public Order deleteOrder(Long orderId) throws  OrderException;

    public List<Order> getAllOrders() throws OrderException;




}
