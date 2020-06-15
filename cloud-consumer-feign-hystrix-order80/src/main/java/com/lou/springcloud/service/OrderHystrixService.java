package com.lou.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = OrderFallbackService.class)
public interface OrderHystrixService {

    @GetMapping(value = "/payment/paymentHystrix_OK/{id}")
    public String paymentHystrix_OK(@PathVariable("id") int id);

    @GetMapping(value = "/payment/paymentHystrix_TimeOut/{id}")
    public String paymentHystrix_TimeOut(@PathVariable("id") int id);

}
