package com.lou.springcloud.controller;

import com.lou.springcloud.domain.CommonResult;
import com.lou.springcloud.domain.Order;
import com.lou.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200,"创建订单成功");
    }

}
