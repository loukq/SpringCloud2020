package com.lou.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyProviderController9902 {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/getMessage")
    public String getMessage(){
        return "i am alibaba provider: "+serverPort;
    }
}
