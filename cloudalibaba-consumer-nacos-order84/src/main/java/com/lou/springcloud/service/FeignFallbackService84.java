package com.lou.springcloud.service;

import com.lou.springcloud.entities.CommonPayment;
import com.lou.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

//定义熔断后的兜底的方法
@Component
public class FeignFallbackService84 implements FeignService84 {
    @Override
    public CommonPayment<Payment> getPayment(String id) {
        return new CommonPayment<Payment>("455","熔断的fallback方法",new Payment(999l,null));
    }
}
