package com.lou.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope//支持nacos的动态刷新的功能
public class ConfigNacosController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/showInfo")
    public String showInfo(){
        return configInfo;
    }
}
