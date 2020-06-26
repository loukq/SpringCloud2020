package com.lou.springcloud.service.impl;

import com.lou.springcloud.dao.OrderDao;
import com.lou.springcloud.domain.Order;
import com.lou.springcloud.service.AccountService;
import com.lou.springcloud.service.OrderService;
import com.lou.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired

    private OrderDao orderDao;
    @Autowired
    private StorageService storageService;
    @Autowired
    private AccountService accountService;

    @Override
//    GlobalTransactional注解实现分布式的事务的控制，带有该注解就是TM，事务的发起方
    @GlobalTransactional(name = "lou-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
//        下订单
        log.info("开始创建订单");
        orderDao.create(order);
//        扣减库存
        log.info("扣减库存开始");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("扣减库存结束");
//        扣减金额
        log.info("开始扣减账户金额");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("扣减账户金额结束");
//        改状态
        log.info("修改订单的状态，从0到1");
        orderDao.update(order.getUserId(),0);
        log.info("修改订单状态结束");
    }
}
