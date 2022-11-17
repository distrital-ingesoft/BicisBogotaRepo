package com.IngeSoft.BicisBogota.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @GetMapping("/")
    public String getMessage(){
        return "Hello World";
    }
}
