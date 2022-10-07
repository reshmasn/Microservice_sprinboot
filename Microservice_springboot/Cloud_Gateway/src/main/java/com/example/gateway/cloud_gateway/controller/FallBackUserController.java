package com.example.gateway.cloud_gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/FallBackUser")
public class FallBackUserController {

    @GetMapping("/userfallback")
    public ResponseEntity<String> fallbackUser(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("We are facing problem for User Service");
    }

}
