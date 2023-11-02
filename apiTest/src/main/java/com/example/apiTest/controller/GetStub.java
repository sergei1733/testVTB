package com.example.apiTest.controller;

import com.example.apiTest.service.ResponseService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class GetStub {
    @PostMapping("/path")
    public ResponseEntity<String> eac( @RequestBody String cn) throws IOException {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<>((String) new ResponseService().responseStub(cn), responseHeaders, HttpStatus.OK);

    }
}
