package com.sumer.labs.customerservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sumer.labs.commons.dto.CartDto;
import com.sumer.labs.commons.dto.OrderDto;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@FeignClient(name = "order-service")
public interface OrderServiceClient {

    @RequestMapping(value = "/api/orders", method = POST)
    OrderDto create(CartDto cartDto);
}
