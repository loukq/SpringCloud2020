package com.lou.springcloud.service;

import com.lou.springcloud.entities.CommonPayment;
import com.lou.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider",fallback = FeignFallbackService84.class)
public interface FeignService84 {
    @GetMapping(value = "/getPayment/{id}")
    public CommonPayment<Payment> getPayment(@PathVariable("id") String id);
}
