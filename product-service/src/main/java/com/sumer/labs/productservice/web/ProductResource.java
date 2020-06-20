package com.sumer.labs.productservice.web;

import org.springframework.web.bind.annotation.*;

import com.sumer.labs.commons.dto.ProductDto;
import com.sumer.labs.productservice.service.ProductService;

import java.util.List;

import static com.sumer.labs.commons.utils.web.Web.API;

@RestController
@RequestMapping(API + "/products")
public class ProductResource {

    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> findAll() {
        return this.productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return this.productService.findById(id);
    }

    @PostMapping
    public ProductDto create(@RequestBody ProductDto productDto) {
        return this.productService.create(productDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.productService.delete(id);
    }
}
