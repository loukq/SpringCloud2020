package com.lou.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyConsumerController83 {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Value("${service-url.nacos-user-service}")
    private String pathUrl;

    @GetMapping("/consumer/getMessage")
    public String getMessage() {
//        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider9901");
//        String path = String.format("http://%s:%s/getMessage", serviceInstance.getHost(), serviceInstance.getPort());
        String path=pathUrl+"/getMessage";
        return restTemplate.getForObject(path, String.class);
    }

}
