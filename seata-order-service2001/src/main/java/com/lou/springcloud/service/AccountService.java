package com.lou.springcloud.service;

import com.lou.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@FeignClient(value = "seata-account-service")
public interface AccountService {
    @GetMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}
