package com.lou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MianConsumer83 {
    public static void main(String[] args) {
        SpringApplication.run(MianConsumer83.class,args);
    }
}
