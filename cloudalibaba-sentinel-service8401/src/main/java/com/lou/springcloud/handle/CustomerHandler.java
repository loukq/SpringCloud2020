package com.lou.springcloud.handle;

import com.alibaba.csp.sentinel.slots.block.BlockException;

//自定义兜底的方法，和业务逻辑分开
public class CustomerHandler {

    public String customerHandler1(String p1, String p2, BlockException blockException){
        return "customerHandler1    ";
    }

    public static String customerHandler2(String p1, String p2, BlockException blockException){
        return "customerHandler2   ";
    }

}
