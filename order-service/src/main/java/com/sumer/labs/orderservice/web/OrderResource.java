package com.sumer.labs.orderservice.web;

import org.springframework.web.bind.annotation.*;

import com.sumer.labs.commons.dto.OrderDto;
import com.sumer.labs.orderservice.service.OrderService;

import java.util.List;

import static com.sumer.labs.commons.utils.web.Web.API;

@RestController
@RequestMapping(API + "/orders")
public class OrderResource {


    private final OrderService orderService;

    public OrderResource(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDto> findAll() {
        return this.orderService.findAll();
    }

//    @GetMapping("/customer/{id}")
//    public List<OrderDto> findAllByUser(@PathVariable Long id) {
//        return this.orderService.findAllByUser(id);
//    }

    @GetMapping("/{id}")
    public OrderDto findById(@PathVariable Long id) {
        return this.orderService.findById(id);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.orderService.delete(id);
    }
}