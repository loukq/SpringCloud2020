package com.lou.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = "com.lou.springcloud.dao")
public class MyBatisConfig {
}
