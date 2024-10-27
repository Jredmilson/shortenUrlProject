package com.shortner.url.shortner.url.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortnerController {

    @PostMapping("shorten-url")
    public ResponseEntity<String> shortenUrl() {

        return ResponseEntity.ok("ok");
    }
}
