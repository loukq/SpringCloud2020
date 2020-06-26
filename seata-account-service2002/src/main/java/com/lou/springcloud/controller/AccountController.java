package com.lou.springcloud.controller;

import com.lou.springcloud.domain.CommonResult;
import com.lou.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        accountService.decreace(userId,money);
        return new CommonResult(200,"账户金额减少成功");
    }

}
