package com.example.gateway.cloud_gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/FallBackDepartment")
public class FallBackDepartmentController {

    @GetMapping("/departmentfallback")
    public ResponseEntity<String> fallbackDepartment(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("We are facing problem for Department Service");
    }
}
