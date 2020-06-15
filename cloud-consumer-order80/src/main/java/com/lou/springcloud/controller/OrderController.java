package com.lou.springcloud.controller;

import com.lou.springcloud.entities.CommonPayment;
import com.lou.springcloud.entities.Payment;
import com.lou.springcloud.ld.MyLB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

//    路径更改为service的名字
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private MyLB myLB;

    @PostMapping(value = "/consumer")
    public CommonPayment<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment", payment, CommonPayment.class);
    }

    @GetMapping(value = "/consumer/{id}")
    public CommonPayment<Payment> getPaymentById(@PathVariable("id") long id){
//        restTemplate.getForObject方法返回的是json的对象
        return restTemplate.getForObject(PAYMENT_URL+"/payment/"+id,CommonPayment.class);
    }

    @GetMapping(value = "/consumer/getForEntity/{id}")
    public CommonPayment<Payment> getPaymentByIdFromEntity(@PathVariable("id") long id){
//        restTemplate.getForEntity返回的是一个ResponseEntity对象，除了对象之外，还包含状态值等信息
        ResponseEntity<CommonPayment> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/" + id, CommonPayment.class);
        if (forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else {
            return new CommonPayment<Payment>("444","z操作失败");
        }
    }

    @RequestMapping(value = "/consumer/getTheUsedService")
    public String getTheUsedService(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        ServiceInstance instance = myLB.instance(instances);
        URI uri = instance.getUri();
        System.out.println(uri.toString());

        String portName = restTemplate.getForObject(uri + "/payment/getPort", String.class);
//        返回服务的端口
        return portName;

    }


}
