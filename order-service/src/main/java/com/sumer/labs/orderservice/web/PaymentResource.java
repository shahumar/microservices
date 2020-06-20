package com.sumer.labs.orderservice.web;

import org.springframework.web.bind.annotation.*;

import com.sumer.labs.commons.dto.PaymentDto;
import com.sumer.labs.orderservice.service.PaymentService;

import java.util.List;

import static com.sumer.labs.commons.utils.web.Web.API;

@RestController
@RequestMapping(API + "/payments")
public class PaymentResource {


    private final PaymentService paymentService;

    public PaymentResource(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<PaymentDto> findAll() {
        return this.paymentService.findAll();
    }

    @GetMapping("/{id}")
    public PaymentDto findById(@PathVariable Long id) {
        return this.paymentService.findById(id);
    }

    @PostMapping
    public PaymentDto create(@RequestBody PaymentDto orderItemDto) {
        return this.paymentService.create(orderItemDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.paymentService.delete(id);
    }
}
