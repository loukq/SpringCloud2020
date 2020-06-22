package com.lou.springcloud.controller;

import com.lou.springcloud.entities.CommonPayment;
import com.lou.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ProviderController9003 {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<String, Payment> hashMap=new HashMap<>();

    static {
        hashMap.put("1",new Payment(1l,"loukq"));
        hashMap.put("2",new Payment(2l,"damin"));
        hashMap.put("3",new Payment(3l,"lilei"));
    }


    @GetMapping(value = "/getPayment/{id}")
    public CommonPayment<Payment> getPayment(@PathVariable("id") String id){
        return new CommonPayment<>("200","server port is "+serverPort,hashMap.get(id) );
    }

}
