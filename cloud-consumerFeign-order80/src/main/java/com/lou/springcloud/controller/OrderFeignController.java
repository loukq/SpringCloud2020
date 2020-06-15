package com.lou.springcloud.controller;

import com.lou.springcloud.entities.CommonPayment;
import com.lou.springcloud.entities.Payment;
import com.lou.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @RequestMapping("/Feign/getPaymentById/{id}")
    public CommonPayment<Payment> getPaymentById(@PathVariable Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/Feign/sleep")
    public String paymentFeignSleep(){
        return paymentFeignService.paymentFeignSleep();
    }


}
