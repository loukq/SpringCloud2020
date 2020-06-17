package com.lou.springcloud.controller;

import com.lou.springcloud.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageProviderController {

    @Autowired
    private MessageService messageService;


    @GetMapping(value = "/send")
    public String send(){
        return messageService.send();
    }
}
