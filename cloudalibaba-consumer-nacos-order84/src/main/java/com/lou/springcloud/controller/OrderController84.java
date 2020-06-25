package com.lou.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lou.springcloud.entities.CommonPayment;
import com.lou.springcloud.entities.Payment;
import com.lou.springcloud.service.FeignService84;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController84 {

    private final String URL = "http://nacos-payment-provider";

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private RestTemplate restTemplate;

//  exceptionsToIgnore属性排除fallback作用的exception
    @GetMapping("/getPaymentByOrder/{id}")
    @SentinelResource(value = "getPaymentByOrder", fallback = "handleFallBack", blockHandler = "blockHandleFunction",
            exceptionsToIgnore = {IllegalArgumentException.class})
//    @SentinelResource(value = "getPaymentByOrder",blockHandler = "blockHandleFunction")
    public CommonPayment<Payment> getPaymentByOrder(@PathVariable("id") Long id) {
        CommonPayment object = restTemplate.getForObject(URL + ":" + serverPort + "/getPayment/" + id, CommonPayment.class);
        if (id == 4) {
            throw new IllegalArgumentException("非法参数异常......");
        } else if (object.getData() == null) {
            throw new NullPointerException("data不能为空......");
        }
        return object;
    }

    public CommonPayment handleFallBack(Long id, Throwable throwable) {
        Payment payment = new Payment(id, "null");
        return new CommonPayment("444", "兜底的方法fallback生效,exception is " + throwable.getMessage(), payment);
    }

    public CommonPayment blockHandleFunction(Long id, BlockException blockException) {
        Payment payment = new Payment(id, "null");
        return new CommonPayment("444", "blockhandle方法生效,exception is " + blockException.getMessage(), payment);
    }

    @Autowired
    private FeignService84 feignService84;


    @GetMapping("/getConsumerFeign/{id}")
    public CommonPayment<Payment> getConsumerFeign(@PathVariable("id") String id){

        return feignService84.getPayment(id);
    }


}
