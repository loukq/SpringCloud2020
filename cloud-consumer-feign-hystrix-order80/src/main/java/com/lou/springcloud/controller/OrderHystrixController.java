package com.lou.springcloud.controller;

import com.lou.springcloud.service.OrderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
//指定全局的fallback方法是哪一个，如果方法有明确它的fallback的方法，使用指定的fallback的方法；否则使用的
//就是该global的fallback方法
//@DefaultProperties(defaultFallback = "paymentHystrix_TimeOutHandler_global")
public class OrderHystrixController {

    @Autowired
    private OrderHystrixService orderHystrixService;


    @GetMapping(value = "/order/paymentHystrix_OK/{id}")
    public String paymentHystrix_OK(@PathVariable("id") int id) {
        return orderHystrixService.paymentHystrix_OK(id);
    }


    //    在消费方进行相同的配置
    //    设置fallback的方法以及超时的时间
//    @HystrixCommand(fallbackMethod = "paymentHystrix_TimeOutHandler",
//            commandProperties = {
//                    @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "1500")})
    @GetMapping(value = "/order/paymentHystrix_TimeOut/{id}")
    public String paymentHystrix_TimeOut(@PathVariable("id") int id) {
        log.info("the id is "+id);
        return orderHystrixService.paymentHystrix_TimeOut(id);
    }

    //    fallback的方法和原方法的参数和放回值保持相同
    public String paymentHystrix_TimeOutHandler(int id) {
        return "order  the thread is :" + Thread.currentThread().getName() + "系统繁忙！" + "status:" + " dofallback";
    }

    //  @HystrixCommand说明使用服务降级的策略，
    // 配置了一个使用的是全局fallback的方法，调用的是全局的fallback的方法
//    @HystrixCommand
    @GetMapping(value = "/order/paymentHystrix_TimeOut_global/{id}")
    public String paymentHystrix_TimeOut_global(@PathVariable("id") int id) {
        return orderHystrixService.paymentHystrix_TimeOut(id);
    }

    // 全局的fallback方法
    // 由于是全局fallback，所以不能加入参数，注意点，在这里吃了亏。
    public String paymentHystrix_TimeOutHandler_global() {
        return "order  the thread is :" + Thread.currentThread().getName() + "系统繁忙！" + "status:" + " global_fallback";
    }

}

