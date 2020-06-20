package com.sumer.labs.orderservice.web;

import org.springframework.web.bind.annotation.*;

import com.sumer.labs.commons.dto.OrderItemDto;
import com.sumer.labs.orderservice.service.OrderItemService;

import java.util.List;

import static com.sumer.labs.commons.utils.web.Web.API;

@RestController
@RequestMapping(API + "/order-items")
public class OrderItemResource {

    private final OrderItemService itemService;

    public OrderItemResource(OrderItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping
    public List<OrderItemDto> findAll() {
        return this.itemService.findAll();
    }


    @GetMapping("/{id}")
    public OrderItemDto findById(@PathVariable Long id) {
        return this.itemService.findById(id);
    }


    @PostMapping
    public OrderItemDto create(@RequestBody OrderItemDto orderItemDto) {
        return this.itemService.create(orderItemDto);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.itemService.delete(id);
    }
}
