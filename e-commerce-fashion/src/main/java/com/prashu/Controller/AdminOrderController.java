package com.prashu.Controller;

import com.prashu.Service.OrderService;
import com.prashu.exceptions.OrderException;
import com.prashu.model.Order;
import com.prashu.responses.ApiResponse;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/admin/orders")
public class AdminOrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrdersHandler() throws OrderException {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<List<Order>>(orders, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{orderId}/confirmed")
    public ResponseEntity<Order> ConfirmedOrderHandler(@PathVariable Long orderId,
                                                       @RequestHeader("Authorization") String jwt) throws OrderException{
        Order order = orderService.confirmedOrder(orderId);

        return new ResponseEntity<>(order,HttpStatus.OK);

    }

    @PutMapping("{orderId}/ship")
    public ResponseEntity<Order> ShippedOrderHandler(@PathVariable Long orderId,
                                                     @RequestHeader("Authorization") String jwt) throws  OrderException{
        Order order = orderService.shippingOrder(orderId);

        return new ResponseEntity<>(order,HttpStatus.OK);

    }

    @PutMapping("/{orderId}/deliver")
    public  ResponseEntity<Order> deliveryOrderHandler(@PathVariable Long orderId, @RequestHeader("Authorization") String jwt) throws OrderException{
        Order order = orderService.deliveredOrder(orderId);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    @PutMapping("/{orderId}/cancel")
    public  ResponseEntity<Order>  cancelOrderHandler(@PathVariable Long orderId, @RequestHeader("Authorization") String jwt )throws OrderException{
        Order order = orderService.canceledOrder(orderId);
        return new ResponseEntity<>(order,HttpStatus.OK);

    }

    @DeleteMapping("/{orderId}/delete")
    public  ResponseEntity<ApiResponse>  deleteOrderHandler(@PathVariable Long orderId, @RequestHeader("Authorization") String jwt )throws OrderException{
        orderService.deleteOrder(orderId);
        ApiResponse res = new ApiResponse();
        res.setMessage("order deleted successfully");
        res.setStatus(true);
        return new ResponseEntity<ApiResponse>(res,HttpStatus.OK);
    }
}
