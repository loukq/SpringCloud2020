package com.lou.springcloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FilterService {

    @SentinelResource(value = "getOrder", blockHandler = "handleException")
    public String  getOrder() {
        return String.valueOf(new Random().nextInt());
    }
}
