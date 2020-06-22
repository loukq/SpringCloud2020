package com.lou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MainSentinelService8401 {
    public static void main(String[] args) {
        SpringApplication.run(MainSentinelService8401.class,args);
    }
}
