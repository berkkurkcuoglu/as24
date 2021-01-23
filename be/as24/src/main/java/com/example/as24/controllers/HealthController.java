package com.example.as24.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/health")
public class HealthController {

    @GetMapping
    public ResponseEntity<HttpStatus> isHealthy() {
        return ResponseEntity.ok().build();
    }
}
