package com.ecomm.saurabh.ecommapp.controller;

import com.ecomm.saurabh.ecommapp.domain.Order;
import com.ecomm.saurabh.ecommapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * Api call to create new orders
     * @param order
     */
    @PostMapping("/orders")
    public void createOrder(@RequestBody Order order){
        orderService.createOrder(order);
    }
}
