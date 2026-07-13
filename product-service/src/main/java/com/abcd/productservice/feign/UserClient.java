package com.abcd.productservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.abcd.productservice.dto.User;

@FeignClient(
        name = "user-service",
        url = "${user-service.url}"
)
public interface UserClient {

    @GetMapping("/users/{id}")
    User getUser(@PathVariable Long id);

}
