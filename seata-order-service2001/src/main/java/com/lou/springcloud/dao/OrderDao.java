package com.lou.springcloud.dao;

import com.lou.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {
//    创建订单
    void create(Order order);
//    修改订单的状态
    void update(@Param("userId") Long userId,@Param("status") Integer status);

}
