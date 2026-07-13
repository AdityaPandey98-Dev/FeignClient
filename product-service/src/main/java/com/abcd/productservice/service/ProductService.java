package com.abcd.productservice.service;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.abcd.productservice.dto.User;
import com.abcd.productservice.feign.UserClient;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final UserClient userClient;

    public User fetchUser(Long id) {

        return userClient.getUser(id);

    }

}
