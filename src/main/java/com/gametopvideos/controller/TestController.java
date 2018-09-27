package com.gametopvideos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping(value = "/test")
    public String HelloWorld(){
        return "Winter is Coming";
    }
}
