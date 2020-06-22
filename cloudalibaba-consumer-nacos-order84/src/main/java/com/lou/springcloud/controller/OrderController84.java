package com.lou.springcloud.controller;

import com.lou.springcloud.entities.CommonPayment;
import com.lou.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController84 {

    private final String  URL="http://nacos-payment-provider";

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/getPaymentByOrder/{id}")
    public CommonPayment<Payment> getPaymentByOrder(@PathVariable("id") String id){
        return restTemplate.getForObject(URL+":"+serverPort+"/getPayment/"+id,CommonPayment.class);
    }




}
