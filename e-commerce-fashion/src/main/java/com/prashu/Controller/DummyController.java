package com.prashu.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

    @GetMapping("/")
    public String index(){
        System.out.println("Index method called");
        return "Hello User Server is working";
    }
}
