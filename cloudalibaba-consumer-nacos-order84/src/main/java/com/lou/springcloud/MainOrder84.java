package com.lou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MainOrder84 {
    public static void main(String[] args) {
        SpringApplication.run(MainOrder84.class,args);
    }
}
