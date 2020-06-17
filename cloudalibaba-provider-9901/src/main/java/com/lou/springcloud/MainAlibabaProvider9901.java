package com.lou.springcloud;

import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MainAlibabaProvider9901 {
    public static void main(String[] args) {
        SpringApplication.run(MainAlibabaProvider9901.class,args);
    }
}
