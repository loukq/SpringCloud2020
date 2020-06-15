package com.lou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MainConfigCenter3355 {
    public static void main(String[] args) {
        SpringApplication.run(MainConfigCenter3355.class,args);
    }
}
