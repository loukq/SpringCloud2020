package com.lou.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced()
//    开启负载均衡，服务端的集群才会生效
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
