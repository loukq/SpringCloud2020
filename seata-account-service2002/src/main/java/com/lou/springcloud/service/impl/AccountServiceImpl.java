package com.lou.springcloud.service.impl;

import com.lou.springcloud.dao.AccountDao;
import com.lou.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void decreace(Long userId, BigDecimal money) {
//        设置超时时间来模拟异常的发生
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        accountDao.decrease(userId, money);
        log.info("AccountServiceImpl......");

    }
}
