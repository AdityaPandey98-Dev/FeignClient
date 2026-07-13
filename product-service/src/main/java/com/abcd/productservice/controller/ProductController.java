package com.abcd.productservice.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import com.abcd.productservice.dto.User;
import com.abcd.productservice.service.ProductService;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {

        return productService.fetchUser(id);

    }

}
