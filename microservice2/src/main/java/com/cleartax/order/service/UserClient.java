package com.cleartax.order.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user", url = "http://localhost:8080")
@CircuitBreaker(name = "userClient", fallbackMethod = "fallbackMethod")
public interface UserClient {

    @GetMapping("/user/{id}")
    public String getUserById( @PathVariable String id);

    default String fallbackMethod(Exception ex) {
        return "Fallback response";
    }

}
