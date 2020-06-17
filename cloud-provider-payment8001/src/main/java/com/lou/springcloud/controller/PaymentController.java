package com.lou.springcloud.controller;

import com.lou.springcloud.entities.CommonPayment;
import com.lou.springcloud.entities.Payment;
import com.lou.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment")
    public CommonPayment<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);

        log.info("插入结果：" + payment);
        return result > 0 ? new CommonPayment<Payment>("200", "插入成功,serverPort:"+serverPort, payment) : new CommonPayment<Payment>("444", "插入失败", null);
    }

    @GetMapping(value = "/payment/{id}")
    public CommonPayment<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果：" + payment);
        return payment != null ? new CommonPayment<Payment>("200", "查询成功,serverPort:"+serverPort, payment) : new CommonPayment<Payment>("444", "查询失败", null);
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service :
                services) {
            System.out.println(service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance:
             instances) {
            System.out.println(serviceInstance.getInstanceId()+"\t"+serviceInstance.getHost()+"\t"+serviceInstance.getUri());
        }
        return discoveryClient;
    }

    @RequestMapping("/payment/getPort")
    public String getServciceInstance(){
        return serverPort;
    }

    @GetMapping("/payment/sleep")
    public String paymentFeignSleep(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }


    @GetMapping(value = "/payment/zipkin")
    public String paymentZipkin(){
        return "i am zipkin";
    }
}
