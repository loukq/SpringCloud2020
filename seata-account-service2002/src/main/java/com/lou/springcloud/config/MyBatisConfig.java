package com.lou.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

//Mybatis的配置
@Configuration
@MapperScan("com.lou.springcloud.dao")
public class MyBatisConfig {
}
