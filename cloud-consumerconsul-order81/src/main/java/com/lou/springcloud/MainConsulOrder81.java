package com.lou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MainConsulOrder81 {
    public static void main(String[] args) {
        SpringApplication.run(MainConsulOrder81.class,args);
    }
}
