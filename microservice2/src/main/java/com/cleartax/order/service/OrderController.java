package com.cleartax.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    List<Order> orders = new ArrayList<>();

    @Autowired
    private UserClient userClient;

    @GetMapping("/getUser/{id}")
    public String getUserName(@PathVariable String id){

        return userClient.getUserById(id);
    }

    @GetMapping("/order/{id}")
    public String getOrderById( @PathVariable String id) {

        for(Order order : orders) {

            if(order.id.equals(id)) {
                return order.id;
            }
        }

        return "order not found";
    }

    @PostMapping("order/add")
    public void addOrder(@RequestBody Order order) {
        orders.add(order);
    }
}
