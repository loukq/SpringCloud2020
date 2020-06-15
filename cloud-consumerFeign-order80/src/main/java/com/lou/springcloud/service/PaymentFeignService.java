package com.lou.springcloud.service;

import com.lou.springcloud.entities.CommonPayment;
import com.lou.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//指定微服务的名称
@FeignClient("CLOUD-PAYMENT-SERVICE")
@Component
public interface PaymentFeignService {
    @GetMapping(value = "/payment/{id}")
    public CommonPayment<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/sleep")
    public String paymentFeignSleep();
}
