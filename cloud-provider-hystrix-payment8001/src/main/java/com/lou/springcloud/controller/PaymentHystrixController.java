package com.lou.springcloud.controller;

import com.lou.springcloud.service.MyHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentHystrixController {

    @Autowired
    private MyHystrixService myHystrixService;

    @Value("server.port")
    private String serverport;

    @GetMapping(value = "/payment/paymentHystrix_OK/{id}")
    public String paymentHystrix_OK(@PathVariable("id") int id) {
        return myHystrixService.paymentHystrix_OK(id);
    }

    @GetMapping(value = "/payment/paymentHystrix_TimeOut/{id}")
    public String paymentHystrix_TimeOut(@PathVariable int id) {
        return myHystrixService.paymentHystrix_TimeOut(id);
    }


    //    服务熔断的controller
    @GetMapping(value = "/payment/paymentHystrix_Break/{id}")
    public String paymentHystrix_Break(@PathVariable("id") int id) {
        return myHystrixService.paymentCircuitBreaker(id);
    }


    @GetMapping(value = "/payment/lb")
    public String getLb(){
        return serverport;
    }


}
