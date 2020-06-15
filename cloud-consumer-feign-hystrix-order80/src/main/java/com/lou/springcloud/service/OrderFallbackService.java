package com.lou.springcloud.service;

import org.springframework.stereotype.Component;

//把fallback的方法和业务逻辑的方法进行解耦
//通过实行服务的接口类，把所有的服务降级都在这里进行处理
@Component
public class OrderFallbackService implements OrderHystrixService {
    @Override
    public String paymentHystrix_OK(int id) {
        return "OrderFallbackService--paymentHystrix_OK--fallback";
    }

    @Override
    public String paymentHystrix_TimeOut(int id) {
        return "OrderFallbackService--paymentHystrix_TimeOut--fallback";
    }
}
