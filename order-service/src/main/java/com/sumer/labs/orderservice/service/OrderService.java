package com.sumer.labs.orderservice.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sumer.labs.commons.dto.CartDto;
import com.sumer.labs.commons.dto.OrderDto;
import com.sumer.labs.orderservice.domain.Order;
import com.sumer.labs.orderservice.domain.enumeration.OrderStatus;
import com.sumer.labs.orderservice.repository.OrderRepository;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public List<OrderDto> findAll() {
        log.debug("Request to get all Orders");
        return this.orderRepository.findAll()
                .stream().map(OrderService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OrderDto findById(Long id) {
        log.debug("Request to get Order : {}", id);
        return this.orderRepository.findById(id).map(OrderService::mapToDto).orElse(null);
    }

//    public List<OrderDto> findAllByUser(Long id) {
//        return this.orderRepository.findByCartCustomer_Id(id)
//                .stream()
//                .map(OrderService::mapToDto)
//                .collect(Collectors.toList());
//    }

    public Order createOrder(CartDto cartDto) {
        log.debug("Request to create Order : {}", cartDto);
        return this.orderRepository.save(
                    new Order(
                        BigDecimal.ZERO,
                        OrderStatus.CREATION,
                        null,
                        null,
                        null,
                        Collections.emptySet(),
                        cartDto.getId()
                    )
                );
        
    }


    public OrderDto create(CartDto cart) {
        log.debug("Request to create Order with a Cart : {}", cart);
        return mapToDto(this.createOrder(cart));
    }


    public void delete(Long id) {
        log.debug("Request to delete Order : {}", id);
        this.orderRepository.deleteById(id);
    }


    public static OrderDto mapToDto(Order order) {
        if (order != null) {
            return new OrderDto(
                order.getId(),
                order.getTotalPrice(),
                order.getStatus().name(),
                order.getShipped(),
                PaymentService.mapToDto(order.getPayment()),
                AddressService.mapToDto(order.getShipmentAddress()),
                order.getOrderItems()
                        .stream()
                        .map(OrderItemService::mapToDto)
                        .collect(Collectors.toSet())
            );
        }
        return null;
    }
}
