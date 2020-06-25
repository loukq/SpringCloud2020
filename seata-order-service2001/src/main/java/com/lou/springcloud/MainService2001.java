package com.lou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源的自动配置，使用自己的数据源
@EnableFeignClients
@EnableDiscoveryClient
public class MainService2001 {
    public static void main(String[] args) {
        SpringApplication.run(MainService2001.class,args);
    }
}
